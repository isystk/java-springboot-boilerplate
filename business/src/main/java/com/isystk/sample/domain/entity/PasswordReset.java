package com.isystk.sample.domain.entity;

import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;
import com.isystk.sample.domain.dto.common.DomaDtoImpl;

import lombok.Getter;
import lombok.Setter;

/**
 * パスワードリセット
 *
 * 自動生成のため原則修正禁止!!
 *
 */
@Entity
@Table(name = "password_reset")
@Getter
@Setter
public class PasswordReset extends DomaDtoImpl {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;


    /** メールアドレス */
    @Column(name = "email")
    String email;

    /** ワンタイムトークン */
    @Column(name = "token")
    String token;

    /** 登録日時 */
    @Column(name = "created_at")
    LocalDateTime createdAt;
}