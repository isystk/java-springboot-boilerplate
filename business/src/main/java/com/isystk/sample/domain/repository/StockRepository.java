package com.isystk.sample.domain.repository;

import static com.isystk.sample.domain.util.DomaUtils.createSelectOptions;
import static java.util.stream.Collectors.toList;

import com.google.common.collect.Lists;
import com.isystk.sample.common.dto.Page;
import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.common.exception.NoDataFoundException;
import com.isystk.sample.common.helper.ImageHelper;
import com.isystk.sample.common.service.BaseRepository;
import com.isystk.sample.common.util.DateUtils;
import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.domain.dao.StockDao;
import com.isystk.sample.domain.dto.StockCriteria;
import com.isystk.sample.domain.dto.StockRepositoryDto;
import com.isystk.sample.domain.entity.Stock;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 商品リポジトリ
 */
@Repository
public class StockRepository extends BaseRepository {

  @Autowired
  ImageHelper imageHelper;

  @Autowired
  StockDao stockDao;

  /**
   * 商品を複数取得します。
   *
   * @param criteria
   * @return
   */
  public List<StockRepositoryDto> findAll(StockCriteria criteria) {
    var options = createSelectOptions(1, Integer.MAX_VALUE);
    return convertDto(stockDao.findAll(criteria, options, toList()));
  }

  /**
   * 商品を複数取得します。(ページングあり)
   *
   * @param criteria
   * @param pageable
   * @return
   */
  public Page<StockRepositoryDto> findPage(StockCriteria criteria, Pageable pageable) {
    var options = createSelectOptions(pageable);
    var stocksList =  convertDto(stockDao.findAll(criteria, options.count(), toList()));
    return pageFactory.create(stocksList, pageable, options.getCount());
  }

  /**
   * RepositoryDto に変換します。
   *
   * @param stockList
   * @return
   */
  private List<StockRepositoryDto> convertDto(List<Stock> stockList) {

    // stockList を元に、stockDtoList へコピー
    return ObjectMapperUtils
        .mapAll(stockList, StockRepositoryDto.class);

  }

  /**
   * 商品を取得します。
   *
   * @param criteria
   * @return
   */
  public Optional<StockRepositoryDto> findOne(StockCriteria criteria) {
    var data = stockDao.findOne(criteria)
        .orElseThrow(() -> new NoDataFoundException(criteria + "のデータが見つかりません。"));
    return Optional.ofNullable(convertDto(Lists.newArrayList(data)).get(0));
  }

  /**
   * 商品を取得します。
   *
   * @return
   */
  public StockRepositoryDto findById(final BigInteger id) {
    var data = stockDao.selectById(id)
        .orElseThrow(() -> new NoDataFoundException("stock_id=" + id + " のデータが見つかりません。"));
    return convertDto(Lists.newArrayList(data)).get(0);
  }

  /**
   * 商品を追加します。
   *
   * @param stockDto
   * @return
   */
  public Stock create(final StockRepositoryDto stockDto) {

    // 画像ファイルをS3にアップロードする
    imageHelper.saveFile(stockDto.getStockImageData(), "/stocks", stockDto.getStockImageName());

    val time = DateUtils.getNow();

    // 商品テーブル
    val stocks = ObjectMapperUtils.map(stockDto, Stock.class);
    stocks.setImgpath(stockDto.getStockImageName());
    stocks.setCreatedAt(time); // 作成日
    stocks.setUpdatedAt(time); // 更新日
    stocks.setDeleteFlg(Byte.valueOf("0")); // 削除フラグ
    stocks.setVersion(0L); // 楽観ロック改定番号
    stockDao.insert(stocks);

    return stocks;
  }

  /**
   * 商品を更新します。
   *
   * @param stocksDto
   * @return
   */
  public Stock update(final StockRepositoryDto stocksDto) {
    val time = DateUtils.getNow();

    val stock = stockDao.selectById(stocksDto.getId())
        .orElseThrow(
            () -> new NoDataFoundException("stock_id=" + stocksDto.getId() + " のデータが見つかりません。"));

    // 商品テーブル
    val stocks = ObjectMapperUtils.mapExcludeNull(stocksDto, stock);
    stocks.setUpdatedAt(time); // 更新日
    stockDao.update(stocks);

    return stocks;
  }

  /**
   * 商品を論理削除します。
   *
   * @return
   */
  public Stock delete(final BigInteger stockId) {
    val stock = stockDao.selectById(stockId)
        .orElseThrow(() -> new NoDataFoundException("stock_id=" + stockId + " のデータが見つかりません。"));

    val time = DateUtils.getNow();
    stock.setUpdatedAt(time); // 削除日
    stock.setDeleteFlg((byte) 1); // 削除フラグ
    int updated = stockDao.update(stock);

    if (updated < 1) {
      throw new NoDataFoundException("stock_id=" + stockId + " は更新できませんでした。");
    }

    return stock;
  }
}
