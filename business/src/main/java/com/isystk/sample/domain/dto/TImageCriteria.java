package com.isystk.sample.domain.dto;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.isystk.sample.domain.entity.TImage;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TImageCriteria extends TImage {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;


    Integer imageIdEqual;
    Integer imageIdNotEqual;
    boolean imageIdIsNull;
    boolean imageIdIsNotNull;
    List<Integer> imageIdIn;
    List<Integer> imageIdNotIn;
    Integer imageIdLike;

    LocalDateTime registTimeEqual;
    LocalDateTime registTimeNotEqual;
    boolean registTimeIsNull;
    boolean registTimeIsNotNull;
    List<LocalDateTime> registTimeIn;
    List<LocalDateTime> registTimeNotIn;
    LocalDateTime registTimeLike;

    LocalDateTime updateTimeEqual;
    LocalDateTime updateTimeNotEqual;
    boolean updateTimeIsNull;
    boolean updateTimeIsNotNull;
    List<LocalDateTime> updateTimeIn;
    List<LocalDateTime> updateTimeNotIn;
    LocalDateTime updateTimeLike;

    Boolean deleteFlgEqual;
    Boolean deleteFlgNotEqual;
    boolean deleteFlgIsNull;
    boolean deleteFlgIsNotNull;
    List<Boolean> deleteFlgIn;
    List<Boolean> deleteFlgNotIn;
    Boolean deleteFlgLike;
}