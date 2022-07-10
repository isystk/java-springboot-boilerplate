package com.isystk.sample.batch.jobs.importMst;

import com.isystk.sample.batch.listener.BaseJobExecutionListener;

public class ImportMstJobListener extends BaseJobExecutionListener {

  @Override
  protected String getBatchId() {
    return "BATCH_002";
  }

  @Override
  protected String getBatchName() {
    return "マスタ取り込み";
  }
}
