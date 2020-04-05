package com.isystk.sample.domain.dto;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 *
 * 自動生成のため原則修正禁止!!
 *
 */
@Getter
@Setter
public class TPostCriteria {


    Integer postIdEq;
    Integer postIdNe;
    Integer postIdLt;
    Integer postIdLe;
    Integer postIdGt;
    Integer postIdGe;
    boolean postIdIsNull;
    boolean postIdIsNotNull;
    List<Integer> postIdIn;
    List<Integer> postIdNotIn;

    Integer userIdEq;
    Integer userIdNe;
    Integer userIdLt;
    Integer userIdLe;
    Integer userIdGt;
    Integer userIdGe;
    boolean userIdIsNull;
    boolean userIdIsNotNull;
    List<Integer> userIdIn;
    List<Integer> userIdNotIn;

    String titleEq;
    String titleNe;
    String titleLt;
    String titleLe;
    String titleGt;
    String titleGe;
    boolean titleIsNull;
    boolean titleIsNotNull;
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
    String textLike;
    String textNotLike;
    String textStarts;
    String textNotStarts;
    String textEnds;
    String textNotEnds;

    LocalDateTime registTimeEq;
    LocalDateTime registTimeNe;
    LocalDateTime registTimeLt;
    LocalDateTime registTimeLe;
    LocalDateTime registTimeGt;
    LocalDateTime registTimeGe;
    boolean registTimeIsNull;
    boolean registTimeIsNotNull;

    LocalDateTime updateTimeEq;
    LocalDateTime updateTimeNe;
    LocalDateTime updateTimeLt;
    LocalDateTime updateTimeLe;
    LocalDateTime updateTimeGt;
    LocalDateTime updateTimeGe;
    boolean updateTimeIsNull;
    boolean updateTimeIsNotNull;

    boolean deleteFlgTrue;
    boolean deleteFlgFalse;


    String orderBy;
}