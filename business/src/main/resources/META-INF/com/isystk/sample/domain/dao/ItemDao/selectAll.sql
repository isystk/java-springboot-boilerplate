SELECT
  /*%expand*/*
FROM
  item
WHERE
/*%if criteria.id != null */
  AND id = /* criteria.id */1
/*%end*/
ORDER BY
  id ASC
