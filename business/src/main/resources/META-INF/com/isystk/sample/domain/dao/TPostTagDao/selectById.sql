select
  /*%expand*/*
from
  t_post_tag
where
  POST_ID = /* postId */1
  and
  POST_TAG_ID = /* postTagId */1
