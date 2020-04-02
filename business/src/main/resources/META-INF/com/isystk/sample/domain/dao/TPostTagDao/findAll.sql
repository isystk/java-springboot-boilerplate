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
/*%if criteria.postIdIn != null  */
  POST_ID IN /* criteria.postIdIn */(1,2,3)
/*%end*/
/*%if criteria.postIdNotIn != null  */
  POST_ID NOT IN /* criteria.postIdNotIn */(1,2,3)
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
/*%if criteria.postTagIdIn != null  */
  POST_TAG_ID IN /* criteria.postTagIdIn */(1,2,3)
/*%end*/
/*%if criteria.postTagIdNotIn != null  */
  POST_TAG_ID NOT IN /* criteria.postTagIdNotIn */(1,2,3)
/*%end*/
