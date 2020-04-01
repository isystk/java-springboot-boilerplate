SELECT
  /*%expand*/*
FROM
  t_post_image
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
/*%if criteria.imageIdEqual != null */
  IMAGE_ID = /* criteria.imageIdEqual */1
/*%end*/
/*%if criteria.imageIdNotEqual != null */
  IMAGE_ID != /* criteria.imageIdNotEqual */1
/*%end*/
/*%if criteria.imageIdIsNull  */
  IMAGE_ID IS NULL
/*%end*/
/*%if criteria.imageIdIsNotNull  */
  IMAGE_ID IS NOT NULL
/*%end*/
/*%if criteria.imageIdIn != null  */
  IMAGE_ID IN /* criteria.imageIdIn */(1,2,3)
/*%end*/
/*%if criteria.imageIdNotIn != null  */
  IMAGE_ID NOT IN /* criteria.imageIdNotIn */(1,2,3)
/*%end*/
