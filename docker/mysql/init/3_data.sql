
DELETE FROM T_STAFF WHERE EMAIL = 'test@sample.com';
INSERT INTO T_STAFF(EMAIL, PASSWORD, FAMILY_NAME, NAME, FAMILY_NAME_KANA, NAME_KANA, REGIST_TIME, UPDATE_TIME) VALUES
('test@sample.com', '$2a$06$hY5MzfruCds1t5uFLzrlBuw3HcrEGeysr9xJE4Cml5xEOVf425pmK', '管理者', '１', 'カンリシャ', '1', now(), now());

DELETE FROM T_USER WHERE EMAIL = 'test@sample.com';
INSERT INTO T_USER(EMAIL, PASSWORD, FAMILY_NAME, NAME, FAMILY_NAME_KANA, NAME_KANA, STATUS, REGIST_TIME, UPDATE_TIME) VALUES
('test@sample.com', '$2a$06$hY5MzfruCds1t5uFLzrlBuw3HcrEGeysr9xJE4Cml5xEOVf425pmK', 'ユーザー', '１', 'ユーザー', '1', 2, now(), now());
