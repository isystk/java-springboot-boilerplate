SELECT
  /*%expand*/*
FROM
  t_image
WHERE
/*%if criteria.imageId != null */
  IMAGE_ID = /* criteria.imageId */1
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
