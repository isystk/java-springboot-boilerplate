SELECT
  /*%expand*/*
FROM
  item
WHERE
/*%if criteria.id != null */
  AND id = /* criteria.id */1
/*%end*/
/*%if criteria.name != null */
  AND name = /* criteria.name */'aaaa@bbbb.com'
/*%end*/
LIMIT 1
