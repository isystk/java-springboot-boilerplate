package com.isystk.sample.web.front.service;

import com.isystk.sample.domain.dao.UserDao;
import com.isystk.sample.domain.dto.UserCriteria;
import com.isystk.sample.domain.entity.User;
import com.isystk.sample.domain.repository.UserRepository;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.isystk.sample.common.exception.NoDataFoundException;
import com.isystk.sample.common.helper.SendMailHelper;
import com.isystk.sample.common.service.BaseTransactionalService;

@Service
public class EntryRemindService extends BaseTransactionalService {

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
    User user = userDao.findOne(criteria)
        .orElseThrow(() -> new NoDataFoundException("email=" + email + " のデータが見つかりません。"));
//
//    // パスワード変更ワンタイムパスを登録する(Delete→Insert)
//    TUserOnetimePassCriteria onetimePassCriteria = new TUserOnetimePassCriteria();
//    onetimePassCriteria.setUserIdEq(tUser.getUserId());
//    TUserOnetimePass tUserOnetimePass = tUserOnetimePassDao.findOne(onetimePassCriteria)
//        .orElse(null);
//    if (tUserOnetimePass != null) {
//      tUserOnetimePassDao.delete(tUserOnetimePass);
//    }
//
//    tUserOnetimePass = new TUserOnetimePass();
//    tUserOnetimePass.setUserId(tUser.getUserId());
//    String onetimeKey = generateOnetimeKey();
//    tUserOnetimePass.setOnetimeKey(onetimeKey);
//    // 7時間の制限時間を設ける
//    tUserOnetimePass.setOnetimeValidTime(DateUtils.getNow().plusHours(7));
//    tUserOnetimePassDao.insert(tUserOnetimePass);
//
//    // 新パスワード設定画面のお知らせメールを送信する
//    val mailTemplate = getMailTemplate(MailTemplate.ENTRY_REMIND.getCode());
//    val subject = mailTemplate.getTitle();
//    val templateBody = mailTemplate.getText();
//    EntryRegistTemporary dto = new EntryRegistTemporary();
//    dto.setFamilyName(tUser.getFamilyName());
//    dto.setDomain(domain);
//    dto.setOnetimeKey(onetimeKey);
//    Map<String, Object> objects = new HashMap<>();
//    objects.put("dto", dto);
//    val body = sendMailHelper.getMailBody(templateBody, objects);
//    sendMailHelper.sendMail(fromAddress, tUser.getEmail(), subject, body);
  }

  /**
   * パスワード変更
   *
   * @param onetimeKey
   * @param password
   */
  public void changePassword(String onetimeKey, String password) {

//    // ワンタイムキーからユーザーIDを取得する
//    var tUserOnetimePass = getTUserOnetimePass(onetimeKey);
//    if (tUserOnetimePass == null) {
//      throw new NoDataFoundException("指定されたワンタイムキーが見つかりません。[onetimeKey=" + onetimeKey + "]");
//    }

//    // 承認期限オーバー
//    if (DateUtils.beforeNow(tUserOnetimePass.getOnetimeValidTime())) {
//      throw new NoDataFoundException("指定されたワンタイムキーは承認期限を過ぎています。[onetimeKey=" + onetimeKey + "]");
//    }

//    // ユーザー情報を取得する
//    User user = userDao.selectById(tUserOnetimePass.getUserId())
//        .orElseThrow(() -> new NoDataFoundException(
//            "user_id=" + tUserOnetimePass.getUserId() + " のデータが見つかりません。"));
//
//    // パスワードを変更する
//    tUser.setPassword(password);
//    tUserRepository.update(tUser);
//
//    // ワンタイムキーを削除
//    tUserOnetimePassDao.delete(tUserOnetimePass);
  }

  /**
   * ワンタイムキー生成
   *
   * @return 生成されたワンタイムキー
   */
  private String generateOnetimeKey() {
    String onetimeKey = "";
    boolean loopFlg = true;

    do {
      // ランダムな文字列を生成する。
      onetimeKey = RandomStringUtils.randomAlphanumeric(32);

//      // 生成したキーが存在しないか確認する
//      if (null == getTUserOnetimePass(onetimeKey)) {
//        loopFlg = false;
//      }
    } while (loopFlg);

    return onetimeKey;
  }

  /**
//   * パスワード変更ワンタイムEntityを取得する
//   *
//   * @param onetimeKey ワンタイムキー
//   * @return パスワード変更ワンタイムEntity
//   */
//  public TUserOnetimePass getTUserOnetimePass(String onetimeKey) {
//    TUserOnetimePassCriteria criteria = new TUserOnetimePassCriteria();
//    criteria.setOnetimeKeyEq(onetimeKey);
//    return tUserOnetimePassDao.findOne(criteria).orElse(null);
//  }

//  /**
//   * メールテンプレートを取得する。
//   *
//   * @return
//   */
//  protected MMailTemplate getMailTemplate(String templateId) {
//    val criteria = new MMailTemplateCriteria();
//    criteria.setMailTemplateIdEq(Integer.valueOf(templateId));
//    val mailTemplate = mMailTemplateDao.findOne(criteria).orElseThrow(
//        () -> new NoDataFoundException("templateKey=" + templateId + " のデータが見つかりません。"));
//
//    return mailTemplate;
//  }

}
