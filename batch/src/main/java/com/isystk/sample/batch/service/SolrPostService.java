package com.isystk.sample.batch.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.isystk.sample.common.dto.PageFactory;
import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.common.service.BaseTransactionalService;
import com.isystk.sample.domain.dao.MPostTagDao;
import com.isystk.sample.domain.dto.MPostTagCriteria;
import com.isystk.sample.domain.dto.TPostCriteria;
import com.isystk.sample.domain.entity.MPostTag;
import com.isystk.sample.domain.repository.TPostRepository;
import com.isystk.sample.solr.dto.SolrPost;
import com.isystk.sample.solr.repository.SolrPostRepository;

import lombok.val;

@Service
public class SolrPostService extends BaseTransactionalService {

	@Autowired
	SolrPostRepository solrPostRepository;

	@Autowired
	TPostRepository postRepository;

	@Autowired
	MPostTagDao mPostTagDao;

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

		// 有効な投稿を全件取得する
		var criteria = new TPostCriteria();
		criteria.setDeleteFlgEqual(false);
		val pages = postRepository.findAll(criteria, Pageable.NO_LIMIT);

		// 入力値を詰め替える
		SolrPost[] datas = modelMapper.map(pages.getData(), SolrPost[].class);

		MPostTagCriteria mPostTagCriteria = new MPostTagCriteria();
		mPostTagCriteria.setDeleteFlgEqual(false);
		val mPostTagList = mPostTagDao.findAll(mPostTagCriteria);
		Map<Integer, String> tagNameMap = Maps.newHashMap();
		for (MPostTag mPostTag : mPostTagList) {
			tagNameMap.put(mPostTag.getPostTagId(), mPostTag.getName());
		}

		for (SolrPost data : datas) {
			// 投稿画像データを詰める
			var imageIdList = Lists.newArrayList(481317464);
			data.setImageIdList(imageIdList);

			// 投稿タグIDデータを詰める
			var tagIdList = Lists.newArrayList(1,3,5,7,9);
			data.setTagIdList(tagIdList);

			// 投稿タグ名称データを詰める
			List<String> tagNameList = Lists.newArrayList();
			for (Integer tagId : tagIdList) {
				tagNameList.add(tagNameMap.get(tagId));
			}
			data.setTagNameList(tagNameList);

		}

		// Solrをすべて削除
		solrPostRepository.deleteAll();

		// Solrに保存
		solrPostRepository.saveAll(Arrays.asList(datas));
	}

}
