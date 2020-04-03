package com.isystk.sample.domain.dto;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MMailTemplateCriteria {


    Integer mailTemplateIdEqual;
    Integer mailTemplateIdNotEqual;
    boolean mailTemplateIdIsNull;
    boolean mailTemplateIdIsNotNull;
    List<Integer> mailTemplateIdIn;
    List<Integer> mailTemplateIdNotIn;

    Integer templateDivEqual;
    Integer templateDivNotEqual;
    boolean templateDivIsNull;
    boolean templateDivIsNotNull;
    List<Integer> templateDivIn;
    List<Integer> templateDivNotIn;

    String titleEqual;
    String titleNotEqual;
    boolean titleIsNull;
    boolean titleIsNotNull;
    String titleLike;

    String textEqual;
    String textNotEqual;
    boolean textIsNull;
    boolean textIsNotNull;
    String textLike;

    LocalDateTime registTimeEqual;
    LocalDateTime registTimeNotEqual;
    boolean registTimeIsNull;
    boolean registTimeIsNotNull;

    LocalDateTime updateTimeEqual;
    LocalDateTime updateTimeNotEqual;
    boolean updateTimeIsNull;
    boolean updateTimeIsNotNull;

    boolean deleteFlgTrue;
    boolean deleteFlgFalse;

}