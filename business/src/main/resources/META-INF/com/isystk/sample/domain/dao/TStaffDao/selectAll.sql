SELECT
  /*%expand*/*
FROM
  t_staff
WHERE
  deleted_at IS NULL
/*%if criteria.id != null */
  AND staff_id = /* criteria.id */1
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
  staff_id ASC
