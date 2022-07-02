package com.isystk.sample.domain.dto;

import java.math.BigInteger;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * お問い合わせ
 *
 * 自動生成のため原則修正禁止!!
 *
 */
@Getter
@Setter
public class ContactFormCriteria {


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

    String yourNameEq;
    String yourNameNe;
    String yourNameLt;
    String yourNameLe;
    String yourNameGt;
    String yourNameGe;
    boolean yourNameIsNull;
    boolean yourNameIsNotNull;
    List<String> yourNameIn;
    List<String> yourNameNotIn;
    String yourNameLike;
    String yourNameNotLike;
    String yourNameStarts;
    String yourNameNotStarts;
    String yourNameEnds;
    String yourNameNotEnds;

    String titleEq;
    String titleNe;
    String titleLt;
    String titleLe;
    String titleGt;
    String titleGe;
    boolean titleIsNull;
    boolean titleIsNotNull;
    List<String> titleIn;
    List<String> titleNotIn;
    String titleLike;
    String titleNotLike;
    String titleStarts;
    String titleNotStarts;
    String titleEnds;
    String titleNotEnds;

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

    String urlEq;
    String urlNe;
    String urlLt;
    String urlLe;
    String urlGt;
    String urlGe;
    boolean urlIsNull;
    boolean urlIsNotNull;
    List<String> urlIn;
    List<String> urlNotIn;
    String urlLike;
    String urlNotLike;
    String urlStarts;
    String urlNotStarts;
    String urlEnds;
    String urlNotEnds;

    Boolean genderEq;
    Boolean genderNe;
    Boolean genderLt;
    Boolean genderLe;
    Boolean genderGt;
    Boolean genderGe;
    boolean genderIsNull;
    boolean genderIsNotNull;

    Byte ageEq;
    Byte ageNe;
    Byte ageLt;
    Byte ageLe;
    Byte ageGt;
    Byte ageGe;
    boolean ageIsNull;
    boolean ageIsNotNull;
    List<Byte> ageIn;
    List<Byte> ageNotIn;

    String contactEq;
    String contactNe;
    String contactLt;
    String contactLe;
    String contactGt;
    String contactGe;
    boolean contactIsNull;
    boolean contactIsNotNull;
    List<String> contactIn;
    List<String> contactNotIn;
    String contactLike;
    String contactNotLike;
    String contactStarts;
    String contactNotStarts;
    String contactEnds;
    String contactNotEnds;

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