-- Project Name : laraec
-- Date/Time    : 2022/06/23 17:10:15
-- Author       : USER
-- RDBMS Type   : MySQL
-- Application  : A5:SQL Mk-2

-- ユーザ
create table users (
  id bigint unsigned auto_increment not null comment 'ユーザID'
  , provider_id varchar(255) comment 'プロバイダID'
  , provider_name varchar(255) comment 'プロバイダ名'
  , name varchar(255) not null comment 'ユーザ名'
  , email varchar(255) not null comment 'メールアドレス'
  , email_verified_at timestamp default null comment 'メール検証日時'
  , password varchar(255) comment 'パスワード'
  , remember_token varchar(100) comment 'remember_token'
  , created_at timestamp default null comment '登録日時'
  , updated_at timestamp default null comment '更新日時'
  , delete_flg TINYINT default 0 not null comment '削除フラグ'
  , version BIGINT default 1 not null comment '楽観チェック用バージョン'
  , constraint users_PKC primary key (id)
) comment 'ユーザ' ;

alter table users add unique users_IX1 (email) ;

alter table users add unique users_IX2 (provider_id,provider_name) ;

-- 商品
create table stocks (
  id bigint unsigned auto_increment not null comment '商品ID'
  , name varchar(100) not null comment '商品名'
  , detail varchar(500) not null comment '説明文'
  , price int not null comment '価格'
  , imgpath varchar(200) not null comment '画像ファイル名'
  , quantity int comment '在庫数'
  , created_at timestamp default null comment '登録日時'
  , updated_at timestamp default null comment '更新日時'
  , delete_flg TINYINT default 0 not null comment '削除フラグ'
  , version BIGINT default 1 not null comment '楽観チェック用バージョン'
  , constraint stocks_PKC primary key (id)
) comment '商品' ;

-- パスワードリセット
create table password_resets (
  email varchar(255) not null comment 'メールアドレス'
  , token varchar(255) not null comment 'ワンタイムトークン'
  , created_at timestamp default null comment '登録日時'
) comment 'パスワードリセット' ;

create index password_resets_IX1
  on password_resets(email);

-- 注文
create table orders (
  id bigint unsigned auto_increment not null comment '注文ID'
  , stock_id bigint unsigned not null comment '商品ID'
  , user_id bigint unsigned not null comment 'ユーザID'
  , price int comment '価格'
  , quantity int comment '個数'
  , created_at timestamp default null comment '登録日時'
  , updated_at timestamp default null comment '更新日時'
  , delete_flg TINYINT default 0 not null comment '削除フラグ'
  , version BIGINT default 1 not null comment '楽観チェック用バージョン'
  , constraint orders_PKC primary key (id)
) comment '注文' ;

create index orders_IX1
  on orders(stock_id);

-- お問い合わせ
create table contact_forms (
  id bigint unsigned auto_increment not null comment 'id'
  , your_name varchar(20) not null comment 'お名前'
  , title varchar(50) not null comment 'タイトル'
  , email varchar(255) not null comment 'メールアドレス'
  , url longtext comment 'URL'
  , gender tinyint(1) not null comment '性別'
  , age tinyint not null comment '年齢'
  , contact varchar(200) not null comment 'お問い合わせ内容'
  , created_at timestamp default null comment '登録日時'
  , updated_at timestamp default null comment '更新日時'
  , delete_flg TINYINT default 0 not null comment '削除フラグ'
  , version BIGINT default 1 not null comment '楽観チェック用バージョン'
  , constraint contact_forms_PKC primary key (id)
) comment 'お問い合わせ' ;

-- お問い合わせ画像
create table contact_form_images (
  id bigint unsigned auto_increment not null comment 'お問い合わせ画像ID'
  , contact_form_id bigint unsigned not null comment 'お問い合わせID'
  , file_name varchar(100) not null comment 'ファイル名'
  , created_at timestamp default null comment '登録日時'
  , updated_at timestamp default null comment '更新日時'
  , delete_flg TINYINT default 0 not null comment '削除フラグ'
  , version BIGINT default 1 not null comment '楽観チェック用バージョン'
  , constraint contact_form_images_PKC primary key (id)
) comment 'お問い合わせ画像' ;

create index contact_form_images_IX1
  on contact_form_images(contact_form_id);

-- カート
create table carts (
  id bigint unsigned auto_increment not null comment 'カートID'
  , stock_id bigint unsigned not null comment '商品ID'
  , user_id bigint unsigned not null comment 'ユーザID'
  , created_at timestamp default null comment '登録日時'
  , updated_at timestamp default null comment '更新日時'
  , delete_flg TINYINT default 0 not null comment '削除フラグ'
  , version BIGINT default 1 not null comment '楽観チェック用バージョン'
  , constraint carts_PKC primary key (id)
) comment 'カート' ;

create index carts_IX1
  on carts(stock_id);

create index carts_IX2
  on carts(user_id);

-- 管理者
create table admins (
  id int unsigned auto_increment not null comment '管理者ID'
  , name varchar(255) not null comment '管理者名'
  , email varchar(255) not null comment 'メールアドレス'
  , password varchar(255) not null comment 'パスワード'
  , remember_token varchar(100) comment 'remember_token'
  , created_at timestamp default null comment '登録日時'
  , updated_at timestamp default null comment '更新日時'
  , delete_flg TINYINT default 0 not null comment '削除フラグ'
  , version BIGINT default 1 not null comment '楽観チェック用バージョン'
  , constraint admins_PKC primary key (id)
) comment '管理者' ;

alter table admins add unique admins_IX1 (email) ;
