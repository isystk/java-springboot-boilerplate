package com.isystk.sample.domain.dto;

import java.math.BigInteger;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * パスワードリセット
 *
 * 自動生成のため原則修正禁止!!
 *
 */
@Getter
@Setter
public class PasswordResetsCriteria {


    String emailEq;
    String emailNe;
    String emailLt;
    String emailLe;
    String emailGt;
    String emailGe;
    boolean emailIsNull;
    boolean emailIsNotNull;
    String emailLike;
    String emailNotLike;
    String emailStarts;
    String emailNotStarts;
    String emailEnds;
    String emailNotEnds;

    String tokenEq;
    String tokenNe;
    String tokenLt;
    String tokenLe;
    String tokenGt;
    String tokenGe;
    boolean tokenIsNull;
    boolean tokenIsNotNull;
    String tokenLike;
    String tokenNotLike;
    String tokenStarts;
    String tokenNotStarts;
    String tokenEnds;
    String tokenNotEnds;

    LocalDateTime createdAtEq;
    LocalDateTime createdAtNe;
    LocalDateTime createdAtLt;
    LocalDateTime createdAtLe;
    LocalDateTime createdAtGt;
    LocalDateTime createdAtGe;
    boolean createdAtIsNull;
    boolean createdAtIsNotNull;

    String orderBy;
}