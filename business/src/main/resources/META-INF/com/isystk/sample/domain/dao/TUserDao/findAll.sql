--  自動生成のため原則修正禁止!!
SELECT
  /*%expand*/*
FROM
  t_user
WHERE
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
/*%if criteria.zipEq != null */
  ZIP = /* criteria.zipEq */'a'
/*%end*/
/*%if criteria.zipNe != null */
  ZIP != /* criteria.zipNe */'a'
/*%end*/
/*%if criteria.zipLt != null */
  ZIP < /* criteria.zipLt */'a'
/*%end*/
/*%if criteria.zipLe != null */
  ZIP <= /* criteria.zipLe */'a'
/*%end*/
/*%if criteria.zipGt != null */
  ZIP > /* criteria.zipLt */'a'
/*%end*/
/*%if criteria.zipGe != null */
  ZIP >= /* criteria.zipLe */'a'
/*%end*/
/*%if criteria.zipIsNull  */
  ZIP IS NULL
/*%end*/
/*%if criteria.zipIsNotNull  */
  ZIP IS NOT NULL
/*%end*/
/*%if criteria.zipLike != null  */
  ZIP LIKE /* @infix(criteria.zipLike) */'smith'
/*%end*/
/*%if criteria.zipNotLike != null  */
  ZIP NOT LIKE /* @infix(criteria.zipNotLike) */'smith'
/*%end*/
/*%if criteria.zipStarts != null  */
  ZIP LIKE /* @prefix(criteria.zipStarts) */'smith'
/*%end*/
/*%if criteria.zipNotStarts != null  */
  ZIP NOT LIKE /* @prefix(criteria.zipNotStarts) */'smith'
/*%end*/
/*%if criteria.zipEnds != null  */
  ZIP LIKE /* @suffix(criteria.zipEnds) */'smith'
/*%end*/
/*%if criteria.zipNotEnds != null  */
  ZIP NOT LIKE /* @suffix(criteria.zipNotEnds) */'smith'
/*%end*/
/*%if criteria.prefectureIdEq != null */
  PREFECTURE_ID = /* criteria.prefectureIdEq */1
/*%end*/
/*%if criteria.prefectureIdNe != null */
  PREFECTURE_ID != /* criteria.prefectureIdNe */1
/*%end*/
/*%if criteria.prefectureIdLt != null */
  PREFECTURE_ID < /* criteria.prefectureIdLt */1
/*%end*/
/*%if criteria.prefectureIdLe != null */
  PREFECTURE_ID <= /* criteria.prefectureIdLe */1
/*%end*/
/*%if criteria.prefectureIdGt != null */
  PREFECTURE_ID > /* criteria.prefectureIdLt */1
/*%end*/
/*%if criteria.prefectureIdGe != null */
  PREFECTURE_ID >= /* criteria.prefectureIdLe */1
/*%end*/
/*%if criteria.prefectureIdIsNull  */
  PREFECTURE_ID IS NULL
/*%end*/
/*%if criteria.prefectureIdIsNotNull  */
  PREFECTURE_ID IS NOT NULL
/*%end*/
/*%if criteria.prefectureIdIn != null  */
  PREFECTURE_ID IN /* criteria.prefectureIdIn */(1,2,3)
/*%end*/
/*%if criteria.prefectureIdNotIn != null  */
  PREFECTURE_ID NOT IN /* criteria.prefectureIdNotIn */(1,2,3)
/*%end*/
/*%if criteria.areaEq != null */
  AREA = /* criteria.areaEq */'a'
/*%end*/
/*%if criteria.areaNe != null */
  AREA != /* criteria.areaNe */'a'
/*%end*/
/*%if criteria.areaLt != null */
  AREA < /* criteria.areaLt */'a'
/*%end*/
/*%if criteria.areaLe != null */
  AREA <= /* criteria.areaLe */'a'
/*%end*/
/*%if criteria.areaGt != null */
  AREA > /* criteria.areaLt */'a'
/*%end*/
/*%if criteria.areaGe != null */
  AREA >= /* criteria.areaLe */'a'
/*%end*/
/*%if criteria.areaIsNull  */
  AREA IS NULL
/*%end*/
/*%if criteria.areaIsNotNull  */
  AREA IS NOT NULL
/*%end*/
/*%if criteria.areaLike != null  */
  AREA LIKE /* @infix(criteria.areaLike) */'smith'
/*%end*/
/*%if criteria.areaNotLike != null  */
  AREA NOT LIKE /* @infix(criteria.areaNotLike) */'smith'
/*%end*/
/*%if criteria.areaStarts != null  */
  AREA LIKE /* @prefix(criteria.areaStarts) */'smith'
/*%end*/
/*%if criteria.areaNotStarts != null  */
  AREA NOT LIKE /* @prefix(criteria.areaNotStarts) */'smith'
/*%end*/
/*%if criteria.areaEnds != null  */
  AREA LIKE /* @suffix(criteria.areaEnds) */'smith'
/*%end*/
/*%if criteria.areaNotEnds != null  */
  AREA NOT LIKE /* @suffix(criteria.areaNotEnds) */'smith'
/*%end*/
/*%if criteria.addressEq != null */
  ADDRESS = /* criteria.addressEq */'a'
/*%end*/
/*%if criteria.addressNe != null */
  ADDRESS != /* criteria.addressNe */'a'
/*%end*/
/*%if criteria.addressLt != null */
  ADDRESS < /* criteria.addressLt */'a'
/*%end*/
/*%if criteria.addressLe != null */
  ADDRESS <= /* criteria.addressLe */'a'
/*%end*/
/*%if criteria.addressGt != null */
  ADDRESS > /* criteria.addressLt */'a'
/*%end*/
/*%if criteria.addressGe != null */
  ADDRESS >= /* criteria.addressLe */'a'
/*%end*/
/*%if criteria.addressIsNull  */
  ADDRESS IS NULL
/*%end*/
/*%if criteria.addressIsNotNull  */
  ADDRESS IS NOT NULL
/*%end*/
/*%if criteria.addressLike != null  */
  ADDRESS LIKE /* @infix(criteria.addressLike) */'smith'
/*%end*/
/*%if criteria.addressNotLike != null  */
  ADDRESS NOT LIKE /* @infix(criteria.addressNotLike) */'smith'
/*%end*/
/*%if criteria.addressStarts != null  */
  ADDRESS LIKE /* @prefix(criteria.addressStarts) */'smith'
/*%end*/
/*%if criteria.addressNotStarts != null  */
  ADDRESS NOT LIKE /* @prefix(criteria.addressNotStarts) */'smith'
/*%end*/
/*%if criteria.addressEnds != null  */
  ADDRESS LIKE /* @suffix(criteria.addressEnds) */'smith'
/*%end*/
/*%if criteria.addressNotEnds != null  */
  ADDRESS NOT LIKE /* @suffix(criteria.addressNotEnds) */'smith'
/*%end*/
/*%if criteria.buildingEq != null */
  BUILDING = /* criteria.buildingEq */'a'
/*%end*/
/*%if criteria.buildingNe != null */
  BUILDING != /* criteria.buildingNe */'a'
/*%end*/
/*%if criteria.buildingLt != null */
  BUILDING < /* criteria.buildingLt */'a'
/*%end*/
/*%if criteria.buildingLe != null */
  BUILDING <= /* criteria.buildingLe */'a'
/*%end*/
/*%if criteria.buildingGt != null */
  BUILDING > /* criteria.buildingLt */'a'
/*%end*/
/*%if criteria.buildingGe != null */
  BUILDING >= /* criteria.buildingLe */'a'
/*%end*/
/*%if criteria.buildingIsNull  */
  BUILDING IS NULL
/*%end*/
/*%if criteria.buildingIsNotNull  */
  BUILDING IS NOT NULL
/*%end*/
/*%if criteria.buildingLike != null  */
  BUILDING LIKE /* @infix(criteria.buildingLike) */'smith'
/*%end*/
/*%if criteria.buildingNotLike != null  */
  BUILDING NOT LIKE /* @infix(criteria.buildingNotLike) */'smith'
/*%end*/
/*%if criteria.buildingStarts != null  */
  BUILDING LIKE /* @prefix(criteria.buildingStarts) */'smith'
/*%end*/
/*%if criteria.buildingNotStarts != null  */
  BUILDING NOT LIKE /* @prefix(criteria.buildingNotStarts) */'smith'
/*%end*/
/*%if criteria.buildingEnds != null  */
  BUILDING LIKE /* @suffix(criteria.buildingEnds) */'smith'
/*%end*/
/*%if criteria.buildingNotEnds != null  */
  BUILDING NOT LIKE /* @suffix(criteria.buildingNotEnds) */'smith'
/*%end*/
/*%if criteria.telEq != null */
  TEL = /* criteria.telEq */'a'
/*%end*/
/*%if criteria.telNe != null */
  TEL != /* criteria.telNe */'a'
/*%end*/
/*%if criteria.telLt != null */
  TEL < /* criteria.telLt */'a'
/*%end*/
/*%if criteria.telLe != null */
  TEL <= /* criteria.telLe */'a'
/*%end*/
/*%if criteria.telGt != null */
  TEL > /* criteria.telLt */'a'
/*%end*/
/*%if criteria.telGe != null */
  TEL >= /* criteria.telLe */'a'
/*%end*/
/*%if criteria.telIsNull  */
  TEL IS NULL
/*%end*/
/*%if criteria.telIsNotNull  */
  TEL IS NOT NULL
/*%end*/
/*%if criteria.telLike != null  */
  TEL LIKE /* @infix(criteria.telLike) */'smith'
/*%end*/
/*%if criteria.telNotLike != null  */
  TEL NOT LIKE /* @infix(criteria.telNotLike) */'smith'
/*%end*/
/*%if criteria.telStarts != null  */
  TEL LIKE /* @prefix(criteria.telStarts) */'smith'
/*%end*/
/*%if criteria.telNotStarts != null  */
  TEL NOT LIKE /* @prefix(criteria.telNotStarts) */'smith'
/*%end*/
/*%if criteria.telEnds != null  */
  TEL LIKE /* @suffix(criteria.telEnds) */'smith'
/*%end*/
/*%if criteria.telNotEnds != null  */
  TEL NOT LIKE /* @suffix(criteria.telNotEnds) */'smith'
/*%end*/
/*%if criteria.sexEq != null */
  SEX = /* criteria.sexEq */1
/*%end*/
/*%if criteria.sexNe != null */
  SEX != /* criteria.sexNe */1
/*%end*/
/*%if criteria.sexLt != null */
  SEX < /* criteria.sexLt */1
/*%end*/
/*%if criteria.sexLe != null */
  SEX <= /* criteria.sexLe */1
/*%end*/
/*%if criteria.sexGt != null */
  SEX > /* criteria.sexLt */1
/*%end*/
/*%if criteria.sexGe != null */
  SEX >= /* criteria.sexLe */1
/*%end*/
/*%if criteria.sexIsNull  */
  SEX IS NULL
/*%end*/
/*%if criteria.sexIsNotNull  */
  SEX IS NOT NULL
/*%end*/
/*%if criteria.sexIn != null  */
  SEX IN /* criteria.sexIn */(1,2,3)
/*%end*/
/*%if criteria.sexNotIn != null  */
  SEX NOT IN /* criteria.sexNotIn */(1,2,3)
/*%end*/
/*%if criteria.birthdayEq != null */
  BIRTHDAY = /* criteria.birthdayEq */'2010-01-23'
/*%end*/
/*%if criteria.birthdayNe != null */
  BIRTHDAY != /* criteria.birthdayNe */'2010-01-23'
/*%end*/
/*%if criteria.birthdayLt != null */
  BIRTHDAY < /* criteria.birthdayLt */'2010-01-23'
/*%end*/
/*%if criteria.birthdayLe != null */
  BIRTHDAY <= /* criteria.birthdayLe */'2010-01-23'
/*%end*/
/*%if criteria.birthdayGt != null */
  BIRTHDAY > /* criteria.birthdayLt */'2010-01-23'
/*%end*/
/*%if criteria.birthdayGe != null */
  BIRTHDAY >= /* criteria.birthdayLe */'2010-01-23'
/*%end*/
/*%if criteria.birthdayIsNull  */
  BIRTHDAY IS NULL
/*%end*/
/*%if criteria.birthdayIsNotNull  */
  BIRTHDAY IS NOT NULL
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
/*%if criteria.statusEq != null */
  STATUS = /* criteria.statusEq */1
/*%end*/
/*%if criteria.statusNe != null */
  STATUS != /* criteria.statusNe */1
/*%end*/
/*%if criteria.statusLt != null */
  STATUS < /* criteria.statusLt */1
/*%end*/
/*%if criteria.statusLe != null */
  STATUS <= /* criteria.statusLe */1
/*%end*/
/*%if criteria.statusGt != null */
  STATUS > /* criteria.statusLt */1
/*%end*/
/*%if criteria.statusGe != null */
  STATUS >= /* criteria.statusLe */1
/*%end*/
/*%if criteria.statusIsNull  */
  STATUS IS NULL
/*%end*/
/*%if criteria.statusIsNotNull  */
  STATUS IS NOT NULL
/*%end*/
/*%if criteria.statusIn != null  */
  STATUS IN /* criteria.statusIn */(1,2,3)
/*%end*/
/*%if criteria.statusNotIn != null  */
  STATUS NOT IN /* criteria.statusNotIn */(1,2,3)
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
