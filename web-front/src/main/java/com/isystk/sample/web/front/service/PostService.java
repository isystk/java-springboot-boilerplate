package com.isystk.sample.web.front.service;

import static com.isystk.sample.domain.util.DomaUtils.createSelectOptions;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.isystk.sample.common.dto.Page;
import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.common.helper.ImageHelper;
import com.isystk.sample.common.service.BaseTransactionalService;
import com.isystk.sample.common.util.DateUtils;
import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.domain.dto.TPostResultDto;
import com.isystk.sample.domain.dto.TPostCriteria;
import com.isystk.sample.domain.entity.TPost;
import com.isystk.sample.domain.entity.TPostImage;
import com.isystk.sample.domain.repository.TPostRepository;
import com.isystk.sample.solr.dto.SolrPost;
import com.isystk.sample.solr.dto.SolrPostCriteria;
import com.isystk.sample.solr.repository.SolrPostRepository;
import com.isystk.sample.web.front.dto.FrontPostDto;

import lombok.val;

@Service
public class PostService extends BaseTransactionalService {

	@Autowired
	SolrPostRepository solrPostRepository;

	@Autowired
	TPostRepository postRepository;

	@Autowired
	ImageHelper imageHelper;

	/**
	 * Solrの投稿インデックスを取得します。
	 *
	 * @param datas
	 * @return
	 */
	@Transactional(readOnly = true) // 読み取りのみの場合は指定する
	public Page<FrontPostDto> findSolrAll(SolrPostCriteria criteria, Pageable pageable) {
		Assert.notNull(criteria, "criteria must not be null");

		// TODO ここでページングを設定
		Iterable<SolrPost> solrPosts = solrPostRepository.findAll();

		List<FrontPostDto> solrPostList = Lists.newArrayList();
		for (SolrPost solrPost : solrPosts) {
			solrPostList.add(convertToFrontPostDto(solrPost));
		}

		// ページングを指定する
		val options = createSelectOptions(pageable).count();
		return pageFactory.create(solrPostList, pageable, options.getCount());
	}

	/**
	 * Solrの投稿インデックスを取得します。
	 *
	 * @param datas
	 * @return
	 */
	@Transactional(readOnly = true) // 読み取りのみの場合は指定する
	public Optional<FrontPostDto> findSolrById(Integer postId) {
		Assert.notNull(postId, "criteria must not be null");

		SolrPost solrPost = solrPostRepository.findByPostId(postId);

		return Optional.of(convertToFrontPostDto(solrPost));
	}

	/**
	 *
	 * @param solrPost
	 * @return
	 */
	private FrontPostDto convertToFrontPostDto(SolrPost solrPost) {
		// 入力値を詰め替える
		var dto = ObjectMapperUtils.map(solrPost, FrontPostDto.class);

		// 画像のパスを設定
		List<String> imageUrlList = Lists.newArrayList();
		for (Integer imageId : solrPost.getImageIdList()) {
			imageUrlList.add(imageHelper.getUrl(imageId));
		}
		dto.setImageUrlList(imageUrlList);

		dto.setRegistTimeYYYYMMDD(DateUtils.format(solrPost.getRegistTime(), DateTimeFormatter.ofPattern("yyyy/MM/dd")));
		dto.setRegistTimeMMDD(DateUtils.format(solrPost.getRegistTime(), DateTimeFormatter.ofPattern("MM/dd")));
		return dto;
	}

	/**
	 * 投稿を複数取得します。
	 *
	 * @param criteria
	 * @param pageable
	 * @return
	 */
	@Transactional(readOnly = true) // 読み取りのみの場合は指定する
	public Page<FrontPostDto> findAll(TPostCriteria criteria, Pageable pageable) {
		Assert.notNull(criteria, "criteria must not be null");
		Page<TPostResultDto> postDtoPage = postRepository.findAll(criteria, pageable);

		List<FrontPostDto> list = Lists.newArrayList();
		for (TPostResultDto postDto : postDtoPage.getData()) {
			var dto = ObjectMapperUtils.map(postDto, FrontPostDto.class);

			List<String> imageUrlList = Lists.newArrayList();
			if (postDto.getTPostImageList() != null) {
				for (TPostImage tPostImage : postDto.getTPostImageList()) {
					imageUrlList.add(imageHelper.getUrl(tPostImage.getImageId()));
				}
			}
			dto.setImageUrlList(imageUrlList);

			list.add(dto);
		}

		return pageFactory.create(list, postDtoPage, postDtoPage.getCount());
	}

	/**
	 * 投稿を取得します。
	 *
	 * @return
	 */
	@Transactional(readOnly = true)
	public Optional<TPost> findOne(TPostCriteria criteria) {
		Assert.notNull(criteria, "criteria must not be null");
		return postRepository.findOne(criteria);
	}

	/**
	 * 投稿を取得します。
	 *
	 * @return
	 */
	@Transactional(readOnly = true)
	public TPost findById(final Integer id) {
		Assert.notNull(id, "id must not be null");
		return postRepository.findById(id);
	}

	/**
	 * 投稿を追加します。
	 *
	 * @param input
	 * @return
	 */
	public TPost create(final TPost input) {
		Assert.notNull(input, "input must not be null");
		return postRepository.create(input);
	}

	/**
	 * 投稿を更新します。
	 *
	 * @param input
	 * @return
	 */
	public TPost update(final TPost input) {
		Assert.notNull(input, "input must not be null");
		return postRepository.update(input);
	}

	/**
	 * 投稿を論理削除します。
	 *
	 * @return
	 */
	public TPost delete(final Integer id) {
		Assert.notNull(id, "id must not be null");
		return postRepository.delete(id);
	}
}
