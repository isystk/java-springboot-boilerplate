package com.isystk.sample.domain.repository;

import static com.isystk.sample.domain.util.DomaUtils.createSelectOptions;
import static java.util.stream.Collectors.toList;

import com.isystk.sample.domain.dao.UserDao;
import com.isystk.sample.domain.dto.UserCriteria;
import com.isystk.sample.domain.dto.UserRepositoryDto;
import com.isystk.sample.domain.entity.User;
import java.math.BigInteger;
import java.util.List;

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
   * 投稿を複数取得します。
   *
   * @param criteria
   * @param pageable
   * @return
   */
  public Page<UserRepositoryDto> findAll(UserCriteria criteria, Pageable pageable) {
    var options = createSelectOptions(pageable);
    // ページングを指定する
    return pageFactory.create(convertDto(
        userDao.findAll(criteria,
            options.count(),
            toList()
        )), pageable, options.getCount());
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
    inputUser.setDeleteFlg((byte)0); // 削除フラグ
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
