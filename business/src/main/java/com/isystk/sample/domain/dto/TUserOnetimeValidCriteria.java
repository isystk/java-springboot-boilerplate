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
public class TUserOnetimeValidCriteria {


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

    String onetimeKeyEq;
    String onetimeKeyNe;
    String onetimeKeyLt;
    String onetimeKeyLe;
    String onetimeKeyGt;
    String onetimeKeyGe;
    boolean onetimeKeyIsNull;
    boolean onetimeKeyIsNotNull;
    String onetimeKeyLike;
    String onetimeKeyNotLike;
    String onetimeKeyStarts;
    String onetimeKeyNotStarts;
    String onetimeKeyEnds;
    String onetimeKeyNotEnds;

    LocalDateTime onetimeValidTimeEq;
    LocalDateTime onetimeValidTimeNe;
    LocalDateTime onetimeValidTimeLt;
    LocalDateTime onetimeValidTimeLe;
    LocalDateTime onetimeValidTimeGt;
    LocalDateTime onetimeValidTimeGe;
    boolean onetimeValidTimeIsNull;
    boolean onetimeValidTimeIsNotNull;

    String orderBy;
}