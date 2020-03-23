SELECT
  /*%expand*/*
FROM
  t_staff
WHERE
  DELETE_FLG = false
/*%if criteria.id != null */
  AND staff_id = /* criteria.id */1
/*%end*/
/*%if criteria.email != null */
  AND email = /* criteria.email */'aaaa@bbbb.com'
/*%end*/
LIMIT 1
