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
    Integer userIdLike;

    String onetimeKeyEqual;
    String onetimeKeyNotEqual;
    boolean onetimeKeyIsNull;
    boolean onetimeKeyIsNotNull;
    List<String> onetimeKeyIn;
    List<String> onetimeKeyNotIn;
    String onetimeKeyLike;

    LocalDateTime onetimeValidTimeEqual;
    LocalDateTime onetimeValidTimeNotEqual;
    boolean onetimeValidTimeIsNull;
    boolean onetimeValidTimeIsNotNull;
    List<LocalDateTime> onetimeValidTimeIn;
    List<LocalDateTime> onetimeValidTimeNotIn;
    LocalDateTime onetimeValidTimeLike;
}