package com.isystk.sample.batch.jobs.solr;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import com.isystk.sample.batch.context.BatchContext;
import com.isystk.sample.batch.jobs.BaseTasklet;
import com.isystk.sample.common.util.DateUtils;
import com.isystk.sample.domain.dto.TPostCriteria;
import com.isystk.sample.domain.dto.common.Pageable;
import com.isystk.sample.domain.service.PostService;
import com.isystk.sample.solr.dto.SolrPost;
import com.isystk.sample.solr.repository.SolrPostRepository;
import com.isystk.sample.solr.service.SolrPostService;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

/**
 * インデックス生成
 */
@Slf4j
public class SolrRegistTasklet extends BaseTasklet<SolrRegistPostDto> {

	@Autowired
	PostService postService;

    @Autowired
    SolrPostService solrPostService;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws IOException {
    	return super.execute(contribution, chunkContext);
    }

    @Override
    protected void doProcess(BatchContext context) {

		// 全件取得する
		val pages = postService.findAll(new TPostCriteria(), Pageable.NO_LIMIT);

		// 入力値を詰め替える
		SolrPost[] datas = modelMapper.map(pages.getData(), SolrPost[].class);

		// Solrの投稿インデックスを更新します。
		solrPostService.save(Arrays.asList(datas));
    }

}
