--  自動生成のため原則修正禁止!!
SELECT
  /*%expand*/*
FROM
  mail_template
WHERE
/*%if criteria.mailTemplateIdEq != null */
  and mail_template_id = /* criteria.mailTemplateIdEq */1
/*%end*/
/*%if criteria.mailTemplateIdNe != null */
  and mail_template_id != /* criteria.mailTemplateIdNe */1
/*%end*/
/*%if criteria.mailTemplateIdLt != null */
  and mail_template_id < /* criteria.mailTemplateIdLt */1
/*%end*/
/*%if criteria.mailTemplateIdLe != null */
  and mail_template_id <= /* criteria.mailTemplateIdLe */1
/*%end*/
/*%if criteria.mailTemplateIdGt != null */
  and mail_template_id > /* criteria.mailTemplateIdGt */1
/*%end*/
/*%if criteria.mailTemplateIdGe != null */
  and mail_template_id >= /* criteria.mailTemplateIdGe */1
/*%end*/
/*%if criteria.mailTemplateIdIsNull  */
  and mail_template_id IS NULL
/*%end*/
/*%if criteria.mailTemplateIdIsNotNull  */
  and mail_template_id IS NOT NULL
/*%end*/
/*%if criteria.mailTemplateIdIn != null  */
  and mail_template_id IN /* criteria.mailTemplateIdIn */(1,2,3)
/*%end*/
/*%if criteria.mailTemplateIdNotIn != null  */
  and mail_template_id NOT IN /* criteria.mailTemplateIdNotIn */(1,2,3)
/*%end*/
/*%if criteria.mailTemplateDivEq != null */
  and mail_template_div = /* criteria.mailTemplateDivEq */1
/*%end*/
/*%if criteria.mailTemplateDivNe != null */
  and mail_template_div != /* criteria.mailTemplateDivNe */1
/*%end*/
/*%if criteria.mailTemplateDivLt != null */
  and mail_template_div < /* criteria.mailTemplateDivLt */1
/*%end*/
/*%if criteria.mailTemplateDivLe != null */
  and mail_template_div <= /* criteria.mailTemplateDivLe */1
/*%end*/
/*%if criteria.mailTemplateDivGt != null */
  and mail_template_div > /* criteria.mailTemplateDivGt */1
/*%end*/
/*%if criteria.mailTemplateDivGe != null */
  and mail_template_div >= /* criteria.mailTemplateDivGe */1
/*%end*/
/*%if criteria.mailTemplateDivIsNull  */
  and mail_template_div IS NULL
/*%end*/
/*%if criteria.mailTemplateDivIsNotNull  */
  and mail_template_div IS NOT NULL
/*%end*/
/*%if criteria.mailTemplateDivIn != null  */
  and mail_template_div IN /* criteria.mailTemplateDivIn */(1,2,3)
/*%end*/
/*%if criteria.mailTemplateDivNotIn != null  */
  and mail_template_div NOT IN /* criteria.mailTemplateDivNotIn */(1,2,3)
/*%end*/
/*%if criteria.titleEq != null */
  and title = /* criteria.titleEq */'a'
/*%end*/
/*%if criteria.titleNe != null */
  and title != /* criteria.titleNe */'a'
/*%end*/
/*%if criteria.titleLt != null */
  and title < /* criteria.titleLt */'a'
/*%end*/
/*%if criteria.titleLe != null */
  and title <= /* criteria.titleLe */'a'
/*%end*/
/*%if criteria.titleGt != null */
  and title > /* criteria.titleGt */'a'
/*%end*/
/*%if criteria.titleGe != null */
  and title >= /* criteria.titleGe */'a'
/*%end*/
/*%if criteria.titleIsNull  */
  and title IS NULL
/*%end*/
/*%if criteria.titleIsNotNull  */
  and title IS NOT NULL
/*%end*/
/*%if criteria.titleIn != null  */
  and title IN /* criteria.titleIn */(1,2,3)
/*%end*/
/*%if criteria.titleNotIn != null  */
  and title NOT IN /* criteria.titleNotIn */(1,2,3)
/*%end*/
/*%if criteria.titleLike != null  */
  and title LIKE /* @infix(criteria.titleLike) */'smith'
/*%end*/
/*%if criteria.titleNotLike != null  */
  and title NOT LIKE /* @infix(criteria.titleNotLike) */'smith'
/*%end*/
/*%if criteria.titleStarts != null  */
  and title LIKE /* @prefix(criteria.titleStarts) */'smith'
/*%end*/
/*%if criteria.titleNotStarts != null  */
  and title NOT LIKE /* @prefix(criteria.titleNotStarts) */'smith'
/*%end*/
/*%if criteria.titleEnds != null  */
  and title LIKE /* @suffix(criteria.titleEnds) */'smith'
/*%end*/
/*%if criteria.titleNotEnds != null  */
  and title NOT LIKE /* @suffix(criteria.titleNotEnds) */'smith'
/*%end*/
/*%if criteria.textEq != null */
  and text = /* criteria.textEq */'a'
/*%end*/
/*%if criteria.textNe != null */
  and text != /* criteria.textNe */'a'
/*%end*/
/*%if criteria.textLt != null */
  and text < /* criteria.textLt */'a'
/*%end*/
/*%if criteria.textLe != null */
  and text <= /* criteria.textLe */'a'
/*%end*/
/*%if criteria.textGt != null */
  and text > /* criteria.textGt */'a'
/*%end*/
/*%if criteria.textGe != null */
  and text >= /* criteria.textGe */'a'
/*%end*/
/*%if criteria.textIsNull  */
  and text IS NULL
/*%end*/
/*%if criteria.textIsNotNull  */
  and text IS NOT NULL
/*%end*/
/*%if criteria.textIn != null  */
  and text IN /* criteria.textIn */(1,2,3)
/*%end*/
/*%if criteria.textNotIn != null  */
  and text NOT IN /* criteria.textNotIn */(1,2,3)
/*%end*/
/*%if criteria.textLike != null  */
  and text LIKE /* @infix(criteria.textLike) */'smith'
/*%end*/
/*%if criteria.textNotLike != null  */
  and text NOT LIKE /* @infix(criteria.textNotLike) */'smith'
/*%end*/
/*%if criteria.textStarts != null  */
  and text LIKE /* @prefix(criteria.textStarts) */'smith'
/*%end*/
/*%if criteria.textNotStarts != null  */
  and text NOT LIKE /* @prefix(criteria.textNotStarts) */'smith'
/*%end*/
/*%if criteria.textEnds != null  */
  and text LIKE /* @suffix(criteria.textEnds) */'smith'
/*%end*/
/*%if criteria.textNotEnds != null  */
  and text NOT LIKE /* @suffix(criteria.textNotEnds) */'smith'
/*%end*/
/*%if criteria.createdAtEq != null */
  and created_at = /* criteria.createdAtEq */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.createdAtNe != null */
  and created_at != /* criteria.createdAtNe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.createdAtLt != null */
  and created_at < /* criteria.createdAtLt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.createdAtLe != null */
  and created_at <= /* criteria.createdAtLe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.createdAtGt != null */
  and created_at > /* criteria.createdAtGt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.createdAtGe != null */
  and created_at >= /* criteria.createdAtGe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.createdAtIsNull  */
  and created_at IS NULL
/*%end*/
/*%if criteria.createdAtIsNotNull  */
  and created_at IS NOT NULL
/*%end*/
/*%if criteria.updatedAtEq != null */
  and updated_at = /* criteria.updatedAtEq */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updatedAtNe != null */
  and updated_at != /* criteria.updatedAtNe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updatedAtLt != null */
  and updated_at < /* criteria.updatedAtLt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updatedAtLe != null */
  and updated_at <= /* criteria.updatedAtLe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updatedAtGt != null */
  and updated_at > /* criteria.updatedAtGt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updatedAtGe != null */
  and updated_at >= /* criteria.updatedAtGe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updatedAtIsNull  */
  and updated_at IS NULL
/*%end*/
/*%if criteria.updatedAtIsNotNull  */
  and updated_at IS NOT NULL
/*%end*/
/*%if criteria.deleteFlgTrue  */
  and delete_flg = true
/*%end*/
/*%if criteria.deleteFlgFalse  */
  and delete_flg = false
/*%end*/
