--  自動生成のため原則修正禁止!!
SELECT
  /*%expand*/*
FROM
  t_post_image
WHERE
/*%if criteria.postIdEq != null */
  POST_ID = /* criteria.postIdEq */1
/*%end*/
/*%if criteria.postIdNe != null */
  POST_ID != /* criteria.postIdNe */1
/*%end*/
/*%if criteria.postIdLt != null */
  POST_ID < /* criteria.postIdLt */1
/*%end*/
/*%if criteria.postIdLe != null */
  POST_ID <= /* criteria.postIdLe */1
/*%end*/
/*%if criteria.postIdGt != null */
  POST_ID > /* criteria.postIdLt */1
/*%end*/
/*%if criteria.postIdGe != null */
  POST_ID >= /* criteria.postIdLe */1
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
/*%if criteria.imageIdEq != null */
  IMAGE_ID = /* criteria.imageIdEq */1
/*%end*/
/*%if criteria.imageIdNe != null */
  IMAGE_ID != /* criteria.imageIdNe */1
/*%end*/
/*%if criteria.imageIdLt != null */
  IMAGE_ID < /* criteria.imageIdLt */1
/*%end*/
/*%if criteria.imageIdLe != null */
  IMAGE_ID <= /* criteria.imageIdLe */1
/*%end*/
/*%if criteria.imageIdGt != null */
  IMAGE_ID > /* criteria.imageIdLt */1
/*%end*/
/*%if criteria.imageIdGe != null */
  IMAGE_ID >= /* criteria.imageIdLe */1
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
