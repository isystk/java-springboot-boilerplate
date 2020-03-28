package com.isystk.sample.domain.entity;

import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.Version;
import com.isystk.sample.domain.dto.common.DomaDtoImpl;

/**
 * 
 */
@Entity
@Table(name = "m_mail_template")
public class MMailTemplate extends DomaDtoImpl {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;


    /** MAIL_TEMPLATEID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAIL_TEMPLATE_ID")
    Integer mailTemplateId;

    /**  */
    @Column(name = "TEMPLATE_DIV")
    Integer templateDiv;

    /**  */
    @Column(name = "TITLE")
    String title;

    /**  */
    @Column(name = "TEXT")
    String text;





    /**
     * Returns the mailTemplateId.
     *
     * @return the mailTemplateId
     */
    public Integer getMailTemplateId() {
        return mailTemplateId;
    }

    /**
     * Sets the mailTemplateId.
     *
     * @param mailTemplateId the mailTemplateId
     */
    public void setMailTemplateId(Integer mailTemplateId) {
        this.mailTemplateId = mailTemplateId;
    }
    /**
     * Returns the templateDiv.
     *
     * @return the templateDiv
     */
    public Integer getTemplateDiv() {
        return templateDiv;
    }

    /**
     * Sets the templateDiv.
     *
     * @param templateDiv the templateDiv
     */
    public void setTemplateDiv(Integer templateDiv) {
        this.templateDiv = templateDiv;
    }
    /**
     * Returns the title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * Returns the text.
     *
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text.
     *
     * @param text the text
     */
    public void setText(String text) {
        this.text = text;
    }
}