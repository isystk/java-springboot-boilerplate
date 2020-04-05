--  自動生成のため原則修正禁止!!
SELECT
  /*%expand*/*
FROM
  t_post_image
WHERE
/*%if criteria.postIdEq != null */
  and POST_ID = /* criteria.postIdEq */1
/*%end*/
/*%if criteria.postIdNe != null */
  and POST_ID != /* criteria.postIdNe */1
/*%end*/
/*%if criteria.postIdLt != null */
  and POST_ID < /* criteria.postIdLt */1
/*%end*/
/*%if criteria.postIdLe != null */
  and POST_ID <= /* criteria.postIdLe */1
/*%end*/
/*%if criteria.postIdGt != null */
  and POST_ID > /* criteria.postIdGt */1
/*%end*/
/*%if criteria.postIdGe != null */
  and POST_ID >= /* criteria.postIdGe */1
/*%end*/
/*%if criteria.postIdIsNull  */
  and POST_ID IS NULL
/*%end*/
/*%if criteria.postIdIsNotNull  */
  and POST_ID IS NOT NULL
/*%end*/
/*%if criteria.postIdIn != null  */
  and POST_ID IN /* criteria.postIdIn */(1,2,3)
/*%end*/
/*%if criteria.postIdNotIn != null  */
  and POST_ID NOT IN /* criteria.postIdNotIn */(1,2,3)
/*%end*/
/*%if criteria.imageIdEq != null */
  and IMAGE_ID = /* criteria.imageIdEq */1
/*%end*/
/*%if criteria.imageIdNe != null */
  and IMAGE_ID != /* criteria.imageIdNe */1
/*%end*/
/*%if criteria.imageIdLt != null */
  and IMAGE_ID < /* criteria.imageIdLt */1
/*%end*/
/*%if criteria.imageIdLe != null */
  and IMAGE_ID <= /* criteria.imageIdLe */1
/*%end*/
/*%if criteria.imageIdGt != null */
  and IMAGE_ID > /* criteria.imageIdGt */1
/*%end*/
/*%if criteria.imageIdGe != null */
  and IMAGE_ID >= /* criteria.imageIdGe */1
/*%end*/
/*%if criteria.imageIdIsNull  */
  and IMAGE_ID IS NULL
/*%end*/
/*%if criteria.imageIdIsNotNull  */
  and IMAGE_ID IS NOT NULL
/*%end*/
/*%if criteria.imageIdIn != null  */
  and IMAGE_ID IN /* criteria.imageIdIn */(1,2,3)
/*%end*/
/*%if criteria.imageIdNotIn != null  */
  and IMAGE_ID NOT IN /* criteria.imageIdNotIn */(1,2,3)
/*%end*/
/*# criteria.orderBy */
