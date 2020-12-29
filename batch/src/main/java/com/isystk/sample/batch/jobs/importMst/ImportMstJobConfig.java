package com.isystk.sample.batch.jobs.importMst;

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
 * ユーザー情報取り込み
 */
@Configuration
@EnableBatchProcessing
public class ImportMstJobConfig {

  @Autowired
  JobBuilderFactory jobBuilderFactory;

  @Autowired
  StepBuilderFactory stepBuilderFactory;

  @Bean
  public JobExecutionListener importUserJobListener() {
    return new ImportMstJobListener();
  }

  @Bean
  public Job importMstJob() {
    return jobBuilderFactory.get("importMstJob").incrementer(new RunIdIncrementer())
        .listener(importUserJobListener()).start(importMstPostStep())
//              .next(importMstPostStep())
        .build();
  }

  @Bean
  public Step importMstPostStep() {
    return stepBuilderFactory.get("importMstPostStep").listener(new DefaultStepExecutionListener())
        .tasklet(importMstPostTasklet()).build();
  }

  @Bean
  public Tasklet importMstPostTasklet() {
    return new ImportMstPostTasklet();
  }
}
