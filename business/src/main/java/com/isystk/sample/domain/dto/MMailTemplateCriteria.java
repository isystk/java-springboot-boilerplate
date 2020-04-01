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
    Integer mailTemplateIdLike;

    Integer templateDivEqual;
    Integer templateDivNotEqual;
    boolean templateDivIsNull;
    boolean templateDivIsNotNull;
    List<Integer> templateDivIn;
    List<Integer> templateDivNotIn;
    Integer templateDivLike;

    String titleEqual;
    String titleNotEqual;
    boolean titleIsNull;
    boolean titleIsNotNull;
    List<String> titleIn;
    List<String> titleNotIn;
    String titleLike;

    String textEqual;
    String textNotEqual;
    boolean textIsNull;
    boolean textIsNotNull;
    List<String> textIn;
    List<String> textNotIn;
    String textLike;

    LocalDateTime registTimeEqual;
    LocalDateTime registTimeNotEqual;
    boolean registTimeIsNull;
    boolean registTimeIsNotNull;
    List<LocalDateTime> registTimeIn;
    List<LocalDateTime> registTimeNotIn;
    LocalDateTime registTimeLike;

    LocalDateTime updateTimeEqual;
    LocalDateTime updateTimeNotEqual;
    boolean updateTimeIsNull;
    boolean updateTimeIsNotNull;
    List<LocalDateTime> updateTimeIn;
    List<LocalDateTime> updateTimeNotIn;
    LocalDateTime updateTimeLike;

    Boolean deleteFlgEqual;
    Boolean deleteFlgNotEqual;
    boolean deleteFlgIsNull;
    boolean deleteFlgIsNotNull;
    List<Boolean> deleteFlgIn;
    List<Boolean> deleteFlgNotIn;
    Boolean deleteFlgLike;

    Long versionEqual;
    Long versionNotEqual;
    boolean versionIsNull;
    boolean versionIsNotNull;
    List<Long> versionIn;
    List<Long> versionNotIn;
    Long versionLike;
}