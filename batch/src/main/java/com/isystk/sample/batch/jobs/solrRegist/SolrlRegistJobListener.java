package com.isystk.sample.batch.jobs.solrRegist;

import com.isystk.sample.batch.listener.BaseJobExecutionListener;

public class SolrlRegistJobListener extends BaseJobExecutionListener {

  @Override
  protected String getBatchId() {
    return "BATCH_001";
  }

  @Override
  protected String getBatchName() {
    return "インデックス生成";
  }
}
