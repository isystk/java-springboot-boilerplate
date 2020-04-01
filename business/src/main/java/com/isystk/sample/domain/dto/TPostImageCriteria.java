package com.isystk.sample.domain.dto;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.isystk.sample.domain.entity.TPostImage;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TPostImageCriteria extends TPostImage {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;


    Integer postIdEqual;
    Integer postIdNotEqual;
    boolean postIdIsNull;
    boolean postIdIsNotNull;
    List<Integer> postIdIn;
    List<Integer> postIdNotIn;

    Integer imageIdEqual;
    Integer imageIdNotEqual;
    boolean imageIdIsNull;
    boolean imageIdIsNotNull;
    List<Integer> imageIdIn;
    List<Integer> imageIdNotIn;
}