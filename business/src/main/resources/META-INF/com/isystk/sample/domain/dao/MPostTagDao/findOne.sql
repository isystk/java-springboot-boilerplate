SELECT
  /*%expand*/*
FROM
  m_post_tag
WHERE
/*%if criteria.postTagIdEqual != null */
  POST_TAG_ID = /* criteria.postTagIdEqual */1
/*%end*/
/*%if criteria.postTagIdNotEqual != null */
  POST_TAG_ID != /* criteria.postTagIdNotEqual */1
/*%end*/
/*%if criteria.postTagIdIsNull  */
  POST_TAG_ID IS NULL
/*%end*/
/*%if criteria.postTagIdIsNotNull  */
  POST_TAG_ID IS NOT NULL
/*%end*/
/*%if criteria.postTagIdIn != null  */
  POST_TAG_ID IN /* criteria.postTagIdIn */(1,2,3)
/*%end*/
/*%if criteria.postTagIdNotIn != null  */
  POST_TAG_ID NOT IN /* criteria.postTagIdNotIn */(1,2,3)
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

