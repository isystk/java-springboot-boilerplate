package com.isystk.sample.domain.dto;

import java.math.BigInteger;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * メールテンプレート
 *
 * 自動生成のため原則修正禁止!!
 *
 */
@Getter
@Setter
public class MailTemplateCriteria {


    Integer mailTemplateIdEq;
    Integer mailTemplateIdNe;
    Integer mailTemplateIdLt;
    Integer mailTemplateIdLe;
    Integer mailTemplateIdGt;
    Integer mailTemplateIdGe;
    boolean mailTemplateIdIsNull;
    boolean mailTemplateIdIsNotNull;
    List<Integer> mailTemplateIdIn;
    List<Integer> mailTemplateIdNotIn;

    Byte mailTemplateDivEq;
    Byte mailTemplateDivNe;
    Byte mailTemplateDivLt;
    Byte mailTemplateDivLe;
    Byte mailTemplateDivGt;
    Byte mailTemplateDivGe;
    boolean mailTemplateDivIsNull;
    boolean mailTemplateDivIsNotNull;
    List<Byte> mailTemplateDivIn;
    List<Byte> mailTemplateDivNotIn;

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

    String textEq;
    String textNe;
    String textLt;
    String textLe;
    String textGt;
    String textGe;
    boolean textIsNull;
    boolean textIsNotNull;
    List<String> textIn;
    List<String> textNotIn;
    String textLike;
    String textNotLike;
    String textStarts;
    String textNotStarts;
    String textEnds;
    String textNotEnds;

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