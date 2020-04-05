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
public class TPostTagCriteria {


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

    String orderBy;
}