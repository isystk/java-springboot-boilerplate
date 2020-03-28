SELECT
  /*%expand*/*
FROM
  t_user_onetime_valid
WHERE
  USER_ID = /* userId */1
LIMIT 1