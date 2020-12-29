--  自動生成のため原則修正禁止!!
SELECT
  /*%expand*/*
FROM
  m_post_tag
WHERE
/*%if criteria.postTagIdEq != null */
  and POST_TAG_ID = /* criteria.postTagIdEq */1
/*%end*/
/*%if criteria.postTagIdNe != null */
  and POST_TAG_ID != /* criteria.postTagIdNe */1
/*%end*/
/*%if criteria.postTagIdLt != null */
  and POST_TAG_ID < /* criteria.postTagIdLt */1
/*%end*/
/*%if criteria.postTagIdLe != null */
  and POST_TAG_ID <= /* criteria.postTagIdLe */1
/*%end*/
/*%if criteria.postTagIdGt != null */
  and POST_TAG_ID > /* criteria.postTagIdGt */1
/*%end*/
/*%if criteria.postTagIdGe != null */
  and POST_TAG_ID >= /* criteria.postTagIdGe */1
/*%end*/
/*%if criteria.postTagIdIsNull  */
  and POST_TAG_ID IS NULL
/*%end*/
/*%if criteria.postTagIdIsNotNull  */
  and POST_TAG_ID IS NOT NULL
/*%end*/
/*%if criteria.postTagIdIn != null  */
  and POST_TAG_ID IN /* criteria.postTagIdIn */(1,2,3)
/*%end*/
/*%if criteria.postTagIdNotIn != null  */
  and POST_TAG_ID NOT IN /* criteria.postTagIdNotIn */(1,2,3)
/*%end*/
/*%if criteria.nameEq != null */
  and NAME = /* criteria.nameEq */'a'
/*%end*/
/*%if criteria.nameNe != null */
  and NAME != /* criteria.nameNe */'a'
/*%end*/
/*%if criteria.nameLt != null */
  and NAME < /* criteria.nameLt */'a'
/*%end*/
/*%if criteria.nameLe != null */
  and NAME <= /* criteria.nameLe */'a'
/*%end*/
/*%if criteria.nameGt != null */
  and NAME > /* criteria.nameGt */'a'
/*%end*/
/*%if criteria.nameGe != null */
  and NAME >= /* criteria.nameGe */'a'
/*%end*/
/*%if criteria.nameIsNull  */
  and NAME IS NULL
/*%end*/
/*%if criteria.nameIsNotNull  */
  and NAME IS NOT NULL
/*%end*/
/*%if criteria.nameLike != null  */
  and NAME LIKE /* @infix(criteria.nameLike) */'smith'
/*%end*/
/*%if criteria.nameNotLike != null  */
  and NAME NOT LIKE /* @infix(criteria.nameNotLike) */'smith'
/*%end*/
/*%if criteria.nameStarts != null  */
  and NAME LIKE /* @prefix(criteria.nameStarts) */'smith'
/*%end*/
/*%if criteria.nameNotStarts != null  */
  and NAME NOT LIKE /* @prefix(criteria.nameNotStarts) */'smith'
/*%end*/
/*%if criteria.nameEnds != null  */
  and NAME LIKE /* @suffix(criteria.nameEnds) */'smith'
/*%end*/
/*%if criteria.nameNotEnds != null  */
  and NAME NOT LIKE /* @suffix(criteria.nameNotEnds) */'smith'
/*%end*/
/*%if criteria.registTimeEq != null */
  and REGIST_TIME = /* criteria.registTimeEq */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.registTimeNe != null */
  and REGIST_TIME != /* criteria.registTimeNe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.registTimeLt != null */
  and REGIST_TIME < /* criteria.registTimeLt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.registTimeLe != null */
  and REGIST_TIME <= /* criteria.registTimeLe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.registTimeGt != null */
  and REGIST_TIME > /* criteria.registTimeGt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.registTimeGe != null */
  and REGIST_TIME >= /* criteria.registTimeGe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.registTimeIsNull  */
  and REGIST_TIME IS NULL
/*%end*/
/*%if criteria.registTimeIsNotNull  */
  and REGIST_TIME IS NOT NULL
/*%end*/
/*%if criteria.updateTimeEq != null */
  and UPDATE_TIME = /* criteria.updateTimeEq */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updateTimeNe != null */
  and UPDATE_TIME != /* criteria.updateTimeNe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updateTimeLt != null */
  and UPDATE_TIME < /* criteria.updateTimeLt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updateTimeLe != null */
  and UPDATE_TIME <= /* criteria.updateTimeLe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updateTimeGt != null */
  and UPDATE_TIME > /* criteria.updateTimeGt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updateTimeGe != null */
  and UPDATE_TIME >= /* criteria.updateTimeGe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updateTimeIsNull  */
  and UPDATE_TIME IS NULL
/*%end*/
/*%if criteria.updateTimeIsNotNull  */
  and UPDATE_TIME IS NOT NULL
/*%end*/
/*%if criteria.deleteFlgTrue  */
  and DELETE_FLG = true
/*%end*/
/*%if criteria.deleteFlgFalse  */
  and DELETE_FLG = false
/*%end*/
