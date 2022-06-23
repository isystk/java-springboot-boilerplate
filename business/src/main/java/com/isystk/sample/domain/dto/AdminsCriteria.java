package com.isystk.sample.domain.dto;

import java.math.BigInteger;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * 管理者
 *
 * 自動生成のため原則修正禁止!!
 *
 */
@Getter
@Setter
public class AdminsCriteria {


    Long idEq;
    Long idNe;
    Long idLt;
    Long idLe;
    Long idGt;
    Long idGe;
    boolean idIsNull;
    boolean idIsNotNull;
    List<Long> idIn;
    List<Long> idNotIn;

    String nameEq;
    String nameNe;
    String nameLt;
    String nameLe;
    String nameGt;
    String nameGe;
    boolean nameIsNull;
    boolean nameIsNotNull;
    String nameLike;
    String nameNotLike;
    String nameStarts;
    String nameNotStarts;
    String nameEnds;
    String nameNotEnds;

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

    String passwordEq;
    String passwordNe;
    String passwordLt;
    String passwordLe;
    String passwordGt;
    String passwordGe;
    boolean passwordIsNull;
    boolean passwordIsNotNull;
    String passwordLike;
    String passwordNotLike;
    String passwordStarts;
    String passwordNotStarts;
    String passwordEnds;
    String passwordNotEnds;

    String rememberTokenEq;
    String rememberTokenNe;
    String rememberTokenLt;
    String rememberTokenLe;
    String rememberTokenGt;
    String rememberTokenGe;
    boolean rememberTokenIsNull;
    boolean rememberTokenIsNotNull;
    String rememberTokenLike;
    String rememberTokenNotLike;
    String rememberTokenStarts;
    String rememberTokenNotStarts;
    String rememberTokenEnds;
    String rememberTokenNotEnds;

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