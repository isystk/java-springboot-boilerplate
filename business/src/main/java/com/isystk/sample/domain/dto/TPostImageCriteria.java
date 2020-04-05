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
public class TPostImageCriteria {


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

    Integer imageIdEq;
    Integer imageIdNe;
    Integer imageIdLt;
    Integer imageIdLe;
    Integer imageIdGt;
    Integer imageIdGe;
    boolean imageIdIsNull;
    boolean imageIdIsNotNull;
    List<Integer> imageIdIn;
    List<Integer> imageIdNotIn;

    String orderBy;
}