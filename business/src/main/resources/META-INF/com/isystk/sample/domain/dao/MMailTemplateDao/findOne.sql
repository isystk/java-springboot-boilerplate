--  自動生成のため原則修正禁止!!
SELECT
  /*%expand*/*
FROM
  m_mail_template
WHERE
/*%if criteria.mailTemplateIdEq != null */
  and MAIL_TEMPLATE_ID = /* criteria.mailTemplateIdEq */1
/*%end*/
/*%if criteria.mailTemplateIdNe != null */
  and MAIL_TEMPLATE_ID != /* criteria.mailTemplateIdNe */1
/*%end*/
/*%if criteria.mailTemplateIdLt != null */
  and MAIL_TEMPLATE_ID < /* criteria.mailTemplateIdLt */1
/*%end*/
/*%if criteria.mailTemplateIdLe != null */
  and MAIL_TEMPLATE_ID <= /* criteria.mailTemplateIdLe */1
/*%end*/
/*%if criteria.mailTemplateIdGt != null */
  and MAIL_TEMPLATE_ID > /* criteria.mailTemplateIdGt */1
/*%end*/
/*%if criteria.mailTemplateIdGe != null */
  and MAIL_TEMPLATE_ID >= /* criteria.mailTemplateIdGe */1
/*%end*/
/*%if criteria.mailTemplateIdIsNull  */
  and MAIL_TEMPLATE_ID IS NULL
/*%end*/
/*%if criteria.mailTemplateIdIsNotNull  */
  and MAIL_TEMPLATE_ID IS NOT NULL
/*%end*/
/*%if criteria.mailTemplateIdIn != null  */
  and MAIL_TEMPLATE_ID IN /* criteria.mailTemplateIdIn */(1,2,3)
/*%end*/
/*%if criteria.mailTemplateIdNotIn != null  */
  and MAIL_TEMPLATE_ID NOT IN /* criteria.mailTemplateIdNotIn */(1,2,3)
/*%end*/
/*%if criteria.templateDivEq != null */
  and TEMPLATE_DIV = /* criteria.templateDivEq */1
/*%end*/
/*%if criteria.templateDivNe != null */
  and TEMPLATE_DIV != /* criteria.templateDivNe */1
/*%end*/
/*%if criteria.templateDivLt != null */
  and TEMPLATE_DIV < /* criteria.templateDivLt */1
/*%end*/
/*%if criteria.templateDivLe != null */
  and TEMPLATE_DIV <= /* criteria.templateDivLe */1
/*%end*/
/*%if criteria.templateDivGt != null */
  and TEMPLATE_DIV > /* criteria.templateDivGt */1
/*%end*/
/*%if criteria.templateDivGe != null */
  and TEMPLATE_DIV >= /* criteria.templateDivGe */1
/*%end*/
/*%if criteria.templateDivIsNull  */
  and TEMPLATE_DIV IS NULL
/*%end*/
/*%if criteria.templateDivIsNotNull  */
  and TEMPLATE_DIV IS NOT NULL
/*%end*/
/*%if criteria.templateDivIn != null  */
  and TEMPLATE_DIV IN /* criteria.templateDivIn */(1,2,3)
/*%end*/
/*%if criteria.templateDivNotIn != null  */
  and TEMPLATE_DIV NOT IN /* criteria.templateDivNotIn */(1,2,3)
/*%end*/
/*%if criteria.titleEq != null */
  and TITLE = /* criteria.titleEq */'a'
/*%end*/
/*%if criteria.titleNe != null */
  and TITLE != /* criteria.titleNe */'a'
/*%end*/
/*%if criteria.titleLt != null */
  and TITLE < /* criteria.titleLt */'a'
/*%end*/
/*%if criteria.titleLe != null */
  and TITLE <= /* criteria.titleLe */'a'
/*%end*/
/*%if criteria.titleGt != null */
  and TITLE > /* criteria.titleGt */'a'
/*%end*/
/*%if criteria.titleGe != null */
  and TITLE >= /* criteria.titleGe */'a'
/*%end*/
/*%if criteria.titleIsNull  */
  and TITLE IS NULL
/*%end*/
/*%if criteria.titleIsNotNull  */
  and TITLE IS NOT NULL
/*%end*/
/*%if criteria.titleLike != null  */
  and TITLE LIKE /* @infix(criteria.titleLike) */'smith'
/*%end*/
/*%if criteria.titleNotLike != null  */
  and TITLE NOT LIKE /* @infix(criteria.titleNotLike) */'smith'
/*%end*/
/*%if criteria.titleStarts != null  */
  and TITLE LIKE /* @prefix(criteria.titleStarts) */'smith'
/*%end*/
/*%if criteria.titleNotStarts != null  */
  and TITLE NOT LIKE /* @prefix(criteria.titleNotStarts) */'smith'
/*%end*/
/*%if criteria.titleEnds != null  */
  and TITLE LIKE /* @suffix(criteria.titleEnds) */'smith'
/*%end*/
/*%if criteria.titleNotEnds != null  */
  and TITLE NOT LIKE /* @suffix(criteria.titleNotEnds) */'smith'
/*%end*/
/*%if criteria.textEq != null */
  and TEXT = /* criteria.textEq */'a'
/*%end*/
/*%if criteria.textNe != null */
  and TEXT != /* criteria.textNe */'a'
/*%end*/
/*%if criteria.textLt != null */
  and TEXT < /* criteria.textLt */'a'
/*%end*/
/*%if criteria.textLe != null */
  and TEXT <= /* criteria.textLe */'a'
/*%end*/
/*%if criteria.textGt != null */
  and TEXT > /* criteria.textGt */'a'
/*%end*/
/*%if criteria.textGe != null */
  and TEXT >= /* criteria.textGe */'a'
/*%end*/
/*%if criteria.textIsNull  */
  and TEXT IS NULL
/*%end*/
/*%if criteria.textIsNotNull  */
  and TEXT IS NOT NULL
/*%end*/
/*%if criteria.textLike != null  */
  and TEXT LIKE /* @infix(criteria.textLike) */'smith'
/*%end*/
/*%if criteria.textNotLike != null  */
  and TEXT NOT LIKE /* @infix(criteria.textNotLike) */'smith'
/*%end*/
/*%if criteria.textStarts != null  */
  and TEXT LIKE /* @prefix(criteria.textStarts) */'smith'
/*%end*/
/*%if criteria.textNotStarts != null  */
  and TEXT NOT LIKE /* @prefix(criteria.textNotStarts) */'smith'
/*%end*/
/*%if criteria.textEnds != null  */
  and TEXT LIKE /* @suffix(criteria.textEnds) */'smith'
/*%end*/
/*%if criteria.textNotEnds != null  */
  and TEXT NOT LIKE /* @suffix(criteria.textNotEnds) */'smith'
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
