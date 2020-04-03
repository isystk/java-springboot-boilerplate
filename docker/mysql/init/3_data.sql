
USE sample;

DELETE FROM T_STAFF WHERE EMAIL = 'test@sample.com';
INSERT INTO T_STAFF(EMAIL, PASSWORD, FAMILY_NAME, NAME, FAMILY_NAME_KANA, NAME_KANA, REGIST_TIME, UPDATE_TIME) VALUES
('test@sample.com', '$2a$10$BkIISE3qUk3khS577JhW3OOuhJJ3LRo.xDZ9MfRuwkgq/TcTTWOyG', '管理者', '１', 'カンリシャ', 'ワン', now(), now());

DELETE FROM T_USER WHERE EMAIL = 'test@sample.com';
INSERT INTO t_user (EMAIL, PASSWORD, FAMILY_NAME, NAME, FAMILY_NAME_KANA, NAME_KANA, ZIP, PREFECTURE_ID, AREA, ADDRESS, BUILDING, TEL, SEX, BIRTHDAY, LAST_LOGIN_TIME, STATUS, REGIST_TIME, UPDATE_TIME, DELETE_FLG, VERSION) VALUES
('test@sample.com', '$2a$10$BkIISE3qUk3khS577JhW3OOuhJJ3LRo.xDZ9MfRuwkgq/TcTTWOyG', 'サンプル', '１', 'サンプル', 'ワン', '110-0006', 13, '台東区', '秋葉原１－１－１', 'XXXXビル１０１', '09012345678', 2, NULL, NULL, 0, now(), now(), 0, 0);


DELETE FROM m_mail_template WHERE MAIL_TEMPLATE_ID IN (1, 2);
INSERT INTO m_mail_template (MAIL_TEMPLATE_ID, TEMPLATE_DIV, TITLE, TEXT, REGIST_TIME, UPDATE_TIME, DELETE_FLG, VERSION) VALUES
(1, 1, '会員仮登録完了のお知らせ', '[[${dto.familyName}]] 様\r\n\r\nご登録いただき、ありがとうございます。\r\n現在、仮登録の状態ですので、下記URLをクリックして登録を完了させてください。\r\n\r\nhttps://[[${dto.domain}]]/entry/regist/[[${dto.onetimeKey}]]/\r\n\r\n', now(), now(), 0, 1),
(2, 1, '会員本登録完了のお知らせ', '[[${dto.familyName}]] 様\r\n\r\nこの度はご登録いただき、ありがとうございます。\r\n[[${dto.familyName}]]様の会員登録手続きが完了しました。\r\n\r\n------------------------------------------------------------------------\r\n会員専用ページへは、下記URLより、\r\nご登録いただいたメールアドレスとパスワードを入力してログインしてください。\r\n\r\nhttps://[[${dto.domain}]]/login/\r\n------------------------------------------------------------------------\r\n\r\n今後ともよろしくお願い致します。\r\n', now(), now(), 0, 1);
