
DELETE FROM admin WHERE email = 'sample@sample.com';
INSERT INTO admin(name, email, password, created_at, updated_at) VALUES
('管理者A', 'sample@sample.com', '$2a$10$BkIISE3qUk3khS577JhW3OOuhJJ3LRo.xDZ9MfRuwkgq/TcTTWOyG', now(), now());
