SELECT
  /*%expand*/*
FROM
  t_post_tag
WHERE
  POST_ID = /* postId */1
  and
  POST_TAG_ID = /* postTagId */1
LIMIT 1