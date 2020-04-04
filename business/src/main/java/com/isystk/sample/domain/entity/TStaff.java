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
@Table(name = "t_staff")
@Getter
@Setter
public class TStaff extends DomaDtoImpl {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;


    /** 管理者ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STAFF_ID")
    Integer staffId;

    /** メールアドレス */
    @Column(name = "EMAIL")
    String email;

    /** パスワード */
    @Column(name = "PASSWORD")
    String password;

    /** 姓 */
    @Column(name = "FAMILY_NAME")
    String familyName;

    /** 名 */
    @Column(name = "NAME")
    String name;

    /** 姓（カナ） */
    @Column(name = "FAMILY_NAME_KANA")
    String familyNameKana;

    /** 名（カナ） */
    @Column(name = "NAME_KANA")
    String nameKana;

    /** 最終ログイン日時 */
    @Column(name = "LAST_LOGIN_TIME")
    LocalDateTime lastLoginTime;

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