package com.isystk.sample.web.front.service;

import com.google.common.collect.Maps;
import com.isystk.sample.common.dto.mail.MailEntryRegistTemporary;
import com.isystk.sample.common.util.DateUtils;
import com.isystk.sample.common.values.MailTemplateDiv;
import com.isystk.sample.domain.dao.PasswordResetDao;
import com.isystk.sample.domain.dto.PasswordResetCriteria;
import com.isystk.sample.domain.dto.UserCriteria;
import com.isystk.sample.domain.entity.PasswordReset;
import com.isystk.sample.domain.entity.User;
import com.isystk.sample.domain.repository.MailTemplateRepository;

import com.isystk.sample.domain.repository.UserRepository;
import java.util.Map;
import lombok.val;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.isystk.sample.common.exception.NoDataFoundException;
import com.isystk.sample.common.helper.SendMailHelper;
import com.isystk.sample.common.service.BaseTransactionalService;

@Service
public class PasswordResetService extends BaseTransactionalService {

  @Value("${spring.mail.properties.mail.from}")
  String fromAddress;

  @Value("${server.address}")
  String domain;

  @Autowired
  PasswordResetDao passwordResetDao;

  @Autowired
  MailTemplateRepository mailTemplateRepository;

  @Autowired
  UserRepository userRepository;

  @Autowired
  SendMailHelper sendMailHelper;

  /**
   * パスワード変更ワンタイムパス登録
   *
   * @param email
   */
  public void registOnetimePass(String email) {

    // ユーザー情報を取得する
    UserCriteria criteria = new UserCriteria();
    criteria.setEmailEq(email);
    criteria.setDeleteFlgFalse(true);
    User user = userRepository.findOne(criteria)
        .orElseThrow(() -> new NoDataFoundException("email=" + email + " のデータが見つかりません。"));

    // パスワード変更ワンタイムパスを登録する(Delete→Insert)
    {
      PasswordResetCriteria passwordResetCriteria = new PasswordResetCriteria();
      passwordResetCriteria.setEmailEq(user.getEmail());
      PasswordReset passwordReset = passwordResetDao.findOne(passwordResetCriteria)
          .orElse(null);
      if (passwordReset != null) {
        passwordResetDao.delete(passwordReset);
      }
    }

    PasswordReset passwordReset = new PasswordReset();
    passwordReset.setEmail(user.getEmail());
    String onetimeKey = generateOnetimeKey();
    passwordReset.setToken(onetimeKey);
    passwordReset.setCreatedAt(DateUtils.getNow());
    passwordReset.setUpdatedAt(DateUtils.getNow());
    passwordReset.setDeleteFlg(false);
    passwordResetDao.insert(passwordReset);

    // 新パスワード設定画面のお知らせメールを送信する
    val mailTemplate = mailTemplateRepository.getMailTemplate(MailTemplateDiv.ENTRY_REMIND);
    val subject = mailTemplate.getTitle();
    val templateBody = mailTemplate.getText();
    MailEntryRegistTemporary dto = new MailEntryRegistTemporary();
    dto.setUserName(user.getName());
    dto.setDomain(domain);
    dto.setOnetimeKey(onetimeKey);
    Map<String, Object> objects = Maps.newHashMap();
    objects.put("dto", dto);
    val body = sendMailHelper.getMailBody(templateBody, objects);
    sendMailHelper.sendMail(fromAddress, user.getEmail(), subject, body);
  }

  /**
   * パスワード変更
   *
   * @param onetimeKey
   * @param password
   */
  public void changePassword(String onetimeKey, String password) {

    // ワンタイムキーからユーザーIDを取得する
    PasswordResetCriteria criteria = new PasswordResetCriteria();
    criteria.setTokenEq(onetimeKey);
    var passwordReset = passwordResetDao.findOne(criteria).orElseThrow(() -> new NoDataFoundException("指定されたワンタイムキーが見つかりません。[onetimeKey=" + onetimeKey + "]"));

    // 承認期限オーバー
    if (DateUtils.beforeNow(DateUtils.addMinutes(passwordReset.getCreatedAt(), 60))) {
      throw new NoDataFoundException("指定されたワンタイムキーは期限を過ぎています。[onetimeKey=" + onetimeKey + "]");
    }

    // ユーザー情報を取得する
    UserCriteria userCriteria = new UserCriteria();
    userCriteria.setEmailEq(passwordReset.getEmail());
    User user = userRepository.findOne(userCriteria)
        .orElseThrow(() -> new NoDataFoundException(
            "email=" + passwordReset.getEmail() + " のデータが見つかりません。"));

    // パスワードを変更する
    user.setPassword(password);
    userRepository.update(user);

    // ワンタイムキーを削除
    passwordResetDao.delete(passwordReset);
  }

  /**
   * ワンタイムキー生成
   *
   * @return 生成されたワンタイムキー
   */
  private String generateOnetimeKey() {
      // ランダムな文字列を生成する。
      return RandomStringUtils.randomAlphanumeric(32);
  }

}
