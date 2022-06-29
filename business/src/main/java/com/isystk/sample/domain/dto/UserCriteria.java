package com.isystk.sample.domain.dto;

import java.math.BigInteger;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * ユーザ
 *
 * 自動生成のため原則修正禁止!!
 *
 */
@Getter
@Setter
public class UserCriteria {


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

    String providerIdEq;
    String providerIdNe;
    String providerIdLt;
    String providerIdLe;
    String providerIdGt;
    String providerIdGe;
    boolean providerIdIsNull;
    boolean providerIdIsNotNull;
    String providerIdLike;
    String providerIdNotLike;
    String providerIdStarts;
    String providerIdNotStarts;
    String providerIdEnds;
    String providerIdNotEnds;

    String providerNameEq;
    String providerNameNe;
    String providerNameLt;
    String providerNameLe;
    String providerNameGt;
    String providerNameGe;
    boolean providerNameIsNull;
    boolean providerNameIsNotNull;
    String providerNameLike;
    String providerNameNotLike;
    String providerNameStarts;
    String providerNameNotStarts;
    String providerNameEnds;
    String providerNameNotEnds;

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

    LocalDateTime emailVerifiedAtEq;
    LocalDateTime emailVerifiedAtNe;
    LocalDateTime emailVerifiedAtLt;
    LocalDateTime emailVerifiedAtLe;
    LocalDateTime emailVerifiedAtGt;
    LocalDateTime emailVerifiedAtGe;
    boolean emailVerifiedAtIsNull;
    boolean emailVerifiedAtIsNotNull;

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

    LocalDateTime lastLoginAtEq;
    LocalDateTime lastLoginAtNe;
    LocalDateTime lastLoginAtLt;
    LocalDateTime lastLoginAtLe;
    LocalDateTime lastLoginAtGt;
    LocalDateTime lastLoginAtGe;
    boolean lastLoginAtIsNull;
    boolean lastLoginAtIsNotNull;

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