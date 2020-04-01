SELECT
  /*%expand*/*
FROM
  t_post_tag
WHERE
/*%if criteria.postIdEqual != null */
  POST_ID = /* criteria.postIdEqual */1
/*%end*/
/*%if criteria.postIdNotEqual != null */
  POST_ID != /* criteria.postIdNotEqual */1
/*%end*/
/*%if criteria.postIdIsNull  */
  POST_ID IS NULL
/*%end*/
/*%if criteria.postIdIsNotNull  */
  POST_ID IS NOT NULL
/*%end*/
/*%if criteria.postTagIdEqual != null */
  POST_TAG_ID = /* criteria.postTagIdEqual */1
/*%end*/
/*%if criteria.postTagIdNotEqual != null */
  POST_TAG_ID != /* criteria.postTagIdNotEqual */1
/*%end*/
/*%if criteria.postTagIdIsNull  */
  POST_TAG_ID IS NULL
/*%end*/
/*%if criteria.postTagIdIsNotNull  */
  POST_TAG_ID IS NOT NULL
/*%end*/

