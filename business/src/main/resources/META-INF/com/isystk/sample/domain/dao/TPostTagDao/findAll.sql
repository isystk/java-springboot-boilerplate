--  自動生成のため原則修正禁止!!
SELECT
  /*%expand*/*
FROM
  t_post_tag
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
/*%if criteria.postTagIdEq != null */
  and POST_TAG_ID = /* criteria.postTagIdEq */1
/*%end*/
/*%if criteria.postTagIdNe != null */
  and POST_TAG_ID != /* criteria.postTagIdNe */1
/*%end*/
/*%if criteria.postTagIdLt != null */
  and POST_TAG_ID < /* criteria.postTagIdLt */1
/*%end*/
/*%if criteria.postTagIdLe != null */
  and POST_TAG_ID <= /* criteria.postTagIdLe */1
/*%end*/
/*%if criteria.postTagIdGt != null */
  and POST_TAG_ID > /* criteria.postTagIdGt */1
/*%end*/
/*%if criteria.postTagIdGe != null */
  and POST_TAG_ID >= /* criteria.postTagIdGe */1
/*%end*/
/*%if criteria.postTagIdIsNull  */
  and POST_TAG_ID IS NULL
/*%end*/
/*%if criteria.postTagIdIsNotNull  */
  and POST_TAG_ID IS NOT NULL
/*%end*/
/*%if criteria.postTagIdIn != null  */
  and POST_TAG_ID IN /* criteria.postTagIdIn */(1,2,3)
/*%end*/
/*%if criteria.postTagIdNotIn != null  */
  and POST_TAG_ID NOT IN /* criteria.postTagIdNotIn */(1,2,3)
/*%end*/
/*# criteria.orderBy */
