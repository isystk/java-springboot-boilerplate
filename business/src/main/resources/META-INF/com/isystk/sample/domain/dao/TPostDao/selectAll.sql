SELECT
  /*%expand*/*
FROM
  t_post
WHERE
  DELETE_FLG = false
/*%if criteria.postId != null */
  AND post_id = /* criteria.postId */1
/*%end*/
/*%if criteria.userId != null */
  AND user_id = /* criteria.userId */1
/*%end*/
/*%if criteria.title != null */
  AND title LIKE /* @infix(criteria.title) */'john' ESCAPE '$'
/*%end*/
ORDER BY post_id ASC
