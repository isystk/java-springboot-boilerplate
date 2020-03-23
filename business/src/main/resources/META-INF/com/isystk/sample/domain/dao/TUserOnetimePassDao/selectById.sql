select
  USER_ID,
  ONETIME_KEY,
  ONETIME_VALID_TIME
from
  t_user_onetime_pass
where
  USER_ID = /* userId */1
