SELECT
  /*%expand*/*
FROM
  t_user_onetime_valid
WHERE
/*%if criteria.userId != null */
  USER_ID = /* criteria.userId */1
/*%end*/
/*%if criteria.onetimeKey != null */
  ONETIME_KEY = /* criteria.onetimeKey */'a'
/*%end*/
/*%if criteria.onetimeValidTime != null */
  ONETIME_VALID_TIME = /* criteria.onetimeValidTime */'2010-01-23 12:34:56'
/*%end*/

