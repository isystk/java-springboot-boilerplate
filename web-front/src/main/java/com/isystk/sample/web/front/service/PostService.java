package com.isystk.sample.web.front.service;

import static com.isystk.sample.domain.util.DomaUtils.createSelectOptions;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import com.isystk.sample.common.exception.NoDataFoundException;
import com.isystk.sample.common.helper.UserHelper;
import com.isystk.sample.web.front.dto.FrontPostImageDto;
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

  @Autowired
  UserHelper userHelper;

  /**
   * Solrの投稿インデックスを取得します。
   *
   * @param criteria
   * @param pageable
   * @return
   */
  @Transactional(readOnly = true) // 読み取りのみの場合は指定する
  public Page<FrontPostDto> findSolrAll(SolrPostCriteria criteria, Pageable pageable) {
    Assert.notNull(criteria, "criteria must not be null");

    // TODO ここでページングを設定
    Iterable<SolrPost> solrPosts = solrPostRepository.findAll();

    List<FrontPostDto> solrPostList = Lists.newArrayList();
    for (SolrPost solrPost : solrPosts) {
      solrPostList.add(convertSolrToFrontPostDto(solrPost));
    }

    // ページングを指定する
    val options = createSelectOptions(pageable).count();
    return pageFactory.create(solrPostList, pageable, options.getCount());
  }

  /**
   * Solrの投稿インデックスを取得します。
   *
   * @param postId
   * @return
   */
  @Transactional(readOnly = true) // 読み取りのみの場合は指定する
  public Optional<FrontPostDto> findDataById(Integer postId) {
    Assert.notNull(postId, "criteria must not be null");

    SolrPost solrPost = solrPostRepository.findByPostId(postId);

    return Optional.of(convertSolrToFrontPostDto(solrPost));
  }

  /**
   * @param solrPost
   * @return
   */
  private FrontPostDto convertSolrToFrontPostDto(SolrPost solrPost) {
    // 入力値を詰め替える
    var dto = ObjectMapperUtils.map(solrPost, FrontPostDto.class);

    // 画像のパスを設定
    List<FrontPostImageDto> imageList = Lists.newArrayList();
    if (solrPost.getImageIdList() != null) {
      for (Integer imageId : solrPost.getImageIdList()) {
        FrontPostImageDto imageDto = new FrontPostImageDto();
        imageDto.setImageId(imageId);
        imageDto.setImageUrl(imageHelper.getUrl(imageId, ImageSuffix.SQUARE.getSuffix()));
        imageList.add(imageDto);
      }
    }
    dto.setImageList(imageList);

    dto.setRegistTimeYYYYMMDD(
        DateUtils.format(solrPost.getRegistTime(), DateTimeFormatter.ofPattern("yyyy/MM/dd")));
    dto.setRegistTimeMMDD(
        DateUtils.format(solrPost.getRegistTime(), DateTimeFormatter.ofPattern("MM/dd")));
    return dto;
  }

  /**
   * DBの投稿インデックスを取得します。
   *
   * @param postId
   * @return
   */
  @Transactional(readOnly = true) // 読み取りのみの場合は指定する
  public Optional<FrontPostDto> findMyDataById(Integer postId) {
    Assert.notNull(postId, "criteria must not be null");

    // 1件取得する
    val post = postRepository.findById(postId);
    if (!post.getUserId().equals(userHelper.getLoginUser().getUserId())) {
      throw new NoDataFoundException(
          "データが見つかりません。post_id=" + postId + " user_id=" + userHelper.getLoginUser().getUserId());
    }

    return Optional.of(convertTPostToFrontPostDto(post));
  }

  /**
   * @param tPostRepositoryDto
   * @return
   */
  private FrontPostDto convertTPostToFrontPostDto(TPostRepositoryDto tPostRepositoryDto) {
    // 入力値を詰め替える
    var dto = ObjectMapperUtils.map(tPostRepositoryDto, FrontPostDto.class);

    // 画像のパスを設定
    List<FrontPostImageDto> imageList = Lists.newArrayList();
    if (tPostRepositoryDto.getTPostImageList() != null) {
      for (TPostImage tPostImage : tPostRepositoryDto.getTPostImageList()) {
        FrontPostImageDto imageDto = new FrontPostImageDto();
        imageDto.setImageId(tPostImage.getImageId());
        imageDto.setImageUrl(
            imageHelper.getUrl(tPostImage.getImageId(), ImageSuffix.SQUARE.getSuffix()));
        imageList.add(imageDto);
      }
    }
    dto.setImageList(imageList);

    dto.setRegistTimeYYYYMMDD(DateUtils
        .format(tPostRepositoryDto.getRegistTime(), DateTimeFormatter.ofPattern("yyyy/MM/dd")));
    dto.setRegistTimeMMDD(
        DateUtils.format(tPostRepositoryDto.getRegistTime(), DateTimeFormatter.ofPattern("MM/dd")));
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

      dto.setImageList(Lists.newArrayList());
      if (postDto.getTPostImageList() != null) {
        for (TPostImage tPostImage : postDto.getTPostImageList()) {
          FrontPostImageDto imageDto = new FrontPostImageDto();
          imageDto.setImageId(tPostImage.getImageId());
          imageDto.setImageUrl(
              imageHelper.getUrl(tPostImage.getImageId(), ImageSuffix.SQUARE.getSuffix()));
          dto.getImageList().add(imageDto);
        }
      }

      list.add(dto);
    }

    return pageFactory.create(list, postDtoPage, postDtoPage.getCount());
  }

  /**
   * 投稿を追加します。
   *
   * @param tPostDto
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
   * @param tPostDto
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
