--  自動生成のため原則修正禁止!!
SELECT
  /*%expand*/*
FROM
  t_staff
WHERE
/*%if criteria.staffIdEq != null */
  STAFF_ID = /* criteria.staffIdEq */1
/*%end*/
/*%if criteria.staffIdNe != null */
  STAFF_ID != /* criteria.staffIdNe */1
/*%end*/
/*%if criteria.staffIdLt != null */
  STAFF_ID < /* criteria.staffIdLt */1
/*%end*/
/*%if criteria.staffIdLe != null */
  STAFF_ID <= /* criteria.staffIdLe */1
/*%end*/
/*%if criteria.staffIdGt != null */
  STAFF_ID > /* criteria.staffIdLt */1
/*%end*/
/*%if criteria.staffIdGe != null */
  STAFF_ID >= /* criteria.staffIdLe */1
/*%end*/
/*%if criteria.staffIdIsNull  */
  STAFF_ID IS NULL
/*%end*/
/*%if criteria.staffIdIsNotNull  */
  STAFF_ID IS NOT NULL
/*%end*/
/*%if criteria.staffIdIn != null  */
  STAFF_ID IN /* criteria.staffIdIn */(1,2,3)
/*%end*/
/*%if criteria.staffIdNotIn != null  */
  STAFF_ID NOT IN /* criteria.staffIdNotIn */(1,2,3)
/*%end*/
/*%if criteria.emailEq != null */
  EMAIL = /* criteria.emailEq */'a'
/*%end*/
/*%if criteria.emailNe != null */
  EMAIL != /* criteria.emailNe */'a'
/*%end*/
/*%if criteria.emailLt != null */
  EMAIL < /* criteria.emailLt */'a'
/*%end*/
/*%if criteria.emailLe != null */
  EMAIL <= /* criteria.emailLe */'a'
/*%end*/
/*%if criteria.emailGt != null */
  EMAIL > /* criteria.emailLt */'a'
/*%end*/
/*%if criteria.emailGe != null */
  EMAIL >= /* criteria.emailLe */'a'
/*%end*/
/*%if criteria.emailIsNull  */
  EMAIL IS NULL
/*%end*/
/*%if criteria.emailIsNotNull  */
  EMAIL IS NOT NULL
/*%end*/
/*%if criteria.emailLike != null  */
  EMAIL LIKE /* @infix(criteria.emailLike) */'smith'
/*%end*/
/*%if criteria.emailNotLike != null  */
  EMAIL NOT LIKE /* @infix(criteria.emailNotLike) */'smith'
/*%end*/
/*%if criteria.emailStarts != null  */
  EMAIL LIKE /* @prefix(criteria.emailStarts) */'smith'
/*%end*/
/*%if criteria.emailNotStarts != null  */
  EMAIL NOT LIKE /* @prefix(criteria.emailNotStarts) */'smith'
/*%end*/
/*%if criteria.emailEnds != null  */
  EMAIL LIKE /* @suffix(criteria.emailEnds) */'smith'
/*%end*/
/*%if criteria.emailNotEnds != null  */
  EMAIL NOT LIKE /* @suffix(criteria.emailNotEnds) */'smith'
/*%end*/
/*%if criteria.passwordEq != null */
  PASSWORD = /* criteria.passwordEq */'a'
/*%end*/
/*%if criteria.passwordNe != null */
  PASSWORD != /* criteria.passwordNe */'a'
/*%end*/
/*%if criteria.passwordLt != null */
  PASSWORD < /* criteria.passwordLt */'a'
/*%end*/
/*%if criteria.passwordLe != null */
  PASSWORD <= /* criteria.passwordLe */'a'
/*%end*/
/*%if criteria.passwordGt != null */
  PASSWORD > /* criteria.passwordLt */'a'
/*%end*/
/*%if criteria.passwordGe != null */
  PASSWORD >= /* criteria.passwordLe */'a'
/*%end*/
/*%if criteria.passwordIsNull  */
  PASSWORD IS NULL
/*%end*/
/*%if criteria.passwordIsNotNull  */
  PASSWORD IS NOT NULL
/*%end*/
/*%if criteria.passwordLike != null  */
  PASSWORD LIKE /* @infix(criteria.passwordLike) */'smith'
/*%end*/
/*%if criteria.passwordNotLike != null  */
  PASSWORD NOT LIKE /* @infix(criteria.passwordNotLike) */'smith'
/*%end*/
/*%if criteria.passwordStarts != null  */
  PASSWORD LIKE /* @prefix(criteria.passwordStarts) */'smith'
/*%end*/
/*%if criteria.passwordNotStarts != null  */
  PASSWORD NOT LIKE /* @prefix(criteria.passwordNotStarts) */'smith'
/*%end*/
/*%if criteria.passwordEnds != null  */
  PASSWORD LIKE /* @suffix(criteria.passwordEnds) */'smith'
/*%end*/
/*%if criteria.passwordNotEnds != null  */
  PASSWORD NOT LIKE /* @suffix(criteria.passwordNotEnds) */'smith'
/*%end*/
/*%if criteria.familyNameEq != null */
  FAMILY_NAME = /* criteria.familyNameEq */'a'
/*%end*/
/*%if criteria.familyNameNe != null */
  FAMILY_NAME != /* criteria.familyNameNe */'a'
/*%end*/
/*%if criteria.familyNameLt != null */
  FAMILY_NAME < /* criteria.familyNameLt */'a'
/*%end*/
/*%if criteria.familyNameLe != null */
  FAMILY_NAME <= /* criteria.familyNameLe */'a'
/*%end*/
/*%if criteria.familyNameGt != null */
  FAMILY_NAME > /* criteria.familyNameLt */'a'
/*%end*/
/*%if criteria.familyNameGe != null */
  FAMILY_NAME >= /* criteria.familyNameLe */'a'
/*%end*/
/*%if criteria.familyNameIsNull  */
  FAMILY_NAME IS NULL
/*%end*/
/*%if criteria.familyNameIsNotNull  */
  FAMILY_NAME IS NOT NULL
/*%end*/
/*%if criteria.familyNameLike != null  */
  FAMILY_NAME LIKE /* @infix(criteria.familyNameLike) */'smith'
/*%end*/
/*%if criteria.familyNameNotLike != null  */
  FAMILY_NAME NOT LIKE /* @infix(criteria.familyNameNotLike) */'smith'
/*%end*/
/*%if criteria.familyNameStarts != null  */
  FAMILY_NAME LIKE /* @prefix(criteria.familyNameStarts) */'smith'
/*%end*/
/*%if criteria.familyNameNotStarts != null  */
  FAMILY_NAME NOT LIKE /* @prefix(criteria.familyNameNotStarts) */'smith'
/*%end*/
/*%if criteria.familyNameEnds != null  */
  FAMILY_NAME LIKE /* @suffix(criteria.familyNameEnds) */'smith'
/*%end*/
/*%if criteria.familyNameNotEnds != null  */
  FAMILY_NAME NOT LIKE /* @suffix(criteria.familyNameNotEnds) */'smith'
/*%end*/
/*%if criteria.nameEq != null */
  NAME = /* criteria.nameEq */'a'
/*%end*/
/*%if criteria.nameNe != null */
  NAME != /* criteria.nameNe */'a'
/*%end*/
/*%if criteria.nameLt != null */
  NAME < /* criteria.nameLt */'a'
/*%end*/
/*%if criteria.nameLe != null */
  NAME <= /* criteria.nameLe */'a'
/*%end*/
/*%if criteria.nameGt != null */
  NAME > /* criteria.nameLt */'a'
/*%end*/
/*%if criteria.nameGe != null */
  NAME >= /* criteria.nameLe */'a'
/*%end*/
/*%if criteria.nameIsNull  */
  NAME IS NULL
/*%end*/
/*%if criteria.nameIsNotNull  */
  NAME IS NOT NULL
/*%end*/
/*%if criteria.nameLike != null  */
  NAME LIKE /* @infix(criteria.nameLike) */'smith'
/*%end*/
/*%if criteria.nameNotLike != null  */
  NAME NOT LIKE /* @infix(criteria.nameNotLike) */'smith'
/*%end*/
/*%if criteria.nameStarts != null  */
  NAME LIKE /* @prefix(criteria.nameStarts) */'smith'
/*%end*/
/*%if criteria.nameNotStarts != null  */
  NAME NOT LIKE /* @prefix(criteria.nameNotStarts) */'smith'
/*%end*/
/*%if criteria.nameEnds != null  */
  NAME LIKE /* @suffix(criteria.nameEnds) */'smith'
/*%end*/
/*%if criteria.nameNotEnds != null  */
  NAME NOT LIKE /* @suffix(criteria.nameNotEnds) */'smith'
/*%end*/
/*%if criteria.familyNameKanaEq != null */
  FAMILY_NAME_KANA = /* criteria.familyNameKanaEq */'a'
/*%end*/
/*%if criteria.familyNameKanaNe != null */
  FAMILY_NAME_KANA != /* criteria.familyNameKanaNe */'a'
/*%end*/
/*%if criteria.familyNameKanaLt != null */
  FAMILY_NAME_KANA < /* criteria.familyNameKanaLt */'a'
/*%end*/
/*%if criteria.familyNameKanaLe != null */
  FAMILY_NAME_KANA <= /* criteria.familyNameKanaLe */'a'
/*%end*/
/*%if criteria.familyNameKanaGt != null */
  FAMILY_NAME_KANA > /* criteria.familyNameKanaLt */'a'
/*%end*/
/*%if criteria.familyNameKanaGe != null */
  FAMILY_NAME_KANA >= /* criteria.familyNameKanaLe */'a'
/*%end*/
/*%if criteria.familyNameKanaIsNull  */
  FAMILY_NAME_KANA IS NULL
/*%end*/
/*%if criteria.familyNameKanaIsNotNull  */
  FAMILY_NAME_KANA IS NOT NULL
/*%end*/
/*%if criteria.familyNameKanaLike != null  */
  FAMILY_NAME_KANA LIKE /* @infix(criteria.familyNameKanaLike) */'smith'
/*%end*/
/*%if criteria.familyNameKanaNotLike != null  */
  FAMILY_NAME_KANA NOT LIKE /* @infix(criteria.familyNameKanaNotLike) */'smith'
/*%end*/
/*%if criteria.familyNameKanaStarts != null  */
  FAMILY_NAME_KANA LIKE /* @prefix(criteria.familyNameKanaStarts) */'smith'
/*%end*/
/*%if criteria.familyNameKanaNotStarts != null  */
  FAMILY_NAME_KANA NOT LIKE /* @prefix(criteria.familyNameKanaNotStarts) */'smith'
/*%end*/
/*%if criteria.familyNameKanaEnds != null  */
  FAMILY_NAME_KANA LIKE /* @suffix(criteria.familyNameKanaEnds) */'smith'
/*%end*/
/*%if criteria.familyNameKanaNotEnds != null  */
  FAMILY_NAME_KANA NOT LIKE /* @suffix(criteria.familyNameKanaNotEnds) */'smith'
/*%end*/
/*%if criteria.nameKanaEq != null */
  NAME_KANA = /* criteria.nameKanaEq */'a'
/*%end*/
/*%if criteria.nameKanaNe != null */
  NAME_KANA != /* criteria.nameKanaNe */'a'
/*%end*/
/*%if criteria.nameKanaLt != null */
  NAME_KANA < /* criteria.nameKanaLt */'a'
/*%end*/
/*%if criteria.nameKanaLe != null */
  NAME_KANA <= /* criteria.nameKanaLe */'a'
/*%end*/
/*%if criteria.nameKanaGt != null */
  NAME_KANA > /* criteria.nameKanaLt */'a'
/*%end*/
/*%if criteria.nameKanaGe != null */
  NAME_KANA >= /* criteria.nameKanaLe */'a'
/*%end*/
/*%if criteria.nameKanaIsNull  */
  NAME_KANA IS NULL
/*%end*/
/*%if criteria.nameKanaIsNotNull  */
  NAME_KANA IS NOT NULL
/*%end*/
/*%if criteria.nameKanaLike != null  */
  NAME_KANA LIKE /* @infix(criteria.nameKanaLike) */'smith'
/*%end*/
/*%if criteria.nameKanaNotLike != null  */
  NAME_KANA NOT LIKE /* @infix(criteria.nameKanaNotLike) */'smith'
/*%end*/
/*%if criteria.nameKanaStarts != null  */
  NAME_KANA LIKE /* @prefix(criteria.nameKanaStarts) */'smith'
/*%end*/
/*%if criteria.nameKanaNotStarts != null  */
  NAME_KANA NOT LIKE /* @prefix(criteria.nameKanaNotStarts) */'smith'
/*%end*/
/*%if criteria.nameKanaEnds != null  */
  NAME_KANA LIKE /* @suffix(criteria.nameKanaEnds) */'smith'
/*%end*/
/*%if criteria.nameKanaNotEnds != null  */
  NAME_KANA NOT LIKE /* @suffix(criteria.nameKanaNotEnds) */'smith'
/*%end*/
/*%if criteria.lastLoginTimeEq != null */
  LAST_LOGIN_TIME = /* criteria.lastLoginTimeEq */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.lastLoginTimeNe != null */
  LAST_LOGIN_TIME != /* criteria.lastLoginTimeNe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.lastLoginTimeLt != null */
  LAST_LOGIN_TIME < /* criteria.lastLoginTimeLt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.lastLoginTimeLe != null */
  LAST_LOGIN_TIME <= /* criteria.lastLoginTimeLe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.lastLoginTimeGt != null */
  LAST_LOGIN_TIME > /* criteria.lastLoginTimeLt */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.lastLoginTimeGe != null */
  LAST_LOGIN_TIME >= /* criteria.lastLoginTimeLe */'2010-01-23 12:34:56'
/*%end*/
/*%if criteria.lastLoginTimeIsNull  */
  LAST_LOGIN_TIME IS NULL
/*%end*/
/*%if criteria.lastLoginTimeIsNotNull  */
  LAST_LOGIN_TIME IS NOT NULL
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
