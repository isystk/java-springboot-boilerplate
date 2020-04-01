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
    Integer staffIdLike;

    String emailEqual;
    String emailNotEqual;
    boolean emailIsNull;
    boolean emailIsNotNull;
    List<String> emailIn;
    List<String> emailNotIn;
    String emailLike;

    String passwordEqual;
    String passwordNotEqual;
    boolean passwordIsNull;
    boolean passwordIsNotNull;
    List<String> passwordIn;
    List<String> passwordNotIn;
    String passwordLike;

    String familyNameEqual;
    String familyNameNotEqual;
    boolean familyNameIsNull;
    boolean familyNameIsNotNull;
    List<String> familyNameIn;
    List<String> familyNameNotIn;
    String familyNameLike;

    String nameEqual;
    String nameNotEqual;
    boolean nameIsNull;
    boolean nameIsNotNull;
    List<String> nameIn;
    List<String> nameNotIn;
    String nameLike;

    String familyNameKanaEqual;
    String familyNameKanaNotEqual;
    boolean familyNameKanaIsNull;
    boolean familyNameKanaIsNotNull;
    List<String> familyNameKanaIn;
    List<String> familyNameKanaNotIn;
    String familyNameKanaLike;

    String nameKanaEqual;
    String nameKanaNotEqual;
    boolean nameKanaIsNull;
    boolean nameKanaIsNotNull;
    List<String> nameKanaIn;
    List<String> nameKanaNotIn;
    String nameKanaLike;

    LocalDateTime lastLoginTimeEqual;
    LocalDateTime lastLoginTimeNotEqual;
    boolean lastLoginTimeIsNull;
    boolean lastLoginTimeIsNotNull;
    List<LocalDateTime> lastLoginTimeIn;
    List<LocalDateTime> lastLoginTimeNotIn;
    LocalDateTime lastLoginTimeLike;

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