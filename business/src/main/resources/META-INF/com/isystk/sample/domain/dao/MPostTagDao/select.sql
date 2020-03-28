SELECT
  /*%expand*/*
FROM
  m_post_tag
WHERE
/*%if criteria.postTagId != null */
  POST_TAG_ID = /* criteria.postTagId */1
/*%end*/
/*%if criteria.name != null */
  NAME = /* criteria.name */'a'
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

