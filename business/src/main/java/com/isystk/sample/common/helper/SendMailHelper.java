package com.isystk.sample.common.helper;

import static com.isystk.sample.common.util.ValidateUtils.isNotEmpty;

import java.util.Map;
import java.util.Properties;

import com.isystk.sample.common.exception.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.StringTemplateResolver;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * メール送信ヘルパー
 */
@Component
@Slf4j
public class SendMailHelper {

  @Value("${spring.mail.host}")
  private String SMTP_HOST_NAME;

  /**
   * メールを送信します。
   *
   * @param fromAddress
   * @param toAddress
   * @param subject
   * @param body
   */
  public void sendMail(String fromAddress, String toAddress, String subject, String body) {
    try {
      Properties props = new Properties();
      props.put("mail.localhost.host", SMTP_HOST_NAME);
      Session session2 = Session.getDefaultInstance(props, null);
      val message = new MimeMessage(session2);

      message.addFrom(InternetAddress.parse(fromAddress));
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
//			message.setSubject(subject, "iso-2022-jp");
//			message.setText(body, "iso-2022-jp");
      message.setSubject(subject, "utf-8");
      message.setText(body, "utf-8");

      Transport.send(message);

    } catch (MailException | AddressException e) {
      log.error("failed to send mail.", e);
      throw new SystemException(e);
    } catch (MessagingException e) {
      log.error("failed to send mail.", e);
      throw new SystemException(e);
    }
  }

  /**
   * 指定したテンプレートのメール本文を返します。
   *
   * @param template
   * @param objects
   * @return
   */
  public String getMailBody(String template, Map<String, Object> objects) {
    val templateEngine = new SpringTemplateEngine();
    templateEngine.setTemplateResolver(templateResolver());

    val context = new Context();
    if (isNotEmpty(objects)) {
      objects.forEach(context::setVariable);
    }

    return templateEngine.process(template, context);
  }

  private ITemplateResolver templateResolver() {
    val resolver = new StringTemplateResolver();
    resolver.setTemplateMode("TEXT");
    resolver.setCacheable(false); // 安全をとってキャッシュしない
    return resolver;
  }
}
