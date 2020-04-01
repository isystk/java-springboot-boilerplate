package com.isystk.sample.domain.dto;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.isystk.sample.domain.entity.TUser;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TUserCriteria extends TUser {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;


    Integer userIdEqual;
    Integer userIdNotEqual;
    boolean userIdIsNull;
    boolean userIdIsNotNull;
    List<Integer> userIdIn;
    List<Integer> userIdNotIn;

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

    String zipEqual;
    String zipNotEqual;
    boolean zipIsNull;
    boolean zipIsNotNull;
    String zipLike;

    Integer prefectureIdEqual;
    Integer prefectureIdNotEqual;
    boolean prefectureIdIsNull;
    boolean prefectureIdIsNotNull;
    List<Integer> prefectureIdIn;
    List<Integer> prefectureIdNotIn;

    String areaEqual;
    String areaNotEqual;
    boolean areaIsNull;
    boolean areaIsNotNull;
    String areaLike;

    String addressEqual;
    String addressNotEqual;
    boolean addressIsNull;
    boolean addressIsNotNull;
    String addressLike;

    String buildingEqual;
    String buildingNotEqual;
    boolean buildingIsNull;
    boolean buildingIsNotNull;
    String buildingLike;

    String telEqual;
    String telNotEqual;
    boolean telIsNull;
    boolean telIsNotNull;
    String telLike;

    Integer sexEqual;
    Integer sexNotEqual;
    boolean sexIsNull;
    boolean sexIsNotNull;
    List<Integer> sexIn;
    List<Integer> sexNotIn;

    LocalDate birthdayEqual;
    LocalDate birthdayNotEqual;
    boolean birthdayIsNull;
    boolean birthdayIsNotNull;

    LocalDateTime lastLoginTimeEqual;
    LocalDateTime lastLoginTimeNotEqual;
    boolean lastLoginTimeIsNull;
    boolean lastLoginTimeIsNotNull;

    Integer statusEqual;
    Integer statusNotEqual;
    boolean statusIsNull;
    boolean statusIsNotNull;
    List<Integer> statusIn;
    List<Integer> statusNotIn;

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