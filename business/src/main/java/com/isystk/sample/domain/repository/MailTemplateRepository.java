package com.isystk.sample.domain.repository;

import com.isystk.sample.common.exception.NoDataFoundException;
import com.isystk.sample.common.service.BaseRepository;
import com.isystk.sample.common.values.MailTemplateDiv;
import com.isystk.sample.domain.dao.MailTemplateDao;
import com.isystk.sample.domain.entity.MailTemplate;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * メールテンプレートリポジトリ
 */
@Repository
public class MailTemplateRepository extends BaseRepository {

  @Autowired
  MailTemplateDao mailTemplateDao;

  /**
   * メールテンプレートを取得する。
   *
   * @return
   */
  public MailTemplate getMailTemplate(MailTemplateDiv mailTemplateDiv) {
    val mailTemplate = mailTemplateDao.selectById(Long.valueOf(mailTemplateDiv.getCode())).orElseThrow(
        () -> new NoDataFoundException("templateKey=" + mailTemplateDiv.getCode() + " のデータが見つかりません。"));
    return mailTemplate;
  }

}
