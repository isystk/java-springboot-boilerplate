select
  /*%expand*/*
from
  t_user
where
  USER_ID = /* userId */1
  and
  VERSION = /* version */1
