package com.isystk.sample.domain.repository;

import static com.isystk.sample.domain.util.DomaUtils.createSelectOptions;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.isystk.sample.common.dto.Page;
import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.common.exception.NoDataFoundException;
import com.isystk.sample.common.service.BaseRepository;
import com.isystk.sample.common.util.DateUtils;
import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.domain.dao.TPostDao;
import com.isystk.sample.domain.dao.TPostImageDao;
import com.isystk.sample.domain.dao.TPostTagDao;
import com.isystk.sample.domain.dao.TUserDao;
import com.isystk.sample.domain.dto.TPostCriteria;
import com.isystk.sample.domain.dto.TPostImageCriteria;
import com.isystk.sample.domain.dto.TPostTagCriteria;
import com.isystk.sample.domain.dto.TUserCriteria;
import com.isystk.sample.domain.entity.TPost;
import com.isystk.sample.domain.entity.TPostImage;
import com.isystk.sample.domain.entity.TPostTag;
import com.isystk.sample.domain.entity.TUser;
import com.isystk.sample.domain.repository.dto.TPostRepositoryDto;

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

  @Autowired
  TUserDao tUserDao;

  /**
   * 投稿を複数取得します。
   *
   * @param criteria
   * @param pageable
   * @return
   */
  public Page<TPostRepositoryDto> findAll(TPostCriteria criteria, Pageable pageable) {
    var options = createSelectOptions(pageable);
    // ページングを指定する
    return pageFactory.create(convertDto(
        tPostDao.findAll(criteria,
            options.count(),
            toList()
        )), pageable, options.getCount());
  }

  /**
   * RepositoryDto に変換します。
   *
   * @param tPostList
   * @return
   */
  private List<TPostRepositoryDto> convertDto(List<TPost> tPostList) {

    // tPostListからPostIdのListを抽出
    List<Integer> postIdList = tPostList.stream().map(e -> Integer.valueOf(e.getPostId()))
        .collect(Collectors.toList());

    // postId をkeyとした、tPostImageListのMapを生成
    TPostImageCriteria tPostImageCriteria = new TPostImageCriteria();
    tPostImageCriteria.setPostIdIn(postIdList);
    Map<Integer, List<TPostImage>> tPostImageMap = tPostImageDao.findAll(tPostImageCriteria)
        .stream().collect(Collectors.groupingBy(TPostImage::getPostId));

    // postId をkeyとした、tPostTagListのMapを生成
    TPostTagCriteria tPostTagCriteria = new TPostTagCriteria();
    tPostTagCriteria.setPostIdIn(postIdList);
    Map<Integer, List<TPostTag>> tPostTagMap = tPostTagDao.findAll(tPostTagCriteria).stream()
        .collect(Collectors.groupingBy(TPostTag::getPostId));

    // tPostListからUserIdのListを抽出
    List<Integer> userIdList = tPostList.stream().map(e -> Integer.valueOf(e.getUserId()))
        .collect(Collectors.toList());

    // userId をkeyとした、tUserのMapを生成
    TUserCriteria tUserCriteria = new TUserCriteria();
    tUserCriteria.setUserIdIn(userIdList);
    Map<Integer, List<TUser>> tUserMap = tUserDao.findAll(tUserCriteria).stream()
        .collect(Collectors.groupingBy(TUser::getUserId));

    // tPostList を元に、postDtoList へコピー
    List<TPostRepositoryDto> postDtoList = ObjectMapperUtils
        .mapAll(tPostList, TPostRepositoryDto.class);
    postDtoList
        .stream()
        .forEach(postDto -> {
          postDto.setTPostImageList(tPostImageMap.get(postDto.getPostId()));
          postDto.setTPostTagList(tPostTagMap.get(postDto.getPostId()));
          postDto.setTUser(tUserMap.get(postDto.getUserId()).get(0));
        });

    return postDtoList;
  }

  /**
   * 投稿を取得します。
   *
   * @param criteria
   * @return
   */
  public Optional<TPostRepositoryDto> findOne(TPostCriteria criteria) {
    var data = tPostDao.findOne(criteria)
        .orElseThrow(() -> new NoDataFoundException(criteria + "のデータが見つかりません。"));
    return Optional.ofNullable(convertDto(Lists.newArrayList(data)).get(0));
  }

  /**
   * 投稿を取得します。
   *
   * @return
   */
  public TPostRepositoryDto findById(final Integer id) {
    var data = tPostDao.selectById(id)
        .orElseThrow(() -> new NoDataFoundException("post_id=" + id + " のデータが見つかりません。"));
    return convertDto(Lists.newArrayList(data)).get(0);
  }

  /**
   * 投稿を追加します。
   *
   * @param tPostDto
   * @return
   */
  public TPost create(final TPostRepositoryDto tPostDto) {
    val time = DateUtils.getNow();

    // 投稿テーブル
    val tPost = ObjectMapperUtils.map(tPostDto, TPost.class);
    tPost.setRegistTime(time); // 作成日
    tPost.setUpdateTime(time); // 更新日
    tPost.setDeleteFlg(false); // 削除フラグ
    tPost.setVersion(0L); // 楽観ロック改定番号
    tPostDao.insert(tPost);

    // 投稿画像テーブル
    val tPostImageList = ObjectMapperUtils
        .mapAll(Optional.ofNullable(tPostDto.getTPostImageList()).orElse(Lists.newArrayList()),
            TPostImage.class);
    tPostImageList.stream()
        .forEach(tPostImage -> {
          tPostImage.setPostId(tPost.getPostId());
          tPostImageDao.insert(tPostImage);
        });

    // 投稿タグテーブル
    val tPostTagList = ObjectMapperUtils
        .mapAll(Optional.ofNullable(tPostDto.getTPostTagList()).orElse(Lists.newArrayList()),
            TPostTag.class);
    tPostTagList.stream()
        .forEach(tPostTag -> {
          tPostTag.setPostId(tPost.getPostId());
          tPostTagDao.insert(tPostTag);
        });

    return tPost;
  }

  /**
   * 投稿を更新します。
   *
   * @param tPostDto
   * @return
   */
  public TPost update(final TPostRepositoryDto tPostDto) {
    val time = DateUtils.getNow();

    val post = tPostDao.selectById(tPostDto.getPostId())
        .orElseThrow(
            () -> new NoDataFoundException("post_id=" + tPostDto.getPostId() + " のデータが見つかりません。"));

    // 投稿テーブル
    val tPost = ObjectMapperUtils.mapExcludeNull(tPostDto, post);
    tPost.setUpdateTime(time); // 更新日
    tPostDao.update(tPost);

    // 投稿画像テーブル (Delete→Insert)
    TPostImageCriteria tPostImageCriteria = new TPostImageCriteria();
    tPostImageCriteria.setPostIdEq(tPostDto.getPostId());

    // 投稿画像（Delete→Insert）
    tPostImageDao.findAll(tPostImageCriteria)
        .stream()
        .forEach(tPostImage -> {
          tPostImageDao.delete(tPostImage);
        });
    ObjectMapperUtils
        .mapAll(Optional.ofNullable(tPostDto.getTPostImageList()).orElse(Lists.newArrayList()),
            TPostImage.class)
        .stream()
        .forEach(tPostImage -> {
          tPostImage.setPostId(tPost.getPostId());
          tPostImageDao.insert(tPostImage);
        });

    // 投稿タグ (Delete→Insert)
    TPostTagCriteria tPostTagCriteria = new TPostTagCriteria();
    tPostTagCriteria.setPostIdEq(tPostDto.getPostId());
    tPostTagDao.findAll(tPostTagCriteria)
        .stream()
        .forEach(tPostTag -> {
          tPostTagDao.delete(tPostTag);
        });

    ObjectMapperUtils
        .mapAll(Optional.ofNullable(tPostDto.getTPostTagList()).orElse(Lists.newArrayList()),
            TPostTag.class)
        .stream()
        .forEach(tPostTag -> {
          tPostTag.setPostId(tPost.getPostId());
          tPostTagDao.insert(tPostTag);
        });

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
    int updated = tPostDao.update(post);

    if (updated < 1) {
      throw new NoDataFoundException("post_id=" + postId + " は更新できませんでした。");
    }

    return post;
  }
}
