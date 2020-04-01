package com.isystk.sample.domain.dto;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.isystk.sample.domain.entity.TUserOnetimePass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TUserOnetimePassCriteria extends TUserOnetimePass {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;


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