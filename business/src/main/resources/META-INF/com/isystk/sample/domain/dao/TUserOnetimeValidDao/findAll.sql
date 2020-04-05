--  自動生成のため原則修正禁止!!
SELECT
  /*%expand*/*
FROM
  t_user_onetime_valid
WHERE
/*%if criteria.userIdEq != null */
  and USER_ID = /* criteria.userIdEq */1
/*%end*/
/*%if criteria.userIdNe != null */
  and USER_ID != /* criteria.userIdNe */1
/*%end*/
/*%if criteria.userIdLt != null */
  and USER_ID < /* criteria.userIdLt */1
/*%end*/
/*%if criteria.userIdLe != null */
  and USER_ID <= /* criteria.userIdLe */1
/*%end*/
/*%if criteria.userIdGt != null */
  and USER_ID > /* criteria.userIdGt */1
/*%end*/
/*%if criteria.userIdGe != null */
  and USER_ID >= /* criteria.userIdGe */1
/*%end*/
/*%if criteria.userIdIsNull  */
  and USER_ID IS NULL
/*%end*/
/*%if criteria.userIdIsNotNull  */
  and USER_ID IS NOT NULL
/*%end*/
/*%if criteria.userIdIn != null  */
  and USER_ID IN /* criteria.userIdIn */(1,2,3)
/*%end*/
/*%if criteria.userIdNotIn != null  */
  and USER_ID NOT IN /* criteria.userIdNotIn */(1,2,3)
/*%end*/
/*%if criteria.onetimeKeyEq != null */
  and ONETIME_KEY = /* criteria.onetimeKeyEq */'a'
/*%end*/
/*%if criteria.onetimeKeyNe != null */
  and ONETIME_KEY != /* criteria.onetimeKeyNe */'a'
/*%end*/
/*%if criteria.onetimeKeyLt != null */
  and ONETIME_KEY < /* criteria.onetimeKeyLt */'a'
/*%end*/
/*%if criteria.onetimeKeyLe != null */
  and ONETIME_KEY <= /* criteria.onetimeKeyLe */'a'
/*%end*/
/*%if criteria.onetimeKeyGt != null */
  and ONETIME_KEY > /* criteria.onetimeKeyGt */'a'
/*%end*/
/*%if criteria.onetimeKeyGe != null */
  and ONETIME_KEY >= /* criteria.onetimeKeyGe */'a'
/*%end*/
/*%if criteria.onetimeKeyIsNull  */
  and ONETIME_KEY IS NULL
/*%end*/
/*%if criteria.onetimeKeyIsNotNull  */
  and ONETIME_KEY IS NOT NULL
/*%end*/
/*%if criteria.onetimeKeyLike != null  */
  and ONETIME_KEY LIKE /* @infix(criteria.onetimeKeyLike) */'smith'
/*%end*/
/*%if criteria.onetimeKeyNotLike != null  */
  and ONETIME_KEY NOT LIKE /* @infix(criteria.onetimeKeyNotLike) */'smith'
/*%end*/
/*%if criteria.onetimeKeyStarts != null  */
  and ONETIME_KEY LIKE /* @prefix(criteria.onetimeKeyStarts) */'smith'
/*%end*/
/*%if criteria.onetimeKeyNotStarts != null  */
  and ONETIME_KEY NOT LIKE /* @prefix(criteria.onetimeKeyNotStarts) */'smith'
/*%end*/
/*%if criteria.onetimeKeyEnds != null  */
  and ONETIME_KEY LIKE /* @suffix(criteria.onetimeKeyEnds) */'smith'
/*%end*/
/*%if criteria.onetimeKeyNotEnds != null  */
  and ONETIME_KEY NOT LIKE /* @suffix(criteria.onetimeKeyNotEnds) */'smith'
/*%end*/
/*%if criteria.onetimeValidTimeEq != null */
  and ONETIME_VALID_TIME = /* criteria.onetimeValidTimeEq */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.onetimeValidTimeNe != null */
  and ONETIME_VALID_TIME != /* criteria.onetimeValidTimeNe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.onetimeValidTimeLt != null */
  and ONETIME_VALID_TIME < /* criteria.onetimeValidTimeLt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.onetimeValidTimeLe != null */
  and ONETIME_VALID_TIME <= /* criteria.onetimeValidTimeLe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.onetimeValidTimeGt != null */
  and ONETIME_VALID_TIME > /* criteria.onetimeValidTimeGt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.onetimeValidTimeGe != null */
  and ONETIME_VALID_TIME >= /* criteria.onetimeValidTimeGe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.onetimeValidTimeIsNull  */
  and ONETIME_VALID_TIME IS NULL
/*%end*/
/*%if criteria.onetimeValidTimeIsNotNull  */
  and ONETIME_VALID_TIME IS NOT NULL
/*%end*/
/*# criteria.orderBy */
