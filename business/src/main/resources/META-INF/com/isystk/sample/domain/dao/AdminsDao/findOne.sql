--  自動生成のため原則修正禁止!!
SELECT
  /*%expand*/*
FROM
  admins
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
/*%if criteria.nameEq != null */
  and name = /* criteria.nameEq */'a'
/*%end*/
/*%if criteria.nameNe != null */
  and name != /* criteria.nameNe */'a'
/*%end*/
/*%if criteria.nameLt != null */
  and name < /* criteria.nameLt */'a'
/*%end*/
/*%if criteria.nameLe != null */
  and name <= /* criteria.nameLe */'a'
/*%end*/
/*%if criteria.nameGt != null */
  and name > /* criteria.nameGt */'a'
/*%end*/
/*%if criteria.nameGe != null */
  and name >= /* criteria.nameGe */'a'
/*%end*/
/*%if criteria.nameIsNull  */
  and name IS NULL
/*%end*/
/*%if criteria.nameIsNotNull  */
  and name IS NOT NULL
/*%end*/
/*%if criteria.nameLike != null  */
  and name LIKE /* @infix(criteria.nameLike) */'smith'
/*%end*/
/*%if criteria.nameNotLike != null  */
  and name NOT LIKE /* @infix(criteria.nameNotLike) */'smith'
/*%end*/
/*%if criteria.nameStarts != null  */
  and name LIKE /* @prefix(criteria.nameStarts) */'smith'
/*%end*/
/*%if criteria.nameNotStarts != null  */
  and name NOT LIKE /* @prefix(criteria.nameNotStarts) */'smith'
/*%end*/
/*%if criteria.nameEnds != null  */
  and name LIKE /* @suffix(criteria.nameEnds) */'smith'
/*%end*/
/*%if criteria.nameNotEnds != null  */
  and name NOT LIKE /* @suffix(criteria.nameNotEnds) */'smith'
/*%end*/
/*%if criteria.emailEq != null */
  and email = /* criteria.emailEq */'a'
/*%end*/
/*%if criteria.emailNe != null */
  and email != /* criteria.emailNe */'a'
/*%end*/
/*%if criteria.emailLt != null */
  and email < /* criteria.emailLt */'a'
/*%end*/
/*%if criteria.emailLe != null */
  and email <= /* criteria.emailLe */'a'
/*%end*/
/*%if criteria.emailGt != null */
  and email > /* criteria.emailGt */'a'
/*%end*/
/*%if criteria.emailGe != null */
  and email >= /* criteria.emailGe */'a'
/*%end*/
/*%if criteria.emailIsNull  */
  and email IS NULL
/*%end*/
/*%if criteria.emailIsNotNull  */
  and email IS NOT NULL
/*%end*/
/*%if criteria.emailLike != null  */
  and email LIKE /* @infix(criteria.emailLike) */'smith'
/*%end*/
/*%if criteria.emailNotLike != null  */
  and email NOT LIKE /* @infix(criteria.emailNotLike) */'smith'
/*%end*/
/*%if criteria.emailStarts != null  */
  and email LIKE /* @prefix(criteria.emailStarts) */'smith'
/*%end*/
/*%if criteria.emailNotStarts != null  */
  and email NOT LIKE /* @prefix(criteria.emailNotStarts) */'smith'
/*%end*/
/*%if criteria.emailEnds != null  */
  and email LIKE /* @suffix(criteria.emailEnds) */'smith'
/*%end*/
/*%if criteria.emailNotEnds != null  */
  and email NOT LIKE /* @suffix(criteria.emailNotEnds) */'smith'
/*%end*/
/*%if criteria.passwordEq != null */
  and password = /* criteria.passwordEq */'a'
/*%end*/
/*%if criteria.passwordNe != null */
  and password != /* criteria.passwordNe */'a'
/*%end*/
/*%if criteria.passwordLt != null */
  and password < /* criteria.passwordLt */'a'
/*%end*/
/*%if criteria.passwordLe != null */
  and password <= /* criteria.passwordLe */'a'
/*%end*/
/*%if criteria.passwordGt != null */
  and password > /* criteria.passwordGt */'a'
/*%end*/
/*%if criteria.passwordGe != null */
  and password >= /* criteria.passwordGe */'a'
/*%end*/
/*%if criteria.passwordIsNull  */
  and password IS NULL
/*%end*/
/*%if criteria.passwordIsNotNull  */
  and password IS NOT NULL
/*%end*/
/*%if criteria.passwordLike != null  */
  and password LIKE /* @infix(criteria.passwordLike) */'smith'
/*%end*/
/*%if criteria.passwordNotLike != null  */
  and password NOT LIKE /* @infix(criteria.passwordNotLike) */'smith'
/*%end*/
/*%if criteria.passwordStarts != null  */
  and password LIKE /* @prefix(criteria.passwordStarts) */'smith'
/*%end*/
/*%if criteria.passwordNotStarts != null  */
  and password NOT LIKE /* @prefix(criteria.passwordNotStarts) */'smith'
/*%end*/
/*%if criteria.passwordEnds != null  */
  and password LIKE /* @suffix(criteria.passwordEnds) */'smith'
/*%end*/
/*%if criteria.passwordNotEnds != null  */
  and password NOT LIKE /* @suffix(criteria.passwordNotEnds) */'smith'
/*%end*/
/*%if criteria.rememberTokenEq != null */
  and remember_token = /* criteria.rememberTokenEq */'a'
/*%end*/
/*%if criteria.rememberTokenNe != null */
  and remember_token != /* criteria.rememberTokenNe */'a'
/*%end*/
/*%if criteria.rememberTokenLt != null */
  and remember_token < /* criteria.rememberTokenLt */'a'
/*%end*/
/*%if criteria.rememberTokenLe != null */
  and remember_token <= /* criteria.rememberTokenLe */'a'
/*%end*/
/*%if criteria.rememberTokenGt != null */
  and remember_token > /* criteria.rememberTokenGt */'a'
/*%end*/
/*%if criteria.rememberTokenGe != null */
  and remember_token >= /* criteria.rememberTokenGe */'a'
/*%end*/
/*%if criteria.rememberTokenIsNull  */
  and remember_token IS NULL
/*%end*/
/*%if criteria.rememberTokenIsNotNull  */
  and remember_token IS NOT NULL
/*%end*/
/*%if criteria.rememberTokenLike != null  */
  and remember_token LIKE /* @infix(criteria.rememberTokenLike) */'smith'
/*%end*/
/*%if criteria.rememberTokenNotLike != null  */
  and remember_token NOT LIKE /* @infix(criteria.rememberTokenNotLike) */'smith'
/*%end*/
/*%if criteria.rememberTokenStarts != null  */
  and remember_token LIKE /* @prefix(criteria.rememberTokenStarts) */'smith'
/*%end*/
/*%if criteria.rememberTokenNotStarts != null  */
  and remember_token NOT LIKE /* @prefix(criteria.rememberTokenNotStarts) */'smith'
/*%end*/
/*%if criteria.rememberTokenEnds != null  */
  and remember_token LIKE /* @suffix(criteria.rememberTokenEnds) */'smith'
/*%end*/
/*%if criteria.rememberTokenNotEnds != null  */
  and remember_token NOT LIKE /* @suffix(criteria.rememberTokenNotEnds) */'smith'
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
