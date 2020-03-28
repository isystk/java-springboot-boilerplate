SELECT
  /*%expand*/*
FROM
  t_user_onetime_pass
WHERE
  USER_ID = /* userId */1
LIMIT 1