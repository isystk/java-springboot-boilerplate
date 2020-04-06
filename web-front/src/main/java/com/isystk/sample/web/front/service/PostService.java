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
import com.isystk.sample.common.values.ImageSuffix;
import com.isystk.sample.domain.dto.TPostCriteria;
import com.isystk.sample.domain.entity.TPost;
import com.isystk.sample.domain.entity.TPostImage;
import com.isystk.sample.domain.repository.TPostRepository;
import com.isystk.sample.domain.repository.dto.TPostRepositoryDto;
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
		if (solrPost.getImageIdList() != null) {
			for (Integer imageId : solrPost.getImageIdList()) {
				imageUrlList.add(imageHelper.getUrl(imageId, ImageSuffix.SQUARE.getSuffix()));
			}
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
		Page<TPostRepositoryDto> postDtoPage = postRepository.findAll(criteria, pageable);

		List<FrontPostDto> list = Lists.newArrayList();
		for (TPostRepositoryDto postDto : postDtoPage.getData()) {
			var dto = ObjectMapperUtils.map(postDto, FrontPostDto.class);

			dto.setImageUrlList(Lists.newArrayList());
			dto.setImageIdList(Lists.newArrayList());
			if (postDto.getTPostImageList() != null) {
				for (TPostImage tPostImage : postDto.getTPostImageList()) {
					dto.getImageIdList().add(tPostImage.getImageId());
					dto.getImageUrlList().add(imageHelper.getUrl(tPostImage.getImageId(), ImageSuffix.SQUARE.getSuffix()));
				}
			}

			list.add(dto);
		}

		return pageFactory.create(list, postDtoPage, postDtoPage.getCount());
	}

	/**
	 * 投稿を追加します。
	 *
	 * @param input
	 * @return
	 */
	public int create(final TPostRepositoryDto tPostDto) {
		Assert.notNull(tPostDto, "input must not be null");
		TPost tPost = postRepository.create(tPostDto);
		return tPost.getPostId();
	}

	/**
	 * 投稿を更新します。
	 *
	 * @param input
	 * @return
	 */
	public void update(final TPostRepositoryDto tPostDto) {
		Assert.notNull(tPostDto, "input must not be null");
		postRepository.update(tPostDto);
	}

	/**
	 * 投稿を論理削除します。
	 *
	 * @return
	 */
	public TPost delete(final Integer postId) {
		Assert.notNull(postId, "postId must not be null");
		return postRepository.delete(postId);
	}
}
