package com.isystk.sample.domain.dto;

import java.math.BigInteger;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * カート
 *
 * 自動生成のため原則修正禁止!!
 *
 */
@Getter
@Setter
public class CartsCriteria {


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

    BigInteger stockIdEq;
    BigInteger stockIdNe;
    BigInteger stockIdLt;
    BigInteger stockIdLe;
    BigInteger stockIdGt;
    BigInteger stockIdGe;
    boolean stockIdIsNull;
    boolean stockIdIsNotNull;
    List<BigInteger> stockIdIn;
    List<BigInteger> stockIdNotIn;

    BigInteger userIdEq;
    BigInteger userIdNe;
    BigInteger userIdLt;
    BigInteger userIdLe;
    BigInteger userIdGt;
    BigInteger userIdGe;
    boolean userIdIsNull;
    boolean userIdIsNotNull;
    List<BigInteger> userIdIn;
    List<BigInteger> userIdNotIn;

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