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

import lombok.Getter;
import lombok.Setter;

/**
 * 
 *
 * 自動生成のため原則修正禁止!!
 *
 */
@Entity
@Table(name = "m_mail_template")
@Getter
@Setter
public class MMailTemplate extends DomaDtoImpl {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;


    /** MAIL_TEMPLATEID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAIL_TEMPLATE_ID")
    Integer mailTemplateId;

    /** テンプレート区分 */
    @Column(name = "TEMPLATE_DIV")
    Integer templateDiv;

    /** タイトル */
    @Column(name = "TITLE")
    String title;

    /** 本文 */
    @Column(name = "TEXT")
    String text;

    /** 登録日時 */
    @Column(name = "REGIST_TIME")
    LocalDateTime registTime;

    /** 更新日時 */
    @Column(name = "UPDATE_TIME")
    LocalDateTime updateTime;

    /** 削除フラグ */
    @Column(name = "DELETE_FLG")
    Boolean deleteFlg;

    /** 楽観チェック用バージョン */
    @Version
    @Column(name = "VERSION")
    Long version;
}