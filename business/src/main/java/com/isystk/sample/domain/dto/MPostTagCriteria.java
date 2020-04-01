package com.isystk.sample.domain.dto;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.isystk.sample.domain.entity.MPostTag;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MPostTagCriteria extends MPostTag {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;


    Integer postTagIdEqual;
    Integer postTagIdNotEqual;
    boolean postTagIdIsNull;
    boolean postTagIdIsNotNull;
    List<Integer> postTagIdIn;
    List<Integer> postTagIdNotIn;
    Integer postTagIdLike;

    String nameEqual;
    String nameNotEqual;
    boolean nameIsNull;
    boolean nameIsNotNull;
    List<String> nameIn;
    List<String> nameNotIn;
    String nameLike;

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