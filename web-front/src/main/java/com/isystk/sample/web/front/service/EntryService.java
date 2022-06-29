package com.isystk.sample.web.front.service;

import com.isystk.sample.domain.dao.UserDao;
import com.isystk.sample.domain.entity.User;
import com.isystk.sample.domain.repository.UserRepository;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.isystk.sample.common.dto.mail.EntryRegistTemporary;
import com.isystk.sample.common.exception.NoDataFoundException;
import com.isystk.sample.common.helper.SendMailHelper;
import com.isystk.sample.common.service.BaseTransactionalService;
import com.isystk.sample.common.util.DateUtils;
import com.isystk.sample.common.values.MailTemplate;
import com.isystk.sample.common.values.UserStatus;

import lombok.val;

@Service
public class EntryService extends BaseTransactionalService {

  @Value("${spring.mail.properties.mail.from}")
  String fromAddress;

  @Value("${server.address}")
  String domain;

  @Autowired
  UserDao userDao;

  @Autowired
  UserRepository userRepository;

  @Autowired
  SendMailHelper sendMailHelper;
//
//  /**
//   * 仮会員登録
//   *
//   * @param user
//   */
//  public void registTemporary(User user) {
//
//    // DB登録する
//    user.setStatus(Integer.valueOf(UserStatus.TEMPORARY.getCode()));
//    userRepository.create(user);
//
//    // 会員-初期承認を登録する
//    UserOnetimeValid userOnetimeValid = new UserOnetimeValid();
//    userOnetimeValid.seuserId(user.geuserId());
//    String onetimeKey = generateOnetimeKey();
//    userOnetimeValid.setOnetimeKey(onetimeKey);
//    // 7時間の制限時間を設ける
//    userOnetimeValid.setOnetimeValidTime(DateUtils.getNow().plusHours(7));
//    userOnetimeValidDao.insert(userOnetimeValid);
//
//    // 仮会員登録メールを送信する
//    val mailTemplate = getMailTemplate(MailTemplate.ENTRY_REGIST_TEMPORARY.getCode());
//    val subject = mailTemplate.getTitle();
//    val templateBody = mailTemplate.getText();
//    EntryRegistTemporary dto = new EntryRegistTemporary();
//    dto.setFamilyName(user.getFamilyName());
//    dto.setDomain(domain);
//    dto.setOnetimeKey(onetimeKey);
//    Map<String, Object> objects = new HashMap<>();
//    objects.put("dto", dto);
//    val body = sendMailHelper.getMailBody(templateBody, objects);
//    sendMailHelper.sendMail(fromAddress, user.getEmail(), subject, body);
//  }
//
//  /**
//   * 本会員登録
//   *
//   * @param onetimeKey
//   */
//  public void registComplete(String onetimeKey) {
//
//    // ワンタイムキーからユーザーIDを取得する
//    var userOnetimeValid = getUserOnetimeValid(onetimeKey);
//    if (userOnetimeValid == null) {
//      throw new NoDataFoundException("指定されたワンタイムキーが見つかりません。[onetimeKey=" + onetimeKey + "]");
//    }
//
//    // 承認期限オーバー
//    if (DateUtils.beforeNow(userOnetimeValid.getOnetimeValidTime())) {
//      throw new NoDataFoundException("指定されたワンタイムキーは承認期限を過ぎています。[onetimeKey=" + onetimeKey + "]");
//    }
//
//    // ユーザー情報を取得する
//    User user = userDao.selectById(userOnetimeValid.geuserId())
//        .orElseThrow(() -> new NoDataFoundException(
//            "user_id=" + userOnetimeValid.geuserId() + " のデータが見つかりません。"));
//
//    // DB登録する
//    user.setStatus(Integer.valueOf(UserStatus.VALID.getCode()));
//    userRepository.update(user);
//
//    // 本会員登録完了メールを送信する
//    val mailTemplate = getMailTemplate(MailTemplate.ENTRY_REGIST_VALID.getCode());
//    val subject = mailTemplate.getTitle();
//    val templateBody = mailTemplate.getText();
//    EntryRegistTemporary dto = new EntryRegistTemporary();
//    dto.setFamilyName(user.getFamilyName());
//    dto.setDomain(domain);
//    Map<String, Object> objects = new HashMap<>();
//    objects.put("dto", dto);
//    val body = sendMailHelper.getMailBody(templateBody, objects);
//    sendMailHelper.sendMail(fromAddress, user.getEmail(), subject, body);
//
//    // ワンタイムキーを削除
//    userOnetimeValidDao.delete(userOnetimeValid);
//  }

//  /**
//   * ワンタイムキー生成
//   *
//   * @return 生成されたワンタイムキー
//   */
//  private String generateOnetimeKey() {
//    String onetimeKey = "";
//    boolean loopFlg = true;
//
//    do {
//      // ランダムな文字列を生成する。
//      onetimeKey = RandomStringUtils.randomAlphanumeric(32);
//
//      // 生成したキーが存在しないか確認する
//      if (null == getUserOnetimeValid(onetimeKey)) {
//        loopFlg = false;
//      }
//    } while (loopFlg);
//
//    return onetimeKey;
//  }

//  /**
//   * 会員-初期承認Entityを取得する
//   *
//   * @param onetimeKey ワンタイムキー
//   * @return 会員Entity
//   */
//  public UserOnetimeValid getUserOnetimeValid(String onetimeKey) {
//    UserOnetimeValidCriteria criteria = new UserOnetimeValidCriteria();
//    criteria.setOnetimeKeyEq(onetimeKey);
//    return userOnetimeValidDao.findOne(criteria).orElse(null);
//  }

}
