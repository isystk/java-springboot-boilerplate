--  自動生成のため原則修正禁止!!
SELECT
  /*%expand*/*
FROM
  t_post_tag
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
/*%if criteria.postTagIdEq != null */
  POST_TAG_ID = /* criteria.postTagIdEq */1
/*%end*/
/*%if criteria.postTagIdNe != null */
  POST_TAG_ID != /* criteria.postTagIdNe */1
/*%end*/
/*%if criteria.postTagIdLt != null */
  POST_TAG_ID < /* criteria.postTagIdLt */1
/*%end*/
/*%if criteria.postTagIdLe != null */
  POST_TAG_ID <= /* criteria.postTagIdLe */1
/*%end*/
/*%if criteria.postTagIdGt != null */
  POST_TAG_ID > /* criteria.postTagIdLt */1
/*%end*/
/*%if criteria.postTagIdGe != null */
  POST_TAG_ID >= /* criteria.postTagIdLe */1
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
