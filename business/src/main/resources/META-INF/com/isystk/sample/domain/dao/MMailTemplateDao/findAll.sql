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
/*%if criteria.mailTemplateIdIn != null  */
  MAIL_TEMPLATE_ID IN /* criteria.mailTemplateIdIn */(1,2,3)
/*%end*/
/*%if criteria.mailTemplateIdNotIn != null  */
  MAIL_TEMPLATE_ID NOT IN /* criteria.mailTemplateIdNotIn */(1,2,3)
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
/*%if criteria.templateDivIn != null  */
  TEMPLATE_DIV IN /* criteria.templateDivIn */(1,2,3)
/*%end*/
/*%if criteria.templateDivNotIn != null  */
  TEMPLATE_DIV NOT IN /* criteria.templateDivNotIn */(1,2,3)
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
/*%if criteria.titleLike != null  */
  TITLE LIKE /* @infix(criteria.titleLike) */'smith'
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
/*%if criteria.textLike != null  */
  TEXT LIKE /* @infix(criteria.textLike) */'smith'
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
