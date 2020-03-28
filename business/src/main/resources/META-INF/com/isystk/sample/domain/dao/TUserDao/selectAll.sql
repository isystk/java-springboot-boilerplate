SELECT
  /*%expand*/*
FROM
  t_user
WHERE
/*%if criteria.userId != null */
  USER_ID = /* criteria.userId */1
/*%end*/
/*%if criteria.email != null */
  EMAIL = /* criteria.email */'a'
/*%end*/
/*%if criteria.password != null */
  PASSWORD = /* criteria.password */'a'
/*%end*/
/*%if criteria.familyName != null */
  FAMILY_NAME = /* criteria.familyName */'a'
/*%end*/
/*%if criteria.name != null */
  NAME = /* criteria.name */'a'
/*%end*/
/*%if criteria.familyNameKana != null */
  FAMILY_NAME_KANA = /* criteria.familyNameKana */'a'
/*%end*/
/*%if criteria.nameKana != null */
  NAME_KANA = /* criteria.nameKana */'a'
/*%end*/
/*%if criteria.zip != null */
  ZIP = /* criteria.zip */'a'
/*%end*/
/*%if criteria.prefectureId != null */
  PREFECTURE_ID = /* criteria.prefectureId */1
/*%end*/
/*%if criteria.area != null */
  AREA = /* criteria.area */'a'
/*%end*/
/*%if criteria.address != null */
  ADDRESS = /* criteria.address */'a'
/*%end*/
/*%if criteria.building != null */
  BUILDING = /* criteria.building */'a'
/*%end*/
/*%if criteria.tel != null */
  TEL = /* criteria.tel */'a'
/*%end*/
/*%if criteria.sex != null */
  SEX = /* criteria.sex */1
/*%end*/
/*%if criteria.birthday != null */
  BIRTHDAY = /* criteria.birthday */'2010-01-23'
/*%end*/
/*%if criteria.lastLoginTime != null */
  LAST_LOGIN_TIME = /* criteria.lastLoginTime */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.status != null */
  STATUS = /* criteria.status */1
/*%end*/
/*%if criteria.registTime != null */
  REGIST_TIME = /* criteria.registTime */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updateTime != null */
  UPDATE_TIME = /* criteria.updateTime */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.deleteFlg != null */
  DELETE_FLG = /* criteria.deleteFlg */'a'
/*%end*/
/*%if criteria.version != null */
  VERSION = /* criteria.version */1
/*%end*/
