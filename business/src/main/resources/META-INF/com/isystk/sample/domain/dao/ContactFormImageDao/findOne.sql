--  自動生成のため原則修正禁止!!
SELECT
  /*%expand*/*
FROM
  contact_form_image
WHERE
/*%if criteria.idEq != null */
  and id = /* criteria.idEq */1
/*%end*/
/*%if criteria.idNe != null */
  and id != /* criteria.idNe */1
/*%end*/
/*%if criteria.idLt != null */
  and id < /* criteria.idLt */1
/*%end*/
/*%if criteria.idLe != null */
  and id <= /* criteria.idLe */1
/*%end*/
/*%if criteria.idGt != null */
  and id > /* criteria.idGt */1
/*%end*/
/*%if criteria.idGe != null */
  and id >= /* criteria.idGe */1
/*%end*/
/*%if criteria.idIsNull  */
  and id IS NULL
/*%end*/
/*%if criteria.idIsNotNull  */
  and id IS NOT NULL
/*%end*/
/*%if criteria.idIn != null  */
  and id IN /* criteria.idIn */(1,2,3)
/*%end*/
/*%if criteria.idNotIn != null  */
  and id NOT IN /* criteria.idNotIn */(1,2,3)
/*%end*/
/*%if criteria.contactFormIdEq != null */
  and contact_form_id = /* criteria.contactFormIdEq */1
/*%end*/
/*%if criteria.contactFormIdNe != null */
  and contact_form_id != /* criteria.contactFormIdNe */1
/*%end*/
/*%if criteria.contactFormIdLt != null */
  and contact_form_id < /* criteria.contactFormIdLt */1
/*%end*/
/*%if criteria.contactFormIdLe != null */
  and contact_form_id <= /* criteria.contactFormIdLe */1
/*%end*/
/*%if criteria.contactFormIdGt != null */
  and contact_form_id > /* criteria.contactFormIdGt */1
/*%end*/
/*%if criteria.contactFormIdGe != null */
  and contact_form_id >= /* criteria.contactFormIdGe */1
/*%end*/
/*%if criteria.contactFormIdIsNull  */
  and contact_form_id IS NULL
/*%end*/
/*%if criteria.contactFormIdIsNotNull  */
  and contact_form_id IS NOT NULL
/*%end*/
/*%if criteria.contactFormIdIn != null  */
  and contact_form_id IN /* criteria.contactFormIdIn */(1,2,3)
/*%end*/
/*%if criteria.contactFormIdNotIn != null  */
  and contact_form_id NOT IN /* criteria.contactFormIdNotIn */(1,2,3)
/*%end*/
/*%if criteria.fileNameEq != null */
  and file_name = /* criteria.fileNameEq */'a'
/*%end*/
/*%if criteria.fileNameNe != null */
  and file_name != /* criteria.fileNameNe */'a'
/*%end*/
/*%if criteria.fileNameLt != null */
  and file_name < /* criteria.fileNameLt */'a'
/*%end*/
/*%if criteria.fileNameLe != null */
  and file_name <= /* criteria.fileNameLe */'a'
/*%end*/
/*%if criteria.fileNameGt != null */
  and file_name > /* criteria.fileNameGt */'a'
/*%end*/
/*%if criteria.fileNameGe != null */
  and file_name >= /* criteria.fileNameGe */'a'
/*%end*/
/*%if criteria.fileNameIsNull  */
  and file_name IS NULL
/*%end*/
/*%if criteria.fileNameIsNotNull  */
  and file_name IS NOT NULL
/*%end*/
/*%if criteria.fileNameLike != null  */
  and file_name LIKE /* @infix(criteria.fileNameLike) */'smith'
/*%end*/
/*%if criteria.fileNameNotLike != null  */
  and file_name NOT LIKE /* @infix(criteria.fileNameNotLike) */'smith'
/*%end*/
/*%if criteria.fileNameStarts != null  */
  and file_name LIKE /* @prefix(criteria.fileNameStarts) */'smith'
/*%end*/
/*%if criteria.fileNameNotStarts != null  */
  and file_name NOT LIKE /* @prefix(criteria.fileNameNotStarts) */'smith'
/*%end*/
/*%if criteria.fileNameEnds != null  */
  and file_name LIKE /* @suffix(criteria.fileNameEnds) */'smith'
/*%end*/
/*%if criteria.fileNameNotEnds != null  */
  and file_name NOT LIKE /* @suffix(criteria.fileNameNotEnds) */'smith'
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
