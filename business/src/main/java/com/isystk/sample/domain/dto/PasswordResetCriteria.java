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
public class PasswordResetCriteria {


    BigInteger idEq;
    BigInteger idNe;
    BigInteger idLt;
    BigInteger idLe;
    BigInteger idGt;
    BigInteger idGe;
    boolean idIsNull;
    boolean idIsNotNull;
    List<BigInteger> idIn;
    List<BigInteger> idNotIn;

    String emailEq;
    String emailNe;
    String emailLt;
    String emailLe;
    String emailGt;
    String emailGe;
    boolean emailIsNull;
    boolean emailIsNotNull;
    List<String> emailIn;
    List<String> emailNotIn;
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
    List<String> tokenIn;
    List<String> tokenNotIn;
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

    LocalDateTime updatedAtEq;
    LocalDateTime updatedAtNe;
    LocalDateTime updatedAtLt;
    LocalDateTime updatedAtLe;
    LocalDateTime updatedAtGt;
    LocalDateTime updatedAtGe;
    boolean updatedAtIsNull;
    boolean updatedAtIsNotNull;

    boolean deleteFlgTrue;
    boolean deleteFlgFalse;


    String orderBy;
}