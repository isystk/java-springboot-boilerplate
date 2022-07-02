package com.isystk.sample.domain.dto;

import java.math.BigInteger;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * お問い合わせ画像
 *
 * 自動生成のため原則修正禁止!!
 *
 */
@Getter
@Setter
public class ContactFormImageCriteria {


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

    BigInteger contactFormIdEq;
    BigInteger contactFormIdNe;
    BigInteger contactFormIdLt;
    BigInteger contactFormIdLe;
    BigInteger contactFormIdGt;
    BigInteger contactFormIdGe;
    boolean contactFormIdIsNull;
    boolean contactFormIdIsNotNull;
    List<BigInteger> contactFormIdIn;
    List<BigInteger> contactFormIdNotIn;

    String fileNameEq;
    String fileNameNe;
    String fileNameLt;
    String fileNameLe;
    String fileNameGt;
    String fileNameGe;
    boolean fileNameIsNull;
    boolean fileNameIsNotNull;
    List<String> fileNameIn;
    List<String> fileNameNotIn;
    String fileNameLike;
    String fileNameNotLike;
    String fileNameStarts;
    String fileNameNotStarts;
    String fileNameEnds;
    String fileNameNotEnds;

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