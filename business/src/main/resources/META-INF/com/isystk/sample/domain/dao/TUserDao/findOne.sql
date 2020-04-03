SELECT
  /*%expand*/*
FROM
  t_user
WHERE
/*%if criteria.userIdEqual != null */
  USER_ID = /* criteria.userIdEqual */1
/*%end*/
/*%if criteria.userIdNotEqual != null */
  USER_ID != /* criteria.userIdNotEqual */1
/*%end*/
/*%if criteria.userIdIsNull  */
  USER_ID IS NULL
/*%end*/
/*%if criteria.userIdIsNotNull  */
  USER_ID IS NOT NULL
/*%end*/
/*%if criteria.userIdIn != null  */
  USER_ID IN /* criteria.userIdIn */(1,2,3)
/*%end*/
/*%if criteria.userIdNotIn != null  */
  USER_ID NOT IN /* criteria.userIdNotIn */(1,2,3)
/*%end*/
/*%if criteria.emailEqual != null */
  EMAIL = /* criteria.emailEqual */'a'
/*%end*/
/*%if criteria.emailNotEqual != null */
  EMAIL != /* criteria.emailNotEqual */'a'
/*%end*/
/*%if criteria.emailIsNull  */
  EMAIL IS NULL
/*%end*/
/*%if criteria.emailIsNotNull  */
  EMAIL IS NOT NULL
/*%end*/
/*%if criteria.emailLike != null  */
  EMAIL LIKE /* @infix(criteria.emailLike) */'smith'
/*%end*/
/*%if criteria.passwordEqual != null */
  PASSWORD = /* criteria.passwordEqual */'a'
/*%end*/
/*%if criteria.passwordNotEqual != null */
  PASSWORD != /* criteria.passwordNotEqual */'a'
/*%end*/
/*%if criteria.passwordIsNull  */
  PASSWORD IS NULL
/*%end*/
/*%if criteria.passwordIsNotNull  */
  PASSWORD IS NOT NULL
/*%end*/
/*%if criteria.passwordLike != null  */
  PASSWORD LIKE /* @infix(criteria.passwordLike) */'smith'
/*%end*/
/*%if criteria.familyNameEqual != null */
  FAMILY_NAME = /* criteria.familyNameEqual */'a'
/*%end*/
/*%if criteria.familyNameNotEqual != null */
  FAMILY_NAME != /* criteria.familyNameNotEqual */'a'
/*%end*/
/*%if criteria.familyNameIsNull  */
  FAMILY_NAME IS NULL
/*%end*/
/*%if criteria.familyNameIsNotNull  */
  FAMILY_NAME IS NOT NULL
/*%end*/
/*%if criteria.familyNameLike != null  */
  FAMILY_NAME LIKE /* @infix(criteria.familyNameLike) */'smith'
/*%end*/
/*%if criteria.nameEqual != null */
  NAME = /* criteria.nameEqual */'a'
/*%end*/
/*%if criteria.nameNotEqual != null */
  NAME != /* criteria.nameNotEqual */'a'
/*%end*/
/*%if criteria.nameIsNull  */
  NAME IS NULL
/*%end*/
/*%if criteria.nameIsNotNull  */
  NAME IS NOT NULL
/*%end*/
/*%if criteria.nameLike != null  */
  NAME LIKE /* @infix(criteria.nameLike) */'smith'
/*%end*/
/*%if criteria.familyNameKanaEqual != null */
  FAMILY_NAME_KANA = /* criteria.familyNameKanaEqual */'a'
/*%end*/
/*%if criteria.familyNameKanaNotEqual != null */
  FAMILY_NAME_KANA != /* criteria.familyNameKanaNotEqual */'a'
/*%end*/
/*%if criteria.familyNameKanaIsNull  */
  FAMILY_NAME_KANA IS NULL
/*%end*/
/*%if criteria.familyNameKanaIsNotNull  */
  FAMILY_NAME_KANA IS NOT NULL
/*%end*/
/*%if criteria.familyNameKanaLike != null  */
  FAMILY_NAME_KANA LIKE /* @infix(criteria.familyNameKanaLike) */'smith'
/*%end*/
/*%if criteria.nameKanaEqual != null */
  NAME_KANA = /* criteria.nameKanaEqual */'a'
/*%end*/
/*%if criteria.nameKanaNotEqual != null */
  NAME_KANA != /* criteria.nameKanaNotEqual */'a'
/*%end*/
/*%if criteria.nameKanaIsNull  */
  NAME_KANA IS NULL
/*%end*/
/*%if criteria.nameKanaIsNotNull  */
  NAME_KANA IS NOT NULL
/*%end*/
/*%if criteria.nameKanaLike != null  */
  NAME_KANA LIKE /* @infix(criteria.nameKanaLike) */'smith'
/*%end*/
/*%if criteria.zipEqual != null */
  ZIP = /* criteria.zipEqual */'a'
/*%end*/
/*%if criteria.zipNotEqual != null */
  ZIP != /* criteria.zipNotEqual */'a'
/*%end*/
/*%if criteria.zipIsNull  */
  ZIP IS NULL
/*%end*/
/*%if criteria.zipIsNotNull  */
  ZIP IS NOT NULL
/*%end*/
/*%if criteria.zipLike != null  */
  ZIP LIKE /* @infix(criteria.zipLike) */'smith'
/*%end*/
/*%if criteria.prefectureIdEqual != null */
  PREFECTURE_ID = /* criteria.prefectureIdEqual */1
/*%end*/
/*%if criteria.prefectureIdNotEqual != null */
  PREFECTURE_ID != /* criteria.prefectureIdNotEqual */1
/*%end*/
/*%if criteria.prefectureIdIsNull  */
  PREFECTURE_ID IS NULL
/*%end*/
/*%if criteria.prefectureIdIsNotNull  */
  PREFECTURE_ID IS NOT NULL
/*%end*/
/*%if criteria.prefectureIdIn != null  */
  PREFECTURE_ID IN /* criteria.prefectureIdIn */(1,2,3)
/*%end*/
/*%if criteria.prefectureIdNotIn != null  */
  PREFECTURE_ID NOT IN /* criteria.prefectureIdNotIn */(1,2,3)
/*%end*/
/*%if criteria.areaEqual != null */
  AREA = /* criteria.areaEqual */'a'
/*%end*/
/*%if criteria.areaNotEqual != null */
  AREA != /* criteria.areaNotEqual */'a'
/*%end*/
/*%if criteria.areaIsNull  */
  AREA IS NULL
/*%end*/
/*%if criteria.areaIsNotNull  */
  AREA IS NOT NULL
/*%end*/
/*%if criteria.areaLike != null  */
  AREA LIKE /* @infix(criteria.areaLike) */'smith'
/*%end*/
/*%if criteria.addressEqual != null */
  ADDRESS = /* criteria.addressEqual */'a'
/*%end*/
/*%if criteria.addressNotEqual != null */
  ADDRESS != /* criteria.addressNotEqual */'a'
/*%end*/
/*%if criteria.addressIsNull  */
  ADDRESS IS NULL
/*%end*/
/*%if criteria.addressIsNotNull  */
  ADDRESS IS NOT NULL
/*%end*/
/*%if criteria.addressLike != null  */
  ADDRESS LIKE /* @infix(criteria.addressLike) */'smith'
/*%end*/
/*%if criteria.buildingEqual != null */
  BUILDING = /* criteria.buildingEqual */'a'
/*%end*/
/*%if criteria.buildingNotEqual != null */
  BUILDING != /* criteria.buildingNotEqual */'a'
/*%end*/
/*%if criteria.buildingIsNull  */
  BUILDING IS NULL
/*%end*/
/*%if criteria.buildingIsNotNull  */
  BUILDING IS NOT NULL
/*%end*/
/*%if criteria.buildingLike != null  */
  BUILDING LIKE /* @infix(criteria.buildingLike) */'smith'
/*%end*/
/*%if criteria.telEqual != null */
  TEL = /* criteria.telEqual */'a'
/*%end*/
/*%if criteria.telNotEqual != null */
  TEL != /* criteria.telNotEqual */'a'
/*%end*/
/*%if criteria.telIsNull  */
  TEL IS NULL
/*%end*/
/*%if criteria.telIsNotNull  */
  TEL IS NOT NULL
/*%end*/
/*%if criteria.telLike != null  */
  TEL LIKE /* @infix(criteria.telLike) */'smith'
/*%end*/
/*%if criteria.sexEqual != null */
  SEX = /* criteria.sexEqual */1
/*%end*/
/*%if criteria.sexNotEqual != null */
  SEX != /* criteria.sexNotEqual */1
/*%end*/
/*%if criteria.sexIsNull  */
  SEX IS NULL
/*%end*/
/*%if criteria.sexIsNotNull  */
  SEX IS NOT NULL
/*%end*/
/*%if criteria.sexIn != null  */
  SEX IN /* criteria.sexIn */(1,2,3)
/*%end*/
/*%if criteria.sexNotIn != null  */
  SEX NOT IN /* criteria.sexNotIn */(1,2,3)
/*%end*/
/*%if criteria.birthdayEqual != null */
  BIRTHDAY = /* criteria.birthdayEqual */'2010-01-23'
/*%end*/
/*%if criteria.birthdayNotEqual != null */
  BIRTHDAY != /* criteria.birthdayNotEqual */'2010-01-23'
/*%end*/
/*%if criteria.birthdayIsNull  */
  BIRTHDAY IS NULL
/*%end*/
/*%if criteria.birthdayIsNotNull  */
  BIRTHDAY IS NOT NULL
/*%end*/
/*%if criteria.lastLoginTimeEqual != null */
  LAST_LOGIN_TIME = /* criteria.lastLoginTimeEqual */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.lastLoginTimeNotEqual != null */
  LAST_LOGIN_TIME != /* criteria.lastLoginTimeNotEqual */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.lastLoginTimeIsNull  */
  LAST_LOGIN_TIME IS NULL
/*%end*/
/*%if criteria.lastLoginTimeIsNotNull  */
  LAST_LOGIN_TIME IS NOT NULL
/*%end*/
/*%if criteria.statusEqual != null */
  STATUS = /* criteria.statusEqual */1
/*%end*/
/*%if criteria.statusNotEqual != null */
  STATUS != /* criteria.statusNotEqual */1
/*%end*/
/*%if criteria.statusIsNull  */
  STATUS IS NULL
/*%end*/
/*%if criteria.statusIsNotNull  */
  STATUS IS NOT NULL
/*%end*/
/*%if criteria.statusIn != null  */
  STATUS IN /* criteria.statusIn */(1,2,3)
/*%end*/
/*%if criteria.statusNotIn != null  */
  STATUS NOT IN /* criteria.statusNotIn */(1,2,3)
/*%end*/
/*%if criteria.registTimeEqual != null */
  REGIST_TIME = /* criteria.registTimeEqual */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.registTimeNotEqual != null */
  REGIST_TIME != /* criteria.registTimeNotEqual */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.registTimeIsNull  */
  REGIST_TIME IS NULL
/*%end*/
/*%if criteria.registTimeIsNotNull  */
  REGIST_TIME IS NOT NULL
/*%end*/
/*%if criteria.updateTimeEqual != null */
  UPDATE_TIME = /* criteria.updateTimeEqual */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updateTimeNotEqual != null */
  UPDATE_TIME != /* criteria.updateTimeNotEqual */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updateTimeIsNull  */
  UPDATE_TIME IS NULL
/*%end*/
/*%if criteria.updateTimeIsNotNull  */
  UPDATE_TIME IS NOT NULL
/*%end*/
/*%if criteria.deleteFlgTrue  */
  DELETE_FLG = true
/*%end*/
/*%if criteria.deleteFlgFalse  */
  DELETE_FLG = false
/*%end*/
