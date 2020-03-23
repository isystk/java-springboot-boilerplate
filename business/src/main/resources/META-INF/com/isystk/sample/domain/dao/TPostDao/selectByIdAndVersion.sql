select
  POST_ID,
  USER_ID,
  TITLE,
  TEXT,
  REGIST_TIME,
  UPDATE_TIME,
  DELETE_FLG,
  VERSION
from
  t_post
where
  POST_ID = /* postId */1
  and
  VERSION = /* version */1
