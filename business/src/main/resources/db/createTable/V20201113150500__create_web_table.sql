-- Project Name : laraec
-- Date/Time    : 2022/07/02 14:58:43
-- Author       : USER
-- RDBMS Type   : MySQL
-- Application  : A5:SQL Mk-2

-- ユーザ
create table user (
  id bigint unsigned auto_increment not null comment 'ユーザID'
  , provider_id varchar(255) comment 'プロバイダID'
  , provider_name varchar(255) comment 'プロバイダ名'
  , name varchar(255) not null comment 'ユーザ名'
  , email varchar(255) not null comment 'メールアドレス'
  , email_verified_at timestamp default null comment 'メール検証日時'
  , password varchar(255) comment 'パスワード'
  , remember_token varchar(100) comment 'remember_token'
  , last_login_at timestamp comment '最終ログイン日時'
  , created_at timestamp default null comment '登録日時'
  , updated_at timestamp default null comment '更新日時'
  , delete_flg boolean default 0 not null comment '削除フラグ'
  , version BIGINT default 1 not null comment '楽観チェック用バージョン'
  , constraint user_PKC primary key (id)
) comment 'ユーザ' ;

alter table user add unique user_IX1 (email) ;

alter table user add unique user_IX2 (provider_id,provider_name) ;

-- 商品
create table stock (
  id bigint unsigned auto_increment not null comment '商品ID'
  , name varchar(100) not null comment '商品名'
  , detail varchar(500) not null comment '説明文'
  , price int not null comment '価格'
  , imgpath varchar(200) not null comment '画像ファイル名'
  , quantity int comment '在庫数'
  , created_at timestamp default null comment '登録日時'
  , updated_at timestamp default null comment '更新日時'
  , delete_flg boolean default 0 not null comment '削除フラグ'
  , version BIGINT default 1 not null comment '楽観チェック用バージョン'
  , constraint stock_PKC primary key (id)
) comment '商品' ;

-- パスワードリセット
create table password_reset (
  email varchar(255) not null comment 'メールアドレス'
  , token varchar(255) not null comment 'ワンタイムトークン'
  , created_at timestamp default null comment '登録日時'
) comment 'パスワードリセット' ;

create index password_reset_IX1
  on password_reset(email);

-- 注文履歴
create table order_history (
  id bigint unsigned auto_increment not null comment '注文履歴ID'
  , stock_id bigint unsigned not null comment '商品ID'
  , user_id bigint unsigned not null comment 'ユーザID'
  , price int comment '価格'
  , quantity int comment '個数'
  , created_at timestamp default null comment '登録日時'
  , updated_at timestamp default null comment '更新日時'
  , delete_flg boolean default 0 not null comment '削除フラグ'
  , version BIGINT default 1 not null comment '楽観チェック用バージョン'
  , constraint order_history_PKC primary key (id)
) comment '注文履歴' ;

create index order_history_IX1
  on order_history(stock_id);

-- お問い合わせ
create table contact_form (
  id bigint unsigned auto_increment not null comment 'id'
  , your_name varchar(20) not null comment 'お名前'
  , title varchar(50) not null comment 'タイトル'
  , email varchar(255) not null comment 'メールアドレス'
  , url longtext comment 'URL'
  , gender tinyint not null comment '性別'
  , age tinyint not null comment '年齢'
  , contact varchar(200) not null comment 'お問い合わせ内容'
  , created_at timestamp default null comment '登録日時'
  , updated_at timestamp default null comment '更新日時'
  , delete_flg boolean default 0 not null comment '削除フラグ'
  , version BIGINT default 1 not null comment '楽観チェック用バージョン'
  , constraint contact_form_PKC primary key (id)
) comment 'お問い合わせ' ;

-- お問い合わせ画像
create table contact_form_image (
  id bigint unsigned auto_increment not null comment 'お問い合わせ画像ID'
  , contact_form_id bigint unsigned not null comment 'お問い合わせID'
  , file_name varchar(100) not null comment 'ファイル名'
  , created_at timestamp default null comment '登録日時'
  , updated_at timestamp default null comment '更新日時'
  , delete_flg boolean default 0 not null comment '削除フラグ'
  , version BIGINT default 1 not null comment '楽観チェック用バージョン'
  , constraint contact_form_image_PKC primary key (id)
) comment 'お問い合わせ画像' ;

create index contact_form_image_IX1
  on contact_form_image(contact_form_id);

-- カート
create table cart (
  id bigint unsigned auto_increment not null comment 'カートID'
  , stock_id bigint unsigned not null comment '商品ID'
  , user_id bigint unsigned not null comment 'ユーザID'
  , created_at timestamp default null comment '登録日時'
  , updated_at timestamp default null comment '更新日時'
  , delete_flg boolean default 0 not null comment '削除フラグ'
  , version BIGINT default 1 not null comment '楽観チェック用バージョン'
  , constraint cart_PKC primary key (id)
) comment 'カート' ;

create index cart_IX1
  on cart(stock_id);

create index cart_IX2
  on cart(user_id);

-- 管理者
create table admin (
  id int unsigned auto_increment not null comment '管理者ID'
  , name varchar(255) not null comment '管理者名'
  , email varchar(255) not null comment 'メールアドレス'
  , password varchar(255) not null comment 'パスワード'
  , remember_token varchar(100) comment 'remember_token'
  , last_login_at timestamp comment '最終ログイン日時'
  , created_at timestamp default null comment '登録日時'
  , updated_at timestamp default null comment '更新日時'
  , delete_flg boolean default 0 not null comment '削除フラグ'
  , version BIGINT default 1 not null comment '楽観チェック用バージョン'
  , constraint admin_PKC primary key (id)
) comment '管理者' ;

alter table admin add unique admin_IX1 (email) ;

alter table cart
  add constraint cart_FK1 foreign key (user_id) references user(id);

alter table cart
  add constraint cart_FK2 foreign key (stock_id) references stock(id);

alter table order_history
  add constraint order_history_FK1 foreign key (stock_id) references stock(id);

alter table contact_form_image
  add constraint contact_form_image_FK1 foreign key (contact_form_id) references contact_form(id);
