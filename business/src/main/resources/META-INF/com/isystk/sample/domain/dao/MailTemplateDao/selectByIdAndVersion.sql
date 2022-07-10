select
  /*%expand*/*
from
  mail_template
where
  mail_template_id = /* mailTemplateId */1
  and
  version = /* version */1
