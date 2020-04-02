package com.isystk.sample.batch.jobs.solrRegist;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.isystk.sample.batch.listener.DefaultStepExecutionListener;

/**
 * インデックス生成
 */
@Configuration
@EnableBatchProcessing
public class SolrRegistJobConfig {

	@Autowired
	JobBuilderFactory jobBuilderFactory;

	@Autowired
	StepBuilderFactory stepBuilderFactory;

	@Bean
	public JobExecutionListener solrlRegistJobListener() {
		return new SolrlRegistJobListener();
	}

	@Bean
	public Job solrRegistJob() {
		return jobBuilderFactory.get("solrRegistJob").incrementer(new RunIdIncrementer())
				.listener(solrlRegistJobListener()).start(solrRegistStep1())
//                .next(solrRegistStep2())
				.build();
	}

	@Bean
	public Step solrRegistStep1() {
		return stepBuilderFactory.get("solrRegistStep1").listener(new DefaultStepExecutionListener())
				.tasklet(solrRegistTasklet()).build();
	}

	@Bean
	public Step solrRegistStep2() {
		return stepBuilderFactory.get("solrRegistStep2").listener(new DefaultStepExecutionListener())
				.tasklet(solrRegistTasklet()).build();
	}

	@Bean
	public Tasklet solrRegistTasklet() {
		return new SolrRegistTasklet();
	}
}
