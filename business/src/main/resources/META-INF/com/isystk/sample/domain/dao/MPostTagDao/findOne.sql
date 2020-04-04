--  自動生成のため原則修正禁止!!
SELECT
  /*%expand*/*
FROM
  m_post_tag
WHERE
/*%if criteria.postTagIdEq != null */
  POST_TAG_ID = /* criteria.postTagIdEq */1
/*%end*/
/*%if criteria.postTagIdNe != null */
  POST_TAG_ID != /* criteria.postTagIdNe */1
/*%end*/
/*%if criteria.postTagIdLt != null */
  POST_TAG_ID < /* criteria.postTagIdLt */1
/*%end*/
/*%if criteria.postTagIdLe != null */
  POST_TAG_ID <= /* criteria.postTagIdLe */1
/*%end*/
/*%if criteria.postTagIdGt != null */
  POST_TAG_ID > /* criteria.postTagIdLt */1
/*%end*/
/*%if criteria.postTagIdGe != null */
  POST_TAG_ID >= /* criteria.postTagIdLe */1
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
/*%if criteria.nameEq != null */
  NAME = /* criteria.nameEq */'a'
/*%end*/
/*%if criteria.nameNe != null */
  NAME != /* criteria.nameNe */'a'
/*%end*/
/*%if criteria.nameLt != null */
  NAME < /* criteria.nameLt */'a'
/*%end*/
/*%if criteria.nameLe != null */
  NAME <= /* criteria.nameLe */'a'
/*%end*/
/*%if criteria.nameGt != null */
  NAME > /* criteria.nameLt */'a'
/*%end*/
/*%if criteria.nameGe != null */
  NAME >= /* criteria.nameLe */'a'
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
/*%if criteria.nameNotLike != null  */
  NAME NOT LIKE /* @infix(criteria.nameNotLike) */'smith'
/*%end*/
/*%if criteria.nameStarts != null  */
  NAME LIKE /* @prefix(criteria.nameStarts) */'smith'
/*%end*/
/*%if criteria.nameNotStarts != null  */
  NAME NOT LIKE /* @prefix(criteria.nameNotStarts) */'smith'
/*%end*/
/*%if criteria.nameEnds != null  */
  NAME LIKE /* @suffix(criteria.nameEnds) */'smith'
/*%end*/
/*%if criteria.nameNotEnds != null  */
  NAME NOT LIKE /* @suffix(criteria.nameNotEnds) */'smith'
/*%end*/
/*%if criteria.registTimeEq != null */
  REGIST_TIME = /* criteria.registTimeEq */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.registTimeNe != null */
  REGIST_TIME != /* criteria.registTimeNe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.registTimeLt != null */
  REGIST_TIME < /* criteria.registTimeLt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.registTimeLe != null */
  REGIST_TIME <= /* criteria.registTimeLe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.registTimeGt != null */
  REGIST_TIME > /* criteria.registTimeLt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.registTimeGe != null */
  REGIST_TIME >= /* criteria.registTimeLe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.registTimeIsNull  */
  REGIST_TIME IS NULL
/*%end*/
/*%if criteria.registTimeIsNotNull  */
  REGIST_TIME IS NOT NULL
/*%end*/
/*%if criteria.updateTimeEq != null */
  UPDATE_TIME = /* criteria.updateTimeEq */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updateTimeNe != null */
  UPDATE_TIME != /* criteria.updateTimeNe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updateTimeLt != null */
  UPDATE_TIME < /* criteria.updateTimeLt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updateTimeLe != null */
  UPDATE_TIME <= /* criteria.updateTimeLe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updateTimeGt != null */
  UPDATE_TIME > /* criteria.updateTimeLt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updateTimeGe != null */
  UPDATE_TIME >= /* criteria.updateTimeLe */'2010-01-23 12:34:56'
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
