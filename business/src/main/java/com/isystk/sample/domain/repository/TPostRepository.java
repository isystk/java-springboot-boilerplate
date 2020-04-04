package com.isystk.sample.domain.repository;

import static com.isystk.sample.domain.util.DomaUtils.createSelectOptions;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.isystk.sample.common.dto.Page;
import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.common.exception.NoDataFoundException;
import com.isystk.sample.common.service.BaseRepository;
import com.isystk.sample.common.util.DateUtils;
import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.domain.dao.TPostDao;
import com.isystk.sample.domain.dao.TPostImageDao;
import com.isystk.sample.domain.dao.TPostTagDao;
import com.isystk.sample.domain.dto.TPostCriteria;
import com.isystk.sample.domain.dto.TPostImageCriteria;
import com.isystk.sample.domain.dto.TPostTagCriteria;
import com.isystk.sample.domain.entity.TPost;
import com.isystk.sample.domain.entity.TPostImage;
import com.isystk.sample.domain.entity.TPostDto;
import com.isystk.sample.domain.entity.TPostTag;

import lombok.val;

/**
 * 投稿リポジトリ
 */
@Repository
public class TPostRepository extends BaseRepository {

	@Autowired
	TPostDao tPostDao;

	@Autowired
	TPostImageDao tPostImageDao;

	@Autowired
	TPostTagDao tPostTagDao;

	/**
	 * 投稿を複数取得します。
	 *
	 * @param criteria
	 * @param pageable
	 * @return
	 */
	public Page<TPostDto> findAll(TPostCriteria criteria, Pageable pageable) {
		// ページングを指定する
		val options = createSelectOptions(pageable).count();
		List<TPost> tPostList = tPostDao.findAll(criteria, options, toList());

		// tPostListからPostIdのListを抽出
		List<Integer> postIdList = tPostList.stream().map(e -> Integer.valueOf(e.getPostId())).collect(Collectors.toList());

		// postId をkeyとした、tPostImageListのMapを生成
		TPostImageCriteria tPostImageCriteria = new TPostImageCriteria();
		tPostImageCriteria.setPostIdIn(postIdList);
		Map<Integer, List<TPostImage>> tPostImageMap = tPostImageDao.findAll(tPostImageCriteria).stream().collect(Collectors.groupingBy(TPostImage::getPostId));

		// postId をkeyとした、tPostTagListのMapを生成
		TPostTagCriteria tPostTagCriteria = new TPostTagCriteria();
		tPostTagCriteria.setPostIdIn(postIdList);
		Map<Integer, List<TPostTag>> tPostTagMap = tPostTagDao.findAll(tPostTagCriteria).stream().collect(Collectors.groupingBy(TPostTag::getPostId));

		// tPostList を元に、postDtoList へコピー
		List<TPostDto> postDtoList = ObjectMapperUtils.mapAll(tPostList, TPostDto.class);
		for (TPostDto postDto : postDtoList) {
			postDto.setTPostImageList(tPostImageMap.get(postDto.getPostId()));
			postDto.setTPostTagList(tPostTagMap.get(postDto.getPostId()));
		}

		return pageFactory.create(postDtoList, pageable, options.getCount());
	}

	/**
	 * 投稿を取得します。
	 *
	 * @param criteria
	 * @return
	 */
	public Optional<TPost> findOne(TPostCriteria criteria) {
		return tPostDao.findOne(criteria);
	}

	/**
	 * 投稿を取得します。
	 *
	 * @return
	 */
	public TPost findById(final Integer id) {
		return tPostDao.selectById(id).orElseThrow(() -> new NoDataFoundException("post_id=" + id + " のデータが見つかりません。"));
	}

	/**
	 * 投稿を追加します。
	 *
	 * @param post
	 * @return
	 */
	public TPost create(final TPostDto tPostDto) {
		val time = DateUtils.getNow();

		// 投稿テーブル
		val tPost = ObjectMapperUtils.map(tPostDto, TPost.class);
		tPost.setRegistTime(time); // 作成日
		tPost.setUpdateTime(time); // 更新日
		tPost.setDeleteFlg(false); // 削除フラグ
		tPost.setVersion(0L); // 楽観ロック改定番号
		tPostDao.insert(tPost);

		// 投稿画像テーブル
		val tPostImageList = ObjectMapperUtils.mapAll(tPostDto.getTPostImageList(), TPostImage.class);
		for (TPostImage tPostImage : tPostImageList) {
			tPostImage.setPostId(tPost.getPostId());
			tPostImageDao.insert(tPostImage);
		}

		// 投稿タグテーブル
		val tPostTagList = ObjectMapperUtils.mapAll(tPostDto.getTPostTagList(), TPostTag.class);
		for (TPostTag tPostTag : tPostTagList) {
			tPostTag.setPostId(tPost.getPostId());
			tPostTagDao.insert(tPostTag);
		}

		return tPost;
	}

	/**
	 * 投稿を更新します。
	 *
	 * @param post
	 * @return
	 */
	public TPost update(final TPostDto tPostDto) {
		val time = DateUtils.getNow();

		val post = tPostDao.selectById(tPostDto.getPostId())
				.orElseThrow(() -> new NoDataFoundException("post_id=" + tPostDto.getPostId() + " のデータが見つかりません。"));

		// 投稿テーブル
		val tPost = ObjectMapperUtils.mapExcludeNull(tPostDto, post);
		tPost.setUpdateTime(time); // 更新日
		tPostDao.update(tPost);

		// 投稿画像テーブル (Delete→Insert)
		TPostImageCriteria tPostImageCriteria = new TPostImageCriteria();
		tPostImageCriteria.setPostIdEq(tPostDto.getPostId());
		for (TPostImage tPostImage : tPostImageDao.findAll(tPostImageCriteria)) {
			tPostImageDao.delete(tPostImage);
		}
		val tPostImageList = ObjectMapperUtils.mapAll(tPostDto.getTPostImageList(), TPostImage.class);
		for (TPostImage tPostImage : tPostImageList) {
			tPostImage.setPostId(tPost.getPostId());
			tPostImageDao.insert(tPostImage);
		}

		// 投稿タグテーブル (Delete→Insert)
		TPostTagCriteria tPostTagCriteria = new TPostTagCriteria();
		tPostTagCriteria.setPostIdEq(tPostDto.getPostId());
		for (TPostTag tPostTag : tPostTagDao.findAll(tPostTagCriteria)) {
			tPostTagDao.delete(tPostTag);
		}
		val tPostTagList = ObjectMapperUtils.mapAll(tPostDto.getTPostTagList(), TPostTag.class);
		for (TPostTag tPostTag : tPostTagList) {
			tPostTag.setPostId(tPost.getPostId());
			tPostTagDao.insert(tPostTag);
		}

		return tPost;
	}

	/**
	 * 投稿を論理削除します。
	 *
	 * @return
	 */
	public TPost delete(final Integer postId) {
		val post = tPostDao.selectById(postId)
				.orElseThrow(() -> new NoDataFoundException("post_id=" + postId + " のデータが見つかりません。"));

		val time = DateUtils.getNow();
		post.setUpdateTime(time); // 削除日
		post.setDeleteFlg(true); // 削除フラグ
		int updated = tPostDao.delete(post);

		if (updated < 1) {
			throw new NoDataFoundException("post_id=" + postId + " は更新できませんでした。");
		}

		return post;
	}
}
