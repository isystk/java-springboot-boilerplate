
DELETE FROM T_STAFF WHERE EMAIL = 'test@sample.com';
INSERT INTO T_STAFF(EMAIL, PASSWORD, FAMILY_NAME, NAME, FAMILY_NAME_KANA, NAME_KANA, REGIST_TIME, UPDATE_TIME) VALUES
('test@sample.com', '$2a$06$hY5MzfruCds1t5uFLzrlBuw3HcrEGeysr9xJE4Cml5xEOVf425pmK', '管理者', '１', 'カンリシャ', '1', now(), now());

DELETE FROM T_USER WHERE EMAIL = 'test@sample.com';
INSERT INTO T_USER(EMAIL, PASSWORD, FAMILY_NAME, NAME, FAMILY_NAME_KANA, NAME_KANA, STATUS, REGIST_TIME, UPDATE_TIME) VALUES
('test@sample.com', '$2a$06$hY5MzfruCds1t5uFLzrlBuw3HcrEGeysr9xJE4Cml5xEOVf425pmK', 'ユーザー', '１', 'ユーザー', '1', 2, now(), now());

DELETE FROM m_mail_template WHERE MAIL_TEMPLATE_ID IN (1, 2);
INSERT INTO `m_mail_template` (`MAIL_TEMPLATE_ID`, `TEMPLATE_DIV`, `TITLE`, `TEXT`, `REGIST_TIME`, `UPDATE_TIME`, `DELETE_FLG`, `VERSION`) VALUES
(1, 1, '会員仮登録完了のお知らせ', '[[${dto.familyName}]] 様\r\n\r\nご登録いただき、ありがとうございます。\r\n現在、仮登録の状態ですので、下記URLをクリックして登録を完了させてください。\r\n\r\nhttps://[[${dto.domain}]]/entry/regist/[[${dto.onetimeKey}]]/\r\n\r\n', '2020-04-02 12:08:39', '2020-04-02 12:08:39', 0, 1),
(2, 1, '会員本登録完了のお知らせ', '[[${dto.familyName}]] 様\r\n\r\nこの度はご登録いただき、ありがとうございます。\r\n[[${dto.familyName}]]様の会員登録手続きが完了しました。\r\n\r\n------------------------------------------------------------------------\r\n会員専用ページへは、下記URLより、\r\nご登録いただいたメールアドレスとパスワードを入力してログインしてください。\r\n\r\nhttps://[[${dto.domain}]]/login/\r\n------------------------------------------------------------------------\r\n\r\n今後ともよろしくお願い致します。\r\n', '2020-04-02 14:55:32', '2020-04-02 14:55:32', 0, 1);
