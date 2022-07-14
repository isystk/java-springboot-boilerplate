package com.isystk.sample.solr;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BaseSolrConfig {

  @Value("#{'${spring.data.solr.host:*}'}")
  String solrHost;

  @Bean
  public HttpSolrClient stockSolrClient() {
    return new HttpSolrClient.Builder(solrHost + "/stock").build();
  }

}
