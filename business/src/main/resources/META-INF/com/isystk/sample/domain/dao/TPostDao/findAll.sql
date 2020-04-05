--  自動生成のため原則修正禁止!!
SELECT
  /*%expand*/*
FROM
  t_post
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
/*%if criteria.userIdEq != null */
  and USER_ID = /* criteria.userIdEq */1
/*%end*/
/*%if criteria.userIdNe != null */
  and USER_ID != /* criteria.userIdNe */1
/*%end*/
/*%if criteria.userIdLt != null */
  and USER_ID < /* criteria.userIdLt */1
/*%end*/
/*%if criteria.userIdLe != null */
  and USER_ID <= /* criteria.userIdLe */1
/*%end*/
/*%if criteria.userIdGt != null */
  and USER_ID > /* criteria.userIdGt */1
/*%end*/
/*%if criteria.userIdGe != null */
  and USER_ID >= /* criteria.userIdGe */1
/*%end*/
/*%if criteria.userIdIsNull  */
  and USER_ID IS NULL
/*%end*/
/*%if criteria.userIdIsNotNull  */
  and USER_ID IS NOT NULL
/*%end*/
/*%if criteria.userIdIn != null  */
  and USER_ID IN /* criteria.userIdIn */(1,2,3)
/*%end*/
/*%if criteria.userIdNotIn != null  */
  and USER_ID NOT IN /* criteria.userIdNotIn */(1,2,3)
/*%end*/
/*%if criteria.titleEq != null */
  and TITLE = /* criteria.titleEq */'a'
/*%end*/
/*%if criteria.titleNe != null */
  and TITLE != /* criteria.titleNe */'a'
/*%end*/
/*%if criteria.titleLt != null */
  and TITLE < /* criteria.titleLt */'a'
/*%end*/
/*%if criteria.titleLe != null */
  and TITLE <= /* criteria.titleLe */'a'
/*%end*/
/*%if criteria.titleGt != null */
  and TITLE > /* criteria.titleGt */'a'
/*%end*/
/*%if criteria.titleGe != null */
  and TITLE >= /* criteria.titleGe */'a'
/*%end*/
/*%if criteria.titleIsNull  */
  and TITLE IS NULL
/*%end*/
/*%if criteria.titleIsNotNull  */
  and TITLE IS NOT NULL
/*%end*/
/*%if criteria.titleLike != null  */
  and TITLE LIKE /* @infix(criteria.titleLike) */'smith'
/*%end*/
/*%if criteria.titleNotLike != null  */
  and TITLE NOT LIKE /* @infix(criteria.titleNotLike) */'smith'
/*%end*/
/*%if criteria.titleStarts != null  */
  and TITLE LIKE /* @prefix(criteria.titleStarts) */'smith'
/*%end*/
/*%if criteria.titleNotStarts != null  */
  and TITLE NOT LIKE /* @prefix(criteria.titleNotStarts) */'smith'
/*%end*/
/*%if criteria.titleEnds != null  */
  and TITLE LIKE /* @suffix(criteria.titleEnds) */'smith'
/*%end*/
/*%if criteria.titleNotEnds != null  */
  and TITLE NOT LIKE /* @suffix(criteria.titleNotEnds) */'smith'
/*%end*/
/*%if criteria.textEq != null */
  and TEXT = /* criteria.textEq */'a'
/*%end*/
/*%if criteria.textNe != null */
  and TEXT != /* criteria.textNe */'a'
/*%end*/
/*%if criteria.textLt != null */
  and TEXT < /* criteria.textLt */'a'
/*%end*/
/*%if criteria.textLe != null */
  and TEXT <= /* criteria.textLe */'a'
/*%end*/
/*%if criteria.textGt != null */
  and TEXT > /* criteria.textGt */'a'
/*%end*/
/*%if criteria.textGe != null */
  and TEXT >= /* criteria.textGe */'a'
/*%end*/
/*%if criteria.textIsNull  */
  and TEXT IS NULL
/*%end*/
/*%if criteria.textIsNotNull  */
  and TEXT IS NOT NULL
/*%end*/
/*%if criteria.textLike != null  */
  and TEXT LIKE /* @infix(criteria.textLike) */'smith'
/*%end*/
/*%if criteria.textNotLike != null  */
  and TEXT NOT LIKE /* @infix(criteria.textNotLike) */'smith'
/*%end*/
/*%if criteria.textStarts != null  */
  and TEXT LIKE /* @prefix(criteria.textStarts) */'smith'
/*%end*/
/*%if criteria.textNotStarts != null  */
  and TEXT NOT LIKE /* @prefix(criteria.textNotStarts) */'smith'
/*%end*/
/*%if criteria.textEnds != null  */
  and TEXT LIKE /* @suffix(criteria.textEnds) */'smith'
/*%end*/
/*%if criteria.textNotEnds != null  */
  and TEXT NOT LIKE /* @suffix(criteria.textNotEnds) */'smith'
/*%end*/
/*%if criteria.registTimeEq != null */
  and REGIST_TIME = /* criteria.registTimeEq */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.registTimeNe != null */
  and REGIST_TIME != /* criteria.registTimeNe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.registTimeLt != null */
  and REGIST_TIME < /* criteria.registTimeLt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.registTimeLe != null */
  and REGIST_TIME <= /* criteria.registTimeLe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.registTimeGt != null */
  and REGIST_TIME > /* criteria.registTimeGt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.registTimeGe != null */
  and REGIST_TIME >= /* criteria.registTimeGe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.registTimeIsNull  */
  and REGIST_TIME IS NULL
/*%end*/
/*%if criteria.registTimeIsNotNull  */
  and REGIST_TIME IS NOT NULL
/*%end*/
/*%if criteria.updateTimeEq != null */
  and UPDATE_TIME = /* criteria.updateTimeEq */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updateTimeNe != null */
  and UPDATE_TIME != /* criteria.updateTimeNe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updateTimeLt != null */
  and UPDATE_TIME < /* criteria.updateTimeLt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updateTimeLe != null */
  and UPDATE_TIME <= /* criteria.updateTimeLe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updateTimeGt != null */
  and UPDATE_TIME > /* criteria.updateTimeGt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updateTimeGe != null */
  and UPDATE_TIME >= /* criteria.updateTimeGe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updateTimeIsNull  */
  and UPDATE_TIME IS NULL
/*%end*/
/*%if criteria.updateTimeIsNotNull  */
  and UPDATE_TIME IS NOT NULL
/*%end*/
/*%if criteria.deleteFlgTrue  */
  and DELETE_FLG = true
/*%end*/
/*%if criteria.deleteFlgFalse  */
  and DELETE_FLG = false
/*%end*/
/*# criteria.orderBy */
