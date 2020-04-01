package com.isystk.sample.domain.dto;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.isystk.sample.domain.entity.TPost;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TPostCriteria extends TPost {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;


    Integer postIdEqual;
    Integer postIdNotEqual;
    boolean postIdIsNull;
    boolean postIdIsNotNull;
    List<Integer> postIdIn;
    List<Integer> postIdNotIn;
    Integer postIdLike;

    Integer userIdEqual;
    Integer userIdNotEqual;
    boolean userIdIsNull;
    boolean userIdIsNotNull;
    List<Integer> userIdIn;
    List<Integer> userIdNotIn;
    Integer userIdLike;

    String titleEqual;
    String titleNotEqual;
    boolean titleIsNull;
    boolean titleIsNotNull;
    List<String> titleIn;
    List<String> titleNotIn;
    String titleLike;

    String textEqual;
    String textNotEqual;
    boolean textIsNull;
    boolean textIsNotNull;
    List<String> textIn;
    List<String> textNotIn;
    String textLike;

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

    Long versionEqual;
    Long versionNotEqual;
    boolean versionIsNull;
    boolean versionIsNotNull;
    List<Long> versionIn;
    List<Long> versionNotIn;
    Long versionLike;
}