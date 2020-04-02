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
import com.isystk.sample.domain.dto.PostDto;
import com.isystk.sample.domain.dto.TPostCriteria;
import com.isystk.sample.domain.dto.TPostImageCriteria;
import com.isystk.sample.domain.dto.TPostTagCriteria;
import com.isystk.sample.domain.entity.TPost;
import com.isystk.sample.domain.entity.TPostImage;
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
	public Page<PostDto> findAll(TPostCriteria criteria, Pageable pageable) {
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
		List<PostDto> postDtoList = ObjectMapperUtils.mapAll(tPostList, PostDto.class);
		for (PostDto postDto : postDtoList) {
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
	public TPost create(final TPost post) {
		// 1件登録
		val time = DateUtils.getNow();

		post.setRegistTime(time); // 作成日
		post.setUpdateTime(time); // 更新日
		post.setDeleteFlg(false); // 削除フラグ
		post.setVersion(0L); // 楽観ロック改定番号
		tPostDao.insert(post);

		return post;
	}

	/**
	 * 投稿を更新します。
	 *
	 * @param post
	 * @return
	 */
	public TPost update(final TPost inputPost) {
//        val uploadFile = inputPost.getUploadFile();
//        if (uploadFile != null) {
//            // 添付ファイルがある場合は、登録・更新する
//            val uploadFileId = inputPost.getUploadFileId();
//            if (uploadFileId == null) {
//                uploadFileDao.insert(uploadFile);
//            } else {
//                uploadFileDao.update(uploadFile);
//            }
//
//            inputPost.setUploadFileId(uploadFile.getId());
//        }

		// 1件更新
		val time = DateUtils.getNow();
		inputPost.setUpdateTime(time); // 更新日
		int updated = tPostDao.update(inputPost);

		if (updated < 1) {
			throw new NoDataFoundException("post_id=" + inputPost.getPostId() + " のデータが見つかりません。");
		}

		return inputPost;
	}

	/**
	 * 投稿を論理削除します。
	 *
	 * @return
	 */
	public TPost delete(final Integer id) {
		val post = tPostDao.selectById(id)
				.orElseThrow(() -> new NoDataFoundException("post_id=" + id + " のデータが見つかりません。"));

		val time = DateUtils.getNow();
		post.setUpdateTime(time); // 削除日
		post.setDeleteFlg(true); // 削除フラグ
		int updated = tPostDao.delete(post);

		if (updated < 1) {
			throw new NoDataFoundException("post_id=" + id + " は更新できませんでした。");
		}

		return post;
	}
}
