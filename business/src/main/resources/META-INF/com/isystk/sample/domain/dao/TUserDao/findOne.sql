--  自動生成のため原則修正禁止!!
SELECT
  /*%expand*/*
FROM
  t_user
WHERE
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
/*%if criteria.zipEq != null */
  and ZIP = /* criteria.zipEq */'a'
/*%end*/
/*%if criteria.zipNe != null */
  and ZIP != /* criteria.zipNe */'a'
/*%end*/
/*%if criteria.zipLt != null */
  and ZIP < /* criteria.zipLt */'a'
/*%end*/
/*%if criteria.zipLe != null */
  and ZIP <= /* criteria.zipLe */'a'
/*%end*/
/*%if criteria.zipGt != null */
  and ZIP > /* criteria.zipGt */'a'
/*%end*/
/*%if criteria.zipGe != null */
  and ZIP >= /* criteria.zipGe */'a'
/*%end*/
/*%if criteria.zipIsNull  */
  and ZIP IS NULL
/*%end*/
/*%if criteria.zipIsNotNull  */
  and ZIP IS NOT NULL
/*%end*/
/*%if criteria.zipLike != null  */
  and ZIP LIKE /* @infix(criteria.zipLike) */'smith'
/*%end*/
/*%if criteria.zipNotLike != null  */
  and ZIP NOT LIKE /* @infix(criteria.zipNotLike) */'smith'
/*%end*/
/*%if criteria.zipStarts != null  */
  and ZIP LIKE /* @prefix(criteria.zipStarts) */'smith'
/*%end*/
/*%if criteria.zipNotStarts != null  */
  and ZIP NOT LIKE /* @prefix(criteria.zipNotStarts) */'smith'
/*%end*/
/*%if criteria.zipEnds != null  */
  and ZIP LIKE /* @suffix(criteria.zipEnds) */'smith'
/*%end*/
/*%if criteria.zipNotEnds != null  */
  and ZIP NOT LIKE /* @suffix(criteria.zipNotEnds) */'smith'
/*%end*/
/*%if criteria.prefectureIdEq != null */
  and PREFECTURE_ID = /* criteria.prefectureIdEq */1
/*%end*/
/*%if criteria.prefectureIdNe != null */
  and PREFECTURE_ID != /* criteria.prefectureIdNe */1
/*%end*/
/*%if criteria.prefectureIdLt != null */
  and PREFECTURE_ID < /* criteria.prefectureIdLt */1
/*%end*/
/*%if criteria.prefectureIdLe != null */
  and PREFECTURE_ID <= /* criteria.prefectureIdLe */1
/*%end*/
/*%if criteria.prefectureIdGt != null */
  and PREFECTURE_ID > /* criteria.prefectureIdGt */1
/*%end*/
/*%if criteria.prefectureIdGe != null */
  and PREFECTURE_ID >= /* criteria.prefectureIdGe */1
/*%end*/
/*%if criteria.prefectureIdIsNull  */
  and PREFECTURE_ID IS NULL
/*%end*/
/*%if criteria.prefectureIdIsNotNull  */
  and PREFECTURE_ID IS NOT NULL
/*%end*/
/*%if criteria.prefectureIdIn != null  */
  and PREFECTURE_ID IN /* criteria.prefectureIdIn */(1,2,3)
/*%end*/
/*%if criteria.prefectureIdNotIn != null  */
  and PREFECTURE_ID NOT IN /* criteria.prefectureIdNotIn */(1,2,3)
/*%end*/
/*%if criteria.areaEq != null */
  and AREA = /* criteria.areaEq */'a'
/*%end*/
/*%if criteria.areaNe != null */
  and AREA != /* criteria.areaNe */'a'
/*%end*/
/*%if criteria.areaLt != null */
  and AREA < /* criteria.areaLt */'a'
/*%end*/
/*%if criteria.areaLe != null */
  and AREA <= /* criteria.areaLe */'a'
/*%end*/
/*%if criteria.areaGt != null */
  and AREA > /* criteria.areaGt */'a'
/*%end*/
/*%if criteria.areaGe != null */
  and AREA >= /* criteria.areaGe */'a'
/*%end*/
/*%if criteria.areaIsNull  */
  and AREA IS NULL
/*%end*/
/*%if criteria.areaIsNotNull  */
  and AREA IS NOT NULL
/*%end*/
/*%if criteria.areaLike != null  */
  and AREA LIKE /* @infix(criteria.areaLike) */'smith'
/*%end*/
/*%if criteria.areaNotLike != null  */
  and AREA NOT LIKE /* @infix(criteria.areaNotLike) */'smith'
/*%end*/
/*%if criteria.areaStarts != null  */
  and AREA LIKE /* @prefix(criteria.areaStarts) */'smith'
/*%end*/
/*%if criteria.areaNotStarts != null  */
  and AREA NOT LIKE /* @prefix(criteria.areaNotStarts) */'smith'
/*%end*/
/*%if criteria.areaEnds != null  */
  and AREA LIKE /* @suffix(criteria.areaEnds) */'smith'
/*%end*/
/*%if criteria.areaNotEnds != null  */
  and AREA NOT LIKE /* @suffix(criteria.areaNotEnds) */'smith'
/*%end*/
/*%if criteria.addressEq != null */
  and ADDRESS = /* criteria.addressEq */'a'
/*%end*/
/*%if criteria.addressNe != null */
  and ADDRESS != /* criteria.addressNe */'a'
/*%end*/
/*%if criteria.addressLt != null */
  and ADDRESS < /* criteria.addressLt */'a'
/*%end*/
/*%if criteria.addressLe != null */
  and ADDRESS <= /* criteria.addressLe */'a'
/*%end*/
/*%if criteria.addressGt != null */
  and ADDRESS > /* criteria.addressGt */'a'
/*%end*/
/*%if criteria.addressGe != null */
  and ADDRESS >= /* criteria.addressGe */'a'
/*%end*/
/*%if criteria.addressIsNull  */
  and ADDRESS IS NULL
/*%end*/
/*%if criteria.addressIsNotNull  */
  and ADDRESS IS NOT NULL
/*%end*/
/*%if criteria.addressLike != null  */
  and ADDRESS LIKE /* @infix(criteria.addressLike) */'smith'
/*%end*/
/*%if criteria.addressNotLike != null  */
  and ADDRESS NOT LIKE /* @infix(criteria.addressNotLike) */'smith'
/*%end*/
/*%if criteria.addressStarts != null  */
  and ADDRESS LIKE /* @prefix(criteria.addressStarts) */'smith'
/*%end*/
/*%if criteria.addressNotStarts != null  */
  and ADDRESS NOT LIKE /* @prefix(criteria.addressNotStarts) */'smith'
/*%end*/
/*%if criteria.addressEnds != null  */
  and ADDRESS LIKE /* @suffix(criteria.addressEnds) */'smith'
/*%end*/
/*%if criteria.addressNotEnds != null  */
  and ADDRESS NOT LIKE /* @suffix(criteria.addressNotEnds) */'smith'
/*%end*/
/*%if criteria.buildingEq != null */
  and BUILDING = /* criteria.buildingEq */'a'
/*%end*/
/*%if criteria.buildingNe != null */
  and BUILDING != /* criteria.buildingNe */'a'
/*%end*/
/*%if criteria.buildingLt != null */
  and BUILDING < /* criteria.buildingLt */'a'
/*%end*/
/*%if criteria.buildingLe != null */
  and BUILDING <= /* criteria.buildingLe */'a'
/*%end*/
/*%if criteria.buildingGt != null */
  and BUILDING > /* criteria.buildingGt */'a'
/*%end*/
/*%if criteria.buildingGe != null */
  and BUILDING >= /* criteria.buildingGe */'a'
/*%end*/
/*%if criteria.buildingIsNull  */
  and BUILDING IS NULL
/*%end*/
/*%if criteria.buildingIsNotNull  */
  and BUILDING IS NOT NULL
/*%end*/
/*%if criteria.buildingLike != null  */
  and BUILDING LIKE /* @infix(criteria.buildingLike) */'smith'
/*%end*/
/*%if criteria.buildingNotLike != null  */
  and BUILDING NOT LIKE /* @infix(criteria.buildingNotLike) */'smith'
/*%end*/
/*%if criteria.buildingStarts != null  */
  and BUILDING LIKE /* @prefix(criteria.buildingStarts) */'smith'
/*%end*/
/*%if criteria.buildingNotStarts != null  */
  and BUILDING NOT LIKE /* @prefix(criteria.buildingNotStarts) */'smith'
/*%end*/
/*%if criteria.buildingEnds != null  */
  and BUILDING LIKE /* @suffix(criteria.buildingEnds) */'smith'
/*%end*/
/*%if criteria.buildingNotEnds != null  */
  and BUILDING NOT LIKE /* @suffix(criteria.buildingNotEnds) */'smith'
/*%end*/
/*%if criteria.telEq != null */
  and TEL = /* criteria.telEq */'a'
/*%end*/
/*%if criteria.telNe != null */
  and TEL != /* criteria.telNe */'a'
/*%end*/
/*%if criteria.telLt != null */
  and TEL < /* criteria.telLt */'a'
/*%end*/
/*%if criteria.telLe != null */
  and TEL <= /* criteria.telLe */'a'
/*%end*/
/*%if criteria.telGt != null */
  and TEL > /* criteria.telGt */'a'
/*%end*/
/*%if criteria.telGe != null */
  and TEL >= /* criteria.telGe */'a'
/*%end*/
/*%if criteria.telIsNull  */
  and TEL IS NULL
/*%end*/
/*%if criteria.telIsNotNull  */
  and TEL IS NOT NULL
/*%end*/
/*%if criteria.telLike != null  */
  and TEL LIKE /* @infix(criteria.telLike) */'smith'
/*%end*/
/*%if criteria.telNotLike != null  */
  and TEL NOT LIKE /* @infix(criteria.telNotLike) */'smith'
/*%end*/
/*%if criteria.telStarts != null  */
  and TEL LIKE /* @prefix(criteria.telStarts) */'smith'
/*%end*/
/*%if criteria.telNotStarts != null  */
  and TEL NOT LIKE /* @prefix(criteria.telNotStarts) */'smith'
/*%end*/
/*%if criteria.telEnds != null  */
  and TEL LIKE /* @suffix(criteria.telEnds) */'smith'
/*%end*/
/*%if criteria.telNotEnds != null  */
  and TEL NOT LIKE /* @suffix(criteria.telNotEnds) */'smith'
/*%end*/
/*%if criteria.sexEq != null */
  and SEX = /* criteria.sexEq */1
/*%end*/
/*%if criteria.sexNe != null */
  and SEX != /* criteria.sexNe */1
/*%end*/
/*%if criteria.sexLt != null */
  and SEX < /* criteria.sexLt */1
/*%end*/
/*%if criteria.sexLe != null */
  and SEX <= /* criteria.sexLe */1
/*%end*/
/*%if criteria.sexGt != null */
  and SEX > /* criteria.sexGt */1
/*%end*/
/*%if criteria.sexGe != null */
  and SEX >= /* criteria.sexGe */1
/*%end*/
/*%if criteria.sexIsNull  */
  and SEX IS NULL
/*%end*/
/*%if criteria.sexIsNotNull  */
  and SEX IS NOT NULL
/*%end*/
/*%if criteria.sexIn != null  */
  and SEX IN /* criteria.sexIn */(1,2,3)
/*%end*/
/*%if criteria.sexNotIn != null  */
  and SEX NOT IN /* criteria.sexNotIn */(1,2,3)
/*%end*/
/*%if criteria.birthdayEq != null */
  and BIRTHDAY = /* criteria.birthdayEq */'2010-01-23'
/*%end*/
/*%if criteria.birthdayNe != null */
  and BIRTHDAY != /* criteria.birthdayNe */'2010-01-23'
/*%end*/
/*%if criteria.birthdayLt != null */
  and BIRTHDAY < /* criteria.birthdayLt */'2010-01-23'
/*%end*/
/*%if criteria.birthdayLe != null */
  and BIRTHDAY <= /* criteria.birthdayLe */'2010-01-23'
/*%end*/
/*%if criteria.birthdayGt != null */
  and BIRTHDAY > /* criteria.birthdayGt */'2010-01-23'
/*%end*/
/*%if criteria.birthdayGe != null */
  and BIRTHDAY >= /* criteria.birthdayGe */'2010-01-23'
/*%end*/
/*%if criteria.birthdayIsNull  */
  and BIRTHDAY IS NULL
/*%end*/
/*%if criteria.birthdayIsNotNull  */
  and BIRTHDAY IS NOT NULL
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
/*%if criteria.statusEq != null */
  and STATUS = /* criteria.statusEq */1
/*%end*/
/*%if criteria.statusNe != null */
  and STATUS != /* criteria.statusNe */1
/*%end*/
/*%if criteria.statusLt != null */
  and STATUS < /* criteria.statusLt */1
/*%end*/
/*%if criteria.statusLe != null */
  and STATUS <= /* criteria.statusLe */1
/*%end*/
/*%if criteria.statusGt != null */
  and STATUS > /* criteria.statusGt */1
/*%end*/
/*%if criteria.statusGe != null */
  and STATUS >= /* criteria.statusGe */1
/*%end*/
/*%if criteria.statusIsNull  */
  and STATUS IS NULL
/*%end*/
/*%if criteria.statusIsNotNull  */
  and STATUS IS NOT NULL
/*%end*/
/*%if criteria.statusIn != null  */
  and STATUS IN /* criteria.statusIn */(1,2,3)
/*%end*/
/*%if criteria.statusNotIn != null  */
  and STATUS NOT IN /* criteria.statusNotIn */(1,2,3)
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
