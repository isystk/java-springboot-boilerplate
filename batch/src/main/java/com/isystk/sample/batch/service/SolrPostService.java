package com.isystk.sample.batch.service;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isystk.sample.common.dto.PageFactory;
import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.common.service.BaseTransactionalService;
import com.isystk.sample.domain.dto.TPostCriteria;
import com.isystk.sample.domain.repository.PostRepository;
import com.isystk.sample.solr.dto.SolrPost;
import com.isystk.sample.solr.repository.SolrPostRepository;

import lombok.val;

@Service
public class SolrPostService extends BaseTransactionalService {

	@Autowired
	SolrPostRepository solrPostRepository;

	@Autowired
	PostRepository postRepository;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	PageFactory pageFactory;

	/**
	 * Solrの投稿インデックスを更新します。
	 *
	 * @param datas
	 * @return
	 */
	public void refresh() {

		// 全件取得する
		val pages = postRepository.findAll(new TPostCriteria(), Pageable.NO_LIMIT);

		// 入力値を詰め替える
		SolrPost[] datas = modelMapper.map(pages.getData(), SolrPost[].class);

		// Solrをすべて削除
		solrPostRepository.deleteAll();

		// Solrに保存
		solrPostRepository.saveAll(Arrays.asList(datas));
	}

}
