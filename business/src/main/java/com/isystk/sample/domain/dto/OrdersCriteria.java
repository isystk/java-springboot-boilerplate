package com.isystk.sample.domain.dto;

import java.math.BigInteger;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * 注文
 *
 * 自動生成のため原則修正禁止!!
 *
 */
@Getter
@Setter
public class OrdersCriteria {


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

    Integer priceEq;
    Integer priceNe;
    Integer priceLt;
    Integer priceLe;
    Integer priceGt;
    Integer priceGe;
    boolean priceIsNull;
    boolean priceIsNotNull;
    List<Integer> priceIn;
    List<Integer> priceNotIn;

    Integer quantityEq;
    Integer quantityNe;
    Integer quantityLt;
    Integer quantityLe;
    Integer quantityGt;
    Integer quantityGe;
    boolean quantityIsNull;
    boolean quantityIsNotNull;
    List<Integer> quantityIn;
    List<Integer> quantityNotIn;

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