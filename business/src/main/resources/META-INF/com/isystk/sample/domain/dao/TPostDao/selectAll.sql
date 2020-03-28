SELECT
  /*%expand*/*
FROM
  t_post
WHERE
/*%if criteria.postId != null */
  POST_ID = /* criteria.postId */1
/*%end*/
/*%if criteria.userId != null */
  USER_ID = /* criteria.userId */1
/*%end*/
/*%if criteria.title != null */
  TITLE = /* criteria.title */'a'
/*%end*/
/*%if criteria.text != null */
  TEXT = /* criteria.text */'a'
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
