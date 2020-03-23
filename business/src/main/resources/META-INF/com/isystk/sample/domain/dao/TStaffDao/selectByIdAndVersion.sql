select
  STAFF_ID,
  EMAIL,
  PASSWORD,
  FAMILY_NAME,
  NAME,
  FAMILY_NAME_KANA,
  NAME_KANA,
  LAST_LOGIN_TIME,
  REGIST_TIME,
  UPDATE_TIME,
  DELETE_FLG,
  VERSION
from
  t_staff
where
  STAFF_ID = /* staffId */1
  and
  VERSION = /* version */1
