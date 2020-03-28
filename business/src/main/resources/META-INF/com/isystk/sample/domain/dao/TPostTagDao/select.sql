SELECT
  /*%expand*/*
FROM
  t_post_tag
WHERE
/*%if criteria.postId != null */
  POST_ID = /* criteria.postId */1
/*%end*/
/*%if criteria.postTagId != null */
  POST_TAG_ID = /* criteria.postTagId */1
/*%end*/

