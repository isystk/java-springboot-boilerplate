package com.isystk.sample.domain.dto;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.isystk.sample.domain.entity.MMailTemplate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MMailTemplateCriteria extends MMailTemplate {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;


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

    Boolean deleteFlgEqual;
    Boolean deleteFlgNotEqual;
    boolean deleteFlgIsNull;
    boolean deleteFlgIsNotNull;

}