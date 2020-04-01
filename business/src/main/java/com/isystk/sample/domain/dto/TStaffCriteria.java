package com.isystk.sample.domain.dto;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.isystk.sample.domain.entity.TStaff;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TStaffCriteria extends TStaff {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;


    Integer staffIdEqual;
    Integer staffIdNotEqual;
    boolean staffIdIsNull;
    boolean staffIdIsNotNull;
    List<Integer> staffIdIn;
    List<Integer> staffIdNotIn;

    String emailEqual;
    String emailNotEqual;
    boolean emailIsNull;
    boolean emailIsNotNull;
    String emailLike;

    String passwordEqual;
    String passwordNotEqual;
    boolean passwordIsNull;
    boolean passwordIsNotNull;
    String passwordLike;

    String familyNameEqual;
    String familyNameNotEqual;
    boolean familyNameIsNull;
    boolean familyNameIsNotNull;
    String familyNameLike;

    String nameEqual;
    String nameNotEqual;
    boolean nameIsNull;
    boolean nameIsNotNull;
    String nameLike;

    String familyNameKanaEqual;
    String familyNameKanaNotEqual;
    boolean familyNameKanaIsNull;
    boolean familyNameKanaIsNotNull;
    String familyNameKanaLike;

    String nameKanaEqual;
    String nameKanaNotEqual;
    boolean nameKanaIsNull;
    boolean nameKanaIsNotNull;
    String nameKanaLike;

    LocalDateTime lastLoginTimeEqual;
    LocalDateTime lastLoginTimeNotEqual;
    boolean lastLoginTimeIsNull;
    boolean lastLoginTimeIsNotNull;

    LocalDateTime registTimeEqual;
    LocalDateTime registTimeNotEqual;
    boolean registTimeIsNull;
    boolean registTimeIsNotNull;

    LocalDateTime updateTimeEqual;
    LocalDateTime updateTimeNotEqual;
    boolean updateTimeIsNull;
    boolean updateTimeIsNotNull;

    Boolean deleteFlgEqual;
    Boolean deleteFlgNotEqual;
    boolean deleteFlgIsNull;
    boolean deleteFlgIsNotNull;

}