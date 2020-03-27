SELECT
  /*%expand*/*
FROM
  t_user
WHERE
/*%if criteria.userId != null */
  AND user_id = /* criteria.userId */1
/*%end*/
/*%if criteria.familyName != null */
  AND FAMILY_NAME LIKE /* @infix(criteria.familyName) */'john' ESCAPE '$'
/*%end*/
/*%if criteria.name != null */
  AND name LIKE /* @infix(criteria.name) */'john' ESCAPE '$'
/*%end*/
/*%if criteria.email != null */
  AND email = /* criteria.email */'aaaa@bbbb.com'
/*%end*/
ORDER BY
  user_id ASC
