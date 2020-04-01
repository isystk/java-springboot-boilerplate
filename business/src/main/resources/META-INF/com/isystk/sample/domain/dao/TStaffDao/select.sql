SELECT
  /*%expand*/*
FROM
  t_staff
WHERE
/*%if criteria.staffIdEqual != null */
  STAFF_ID = /* criteria.staffIdEqual */1
/*%end*/
/*%if criteria.staffIdNotEqual != null */
  STAFF_ID != /* criteria.staffIdNotEqual */1
/*%end*/
/*%if criteria.staffIdIsNull  */
  STAFF_ID IS NULL
/*%end*/
/*%if criteria.staffIdIsNotNull  */
  STAFF_ID IS NOT NULL
/*%end*/
/*%if criteria.staffIdIn != null  */
  STAFF_ID IN /* criteria.staffIdIn */(1,2,3)
/*%end*/
/*%if criteria.staffIdNotIn != null  */
  STAFF_ID NOT IN /* criteria.staffIdNotIn */(1,2,3)
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
/*%if criteria.deleteFlgEqual != null */
  DELETE_FLG = /* criteria.deleteFlgEqual */'a'
/*%end*/
/*%if criteria.deleteFlgNotEqual != null */
  DELETE_FLG != /* criteria.deleteFlgNotEqual */'a'
/*%end*/
/*%if criteria.deleteFlgIsNull  */
  DELETE_FLG IS NULL
/*%end*/
/*%if criteria.deleteFlgIsNotNull  */
  DELETE_FLG IS NOT NULL
/*%end*/

