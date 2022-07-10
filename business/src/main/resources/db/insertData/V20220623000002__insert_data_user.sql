
DELETE FROM user WHERE email = 'test1@test.com';
INSERT INTO user (name, email, password, email_verified_at, created_at, updated_at) VALUES
('テスト1', 'test1@test.com', '$2a$10$BkIISE3qUk3khS577JhW3OOuhJJ3LRo.xDZ9MfRuwkgq/TcTTWOyG', now(), now(), now());
