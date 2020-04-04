--  自動生成のため原則修正禁止!!
SELECT
  /*%expand*/*
FROM
  m_mail_template
WHERE
/*%if criteria.mailTemplateIdEq != null */
  MAIL_TEMPLATE_ID = /* criteria.mailTemplateIdEq */1
/*%end*/
/*%if criteria.mailTemplateIdNe != null */
  MAIL_TEMPLATE_ID != /* criteria.mailTemplateIdNe */1
/*%end*/
/*%if criteria.mailTemplateIdLt != null */
  MAIL_TEMPLATE_ID < /* criteria.mailTemplateIdLt */1
/*%end*/
/*%if criteria.mailTemplateIdLe != null */
  MAIL_TEMPLATE_ID <= /* criteria.mailTemplateIdLe */1
/*%end*/
/*%if criteria.mailTemplateIdGt != null */
  MAIL_TEMPLATE_ID > /* criteria.mailTemplateIdLt */1
/*%end*/
/*%if criteria.mailTemplateIdGe != null */
  MAIL_TEMPLATE_ID >= /* criteria.mailTemplateIdLe */1
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
/*%if criteria.templateDivEq != null */
  TEMPLATE_DIV = /* criteria.templateDivEq */1
/*%end*/
/*%if criteria.templateDivNe != null */
  TEMPLATE_DIV != /* criteria.templateDivNe */1
/*%end*/
/*%if criteria.templateDivLt != null */
  TEMPLATE_DIV < /* criteria.templateDivLt */1
/*%end*/
/*%if criteria.templateDivLe != null */
  TEMPLATE_DIV <= /* criteria.templateDivLe */1
/*%end*/
/*%if criteria.templateDivGt != null */
  TEMPLATE_DIV > /* criteria.templateDivLt */1
/*%end*/
/*%if criteria.templateDivGe != null */
  TEMPLATE_DIV >= /* criteria.templateDivLe */1
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
/*%if criteria.titleEq != null */
  TITLE = /* criteria.titleEq */'a'
/*%end*/
/*%if criteria.titleNe != null */
  TITLE != /* criteria.titleNe */'a'
/*%end*/
/*%if criteria.titleLt != null */
  TITLE < /* criteria.titleLt */'a'
/*%end*/
/*%if criteria.titleLe != null */
  TITLE <= /* criteria.titleLe */'a'
/*%end*/
/*%if criteria.titleGt != null */
  TITLE > /* criteria.titleLt */'a'
/*%end*/
/*%if criteria.titleGe != null */
  TITLE >= /* criteria.titleLe */'a'
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
/*%if criteria.titleNotLike != null  */
  TITLE NOT LIKE /* @infix(criteria.titleNotLike) */'smith'
/*%end*/
/*%if criteria.titleStarts != null  */
  TITLE LIKE /* @prefix(criteria.titleStarts) */'smith'
/*%end*/
/*%if criteria.titleNotStarts != null  */
  TITLE NOT LIKE /* @prefix(criteria.titleNotStarts) */'smith'
/*%end*/
/*%if criteria.titleEnds != null  */
  TITLE LIKE /* @suffix(criteria.titleEnds) */'smith'
/*%end*/
/*%if criteria.titleNotEnds != null  */
  TITLE NOT LIKE /* @suffix(criteria.titleNotEnds) */'smith'
/*%end*/
/*%if criteria.textEq != null */
  TEXT = /* criteria.textEq */'a'
/*%end*/
/*%if criteria.textNe != null */
  TEXT != /* criteria.textNe */'a'
/*%end*/
/*%if criteria.textLt != null */
  TEXT < /* criteria.textLt */'a'
/*%end*/
/*%if criteria.textLe != null */
  TEXT <= /* criteria.textLe */'a'
/*%end*/
/*%if criteria.textGt != null */
  TEXT > /* criteria.textLt */'a'
/*%end*/
/*%if criteria.textGe != null */
  TEXT >= /* criteria.textLe */'a'
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
/*%if criteria.textNotLike != null  */
  TEXT NOT LIKE /* @infix(criteria.textNotLike) */'smith'
/*%end*/
/*%if criteria.textStarts != null  */
  TEXT LIKE /* @prefix(criteria.textStarts) */'smith'
/*%end*/
/*%if criteria.textNotStarts != null  */
  TEXT NOT LIKE /* @prefix(criteria.textNotStarts) */'smith'
/*%end*/
/*%if criteria.textEnds != null  */
  TEXT LIKE /* @suffix(criteria.textEnds) */'smith'
/*%end*/
/*%if criteria.textNotEnds != null  */
  TEXT NOT LIKE /* @suffix(criteria.textNotEnds) */'smith'
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
