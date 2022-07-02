--  自動生成のため原則修正禁止!!
SELECT
  /*%expand*/*
FROM
  password_reset
WHERE
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
/*%if criteria.tokenEq != null */
  and token = /* criteria.tokenEq */'a'
/*%end*/
/*%if criteria.tokenNe != null */
  and token != /* criteria.tokenNe */'a'
/*%end*/
/*%if criteria.tokenLt != null */
  and token < /* criteria.tokenLt */'a'
/*%end*/
/*%if criteria.tokenLe != null */
  and token <= /* criteria.tokenLe */'a'
/*%end*/
/*%if criteria.tokenGt != null */
  and token > /* criteria.tokenGt */'a'
/*%end*/
/*%if criteria.tokenGe != null */
  and token >= /* criteria.tokenGe */'a'
/*%end*/
/*%if criteria.tokenIsNull  */
  and token IS NULL
/*%end*/
/*%if criteria.tokenIsNotNull  */
  and token IS NOT NULL
/*%end*/
/*%if criteria.tokenIn != null  */
  and token IN /* criteria.tokenIn */(1,2,3)
/*%end*/
/*%if criteria.tokenNotIn != null  */
  and token NOT IN /* criteria.tokenNotIn */(1,2,3)
/*%end*/
/*%if criteria.tokenLike != null  */
  and token LIKE /* @infix(criteria.tokenLike) */'smith'
/*%end*/
/*%if criteria.tokenNotLike != null  */
  and token NOT LIKE /* @infix(criteria.tokenNotLike) */'smith'
/*%end*/
/*%if criteria.tokenStarts != null  */
  and token LIKE /* @prefix(criteria.tokenStarts) */'smith'
/*%end*/
/*%if criteria.tokenNotStarts != null  */
  and token NOT LIKE /* @prefix(criteria.tokenNotStarts) */'smith'
/*%end*/
/*%if criteria.tokenEnds != null  */
  and token LIKE /* @suffix(criteria.tokenEnds) */'smith'
/*%end*/
/*%if criteria.tokenNotEnds != null  */
  and token NOT LIKE /* @suffix(criteria.tokenNotEnds) */'smith'
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
/*# criteria.orderBy */
