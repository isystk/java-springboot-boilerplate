package com.isystk.sample.solr;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@EnableSolrRepositories(basePackages = "com.isystk.sample.solr.repository")
public class BaseSolrConfig {

	@Value("#{'${spring.data.solr.host:*}'}")
	String solrURL;

	@Bean
	public SolrClient solrClient() {
		return new HttpSolrClient.Builder(solrURL).build();
	}

	@Bean
	public SolrTemplate solrTemplate(SolrClient client) throws Exception {
		return new SolrTemplate(client);
	}
}
