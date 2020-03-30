package com.isystk.sample.solr.service;

import static com.isystk.sample.domain.util.DomaUtils.createSelectOptions;
import java.util.List;

import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.isystk.sample.domain.dto.common.Page;
import com.isystk.sample.domain.dto.common.PageFactory;
import com.isystk.sample.domain.dto.common.Pageable;
import com.isystk.sample.domain.service.BaseTransactionalService;
import com.isystk.sample.solr.dto.SolrPost;
import com.isystk.sample.solr.dto.SolrPostCriteria;
import com.isystk.sample.solr.repository.SolrPostRepository;

import lombok.val;

@Service
public class SolrPostService extends BaseTransactionalService {

    @Autowired
    SolrPostRepository solrPostRepository;

    @Autowired
    PageFactory pageFactory;

    /**
     * Solrの投稿インデックスを取得します。
     *
     * @param datas
     * @return
     */
    @Transactional(readOnly = true) // 読み取りのみの場合は指定する
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

        return pageFactory.create(solrPostList, pageable, options.getCount());
    }

    /**
     * Solrの投稿インデックスを更新します。
     *
     * @param datas
     * @return
     */
    public void save(final List<SolrPost> datas) {
        Assert.notNull(datas, "input must not be null");

		// Solrをすべて削除
		solrPostRepository.deleteAll();

		// Solrに保存
		solrPostRepository.saveAll(datas);
    }

}
