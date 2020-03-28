SELECT
  /*%expand*/*
FROM
  m_mail_template
WHERE
/*%if criteria.mailTemplateId != null */
  MAIL_TEMPLATE_ID = /* criteria.mailTemplateId */1
/*%end*/
/*%if criteria.templateDiv != null */
  TEMPLATE_DIV = /* criteria.templateDiv */1
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

