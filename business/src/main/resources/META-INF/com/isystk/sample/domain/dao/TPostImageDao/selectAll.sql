SELECT
  /*%expand*/*
FROM
  t_post_image
WHERE
/*%if criteria.postId != null */
  POST_ID = /* criteria.postId */1
/*%end*/
/*%if criteria.imageId != null */
  IMAGE_ID = /* criteria.imageId */1
/*%end*/
