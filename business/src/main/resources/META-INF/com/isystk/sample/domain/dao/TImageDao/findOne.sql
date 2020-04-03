SELECT
  /*%expand*/*
FROM
  t_image
WHERE
/*%if criteria.imageIdEqual != null */
  IMAGE_ID = /* criteria.imageIdEqual */1
/*%end*/
/*%if criteria.imageIdNotEqual != null */
  IMAGE_ID != /* criteria.imageIdNotEqual */1
/*%end*/
/*%if criteria.imageIdIsNull  */
  IMAGE_ID IS NULL
/*%end*/
/*%if criteria.imageIdIsNotNull  */
  IMAGE_ID IS NOT NULL
/*%end*/
/*%if criteria.imageIdIn != null  */
  IMAGE_ID IN /* criteria.imageIdIn */(1,2,3)
/*%end*/
/*%if criteria.imageIdNotIn != null  */
  IMAGE_ID NOT IN /* criteria.imageIdNotIn */(1,2,3)
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
