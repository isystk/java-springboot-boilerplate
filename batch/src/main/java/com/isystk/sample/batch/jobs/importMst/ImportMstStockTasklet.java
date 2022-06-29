package com.isystk.sample.batch.jobs.importMst;

import static com.isystk.sample.common.util.ValidateUtils.isNotEmpty;

import com.isystk.sample.common.helper.ImageHelper;
import com.isystk.sample.common.util.StringUtils;
import com.isystk.sample.domain.dao.StockDao;
import com.isystk.sample.domain.entity.Stock;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Stream;
import javax.validation.ValidationException;

import org.apache.commons.compress.utils.Lists;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import com.isystk.sample.batch.context.BatchContext;
import com.isystk.sample.batch.context.BatchContextHolder;
import com.isystk.sample.batch.item.ItemError;
import com.isystk.sample.batch.jobs.BaseTasklet;
import com.isystk.sample.common.util.DateUtils;
import com.isystk.sample.common.util.ObjectMapperUtils;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

/**
 * ユーザー情報取り込みタスク
 */
@Slf4j
public class ImportMstStockTasklet extends BaseTasklet<ImportMstStockDto> {

  @Autowired
  ImageHelper imageHelper;

  @Autowired
  StockDao stockDao;

  @Override
  public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext)
      throws IOException {
    RepeatStatus status = super.execute(contribution, chunkContext);

    val context = BatchContextHolder.getContext();
    val errors = getErrors(context);

    if (isNotEmpty(errors)) {
      errors.forEach(e -> {
        val sourceName = e.getSourceName();
        val position = e.getPosition();
        val errorMessage = e.getErrorMessage();
        log.error("エラーがあります。ファイル名={}, 行数={}, エラーメッセージ={}", sourceName, position, errorMessage);
      });

      throw new ValidationException("取り込むファイルに不正な行が含まれています。");
    }

    return status;
  }

  @Override
  protected void doProcess(BatchContext context) {

    Path path = Paths.get("src/main/resources/data/stocks.csv");
    val list = Lists.newArrayList();
    try {
      List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
      lines.forEach(line -> {
        val row = StringUtils.csvSplit(line);
        val dto = new ImportMstStockDto();
        dto.setSourceName(path.toString());
        dto.setName(row.get(0));
        dto.setDetail(row.get(1));
        dto.setPrice(row.get(2));
        dto.setImgpath(row.get(3));
        dto.setQuantity(row.get(4));
        list.add(dto);
      });
    } catch (IOException e) {
      e.printStackTrace();
    }

    val stockList = ObjectMapperUtils.map(list, Stock[].class);

    for (Stock stock : stockList) {
      stock.setCreatedAt(DateUtils.getNow());
      stock.setUpdatedAt(DateUtils.getNow());
      // TODO DeleteFlgがデフォルト値0のカラムなのに設定しないとエラーになる。。
      // Caused by: java.sql.SQLIntegrityConstraintViolationException: Column 'delete_flg' cannot be null
      stock.setDeleteFlg((byte)0);
      stockDao.insert(stock);
    }

    // S3に商品画像をアップロード
    Path images = Paths.get("src/main/resources/data/stocks");
    try(Stream<Path> stream = Files.list(images)) {
      stream.forEach(p -> {
        imageHelper.saveFile(p.toAbsolutePath().toString(), "/stocks", p.getFileName().toString(), false);
      });
    }catch(IOException e) {
      e.printStackTrace();
    }

  }

  @SuppressWarnings("unchecked")
  private List<ItemError> getErrors(BatchContext context) {
    val additionalInfo = context.getAdditionalInfo();
    List<ItemError> errors = (List<ItemError>) additionalInfo.get("errors");

    if (errors == null) {
      errors = new ArrayList<>();
    }

    return errors;
  }

}
