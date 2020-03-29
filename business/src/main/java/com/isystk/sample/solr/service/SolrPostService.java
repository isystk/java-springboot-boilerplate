package com.isystk.sample.solr.service;

import static com.isystk.sample.domain.util.DomaUtils.createSelectOptions;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.isystk.sample.domain.dto.common.Page;
import com.isystk.sample.domain.dto.common.PageFactory;
import com.isystk.sample.domain.dto.common.Pageable;
import com.isystk.sample.solr.dto.SolrPost;
import com.isystk.sample.solr.dto.SolrPostCriteria;
import com.isystk.sample.solr.repository.SolrPostRepository;

import lombok.val;

@Service
public class SolrPostService {

    @Autowired
    SolrPostRepository solrPostRepository;

    @Autowired
    PageFactory pageFactory;

    public Page<SolrPost> findAll(SolrPostCriteria criteria, Pageable pageable) {
        Assert.notNull(criteria, "criteria must not be null");

        // TODO ここでページングを設定
        Iterable<SolrPost> posts = solrPostRepository.findAll();

        List<SolrPost> solrPostList = Lists.newArrayList();
        for (SolrPost post : posts) {
        	solrPostList.add(post);
        }

        // ページングを指定する
        val options = createSelectOptions(pageable).count();
        val data = solrPostRepository.findAll();
        return pageFactory.create(solrPostList, pageable, options.getCount());
    }

}
