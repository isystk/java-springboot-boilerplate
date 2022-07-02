package com.isystk.sample.domain.entity;

import java.math.BigInteger;
import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.Version;
import com.isystk.sample.domain.dto.DomaDtoImpl;

import lombok.Getter;
import lombok.Setter;

/**
 * お問い合わせ
 *
 * 自動生成のため原則修正禁止!!
 *
 */
@Entity
@Table(name = "contact_form")
@Getter
@Setter
public class ContactForm extends DomaDtoImpl {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;


    /** id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    BigInteger id;

    /** お名前 */
    @Column(name = "your_name")
    String yourName;

    /** タイトル */
    @Column(name = "title")
    String title;

    /** メールアドレス */
    @Column(name = "email")
    String email;

    /** URL */
    @Column(name = "url")
    String url;

    /** 性別 */
    @Column(name = "gender")
    Byte gender;

    /** 年齢 */
    @Column(name = "age")
    Byte age;

    /** お問い合わせ内容 */
    @Column(name = "contact")
    String contact;

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