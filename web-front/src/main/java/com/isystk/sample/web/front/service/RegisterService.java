package com.isystk.sample.web.front.service;

import com.google.common.collect.Maps;
import com.isystk.sample.common.dto.mail.MailEntryRegistTemporary;
import com.isystk.sample.common.exception.NoDataFoundException;
import com.isystk.sample.common.util.DateUtils;
import com.isystk.sample.common.values.MailTemplateDiv;
import com.isystk.sample.domain.dto.UserCriteria;
import com.isystk.sample.domain.entity.User;
import com.isystk.sample.domain.repository.MailTemplateRepository;
import com.isystk.sample.domain.repository.UserRepository;

import java.math.BigInteger;
import java.util.Map;
import lombok.val;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.isystk.sample.common.helper.SendMailHelper;
import com.isystk.sample.common.service.BaseTransactionalService;

@Service
public class RegisterService extends BaseTransactionalService {

  @Value("${spring.mail.properties.mail.from}")
  String fromAddress;

  @Value("${server.address}")
  String domain;

  @Autowired
  UserRepository userRepository;

  @Autowired
  MailTemplateRepository mailTemplateRepository;

  @Autowired
  SendMailHelper sendMailHelper;

  /**
   * 仮会員登録
   *
   * @param user
   */
  public void registTemporary(User user) {

    String onetimeKey = generateOnetimeKey();
    user.setRememberToken(onetimeKey);
    userRepository.create(user);

    // 仮会員登録メールを送信する
   sendMail(user.getId());
  }

  /**
   * 仮会員登録メール再送信
   *
   * @param userId
   */
  public void sendMail(BigInteger userId) {
    var user = userRepository.findById(userId);
    if(user.getEmailVerifiedAt() != null) {
      throw new NoDataFoundException("既に本会員の状態です。");
    }

    // 仮会員登録メールを送信する
    val mailTemplate = mailTemplateRepository.getMailTemplate(MailTemplateDiv.ENTRY_REGIST_TEMPORARY);
    val subject = mailTemplate.getTitle();
    val templateBody = mailTemplate.getText();
    MailEntryRegistTemporary dto = new MailEntryRegistTemporary();
    dto.setUserName(user.getName());
    dto.setDomain(domain);
    dto.setOnetimeKey(user.getRememberToken());
    Map<String, Object> objects = Maps.newHashMap();
    objects.put("dto", dto);
    val body = sendMailHelper.getMailBody(templateBody, objects);
    sendMailHelper.sendMail(fromAddress, user.getEmail(), subject, body);
  }

  /**
   * 本会員登録
   *
   * @param onetimeKey
   */
  public void registComplete(String onetimeKey) {

    // ワンタイムキーからユーザを取得する
    UserCriteria criteria = new UserCriteria();
    criteria.setRememberTokenEq(onetimeKey);
    var user = userRepository.findOne(criteria)
        .orElseThrow(() -> new NoDataFoundException("onetimeKey=" + onetimeKey + " のデータが見つかりません。"));

    // メールアドレスを検証済みにする
    user.setEmailVerifiedAt(DateUtils.getNow());
    // ワンタイムトークンを削除する
    user.setRememberToken(null);
    userRepository.update(user);

    // 本会員登録完了メールを送信する
    val mailTemplate = mailTemplateRepository.getMailTemplate(MailTemplateDiv.ENTRY_REGIST_VALID);
    val subject = mailTemplate.getTitle();
    val templateBody = mailTemplate.getText();
    MailEntryRegistTemporary dto = new MailEntryRegistTemporary();
    dto.setUserName(user.getName());
    dto.setDomain(domain);
    Map<String, Object> objects = Maps.newHashMap();
    objects.put("dto", dto);
    val body = sendMailHelper.getMailBody(templateBody, objects);
    sendMailHelper.sendMail(fromAddress, user.getEmail(), subject, body);
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
