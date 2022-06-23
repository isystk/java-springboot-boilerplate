--  自動生成のため原則修正禁止!!
SELECT
  /*%expand*/*
FROM
  stocks
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
/*%if criteria.nameEq != null */
  and name = /* criteria.nameEq */'a'
/*%end*/
/*%if criteria.nameNe != null */
  and name != /* criteria.nameNe */'a'
/*%end*/
/*%if criteria.nameLt != null */
  and name < /* criteria.nameLt */'a'
/*%end*/
/*%if criteria.nameLe != null */
  and name <= /* criteria.nameLe */'a'
/*%end*/
/*%if criteria.nameGt != null */
  and name > /* criteria.nameGt */'a'
/*%end*/
/*%if criteria.nameGe != null */
  and name >= /* criteria.nameGe */'a'
/*%end*/
/*%if criteria.nameIsNull  */
  and name IS NULL
/*%end*/
/*%if criteria.nameIsNotNull  */
  and name IS NOT NULL
/*%end*/
/*%if criteria.nameLike != null  */
  and name LIKE /* @infix(criteria.nameLike) */'smith'
/*%end*/
/*%if criteria.nameNotLike != null  */
  and name NOT LIKE /* @infix(criteria.nameNotLike) */'smith'
/*%end*/
/*%if criteria.nameStarts != null  */
  and name LIKE /* @prefix(criteria.nameStarts) */'smith'
/*%end*/
/*%if criteria.nameNotStarts != null  */
  and name NOT LIKE /* @prefix(criteria.nameNotStarts) */'smith'
/*%end*/
/*%if criteria.nameEnds != null  */
  and name LIKE /* @suffix(criteria.nameEnds) */'smith'
/*%end*/
/*%if criteria.nameNotEnds != null  */
  and name NOT LIKE /* @suffix(criteria.nameNotEnds) */'smith'
/*%end*/
/*%if criteria.detailEq != null */
  and detail = /* criteria.detailEq */'a'
/*%end*/
/*%if criteria.detailNe != null */
  and detail != /* criteria.detailNe */'a'
/*%end*/
/*%if criteria.detailLt != null */
  and detail < /* criteria.detailLt */'a'
/*%end*/
/*%if criteria.detailLe != null */
  and detail <= /* criteria.detailLe */'a'
/*%end*/
/*%if criteria.detailGt != null */
  and detail > /* criteria.detailGt */'a'
/*%end*/
/*%if criteria.detailGe != null */
  and detail >= /* criteria.detailGe */'a'
/*%end*/
/*%if criteria.detailIsNull  */
  and detail IS NULL
/*%end*/
/*%if criteria.detailIsNotNull  */
  and detail IS NOT NULL
/*%end*/
/*%if criteria.detailLike != null  */
  and detail LIKE /* @infix(criteria.detailLike) */'smith'
/*%end*/
/*%if criteria.detailNotLike != null  */
  and detail NOT LIKE /* @infix(criteria.detailNotLike) */'smith'
/*%end*/
/*%if criteria.detailStarts != null  */
  and detail LIKE /* @prefix(criteria.detailStarts) */'smith'
/*%end*/
/*%if criteria.detailNotStarts != null  */
  and detail NOT LIKE /* @prefix(criteria.detailNotStarts) */'smith'
/*%end*/
/*%if criteria.detailEnds != null  */
  and detail LIKE /* @suffix(criteria.detailEnds) */'smith'
/*%end*/
/*%if criteria.detailNotEnds != null  */
  and detail NOT LIKE /* @suffix(criteria.detailNotEnds) */'smith'
/*%end*/
/*%if criteria.priceEq != null */
  and price = /* criteria.priceEq */1
/*%end*/
/*%if criteria.priceNe != null */
  and price != /* criteria.priceNe */1
/*%end*/
/*%if criteria.priceLt != null */
  and price < /* criteria.priceLt */1
/*%end*/
/*%if criteria.priceLe != null */
  and price <= /* criteria.priceLe */1
/*%end*/
/*%if criteria.priceGt != null */
  and price > /* criteria.priceGt */1
/*%end*/
/*%if criteria.priceGe != null */
  and price >= /* criteria.priceGe */1
/*%end*/
/*%if criteria.priceIsNull  */
  and price IS NULL
/*%end*/
/*%if criteria.priceIsNotNull  */
  and price IS NOT NULL
/*%end*/
/*%if criteria.priceIn != null  */
  and price IN /* criteria.priceIn */(1,2,3)
/*%end*/
/*%if criteria.priceNotIn != null  */
  and price NOT IN /* criteria.priceNotIn */(1,2,3)
/*%end*/
/*%if criteria.imgpathEq != null */
  and imgpath = /* criteria.imgpathEq */'a'
/*%end*/
/*%if criteria.imgpathNe != null */
  and imgpath != /* criteria.imgpathNe */'a'
/*%end*/
/*%if criteria.imgpathLt != null */
  and imgpath < /* criteria.imgpathLt */'a'
/*%end*/
/*%if criteria.imgpathLe != null */
  and imgpath <= /* criteria.imgpathLe */'a'
/*%end*/
/*%if criteria.imgpathGt != null */
  and imgpath > /* criteria.imgpathGt */'a'
/*%end*/
/*%if criteria.imgpathGe != null */
  and imgpath >= /* criteria.imgpathGe */'a'
/*%end*/
/*%if criteria.imgpathIsNull  */
  and imgpath IS NULL
/*%end*/
/*%if criteria.imgpathIsNotNull  */
  and imgpath IS NOT NULL
/*%end*/
/*%if criteria.imgpathLike != null  */
  and imgpath LIKE /* @infix(criteria.imgpathLike) */'smith'
/*%end*/
/*%if criteria.imgpathNotLike != null  */
  and imgpath NOT LIKE /* @infix(criteria.imgpathNotLike) */'smith'
/*%end*/
/*%if criteria.imgpathStarts != null  */
  and imgpath LIKE /* @prefix(criteria.imgpathStarts) */'smith'
/*%end*/
/*%if criteria.imgpathNotStarts != null  */
  and imgpath NOT LIKE /* @prefix(criteria.imgpathNotStarts) */'smith'
/*%end*/
/*%if criteria.imgpathEnds != null  */
  and imgpath LIKE /* @suffix(criteria.imgpathEnds) */'smith'
/*%end*/
/*%if criteria.imgpathNotEnds != null  */
  and imgpath NOT LIKE /* @suffix(criteria.imgpathNotEnds) */'smith'
/*%end*/
/*%if criteria.quantityEq != null */
  and quantity = /* criteria.quantityEq */1
/*%end*/
/*%if criteria.quantityNe != null */
  and quantity != /* criteria.quantityNe */1
/*%end*/
/*%if criteria.quantityLt != null */
  and quantity < /* criteria.quantityLt */1
/*%end*/
/*%if criteria.quantityLe != null */
  and quantity <= /* criteria.quantityLe */1
/*%end*/
/*%if criteria.quantityGt != null */
  and quantity > /* criteria.quantityGt */1
/*%end*/
/*%if criteria.quantityGe != null */
  and quantity >= /* criteria.quantityGe */1
/*%end*/
/*%if criteria.quantityIsNull  */
  and quantity IS NULL
/*%end*/
/*%if criteria.quantityIsNotNull  */
  and quantity IS NOT NULL
/*%end*/
/*%if criteria.quantityIn != null  */
  and quantity IN /* criteria.quantityIn */(1,2,3)
/*%end*/
/*%if criteria.quantityNotIn != null  */
  and quantity NOT IN /* criteria.quantityNotIn */(1,2,3)
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
