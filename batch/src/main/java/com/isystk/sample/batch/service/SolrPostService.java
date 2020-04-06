package com.isystk.sample.batch.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.isystk.sample.common.dto.PageFactory;
import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.common.service.BaseTransactionalService;
import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.domain.dao.MPostTagDao;
import com.isystk.sample.domain.dto.MPostTagCriteria;
import com.isystk.sample.domain.dto.TPostCriteria;
import com.isystk.sample.domain.entity.MPostTag;
import com.isystk.sample.domain.entity.TPostImage;
import com.isystk.sample.domain.entity.TPostTag;
import com.isystk.sample.domain.repository.TPostRepository;
import com.isystk.sample.domain.repository.dto.TPostRepositoryDto;
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
		criteria.setDeleteFlgFalse(true);
		val postPage = postRepository.findAll(criteria, Pageable.NO_LIMIT);
		if (postPage.getCount() == 0) {
			// 投稿データが0件の場合は何もしない
			return;
		}

		MPostTagCriteria mPostTagCriteria = new MPostTagCriteria();
		mPostTagCriteria.setDeleteFlgFalse(true);
		val mPostTagList = mPostTagDao.findAll(mPostTagCriteria);
		Map<Integer, String> tagNameMap = Maps.newHashMap();
		for (MPostTag mPostTag : mPostTagList) {
			tagNameMap.put(mPostTag.getPostTagId(), mPostTag.getName());
		}

		List<SolrPost> solrPostList = Lists.newArrayList();
		for (TPostRepositoryDto tPostDto : postPage.getData()) {
			SolrPost solrPost = ObjectMapperUtils.map(tPostDto, SolrPost.class);

			// 投稿画像データを詰める
			List<Integer> imageIdList = Lists.newArrayList();
			if (tPostDto.getTPostImageList() != null) {
				for (TPostImage tPostImage : tPostDto.getTPostImageList()) {
					imageIdList.add(tPostImage.getImageId());
				}
			}
			solrPost.setImageIdList(imageIdList);

			// 投稿タグIDデータを詰める
			List<Integer> tagIdList = Lists.newArrayList();
			if (tPostDto.getTPostTagList() != null) {
				for (TPostTag tPostTag : tPostDto.getTPostTagList()) {
					tagIdList.add(tPostTag.getPostTagId());
				}
			}
			solrPost.setTagIdList(tagIdList);

			// 投稿タグ名称データを詰める
			List<String> tagNameList = Lists.newArrayList();
			for (Integer tagId : tagIdList) {
				tagNameList.add(tagNameMap.get(tagId));
			}
			solrPost.setTagNameList(tagNameList);
			solrPostList.add(solrPost);
		}

		// Solrをすべて削除
		solrPostRepository.deleteAll();

		// Solrに保存
		solrPostRepository.saveAll(solrPostList);
	}

}
