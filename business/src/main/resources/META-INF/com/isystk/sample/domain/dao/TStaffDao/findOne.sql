--  自動生成のため原則修正禁止!!
SELECT
  /*%expand*/*
FROM
  t_staff
WHERE
/*%if criteria.staffIdEq != null */
  and STAFF_ID = /* criteria.staffIdEq */1
/*%end*/
/*%if criteria.staffIdNe != null */
  and STAFF_ID != /* criteria.staffIdNe */1
/*%end*/
/*%if criteria.staffIdLt != null */
  and STAFF_ID < /* criteria.staffIdLt */1
/*%end*/
/*%if criteria.staffIdLe != null */
  and STAFF_ID <= /* criteria.staffIdLe */1
/*%end*/
/*%if criteria.staffIdGt != null */
  and STAFF_ID > /* criteria.staffIdGt */1
/*%end*/
/*%if criteria.staffIdGe != null */
  and STAFF_ID >= /* criteria.staffIdGe */1
/*%end*/
/*%if criteria.staffIdIsNull  */
  and STAFF_ID IS NULL
/*%end*/
/*%if criteria.staffIdIsNotNull  */
  and STAFF_ID IS NOT NULL
/*%end*/
/*%if criteria.staffIdIn != null  */
  and STAFF_ID IN /* criteria.staffIdIn */(1,2,3)
/*%end*/
/*%if criteria.staffIdNotIn != null  */
  and STAFF_ID NOT IN /* criteria.staffIdNotIn */(1,2,3)
/*%end*/
/*%if criteria.emailEq != null */
  and EMAIL = /* criteria.emailEq */'a'
/*%end*/
/*%if criteria.emailNe != null */
  and EMAIL != /* criteria.emailNe */'a'
/*%end*/
/*%if criteria.emailLt != null */
  and EMAIL < /* criteria.emailLt */'a'
/*%end*/
/*%if criteria.emailLe != null */
  and EMAIL <= /* criteria.emailLe */'a'
/*%end*/
/*%if criteria.emailGt != null */
  and EMAIL > /* criteria.emailGt */'a'
/*%end*/
/*%if criteria.emailGe != null */
  and EMAIL >= /* criteria.emailGe */'a'
/*%end*/
/*%if criteria.emailIsNull  */
  and EMAIL IS NULL
/*%end*/
/*%if criteria.emailIsNotNull  */
  and EMAIL IS NOT NULL
/*%end*/
/*%if criteria.emailLike != null  */
  and EMAIL LIKE /* @infix(criteria.emailLike) */'smith'
/*%end*/
/*%if criteria.emailNotLike != null  */
  and EMAIL NOT LIKE /* @infix(criteria.emailNotLike) */'smith'
/*%end*/
/*%if criteria.emailStarts != null  */
  and EMAIL LIKE /* @prefix(criteria.emailStarts) */'smith'
/*%end*/
/*%if criteria.emailNotStarts != null  */
  and EMAIL NOT LIKE /* @prefix(criteria.emailNotStarts) */'smith'
/*%end*/
/*%if criteria.emailEnds != null  */
  and EMAIL LIKE /* @suffix(criteria.emailEnds) */'smith'
/*%end*/
/*%if criteria.emailNotEnds != null  */
  and EMAIL NOT LIKE /* @suffix(criteria.emailNotEnds) */'smith'
/*%end*/
/*%if criteria.passwordEq != null */
  and PASSWORD = /* criteria.passwordEq */'a'
/*%end*/
/*%if criteria.passwordNe != null */
  and PASSWORD != /* criteria.passwordNe */'a'
/*%end*/
/*%if criteria.passwordLt != null */
  and PASSWORD < /* criteria.passwordLt */'a'
/*%end*/
/*%if criteria.passwordLe != null */
  and PASSWORD <= /* criteria.passwordLe */'a'
/*%end*/
/*%if criteria.passwordGt != null */
  and PASSWORD > /* criteria.passwordGt */'a'
/*%end*/
/*%if criteria.passwordGe != null */
  and PASSWORD >= /* criteria.passwordGe */'a'
/*%end*/
/*%if criteria.passwordIsNull  */
  and PASSWORD IS NULL
/*%end*/
/*%if criteria.passwordIsNotNull  */
  and PASSWORD IS NOT NULL
/*%end*/
/*%if criteria.passwordLike != null  */
  and PASSWORD LIKE /* @infix(criteria.passwordLike) */'smith'
/*%end*/
/*%if criteria.passwordNotLike != null  */
  and PASSWORD NOT LIKE /* @infix(criteria.passwordNotLike) */'smith'
/*%end*/
/*%if criteria.passwordStarts != null  */
  and PASSWORD LIKE /* @prefix(criteria.passwordStarts) */'smith'
/*%end*/
/*%if criteria.passwordNotStarts != null  */
  and PASSWORD NOT LIKE /* @prefix(criteria.passwordNotStarts) */'smith'
/*%end*/
/*%if criteria.passwordEnds != null  */
  and PASSWORD LIKE /* @suffix(criteria.passwordEnds) */'smith'
/*%end*/
/*%if criteria.passwordNotEnds != null  */
  and PASSWORD NOT LIKE /* @suffix(criteria.passwordNotEnds) */'smith'
/*%end*/
/*%if criteria.familyNameEq != null */
  and FAMILY_NAME = /* criteria.familyNameEq */'a'
/*%end*/
/*%if criteria.familyNameNe != null */
  and FAMILY_NAME != /* criteria.familyNameNe */'a'
/*%end*/
/*%if criteria.familyNameLt != null */
  and FAMILY_NAME < /* criteria.familyNameLt */'a'
/*%end*/
/*%if criteria.familyNameLe != null */
  and FAMILY_NAME <= /* criteria.familyNameLe */'a'
/*%end*/
/*%if criteria.familyNameGt != null */
  and FAMILY_NAME > /* criteria.familyNameGt */'a'
/*%end*/
/*%if criteria.familyNameGe != null */
  and FAMILY_NAME >= /* criteria.familyNameGe */'a'
/*%end*/
/*%if criteria.familyNameIsNull  */
  and FAMILY_NAME IS NULL
/*%end*/
/*%if criteria.familyNameIsNotNull  */
  and FAMILY_NAME IS NOT NULL
/*%end*/
/*%if criteria.familyNameLike != null  */
  and FAMILY_NAME LIKE /* @infix(criteria.familyNameLike) */'smith'
/*%end*/
/*%if criteria.familyNameNotLike != null  */
  and FAMILY_NAME NOT LIKE /* @infix(criteria.familyNameNotLike) */'smith'
/*%end*/
/*%if criteria.familyNameStarts != null  */
  and FAMILY_NAME LIKE /* @prefix(criteria.familyNameStarts) */'smith'
/*%end*/
/*%if criteria.familyNameNotStarts != null  */
  and FAMILY_NAME NOT LIKE /* @prefix(criteria.familyNameNotStarts) */'smith'
/*%end*/
/*%if criteria.familyNameEnds != null  */
  and FAMILY_NAME LIKE /* @suffix(criteria.familyNameEnds) */'smith'
/*%end*/
/*%if criteria.familyNameNotEnds != null  */
  and FAMILY_NAME NOT LIKE /* @suffix(criteria.familyNameNotEnds) */'smith'
/*%end*/
/*%if criteria.nameEq != null */
  and NAME = /* criteria.nameEq */'a'
/*%end*/
/*%if criteria.nameNe != null */
  and NAME != /* criteria.nameNe */'a'
/*%end*/
/*%if criteria.nameLt != null */
  and NAME < /* criteria.nameLt */'a'
/*%end*/
/*%if criteria.nameLe != null */
  and NAME <= /* criteria.nameLe */'a'
/*%end*/
/*%if criteria.nameGt != null */
  and NAME > /* criteria.nameGt */'a'
/*%end*/
/*%if criteria.nameGe != null */
  and NAME >= /* criteria.nameGe */'a'
/*%end*/
/*%if criteria.nameIsNull  */
  and NAME IS NULL
/*%end*/
/*%if criteria.nameIsNotNull  */
  and NAME IS NOT NULL
/*%end*/
/*%if criteria.nameLike != null  */
  and NAME LIKE /* @infix(criteria.nameLike) */'smith'
/*%end*/
/*%if criteria.nameNotLike != null  */
  and NAME NOT LIKE /* @infix(criteria.nameNotLike) */'smith'
/*%end*/
/*%if criteria.nameStarts != null  */
  and NAME LIKE /* @prefix(criteria.nameStarts) */'smith'
/*%end*/
/*%if criteria.nameNotStarts != null  */
  and NAME NOT LIKE /* @prefix(criteria.nameNotStarts) */'smith'
/*%end*/
/*%if criteria.nameEnds != null  */
  and NAME LIKE /* @suffix(criteria.nameEnds) */'smith'
/*%end*/
/*%if criteria.nameNotEnds != null  */
  and NAME NOT LIKE /* @suffix(criteria.nameNotEnds) */'smith'
/*%end*/
/*%if criteria.familyNameKanaEq != null */
  and FAMILY_NAME_KANA = /* criteria.familyNameKanaEq */'a'
/*%end*/
/*%if criteria.familyNameKanaNe != null */
  and FAMILY_NAME_KANA != /* criteria.familyNameKanaNe */'a'
/*%end*/
/*%if criteria.familyNameKanaLt != null */
  and FAMILY_NAME_KANA < /* criteria.familyNameKanaLt */'a'
/*%end*/
/*%if criteria.familyNameKanaLe != null */
  and FAMILY_NAME_KANA <= /* criteria.familyNameKanaLe */'a'
/*%end*/
/*%if criteria.familyNameKanaGt != null */
  and FAMILY_NAME_KANA > /* criteria.familyNameKanaGt */'a'
/*%end*/
/*%if criteria.familyNameKanaGe != null */
  and FAMILY_NAME_KANA >= /* criteria.familyNameKanaGe */'a'
/*%end*/
/*%if criteria.familyNameKanaIsNull  */
  and FAMILY_NAME_KANA IS NULL
/*%end*/
/*%if criteria.familyNameKanaIsNotNull  */
  and FAMILY_NAME_KANA IS NOT NULL
/*%end*/
/*%if criteria.familyNameKanaLike != null  */
  and FAMILY_NAME_KANA LIKE /* @infix(criteria.familyNameKanaLike) */'smith'
/*%end*/
/*%if criteria.familyNameKanaNotLike != null  */
  and FAMILY_NAME_KANA NOT LIKE /* @infix(criteria.familyNameKanaNotLike) */'smith'
/*%end*/
/*%if criteria.familyNameKanaStarts != null  */
  and FAMILY_NAME_KANA LIKE /* @prefix(criteria.familyNameKanaStarts) */'smith'
/*%end*/
/*%if criteria.familyNameKanaNotStarts != null  */
  and FAMILY_NAME_KANA NOT LIKE /* @prefix(criteria.familyNameKanaNotStarts) */'smith'
/*%end*/
/*%if criteria.familyNameKanaEnds != null  */
  and FAMILY_NAME_KANA LIKE /* @suffix(criteria.familyNameKanaEnds) */'smith'
/*%end*/
/*%if criteria.familyNameKanaNotEnds != null  */
  and FAMILY_NAME_KANA NOT LIKE /* @suffix(criteria.familyNameKanaNotEnds) */'smith'
/*%end*/
/*%if criteria.nameKanaEq != null */
  and NAME_KANA = /* criteria.nameKanaEq */'a'
/*%end*/
/*%if criteria.nameKanaNe != null */
  and NAME_KANA != /* criteria.nameKanaNe */'a'
/*%end*/
/*%if criteria.nameKanaLt != null */
  and NAME_KANA < /* criteria.nameKanaLt */'a'
/*%end*/
/*%if criteria.nameKanaLe != null */
  and NAME_KANA <= /* criteria.nameKanaLe */'a'
/*%end*/
/*%if criteria.nameKanaGt != null */
  and NAME_KANA > /* criteria.nameKanaGt */'a'
/*%end*/
/*%if criteria.nameKanaGe != null */
  and NAME_KANA >= /* criteria.nameKanaGe */'a'
/*%end*/
/*%if criteria.nameKanaIsNull  */
  and NAME_KANA IS NULL
/*%end*/
/*%if criteria.nameKanaIsNotNull  */
  and NAME_KANA IS NOT NULL
/*%end*/
/*%if criteria.nameKanaLike != null  */
  and NAME_KANA LIKE /* @infix(criteria.nameKanaLike) */'smith'
/*%end*/
/*%if criteria.nameKanaNotLike != null  */
  and NAME_KANA NOT LIKE /* @infix(criteria.nameKanaNotLike) */'smith'
/*%end*/
/*%if criteria.nameKanaStarts != null  */
  and NAME_KANA LIKE /* @prefix(criteria.nameKanaStarts) */'smith'
/*%end*/
/*%if criteria.nameKanaNotStarts != null  */
  and NAME_KANA NOT LIKE /* @prefix(criteria.nameKanaNotStarts) */'smith'
/*%end*/
/*%if criteria.nameKanaEnds != null  */
  and NAME_KANA LIKE /* @suffix(criteria.nameKanaEnds) */'smith'
/*%end*/
/*%if criteria.nameKanaNotEnds != null  */
  and NAME_KANA NOT LIKE /* @suffix(criteria.nameKanaNotEnds) */'smith'
/*%end*/
/*%if criteria.lastLoginTimeEq != null */
  and LAST_LOGIN_TIME = /* criteria.lastLoginTimeEq */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.lastLoginTimeNe != null */
  and LAST_LOGIN_TIME != /* criteria.lastLoginTimeNe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.lastLoginTimeLt != null */
  and LAST_LOGIN_TIME < /* criteria.lastLoginTimeLt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.lastLoginTimeLe != null */
  and LAST_LOGIN_TIME <= /* criteria.lastLoginTimeLe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.lastLoginTimeGt != null */
  and LAST_LOGIN_TIME > /* criteria.lastLoginTimeGt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.lastLoginTimeGe != null */
  and LAST_LOGIN_TIME >= /* criteria.lastLoginTimeGe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.lastLoginTimeIsNull  */
  and LAST_LOGIN_TIME IS NULL
/*%end*/
/*%if criteria.lastLoginTimeIsNotNull  */
  and LAST_LOGIN_TIME IS NOT NULL
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
