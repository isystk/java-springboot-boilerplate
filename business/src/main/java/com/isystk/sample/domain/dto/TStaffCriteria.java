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
public class TStaffCriteria {


  Integer staffIdEq;
  Integer staffIdNe;
  Integer staffIdLt;
  Integer staffIdLe;
  Integer staffIdGt;
  Integer staffIdGe;
  boolean staffIdIsNull;
  boolean staffIdIsNotNull;
  List<Integer> staffIdIn;
  List<Integer> staffIdNotIn;

  String emailEq;
  String emailNe;
  String emailLt;
  String emailLe;
  String emailGt;
  String emailGe;
  boolean emailIsNull;
  boolean emailIsNotNull;
  String emailLike;
  String emailNotLike;
  String emailStarts;
  String emailNotStarts;
  String emailEnds;
  String emailNotEnds;

  String passwordEq;
  String passwordNe;
  String passwordLt;
  String passwordLe;
  String passwordGt;
  String passwordGe;
  boolean passwordIsNull;
  boolean passwordIsNotNull;
  String passwordLike;
  String passwordNotLike;
  String passwordStarts;
  String passwordNotStarts;
  String passwordEnds;
  String passwordNotEnds;

  String familyNameEq;
  String familyNameNe;
  String familyNameLt;
  String familyNameLe;
  String familyNameGt;
  String familyNameGe;
  boolean familyNameIsNull;
  boolean familyNameIsNotNull;
  String familyNameLike;
  String familyNameNotLike;
  String familyNameStarts;
  String familyNameNotStarts;
  String familyNameEnds;
  String familyNameNotEnds;

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

  String familyNameKanaEq;
  String familyNameKanaNe;
  String familyNameKanaLt;
  String familyNameKanaLe;
  String familyNameKanaGt;
  String familyNameKanaGe;
  boolean familyNameKanaIsNull;
  boolean familyNameKanaIsNotNull;
  String familyNameKanaLike;
  String familyNameKanaNotLike;
  String familyNameKanaStarts;
  String familyNameKanaNotStarts;
  String familyNameKanaEnds;
  String familyNameKanaNotEnds;

  String nameKanaEq;
  String nameKanaNe;
  String nameKanaLt;
  String nameKanaLe;
  String nameKanaGt;
  String nameKanaGe;
  boolean nameKanaIsNull;
  boolean nameKanaIsNotNull;
  String nameKanaLike;
  String nameKanaNotLike;
  String nameKanaStarts;
  String nameKanaNotStarts;
  String nameKanaEnds;
  String nameKanaNotEnds;

  LocalDateTime lastLoginTimeEq;
  LocalDateTime lastLoginTimeNe;
  LocalDateTime lastLoginTimeLt;
  LocalDateTime lastLoginTimeLe;
  LocalDateTime lastLoginTimeGt;
  LocalDateTime lastLoginTimeGe;
  boolean lastLoginTimeIsNull;
  boolean lastLoginTimeIsNotNull;

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