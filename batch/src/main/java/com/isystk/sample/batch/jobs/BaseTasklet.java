package com.isystk.sample.batch.jobs;

import java.io.IOException;

import org.modelmapper.ModelMapper;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.annotation.OnProcessError;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import com.isystk.sample.batch.context.BatchContext;
import com.isystk.sample.batch.context.BatchContextHolder;
import com.isystk.sample.batch.item.ItemPosition;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

/**
 * 基底タスクレット
 */
@Slf4j
public abstract class BaseTasklet<I extends ItemPosition> implements Tasklet {

  /**
   * メインメソッド
   *
   * @param contribution
   * @param chunkContext
   * @return
   * @throws Exception
   */
  public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext)
      throws IOException {
    val context = BatchContextHolder.getContext();

    // 実処理
    doProcess(context);

    return RepeatStatus.FINISHED;
  }

  /**
   * 実処理を実施します。
   *
   * @param context
   * @param item
   * @return
   */
  protected abstract void doProcess(BatchContext context);

  /**
   * 例外発生時のデフォルト実装
   *
   * @param item
   * @param e
   */
  @OnProcessError
  protected void onProcessError(I item, Exception e) {
    log.error("failed to process item.", e);
    throw new IllegalStateException(e);
  }
}
