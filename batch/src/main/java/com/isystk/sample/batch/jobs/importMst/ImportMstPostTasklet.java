package com.isystk.sample.batch.jobs.importMst;

import static com.isystk.sample.common.util.ValidateUtils.isNotEmpty;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ValidationException;

import org.apache.commons.compress.utils.Lists;
import org.apache.commons.lang3.StringUtils;
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
import com.isystk.sample.domain.dao.MPostTagDao;
import com.isystk.sample.domain.entity.MPostTag;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

/**
 * ユーザー情報取り込みタスク
 */
@Slf4j
public class ImportMstPostTasklet extends BaseTasklet<ImportMstPostDto> {

	@Autowired
	MPostTagDao mPostTagDao;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws IOException {
		val status = super.execute(contribution, chunkContext);

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

		Path path = Paths.get("src/main/resources/tag_mst.csv");
		val importTagDtoList = Lists.newArrayList();
		try {
			List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
			lines.forEach(line -> {
				val row = StringUtils.splitByWholeSeparatorPreserveAllTokens(line, ",");
				val dto = new ImportMstPostDto();
				dto.setSourceName(path.toString());
				dto.setPostTagId(row[0]);
				dto.setName(row[1]);
				importTagDtoList.add(dto);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

		val csvPostTags = ObjectMapperUtils.map(importTagDtoList, MPostTag[].class);

		for (MPostTag csvPostTag : csvPostTags) {
			var data = mPostTagDao.selectById(csvPostTag.getPostTagId());
			if (data.isEmpty()) {
				MPostTag mPostTag = ObjectMapperUtils.map(csvPostTag, MPostTag.class);
				mPostTag.setRegistTime(DateUtils.getNow());
				mPostTag.setUpdateTime(DateUtils.getNow());
				mPostTag.setDeleteFlg(false);
				mPostTagDao.insert(mPostTag);
			} else {
				MPostTag mPostTag = data.get();
				mPostTag.setName(csvPostTag.getName());
				mPostTag.setUpdateTime(DateUtils.getNow());
				mPostTagDao.update(mPostTag);
			}
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
