SELECT
  /*%expand*/*
FROM
  t_post
WHERE
/*%if criteria.postIdEqual != null */
  POST_ID = /* criteria.postIdEqual */1
/*%end*/
/*%if criteria.postIdNotEqual != null */
  POST_ID != /* criteria.postIdNotEqual */1
/*%end*/
/*%if criteria.postIdIsNull  */
  POST_ID IS NULL
/*%end*/
/*%if criteria.postIdIsNotNull  */
  POST_ID IS NOT NULL
/*%end*/
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
/*%if criteria.titleEqual != null */
  TITLE = /* criteria.titleEqual */'a'
/*%end*/
/*%if criteria.titleNotEqual != null */
  TITLE != /* criteria.titleNotEqual */'a'
/*%end*/
/*%if criteria.titleIsNull  */
  TITLE IS NULL
/*%end*/
/*%if criteria.titleIsNotNull  */
  TITLE IS NOT NULL
/*%end*/
/*%if criteria.textEqual != null */
  TEXT = /* criteria.textEqual */'a'
/*%end*/
/*%if criteria.textNotEqual != null */
  TEXT != /* criteria.textNotEqual */'a'
/*%end*/
/*%if criteria.textIsNull  */
  TEXT IS NULL
/*%end*/
/*%if criteria.textIsNotNull  */
  TEXT IS NOT NULL
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
/*%if criteria.versionEqual != null */
  VERSION = /* criteria.versionEqual */1
/*%end*/
/*%if criteria.versionNotEqual != null */
  VERSION != /* criteria.versionNotEqual */1
/*%end*/
/*%if criteria.versionIsNull  */
  VERSION IS NULL
/*%end*/
/*%if criteria.versionIsNotNull  */
  VERSION IS NOT NULL
/*%end*/

