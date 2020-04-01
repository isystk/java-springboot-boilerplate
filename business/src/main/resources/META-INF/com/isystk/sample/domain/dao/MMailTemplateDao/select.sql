SELECT
  /*%expand*/*
FROM
  m_mail_template
WHERE
/*%if criteria.mailTemplateIdEqual != null */
  MAIL_TEMPLATE_ID = /* criteria.mailTemplateIdEqual */1
/*%end*/
/*%if criteria.mailTemplateIdNotEqual != null */
  MAIL_TEMPLATE_ID != /* criteria.mailTemplateIdNotEqual */1
/*%end*/
/*%if criteria.mailTemplateIdIsNull  */
  MAIL_TEMPLATE_ID IS NULL
/*%end*/
/*%if criteria.mailTemplateIdIsNotNull  */
  MAIL_TEMPLATE_ID IS NOT NULL
/*%end*/
/*%if criteria.templateDivEqual != null */
  TEMPLATE_DIV = /* criteria.templateDivEqual */1
/*%end*/
/*%if criteria.templateDivNotEqual != null */
  TEMPLATE_DIV != /* criteria.templateDivNotEqual */1
/*%end*/
/*%if criteria.templateDivIsNull  */
  TEMPLATE_DIV IS NULL
/*%end*/
/*%if criteria.templateDivIsNotNull  */
  TEMPLATE_DIV IS NOT NULL
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

