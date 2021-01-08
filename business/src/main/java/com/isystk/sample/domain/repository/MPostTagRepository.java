package com.isystk.sample.domain.repository;

import static com.isystk.sample.domain.util.DomaUtils.createSelectOptions;
import static java.util.stream.Collectors.toList;

import com.google.common.collect.Lists;
import com.isystk.sample.common.dto.CodeValueDto;
import com.isystk.sample.common.exception.NoDataFoundException;
import com.isystk.sample.common.util.DateUtils;
import java.util.List;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.isystk.sample.common.dto.Page;
import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.common.service.BaseRepository;
import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.domain.dao.MPostTagDao;
import com.isystk.sample.domain.dto.MPostTagCriteria;
import com.isystk.sample.domain.entity.MPostTag;
import com.isystk.sample.domain.repository.dto.MPostTagRepositoryDto;

/**
 * 投稿タグマスタリポジトリ
 */
@Repository
public class MPostTagRepository extends BaseRepository {

  @Autowired
  MPostTagDao mPostTagDao;

  /**
   * 投稿タグを複数取得します。
   *
   * @param criteria
   * @param pageable
   * @return
   */
  public Page<MPostTagRepositoryDto> find(MPostTagCriteria criteria, Pageable pageable) {
    var options = createSelectOptions(pageable);
    // ページングを指定する
    return pageFactory.create(convertDto(
        mPostTagDao.findAll(criteria,
            options.count(),
            toList()
        )), pageable, options.getCount());
  }

  /**
   * RepositoryDto に変換します。
   *
   * @param mPostTagList
   * @return
   */
  private List<MPostTagRepositoryDto> convertDto(List<MPostTag> mPostTagList) {

    return ObjectMapperUtils.mapAll(mPostTagList, MPostTagRepositoryDto.class);
  }

  /**
   * 選択用にすべての投稿タグを取得します。
   *
   *  @return
   */
  public List<CodeValueDto> findAllSelectList() {
    return findAllSelectStream().collect(Collectors.toList());
  }

  /**
   * 選択用にすべての投稿タグを取得します。
   *
   *  @return
   */
  public Map<Integer, CodeValueDto> findAllSelectMap() {
    return findAllSelectStream().collect(Collectors.toMap(
        s -> s.getCode(),
        s -> s
    ));
  }

  private Stream<CodeValueDto> findAllSelectStream() {
    return mPostTagDao.findAll(new MPostTagCriteria())
        .stream()
        .map((mPostTag -> {
          CodeValueDto dto = new CodeValueDto();
          dto.setCode(mPostTag.getPostTagId());
          dto.setText(mPostTag.getName());
          return dto;
        }));
  }

  /**
   * メールテンプレートを取得します。
   *
   * @return
   */
  public MPostTagRepositoryDto findById(final Integer id) {
    var data = mPostTagDao.selectById(id)
        .orElseThrow(() -> new NoDataFoundException("post_tag_id=" + id + " のデータが見つかりません。"));
    return convertDto(Lists.newArrayList(data)).get(0);
  }

  /**
   * 投稿タグを追加します。
   *
   * @param mPostTagRepositoryDto
   * @return
   */
  public MPostTag create(final MPostTagRepositoryDto mPostTagRepositoryDto) {

    MPostTagCriteria criteria = new MPostTagCriteria();
    criteria.setNameEq(mPostTagRepositoryDto.getName());
    MPostTag mPostTag = mPostTagDao.findOne(criteria).orElse(null);

    val time = DateUtils.getNow();

    if (mPostTag != null) {
      // 更新

      // 投稿タグテーブル
      mPostTag = ObjectMapperUtils.map(mPostTagRepositoryDto, MPostTag.class);
      mPostTag.setUpdateTime(time); // 更新日
      mPostTag.setDeleteFlg(false); // 削除フラグ
      mPostTagDao.update(mPostTag);

    } else {
      // 新規登録

      mPostTag = ObjectMapperUtils.map(mPostTagRepositoryDto, MPostTag.class);
      mPostTag.setRegistTime(time); // 作成日
      mPostTag.setUpdateTime(time); // 更新日
      mPostTag.setDeleteFlg(false); // 削除フラグ
      mPostTag.setVersion(0L); // 楽観ロック改定番号
      mPostTagDao.insert(mPostTag);

    }

    return mPostTag;
  }

  /**
   * 投稿タグを物理削除します。
   *
   * @return
   */
  public MPostTag delete(final Integer postTagId) {
    val postTag = mPostTagDao.selectById(postTagId)
        .orElseThrow(() -> new NoDataFoundException("post_tag_id=" + postTagId + " のデータが見つかりません。"));

    val time = DateUtils.getNow();
    postTag.setUpdateTime(time); // 削除日
    postTag.setDeleteFlg(true); // 削除フラグ
    int updated = mPostTagDao.update(postTag);

    if (updated < 1) {
      throw new NoDataFoundException("post_tag_id=" + postTagId + " は更新できませんでした。");
    }

    return postTag;
  }
}
