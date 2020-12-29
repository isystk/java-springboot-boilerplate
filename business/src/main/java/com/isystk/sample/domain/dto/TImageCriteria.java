package com.isystk.sample.domain.dto;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * 自動生成のため原則修正禁止!!
 */
@Getter
@Setter
public class TImageCriteria {


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