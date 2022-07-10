--  自動生成のため原則修正禁止!!
SELECT
  /*%expand*/*
FROM
  user
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
/*%if criteria.providerIdEq != null */
  and provider_id = /* criteria.providerIdEq */'a'
/*%end*/
/*%if criteria.providerIdNe != null */
  and provider_id != /* criteria.providerIdNe */'a'
/*%end*/
/*%if criteria.providerIdLt != null */
  and provider_id < /* criteria.providerIdLt */'a'
/*%end*/
/*%if criteria.providerIdLe != null */
  and provider_id <= /* criteria.providerIdLe */'a'
/*%end*/
/*%if criteria.providerIdGt != null */
  and provider_id > /* criteria.providerIdGt */'a'
/*%end*/
/*%if criteria.providerIdGe != null */
  and provider_id >= /* criteria.providerIdGe */'a'
/*%end*/
/*%if criteria.providerIdIsNull  */
  and provider_id IS NULL
/*%end*/
/*%if criteria.providerIdIsNotNull  */
  and provider_id IS NOT NULL
/*%end*/
/*%if criteria.providerIdIn != null  */
  and provider_id IN /* criteria.providerIdIn */(1,2,3)
/*%end*/
/*%if criteria.providerIdNotIn != null  */
  and provider_id NOT IN /* criteria.providerIdNotIn */(1,2,3)
/*%end*/
/*%if criteria.providerIdLike != null  */
  and provider_id LIKE /* @infix(criteria.providerIdLike) */'smith'
/*%end*/
/*%if criteria.providerIdNotLike != null  */
  and provider_id NOT LIKE /* @infix(criteria.providerIdNotLike) */'smith'
/*%end*/
/*%if criteria.providerIdStarts != null  */
  and provider_id LIKE /* @prefix(criteria.providerIdStarts) */'smith'
/*%end*/
/*%if criteria.providerIdNotStarts != null  */
  and provider_id NOT LIKE /* @prefix(criteria.providerIdNotStarts) */'smith'
/*%end*/
/*%if criteria.providerIdEnds != null  */
  and provider_id LIKE /* @suffix(criteria.providerIdEnds) */'smith'
/*%end*/
/*%if criteria.providerIdNotEnds != null  */
  and provider_id NOT LIKE /* @suffix(criteria.providerIdNotEnds) */'smith'
/*%end*/
/*%if criteria.providerNameEq != null */
  and provider_name = /* criteria.providerNameEq */'a'
/*%end*/
/*%if criteria.providerNameNe != null */
  and provider_name != /* criteria.providerNameNe */'a'
/*%end*/
/*%if criteria.providerNameLt != null */
  and provider_name < /* criteria.providerNameLt */'a'
/*%end*/
/*%if criteria.providerNameLe != null */
  and provider_name <= /* criteria.providerNameLe */'a'
/*%end*/
/*%if criteria.providerNameGt != null */
  and provider_name > /* criteria.providerNameGt */'a'
/*%end*/
/*%if criteria.providerNameGe != null */
  and provider_name >= /* criteria.providerNameGe */'a'
/*%end*/
/*%if criteria.providerNameIsNull  */
  and provider_name IS NULL
/*%end*/
/*%if criteria.providerNameIsNotNull  */
  and provider_name IS NOT NULL
/*%end*/
/*%if criteria.providerNameIn != null  */
  and provider_name IN /* criteria.providerNameIn */(1,2,3)
/*%end*/
/*%if criteria.providerNameNotIn != null  */
  and provider_name NOT IN /* criteria.providerNameNotIn */(1,2,3)
/*%end*/
/*%if criteria.providerNameLike != null  */
  and provider_name LIKE /* @infix(criteria.providerNameLike) */'smith'
/*%end*/
/*%if criteria.providerNameNotLike != null  */
  and provider_name NOT LIKE /* @infix(criteria.providerNameNotLike) */'smith'
/*%end*/
/*%if criteria.providerNameStarts != null  */
  and provider_name LIKE /* @prefix(criteria.providerNameStarts) */'smith'
/*%end*/
/*%if criteria.providerNameNotStarts != null  */
  and provider_name NOT LIKE /* @prefix(criteria.providerNameNotStarts) */'smith'
/*%end*/
/*%if criteria.providerNameEnds != null  */
  and provider_name LIKE /* @suffix(criteria.providerNameEnds) */'smith'
/*%end*/
/*%if criteria.providerNameNotEnds != null  */
  and provider_name NOT LIKE /* @suffix(criteria.providerNameNotEnds) */'smith'
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
/*%if criteria.nameIn != null  */
  and name IN /* criteria.nameIn */(1,2,3)
/*%end*/
/*%if criteria.nameNotIn != null  */
  and name NOT IN /* criteria.nameNotIn */(1,2,3)
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
/*%if criteria.emailIn != null  */
  and email IN /* criteria.emailIn */(1,2,3)
/*%end*/
/*%if criteria.emailNotIn != null  */
  and email NOT IN /* criteria.emailNotIn */(1,2,3)
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
/*%if criteria.emailVerifiedAtEq != null */
  and email_verified_at = /* criteria.emailVerifiedAtEq */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.emailVerifiedAtNe != null */
  and email_verified_at != /* criteria.emailVerifiedAtNe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.emailVerifiedAtLt != null */
  and email_verified_at < /* criteria.emailVerifiedAtLt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.emailVerifiedAtLe != null */
  and email_verified_at <= /* criteria.emailVerifiedAtLe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.emailVerifiedAtGt != null */
  and email_verified_at > /* criteria.emailVerifiedAtGt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.emailVerifiedAtGe != null */
  and email_verified_at >= /* criteria.emailVerifiedAtGe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.emailVerifiedAtIsNull  */
  and email_verified_at IS NULL
/*%end*/
/*%if criteria.emailVerifiedAtIsNotNull  */
  and email_verified_at IS NOT NULL
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
/*%if criteria.passwordIn != null  */
  and password IN /* criteria.passwordIn */(1,2,3)
/*%end*/
/*%if criteria.passwordNotIn != null  */
  and password NOT IN /* criteria.passwordNotIn */(1,2,3)
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
/*%if criteria.rememberTokenIn != null  */
  and remember_token IN /* criteria.rememberTokenIn */(1,2,3)
/*%end*/
/*%if criteria.rememberTokenNotIn != null  */
  and remember_token NOT IN /* criteria.rememberTokenNotIn */(1,2,3)
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
/*%if criteria.lastLoginAtEq != null */
  and last_login_at = /* criteria.lastLoginAtEq */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.lastLoginAtNe != null */
  and last_login_at != /* criteria.lastLoginAtNe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.lastLoginAtLt != null */
  and last_login_at < /* criteria.lastLoginAtLt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.lastLoginAtLe != null */
  and last_login_at <= /* criteria.lastLoginAtLe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.lastLoginAtGt != null */
  and last_login_at > /* criteria.lastLoginAtGt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.lastLoginAtGe != null */
  and last_login_at >= /* criteria.lastLoginAtGe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.lastLoginAtIsNull  */
  and last_login_at IS NULL
/*%end*/
/*%if criteria.lastLoginAtIsNotNull  */
  and last_login_at IS NOT NULL
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
