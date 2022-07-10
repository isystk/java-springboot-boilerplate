--  自動生成のため原則修正禁止!!
SELECT
  /*%expand*/*
FROM
  cart
WHERE
/*%if criteria.idEq != null */
  and id = /* criteria.idEq */1
/*%end*/
/*%if criteria.idNe != null */
  and id != /* criteria.idNe */1
/*%end*/
/*%if criteria.idLt != null */
  and id < /* criteria.idLt */1
/*%end*/
/*%if criteria.idLe != null */
  and id <= /* criteria.idLe */1
/*%end*/
/*%if criteria.idGt != null */
  and id > /* criteria.idGt */1
/*%end*/
/*%if criteria.idGe != null */
  and id >= /* criteria.idGe */1
/*%end*/
/*%if criteria.idIsNull  */
  and id IS NULL
/*%end*/
/*%if criteria.idIsNotNull  */
  and id IS NOT NULL
/*%end*/
/*%if criteria.idIn != null  */
  and id IN /* criteria.idIn */(1,2,3)
/*%end*/
/*%if criteria.idNotIn != null  */
  and id NOT IN /* criteria.idNotIn */(1,2,3)
/*%end*/
/*%if criteria.stockIdEq != null */
  and stock_id = /* criteria.stockIdEq */1
/*%end*/
/*%if criteria.stockIdNe != null */
  and stock_id != /* criteria.stockIdNe */1
/*%end*/
/*%if criteria.stockIdLt != null */
  and stock_id < /* criteria.stockIdLt */1
/*%end*/
/*%if criteria.stockIdLe != null */
  and stock_id <= /* criteria.stockIdLe */1
/*%end*/
/*%if criteria.stockIdGt != null */
  and stock_id > /* criteria.stockIdGt */1
/*%end*/
/*%if criteria.stockIdGe != null */
  and stock_id >= /* criteria.stockIdGe */1
/*%end*/
/*%if criteria.stockIdIsNull  */
  and stock_id IS NULL
/*%end*/
/*%if criteria.stockIdIsNotNull  */
  and stock_id IS NOT NULL
/*%end*/
/*%if criteria.stockIdIn != null  */
  and stock_id IN /* criteria.stockIdIn */(1,2,3)
/*%end*/
/*%if criteria.stockIdNotIn != null  */
  and stock_id NOT IN /* criteria.stockIdNotIn */(1,2,3)
/*%end*/
/*%if criteria.userIdEq != null */
  and user_id = /* criteria.userIdEq */1
/*%end*/
/*%if criteria.userIdNe != null */
  and user_id != /* criteria.userIdNe */1
/*%end*/
/*%if criteria.userIdLt != null */
  and user_id < /* criteria.userIdLt */1
/*%end*/
/*%if criteria.userIdLe != null */
  and user_id <= /* criteria.userIdLe */1
/*%end*/
/*%if criteria.userIdGt != null */
  and user_id > /* criteria.userIdGt */1
/*%end*/
/*%if criteria.userIdGe != null */
  and user_id >= /* criteria.userIdGe */1
/*%end*/
/*%if criteria.userIdIsNull  */
  and user_id IS NULL
/*%end*/
/*%if criteria.userIdIsNotNull  */
  and user_id IS NOT NULL
/*%end*/
/*%if criteria.userIdIn != null  */
  and user_id IN /* criteria.userIdIn */(1,2,3)
/*%end*/
/*%if criteria.userIdNotIn != null  */
  and user_id NOT IN /* criteria.userIdNotIn */(1,2,3)
/*%end*/
/*%if criteria.createdAtEq != null */
  and created_at = /* criteria.createdAtEq */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.createdAtNe != null */
  and created_at != /* criteria.createdAtNe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.createdAtLt != null */
  and created_at < /* criteria.createdAtLt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.createdAtLe != null */
  and created_at <= /* criteria.createdAtLe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.createdAtGt != null */
  and created_at > /* criteria.createdAtGt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.createdAtGe != null */
  and created_at >= /* criteria.createdAtGe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.createdAtIsNull  */
  and created_at IS NULL
/*%end*/
/*%if criteria.createdAtIsNotNull  */
  and created_at IS NOT NULL
/*%end*/
/*%if criteria.updatedAtEq != null */
  and updated_at = /* criteria.updatedAtEq */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updatedAtNe != null */
  and updated_at != /* criteria.updatedAtNe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updatedAtLt != null */
  and updated_at < /* criteria.updatedAtLt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updatedAtLe != null */
  and updated_at <= /* criteria.updatedAtLe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updatedAtGt != null */
  and updated_at > /* criteria.updatedAtGt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updatedAtGe != null */
  and updated_at >= /* criteria.updatedAtGe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.updatedAtIsNull  */
  and updated_at IS NULL
/*%end*/
/*%if criteria.updatedAtIsNotNull  */
  and updated_at IS NOT NULL
/*%end*/
/*%if criteria.deleteFlgTrue  */
  and delete_flg = true
/*%end*/
/*%if criteria.deleteFlgFalse  */
  and delete_flg = false
/*%end*/
/*# criteria.orderBy */
