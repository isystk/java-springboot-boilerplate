package com.isystk.sample.domain.entity;

import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.Version;
import com.isystk.sample.domain.dto.DomaDtoImpl;

import lombok.Getter;
import lombok.Setter;

/**
 * メールテンプレート
 *
 * 自動生成のため原則修正禁止!!
 *
 */
@Entity
@Table(name = "mail_template")
@Getter
@Setter
public class MailTemplate extends DomaDtoImpl {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;


    /** テンプレートID */
    @Id
    @Column(name = "mail_template_id")
    Integer mailTemplateId;

    /** テンプレート区分 */
    @Column(name = "mail_template_div")
    Byte mailTemplateDiv;

    /** タイトル */
    @Column(name = "title")
    String title;

    /** 本文 */
    @Column(name = "text")
    String text;

    /** 登録日時 */
    @Column(name = "created_at")
    LocalDateTime createdAt;

    /** 更新日時 */
    @Column(name = "updated_at")
    LocalDateTime updatedAt;

    /** 削除フラグ */
    @Column(name = "delete_flg")
    Boolean deleteFlg;

    /** 楽観チェック用バージョン */
    @Version
    @Column(name = "version")
    Long version;
}