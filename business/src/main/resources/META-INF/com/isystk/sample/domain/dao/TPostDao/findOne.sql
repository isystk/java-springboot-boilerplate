--  自動生成のため原則修正禁止!!
SELECT
  /*%expand*/*
FROM
  t_post
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
/*%if criteria.userIdEq != null */
  USER_ID = /* criteria.userIdEq */1
/*%end*/
/*%if criteria.userIdNe != null */
  USER_ID != /* criteria.userIdNe */1
/*%end*/
/*%if criteria.userIdLt != null */
  USER_ID < /* criteria.userIdLt */1
/*%end*/
/*%if criteria.userIdLe != null */
  USER_ID <= /* criteria.userIdLe */1
/*%end*/
/*%if criteria.userIdGt != null */
  USER_ID > /* criteria.userIdLt */1
/*%end*/
/*%if criteria.userIdGe != null */
  USER_ID >= /* criteria.userIdLe */1
/*%end*/
/*%if criteria.userIdIsNull  */
  USER_ID IS NULL
/*%end*/
/*%if criteria.userIdIsNotNull  */
  USER_ID IS NOT NULL
/*%end*/
/*%if criteria.userIdIn != null  */
  USER_ID IN /* criteria.userIdIn */(1,2,3)
/*%end*/
/*%if criteria.userIdNotIn != null  */
  USER_ID NOT IN /* criteria.userIdNotIn */(1,2,3)
/*%end*/
/*%if criteria.titleEq != null */
  TITLE = /* criteria.titleEq */'a'
/*%end*/
/*%if criteria.titleNe != null */
  TITLE != /* criteria.titleNe */'a'
/*%end*/
/*%if criteria.titleLt != null */
  TITLE < /* criteria.titleLt */'a'
/*%end*/
/*%if criteria.titleLe != null */
  TITLE <= /* criteria.titleLe */'a'
/*%end*/
/*%if criteria.titleGt != null */
  TITLE > /* criteria.titleLt */'a'
/*%end*/
/*%if criteria.titleGe != null */
  TITLE >= /* criteria.titleLe */'a'
/*%end*/
/*%if criteria.titleIsNull  */
  TITLE IS NULL
/*%end*/
/*%if criteria.titleIsNotNull  */
  TITLE IS NOT NULL
/*%end*/
/*%if criteria.titleLike != null  */
  TITLE LIKE /* @infix(criteria.titleLike) */'smith'
/*%end*/
/*%if criteria.titleNotLike != null  */
  TITLE NOT LIKE /* @infix(criteria.titleNotLike) */'smith'
/*%end*/
/*%if criteria.titleStarts != null  */
  TITLE LIKE /* @prefix(criteria.titleStarts) */'smith'
/*%end*/
/*%if criteria.titleNotStarts != null  */
  TITLE NOT LIKE /* @prefix(criteria.titleNotStarts) */'smith'
/*%end*/
/*%if criteria.titleEnds != null  */
  TITLE LIKE /* @suffix(criteria.titleEnds) */'smith'
/*%end*/
/*%if criteria.titleNotEnds != null  */
  TITLE NOT LIKE /* @suffix(criteria.titleNotEnds) */'smith'
/*%end*/
/*%if criteria.textEq != null */
  TEXT = /* criteria.textEq */'a'
/*%end*/
/*%if criteria.textNe != null */
  TEXT != /* criteria.textNe */'a'
/*%end*/
/*%if criteria.textLt != null */
  TEXT < /* criteria.textLt */'a'
/*%end*/
/*%if criteria.textLe != null */
  TEXT <= /* criteria.textLe */'a'
/*%end*/
/*%if criteria.textGt != null */
  TEXT > /* criteria.textLt */'a'
/*%end*/
/*%if criteria.textGe != null */
  TEXT >= /* criteria.textLe */'a'
/*%end*/
/*%if criteria.textIsNull  */
  TEXT IS NULL
/*%end*/
/*%if criteria.textIsNotNull  */
  TEXT IS NOT NULL
/*%end*/
/*%if criteria.textLike != null  */
  TEXT LIKE /* @infix(criteria.textLike) */'smith'
/*%end*/
/*%if criteria.textNotLike != null  */
  TEXT NOT LIKE /* @infix(criteria.textNotLike) */'smith'
/*%end*/
/*%if criteria.textStarts != null  */
  TEXT LIKE /* @prefix(criteria.textStarts) */'smith'
/*%end*/
/*%if criteria.textNotStarts != null  */
  TEXT NOT LIKE /* @prefix(criteria.textNotStarts) */'smith'
/*%end*/
/*%if criteria.textEnds != null  */
  TEXT LIKE /* @suffix(criteria.textEnds) */'smith'
/*%end*/
/*%if criteria.textNotEnds != null  */
  TEXT NOT LIKE /* @suffix(criteria.textNotEnds) */'smith'
/*%end*/
/*%if criteria.registTimeEq != null */
  REGIST_TIME = /* criteria.registTimeEq */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.registTimeNe != null */
  REGIST_TIME != /* criteria.registTimeNe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.registTimeLt != null */
  REGIST_TIME < /* criteria.registTimeLt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.registTimeLe != null */
  REGIST_TIME <= /* criteria.registTimeLe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.registTimeGt != null */
  REGIST_TIME > /* criteria.registTimeLt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.registTimeGe != null */
  REGIST_TIME >= /* criteria.registTimeLe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.registTimeIsNull  */
  REGIST_TIME IS NULL
/*%end*/
/*%if criteria.registTimeIsNotNull  */
  REGIST_TIME IS NOT NULL
/*%end*/
/*%if criteria.updateTimeEq != null */
  UPDATE_TIME = /* criteria.updateTimeEq */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updateTimeNe != null */
  UPDATE_TIME != /* criteria.updateTimeNe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updateTimeLt != null */
  UPDATE_TIME < /* criteria.updateTimeLt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updateTimeLe != null */
  UPDATE_TIME <= /* criteria.updateTimeLe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updateTimeGt != null */
  UPDATE_TIME > /* criteria.updateTimeLt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updateTimeGe != null */
  UPDATE_TIME >= /* criteria.updateTimeLe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updateTimeIsNull  */
  UPDATE_TIME IS NULL
/*%end*/
/*%if criteria.updateTimeIsNotNull  */
  UPDATE_TIME IS NOT NULL
/*%end*/
/*%if criteria.deleteFlgTrue  */
  DELETE_FLG = true
/*%end*/
/*%if criteria.deleteFlgFalse  */
  DELETE_FLG = false
/*%end*/
