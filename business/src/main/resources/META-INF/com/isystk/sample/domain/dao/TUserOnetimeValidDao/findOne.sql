--  自動生成のため原則修正禁止!!
SELECT
  /*%expand*/*
FROM
  t_user_onetime_valid
WHERE
/*%if criteria.userIdEq != null */
  USER_ID = /* criteria.userIdEq */1
/*%end*/
/*%if criteria.userIdNe != null */
  USER_ID != /* criteria.userIdNe */1
/*%end*/
/*%if criteria.userIdLt != null */
  USER_ID < /* criteria.userIdLt */1
/*%end*/
/*%if criteria.userIdLe != null */
  USER_ID <= /* criteria.userIdLe */1
/*%end*/
/*%if criteria.userIdGt != null */
  USER_ID > /* criteria.userIdLt */1
/*%end*/
/*%if criteria.userIdGe != null */
  USER_ID >= /* criteria.userIdLe */1
/*%end*/
/*%if criteria.userIdIsNull  */
  USER_ID IS NULL
/*%end*/
/*%if criteria.userIdIsNotNull  */
  USER_ID IS NOT NULL
/*%end*/
/*%if criteria.userIdIn != null  */
  USER_ID IN /* criteria.userIdIn */(1,2,3)
/*%end*/
/*%if criteria.userIdNotIn != null  */
  USER_ID NOT IN /* criteria.userIdNotIn */(1,2,3)
/*%end*/
/*%if criteria.onetimeKeyEq != null */
  ONETIME_KEY = /* criteria.onetimeKeyEq */'a'
/*%end*/
/*%if criteria.onetimeKeyNe != null */
  ONETIME_KEY != /* criteria.onetimeKeyNe */'a'
/*%end*/
/*%if criteria.onetimeKeyLt != null */
  ONETIME_KEY < /* criteria.onetimeKeyLt */'a'
/*%end*/
/*%if criteria.onetimeKeyLe != null */
  ONETIME_KEY <= /* criteria.onetimeKeyLe */'a'
/*%end*/
/*%if criteria.onetimeKeyGt != null */
  ONETIME_KEY > /* criteria.onetimeKeyLt */'a'
/*%end*/
/*%if criteria.onetimeKeyGe != null */
  ONETIME_KEY >= /* criteria.onetimeKeyLe */'a'
/*%end*/
/*%if criteria.onetimeKeyIsNull  */
  ONETIME_KEY IS NULL
/*%end*/
/*%if criteria.onetimeKeyIsNotNull  */
  ONETIME_KEY IS NOT NULL
/*%end*/
/*%if criteria.onetimeKeyLike != null  */
  ONETIME_KEY LIKE /* @infix(criteria.onetimeKeyLike) */'smith'
/*%end*/
/*%if criteria.onetimeKeyNotLike != null  */
  ONETIME_KEY NOT LIKE /* @infix(criteria.onetimeKeyNotLike) */'smith'
/*%end*/
/*%if criteria.onetimeKeyStarts != null  */
  ONETIME_KEY LIKE /* @prefix(criteria.onetimeKeyStarts) */'smith'
/*%end*/
/*%if criteria.onetimeKeyNotStarts != null  */
  ONETIME_KEY NOT LIKE /* @prefix(criteria.onetimeKeyNotStarts) */'smith'
/*%end*/
/*%if criteria.onetimeKeyEnds != null  */
  ONETIME_KEY LIKE /* @suffix(criteria.onetimeKeyEnds) */'smith'
/*%end*/
/*%if criteria.onetimeKeyNotEnds != null  */
  ONETIME_KEY NOT LIKE /* @suffix(criteria.onetimeKeyNotEnds) */'smith'
/*%end*/
/*%if criteria.onetimeValidTimeEq != null */
  ONETIME_VALID_TIME = /* criteria.onetimeValidTimeEq */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.onetimeValidTimeNe != null */
  ONETIME_VALID_TIME != /* criteria.onetimeValidTimeNe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.onetimeValidTimeLt != null */
  ONETIME_VALID_TIME < /* criteria.onetimeValidTimeLt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.onetimeValidTimeLe != null */
  ONETIME_VALID_TIME <= /* criteria.onetimeValidTimeLe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.onetimeValidTimeGt != null */
  ONETIME_VALID_TIME > /* criteria.onetimeValidTimeLt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.onetimeValidTimeGe != null */
  ONETIME_VALID_TIME >= /* criteria.onetimeValidTimeLe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.onetimeValidTimeIsNull  */
  ONETIME_VALID_TIME IS NULL
/*%end*/
/*%if criteria.onetimeValidTimeIsNotNull  */
  ONETIME_VALID_TIME IS NOT NULL
/*%end*/
