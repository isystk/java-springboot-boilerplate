
DELETE FROM admins WHERE email = 'sample@sample.com';
INSERT INTO admins(name, email, password) VALUES
('管理者A', 'sample@sample.com', '$2a$10$BkIISE3qUk3khS577JhW3OOuhJJ3LRo.xDZ9MfRuwkgq/TcTTWOyG');

DELETE FROM users WHERE email = 'test1@test.com';
INSERT INTO users (name, email, password, email_verified_at, created_at, updated_at) VALUES
('テスト1', 'test1@test.com', '$2a$10$BkIISE3qUk3khS577JhW3OOuhJJ3LRo.xDZ9MfRuwkgq/TcTTWOyG', now(), now(), now());
