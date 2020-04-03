package com.isystk.sample.domain.dto;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TUserOnetimePassCriteria {


    Integer userIdEqual;
    Integer userIdNotEqual;
    boolean userIdIsNull;
    boolean userIdIsNotNull;
    List<Integer> userIdIn;
    List<Integer> userIdNotIn;

    String onetimeKeyEqual;
    String onetimeKeyNotEqual;
    boolean onetimeKeyIsNull;
    boolean onetimeKeyIsNotNull;
    String onetimeKeyLike;

    LocalDateTime onetimeValidTimeEqual;
    LocalDateTime onetimeValidTimeNotEqual;
    boolean onetimeValidTimeIsNull;
    boolean onetimeValidTimeIsNotNull;
}