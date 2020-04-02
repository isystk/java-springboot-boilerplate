package com.isystk.sample.batch.jobs;

import static com.isystk.sample.batch.BatchConst.EXECUTION_STATUS_SKIP;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.batch.item.ExecutionContext;

import lombok.val;

/**
 * 基底ジョブデサイダー
 */
public abstract class BaseJobDecider implements JobExecutionDecider {

	@Override
	public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
		val context = jobExecution.getExecutionContext();

		if (!decideToProceed(context)) {
			return new FlowExecutionStatus(EXECUTION_STATUS_SKIP);
		}

		return FlowExecutionStatus.COMPLETED;
	}

	/**
	 * Falseを返した場合は処理をスキップします。
	 * 
	 * @param context
	 * @return
	 */
	protected abstract boolean decideToProceed(ExecutionContext context);
}
