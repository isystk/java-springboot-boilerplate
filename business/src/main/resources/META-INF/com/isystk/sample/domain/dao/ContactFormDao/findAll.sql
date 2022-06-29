--  自動生成のため原則修正禁止!!
SELECT
  /*%expand*/*
FROM
  contact_form
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
/*%if criteria.yourNameEq != null */
  and your_name = /* criteria.yourNameEq */'a'
/*%end*/
/*%if criteria.yourNameNe != null */
  and your_name != /* criteria.yourNameNe */'a'
/*%end*/
/*%if criteria.yourNameLt != null */
  and your_name < /* criteria.yourNameLt */'a'
/*%end*/
/*%if criteria.yourNameLe != null */
  and your_name <= /* criteria.yourNameLe */'a'
/*%end*/
/*%if criteria.yourNameGt != null */
  and your_name > /* criteria.yourNameGt */'a'
/*%end*/
/*%if criteria.yourNameGe != null */
  and your_name >= /* criteria.yourNameGe */'a'
/*%end*/
/*%if criteria.yourNameIsNull  */
  and your_name IS NULL
/*%end*/
/*%if criteria.yourNameIsNotNull  */
  and your_name IS NOT NULL
/*%end*/
/*%if criteria.yourNameLike != null  */
  and your_name LIKE /* @infix(criteria.yourNameLike) */'smith'
/*%end*/
/*%if criteria.yourNameNotLike != null  */
  and your_name NOT LIKE /* @infix(criteria.yourNameNotLike) */'smith'
/*%end*/
/*%if criteria.yourNameStarts != null  */
  and your_name LIKE /* @prefix(criteria.yourNameStarts) */'smith'
/*%end*/
/*%if criteria.yourNameNotStarts != null  */
  and your_name NOT LIKE /* @prefix(criteria.yourNameNotStarts) */'smith'
/*%end*/
/*%if criteria.yourNameEnds != null  */
  and your_name LIKE /* @suffix(criteria.yourNameEnds) */'smith'
/*%end*/
/*%if criteria.yourNameNotEnds != null  */
  and your_name NOT LIKE /* @suffix(criteria.yourNameNotEnds) */'smith'
/*%end*/
/*%if criteria.titleEq != null */
  and title = /* criteria.titleEq */'a'
/*%end*/
/*%if criteria.titleNe != null */
  and title != /* criteria.titleNe */'a'
/*%end*/
/*%if criteria.titleLt != null */
  and title < /* criteria.titleLt */'a'
/*%end*/
/*%if criteria.titleLe != null */
  and title <= /* criteria.titleLe */'a'
/*%end*/
/*%if criteria.titleGt != null */
  and title > /* criteria.titleGt */'a'
/*%end*/
/*%if criteria.titleGe != null */
  and title >= /* criteria.titleGe */'a'
/*%end*/
/*%if criteria.titleIsNull  */
  and title IS NULL
/*%end*/
/*%if criteria.titleIsNotNull  */
  and title IS NOT NULL
/*%end*/
/*%if criteria.titleLike != null  */
  and title LIKE /* @infix(criteria.titleLike) */'smith'
/*%end*/
/*%if criteria.titleNotLike != null  */
  and title NOT LIKE /* @infix(criteria.titleNotLike) */'smith'
/*%end*/
/*%if criteria.titleStarts != null  */
  and title LIKE /* @prefix(criteria.titleStarts) */'smith'
/*%end*/
/*%if criteria.titleNotStarts != null  */
  and title NOT LIKE /* @prefix(criteria.titleNotStarts) */'smith'
/*%end*/
/*%if criteria.titleEnds != null  */
  and title LIKE /* @suffix(criteria.titleEnds) */'smith'
/*%end*/
/*%if criteria.titleNotEnds != null  */
  and title NOT LIKE /* @suffix(criteria.titleNotEnds) */'smith'
/*%end*/
/*%if criteria.emailEq != null */
  and email = /* criteria.emailEq */'a'
/*%end*/
/*%if criteria.emailNe != null */
  and email != /* criteria.emailNe */'a'
/*%end*/
/*%if criteria.emailLt != null */
  and email < /* criteria.emailLt */'a'
/*%end*/
/*%if criteria.emailLe != null */
  and email <= /* criteria.emailLe */'a'
/*%end*/
/*%if criteria.emailGt != null */
  and email > /* criteria.emailGt */'a'
/*%end*/
/*%if criteria.emailGe != null */
  and email >= /* criteria.emailGe */'a'
/*%end*/
/*%if criteria.emailIsNull  */
  and email IS NULL
/*%end*/
/*%if criteria.emailIsNotNull  */
  and email IS NOT NULL
/*%end*/
/*%if criteria.emailLike != null  */
  and email LIKE /* @infix(criteria.emailLike) */'smith'
/*%end*/
/*%if criteria.emailNotLike != null  */
  and email NOT LIKE /* @infix(criteria.emailNotLike) */'smith'
/*%end*/
/*%if criteria.emailStarts != null  */
  and email LIKE /* @prefix(criteria.emailStarts) */'smith'
/*%end*/
/*%if criteria.emailNotStarts != null  */
  and email NOT LIKE /* @prefix(criteria.emailNotStarts) */'smith'
/*%end*/
/*%if criteria.emailEnds != null  */
  and email LIKE /* @suffix(criteria.emailEnds) */'smith'
/*%end*/
/*%if criteria.emailNotEnds != null  */
  and email NOT LIKE /* @suffix(criteria.emailNotEnds) */'smith'
/*%end*/
/*%if criteria.urlEq != null */
  and url = /* criteria.urlEq */'a'
/*%end*/
/*%if criteria.urlNe != null */
  and url != /* criteria.urlNe */'a'
/*%end*/
/*%if criteria.urlLt != null */
  and url < /* criteria.urlLt */'a'
/*%end*/
/*%if criteria.urlLe != null */
  and url <= /* criteria.urlLe */'a'
/*%end*/
/*%if criteria.urlGt != null */
  and url > /* criteria.urlGt */'a'
/*%end*/
/*%if criteria.urlGe != null */
  and url >= /* criteria.urlGe */'a'
/*%end*/
/*%if criteria.urlIsNull  */
  and url IS NULL
/*%end*/
/*%if criteria.urlIsNotNull  */
  and url IS NOT NULL
/*%end*/
/*%if criteria.urlLike != null  */
  and url LIKE /* @infix(criteria.urlLike) */'smith'
/*%end*/
/*%if criteria.urlNotLike != null  */
  and url NOT LIKE /* @infix(criteria.urlNotLike) */'smith'
/*%end*/
/*%if criteria.urlStarts != null  */
  and url LIKE /* @prefix(criteria.urlStarts) */'smith'
/*%end*/
/*%if criteria.urlNotStarts != null  */
  and url NOT LIKE /* @prefix(criteria.urlNotStarts) */'smith'
/*%end*/
/*%if criteria.urlEnds != null  */
  and url LIKE /* @suffix(criteria.urlEnds) */'smith'
/*%end*/
/*%if criteria.urlNotEnds != null  */
  and url NOT LIKE /* @suffix(criteria.urlNotEnds) */'smith'
/*%end*/
/*%if criteria.genderEq != null */
  and gender = /* criteria.genderEq */'a'
/*%end*/
/*%if criteria.genderNe != null */
  and gender != /* criteria.genderNe */'a'
/*%end*/
/*%if criteria.genderLt != null */
  and gender < /* criteria.genderLt */'a'
/*%end*/
/*%if criteria.genderLe != null */
  and gender <= /* criteria.genderLe */'a'
/*%end*/
/*%if criteria.genderGt != null */
  and gender > /* criteria.genderGt */'a'
/*%end*/
/*%if criteria.genderGe != null */
  and gender >= /* criteria.genderGe */'a'
/*%end*/
/*%if criteria.genderIsNull  */
  and gender IS NULL
/*%end*/
/*%if criteria.genderIsNotNull  */
  and gender IS NOT NULL
/*%end*/
/*%if criteria.ageEq != null */
  and age = /* criteria.ageEq */1
/*%end*/
/*%if criteria.ageNe != null */
  and age != /* criteria.ageNe */1
/*%end*/
/*%if criteria.ageLt != null */
  and age < /* criteria.ageLt */1
/*%end*/
/*%if criteria.ageLe != null */
  and age <= /* criteria.ageLe */1
/*%end*/
/*%if criteria.ageGt != null */
  and age > /* criteria.ageGt */1
/*%end*/
/*%if criteria.ageGe != null */
  and age >= /* criteria.ageGe */1
/*%end*/
/*%if criteria.ageIsNull  */
  and age IS NULL
/*%end*/
/*%if criteria.ageIsNotNull  */
  and age IS NOT NULL
/*%end*/
/*%if criteria.ageIn != null  */
  and age IN /* criteria.ageIn */(1,2,3)
/*%end*/
/*%if criteria.ageNotIn != null  */
  and age NOT IN /* criteria.ageNotIn */(1,2,3)
/*%end*/
/*%if criteria.contactEq != null */
  and contact = /* criteria.contactEq */'a'
/*%end*/
/*%if criteria.contactNe != null */
  and contact != /* criteria.contactNe */'a'
/*%end*/
/*%if criteria.contactLt != null */
  and contact < /* criteria.contactLt */'a'
/*%end*/
/*%if criteria.contactLe != null */
  and contact <= /* criteria.contactLe */'a'
/*%end*/
/*%if criteria.contactGt != null */
  and contact > /* criteria.contactGt */'a'
/*%end*/
/*%if criteria.contactGe != null */
  and contact >= /* criteria.contactGe */'a'
/*%end*/
/*%if criteria.contactIsNull  */
  and contact IS NULL
/*%end*/
/*%if criteria.contactIsNotNull  */
  and contact IS NOT NULL
/*%end*/
/*%if criteria.contactLike != null  */
  and contact LIKE /* @infix(criteria.contactLike) */'smith'
/*%end*/
/*%if criteria.contactNotLike != null  */
  and contact NOT LIKE /* @infix(criteria.contactNotLike) */'smith'
/*%end*/
/*%if criteria.contactStarts != null  */
  and contact LIKE /* @prefix(criteria.contactStarts) */'smith'
/*%end*/
/*%if criteria.contactNotStarts != null  */
  and contact NOT LIKE /* @prefix(criteria.contactNotStarts) */'smith'
/*%end*/
/*%if criteria.contactEnds != null  */
  and contact LIKE /* @suffix(criteria.contactEnds) */'smith'
/*%end*/
/*%if criteria.contactNotEnds != null  */
  and contact NOT LIKE /* @suffix(criteria.contactNotEnds) */'smith'
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
