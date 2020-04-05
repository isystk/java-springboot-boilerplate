--  自動生成のため原則修正禁止!!
SELECT
  /*%expand*/*
FROM
  t_image
WHERE
/*%if criteria.imageIdEq != null */
  and IMAGE_ID = /* criteria.imageIdEq */1
/*%end*/
/*%if criteria.imageIdNe != null */
  and IMAGE_ID != /* criteria.imageIdNe */1
/*%end*/
/*%if criteria.imageIdLt != null */
  and IMAGE_ID < /* criteria.imageIdLt */1
/*%end*/
/*%if criteria.imageIdLe != null */
  and IMAGE_ID <= /* criteria.imageIdLe */1
/*%end*/
/*%if criteria.imageIdGt != null */
  and IMAGE_ID > /* criteria.imageIdGt */1
/*%end*/
/*%if criteria.imageIdGe != null */
  and IMAGE_ID >= /* criteria.imageIdGe */1
/*%end*/
/*%if criteria.imageIdIsNull  */
  and IMAGE_ID IS NULL
/*%end*/
/*%if criteria.imageIdIsNotNull  */
  and IMAGE_ID IS NOT NULL
/*%end*/
/*%if criteria.imageIdIn != null  */
  and IMAGE_ID IN /* criteria.imageIdIn */(1,2,3)
/*%end*/
/*%if criteria.imageIdNotIn != null  */
  and IMAGE_ID NOT IN /* criteria.imageIdNotIn */(1,2,3)
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
/*# criteria.orderBy */
