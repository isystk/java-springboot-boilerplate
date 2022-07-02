package com.isystk.sample.domain.repository;

import static com.isystk.sample.domain.util.DomaUtils.createSelectOptions;
import static java.util.stream.Collectors.toList;

import com.google.common.collect.Lists;
import com.isystk.sample.domain.dao.UserDao;
import com.isystk.sample.domain.dto.UserCriteria;
import com.isystk.sample.domain.dto.UserRepositoryDto;
import com.isystk.sample.domain.entity.User;
import java.math.BigInteger;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.isystk.sample.common.dto.Page;
import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.common.exception.NoDataFoundException;
import com.isystk.sample.common.service.BaseRepository;
import com.isystk.sample.common.util.DateUtils;
import com.isystk.sample.common.util.ObjectMapperUtils;

import lombok.val;

/**
 * ユーザーリポジトリ
 */
@Repository
public class UserRepository extends BaseRepository {

  @Autowired
  UserDao userDao;

  /**
   * 顧客を複数取得します。
   *
   * @param criteria
   * @return
   */
  public List<UserRepositoryDto> findAll(UserCriteria criteria) {
    var options = createSelectOptions(1, Integer.MAX_VALUE);
    return convertDto(userDao.findAll(criteria, options, toList()));
  }

  /**
   * 顧客を複数取得します。(ページングあり)
   *
   * @param criteria
   * @param pageable
   * @return
   */
  public Page<UserRepositoryDto> findPage(UserCriteria criteria, Pageable pageable) {
    var options = createSelectOptions(pageable);
    var userList =  convertDto(userDao.findAll(criteria, options.count(), toList()));
    return pageFactory.create(userList, pageable, options.getCount());
  }

  /**
   * RepositoryDto に変換します。
   *
   * @param tUserList
   * @return
   */
  private List<UserRepositoryDto> convertDto(List<User> tUserList) {

    return ObjectMapperUtils.mapAll(tUserList, UserRepositoryDto.class);
  }

  /**
   * 顧客を取得します。
   *
   * @param criteria
   * @return
   */
  public Optional<UserRepositoryDto> findOne(UserCriteria criteria) {
    var data = userDao.findOne(criteria)
        .orElseThrow(() -> new NoDataFoundException(criteria + "のデータが見つかりません。"));
    return Optional.ofNullable(convertDto(Lists.newArrayList(data)).get(0));
  }

  /**
   * 顧客を取得します。
   *
   * @return
   */
  public UserRepositoryDto findById(final BigInteger id) {
    var data = userDao.selectById(id)
        .orElseThrow(() -> new NoDataFoundException("user_id=" + id + " のデータが見つかりません。"));
    return convertDto(Lists.newArrayList(data)).get(0);
  }

  /**
   * ユーザーを追加します。
   *
   * @param inputUser
   * @return
   */
  public User create(final User inputUser) {

    // 1件登録
    val time = DateUtils.getNow();

    inputUser.setCreatedAt(time); // 作成日
    inputUser.setUpdatedAt(time); // 更新日
    inputUser.setDeleteFlg(false); // 削除フラグ
    inputUser.setVersion(0L); // 楽観ロック改定番号
    userDao.insert(inputUser);

    return inputUser;
  }

  /**
   * ユーザーを更新します。
   *
   * @param inputUser
   * @return
   */
  public User update(final User inputUser) {
    // 1件更新
    val time = DateUtils.getNow();
    inputUser.setUpdatedAt(time); // 更新日
    int updated = userDao.update(inputUser);

    if (updated < 1) {
      throw new NoDataFoundException("user_id=" + inputUser.getId() + " のデータが見つかりません。");
    }

    return inputUser;
  }

  /**
   * ユーザーを論理削除します。
   *
   * @return
   */
  public User delete(final BigInteger id) {
    val user = userDao.selectById(id)
        .orElseThrow(() -> new NoDataFoundException("user_id=" + id + " のデータが見つかりません。"));

    int updated = userDao.delete(user);

    if (updated < 1) {
      throw new NoDataFoundException("user_id=" + id + " は更新できませんでした。");
    }

    return user;
  }
}
