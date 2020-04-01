package com.isystk.sample.web.front.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.isystk.sample.domain.dao.MMailTemplateDao;
import com.isystk.sample.domain.dto.MMailTemplateCriteria;
import com.isystk.sample.domain.dto.common.CommaSeparatedString;
import com.isystk.sample.domain.entity.MMailTemplate;
import com.isystk.sample.domain.entity.TUser;
import com.isystk.sample.domain.exception.NoDataFoundException;
import com.isystk.sample.domain.helper.SendMailHelper;

import lombok.val;

public class EntryService {

    @Value("${spring.mail.properties.mail.from}")
    String fromAddress;

    @Autowired
    MMailTemplateDao mMailTemplateDao;

    @Autowired
    SendMailHelper sendMailHelper;

    public void regist(TUser user) {
        val mailTemplate = getMailTemplate(1);

        val subject = mailTemplate.getTitle();
        val templateBody = mailTemplate.getText();

        Map<String, Object> objects = new HashMap<>();
        objects.put("user", user);

        val body = sendMailHelper.getMailBody(templateBody, objects);

        // メールを送信する
        sendMailHelper.sendMail(fromAddress, new String[] { user.getEmail() }, subject, body);
    }

    /**
     * メールテンプレートを取得する。
     *
     * @return
     */
    protected MMailTemplate getMailTemplate(Integer templateId) {
        val criteria = new MMailTemplateCriteria();
        criteria.setMailTemplateIdEqual(templateId);
        val mailTemplate = mMailTemplateDao.select(criteria).orElseThrow(
                () -> new NoDataFoundException("templateKey=" + criteria.getMailTemplateId() + " のデータが見つかりません。"));

        return mailTemplate;
    }

}
