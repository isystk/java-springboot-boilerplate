package com.isystk.sample.domain.dto;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TPostCriteria {


    Integer postIdEqual;
    Integer postIdNotEqual;
    boolean postIdIsNull;
    boolean postIdIsNotNull;
    List<Integer> postIdIn;
    List<Integer> postIdNotIn;

    Integer userIdEqual;
    Integer userIdNotEqual;
    boolean userIdIsNull;
    boolean userIdIsNotNull;
    List<Integer> userIdIn;
    List<Integer> userIdNotIn;

    String titleEqual;
    String titleNotEqual;
    boolean titleIsNull;
    boolean titleIsNotNull;
    String titleLike;

    String textEqual;
    String textNotEqual;
    boolean textIsNull;
    boolean textIsNotNull;
    String textLike;

    LocalDateTime registTimeEqual;
    LocalDateTime registTimeNotEqual;
    boolean registTimeIsNull;
    boolean registTimeIsNotNull;

    LocalDateTime updateTimeEqual;
    LocalDateTime updateTimeNotEqual;
    boolean updateTimeIsNull;
    boolean updateTimeIsNotNull;

    boolean deleteFlgTrue;
    boolean deleteFlgFalse;

}