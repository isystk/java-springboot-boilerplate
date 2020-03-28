SELECT
  /*%expand*/*
FROM
  t_post_image
WHERE
  POST_ID = /* postId */1
  and
  IMAGE_ID = /* imageId */1
LIMIT 1