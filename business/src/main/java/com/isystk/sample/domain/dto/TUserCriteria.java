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
    Integer userIdLike;

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

    String zipEqual;
    String zipNotEqual;
    boolean zipIsNull;
    boolean zipIsNotNull;
    List<String> zipIn;
    List<String> zipNotIn;
    String zipLike;

    Integer prefectureIdEqual;
    Integer prefectureIdNotEqual;
    boolean prefectureIdIsNull;
    boolean prefectureIdIsNotNull;
    List<Integer> prefectureIdIn;
    List<Integer> prefectureIdNotIn;
    Integer prefectureIdLike;

    String areaEqual;
    String areaNotEqual;
    boolean areaIsNull;
    boolean areaIsNotNull;
    List<String> areaIn;
    List<String> areaNotIn;
    String areaLike;

    String addressEqual;
    String addressNotEqual;
    boolean addressIsNull;
    boolean addressIsNotNull;
    List<String> addressIn;
    List<String> addressNotIn;
    String addressLike;

    String buildingEqual;
    String buildingNotEqual;
    boolean buildingIsNull;
    boolean buildingIsNotNull;
    List<String> buildingIn;
    List<String> buildingNotIn;
    String buildingLike;

    String telEqual;
    String telNotEqual;
    boolean telIsNull;
    boolean telIsNotNull;
    List<String> telIn;
    List<String> telNotIn;
    String telLike;

    Integer sexEqual;
    Integer sexNotEqual;
    boolean sexIsNull;
    boolean sexIsNotNull;
    List<Integer> sexIn;
    List<Integer> sexNotIn;
    Integer sexLike;

    LocalDate birthdayEqual;
    LocalDate birthdayNotEqual;
    boolean birthdayIsNull;
    boolean birthdayIsNotNull;
    List<LocalDate> birthdayIn;
    List<LocalDate> birthdayNotIn;
    LocalDate birthdayLike;

    LocalDateTime lastLoginTimeEqual;
    LocalDateTime lastLoginTimeNotEqual;
    boolean lastLoginTimeIsNull;
    boolean lastLoginTimeIsNotNull;
    List<LocalDateTime> lastLoginTimeIn;
    List<LocalDateTime> lastLoginTimeNotIn;
    LocalDateTime lastLoginTimeLike;

    Integer statusEqual;
    Integer statusNotEqual;
    boolean statusIsNull;
    boolean statusIsNotNull;
    List<Integer> statusIn;
    List<Integer> statusNotIn;
    Integer statusLike;

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