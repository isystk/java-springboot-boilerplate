package com.isystk.sample.domain.dto;

import java.math.BigInteger;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * 商品
 *
 * 自動生成のため原則修正禁止!!
 *
 */
@Getter
@Setter
public class StocksCriteria {


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

    String detailEq;
    String detailNe;
    String detailLt;
    String detailLe;
    String detailGt;
    String detailGe;
    boolean detailIsNull;
    boolean detailIsNotNull;
    String detailLike;
    String detailNotLike;
    String detailStarts;
    String detailNotStarts;
    String detailEnds;
    String detailNotEnds;

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

    String imgpathEq;
    String imgpathNe;
    String imgpathLt;
    String imgpathLe;
    String imgpathGt;
    String imgpathGe;
    boolean imgpathIsNull;
    boolean imgpathIsNotNull;
    String imgpathLike;
    String imgpathNotLike;
    String imgpathStarts;
    String imgpathNotStarts;
    String imgpathEnds;
    String imgpathNotEnds;

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