select
  /*%expand*/*
from
  m_mail_template
where
  MAIL_TEMPLATE_ID = /* mailTemplateId */1
  and
  VERSION = /* version */1
