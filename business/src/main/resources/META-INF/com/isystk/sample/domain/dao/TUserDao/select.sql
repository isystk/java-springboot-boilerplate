SELECT
  /*%expand*/*
FROM
  t_user
WHERE
  DELETE_FLG = false
/*%if criteria.userId != null */
  AND user_id = /* criteria.userId */1
/*%end*/
/*%if criteria.email != null */
  AND email = /* criteria.email */'aaaa@bbbb.com'
/*%end*/
LIMIT 1
