package com.isystk.sample.batch.jobs.solrRegist;

import java.io.IOException;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import com.isystk.sample.batch.context.BatchContext;
import com.isystk.sample.batch.jobs.BaseTasklet;
import com.isystk.sample.batch.service.SolrPostService;

import lombok.extern.slf4j.Slf4j;

/**
 * インデックス生成
 */
@Slf4j
public class SolrRegistTasklet extends BaseTasklet<SolrRegistPostDto> {

  @Autowired
  SolrPostService solrPostService;

  @Override
  public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext)
      throws IOException {
    return super.execute(contribution, chunkContext);
  }

  @Override
  protected void doProcess(BatchContext context) {
    // Solrの投稿インデックスを更新します。
    solrPostService.refresh();
  }

}
