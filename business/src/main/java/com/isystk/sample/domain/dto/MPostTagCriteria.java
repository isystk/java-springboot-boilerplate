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
public class MPostTagCriteria {


    Integer postTagIdEq;
    Integer postTagIdNe;
    Integer postTagIdLt;
    Integer postTagIdLe;
    Integer postTagIdGt;
    Integer postTagIdGe;
    boolean postTagIdIsNull;
    boolean postTagIdIsNotNull;
    List<Integer> postTagIdIn;
    List<Integer> postTagIdNotIn;

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