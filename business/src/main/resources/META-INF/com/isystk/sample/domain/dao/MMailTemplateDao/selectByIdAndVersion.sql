select
  MAIL_TEMPLATE_ID,
  TEMPLATE_DIV,
  TITLE,
  TEXT,
  REGIST_TIME,
  UPDATE_TIME,
  DELETE_FLG,
  VERSION
from
  m_mail_template
where
  MAIL_TEMPLATE_ID = /* mailTemplateId */1
  and
  VERSION = /* version */1
