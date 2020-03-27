package com.isystk.sample.batch.jobs.user;

import com.isystk.sample.batch.listener.BaseJobExecutionListener;

public class ImportUserJobListener extends BaseJobExecutionListener {

    @Override
    protected String getBatchId() {
        return "BATCH_002";
    }

    @Override
    protected String getBatchName() {
        return "ユーザー情報取り込み";
    }
}
