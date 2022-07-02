package com.isystk.sample.domain.entity;

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
 * 管理者
 *
 * 自動生成のため原則修正禁止!!
 *
 */
@Entity
@Table(name = "admin")
@Getter
@Setter
public class Admin extends DomaDtoImpl {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;


    /** 管理者ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    /** 管理者名 */
    @Column(name = "name")
    String name;

    /** メールアドレス */
    @Column(name = "email")
    String email;

    /** パスワード */
    @Column(name = "password")
    String password;

    /** remember_token */
    @Column(name = "remember_token")
    String rememberToken;

    /** 最終ログイン日時 */
    @Column(name = "last_login_at")
    LocalDateTime lastLoginAt;

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