-- Project Name : sample
-- Date/Time    : 2020/03/30 16:46:35
-- Author       : isystk
-- RDBMS Type   : MySQL
-- Application  : A5:SQL Mk-2

-- メールテンプレート
create table M_MAIL_TEMPLATE (
  MAIL_TEMPLATE_ID INT(11) auto_increment not null comment 'MAIL_TEMPLATEID'
  , TEMPLATE_DIV INT(11) not null comment 'テンプレート区分'
  , TITLE VARCHAR(100) not null comment 'タイトル'
  , TEXT VARCHAR(500) not null comment '本文'
  , REGIST_TIME DATETIME not null comment '登録日時'
  , UPDATE_TIME DATETIME not null comment '更新日時'
  , DELETE_FLG TINYINT(1) default 0 not null comment '削除フラグ'
  , VERSION BIGINT default 1 not null comment '楽観チェック用バージョン'
  , constraint M_MAIL_TEMPLATE_PKC primary key (MAIL_TEMPLATE_ID)
) comment 'メールテンプレート' ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=Compressed;

-- 管理者
create table T_STAFF (
  STAFF_ID INT(11) auto_increment not null comment '管理者ID'
  , EMAIL VARCHAR(256) not null comment 'メールアドレス'
  , PASSWORD VARCHAR(100) not null comment 'パスワード'
  , FAMILY_NAME VARCHAR(20) not null comment '姓'
  , NAME VARCHAR(20) not null comment '名'
  , FAMILY_NAME_KANA VARCHAR(20) not null comment '姓（カナ）'
  , NAME_KANA VARCHAR(20) not null comment '名（カナ）'
  , LAST_LOGIN_TIME DATETIME comment '最終ログイン日時'
  , REGIST_TIME DATETIME not null comment '登録日時'
  , UPDATE_TIME DATETIME not null comment '更新日時'
  , DELETE_FLG TINYINT(1) default 0 not null comment '削除フラグ'
  , VERSION BIGINT default 1 not null comment '楽観チェック用バージョン'
  , constraint T_STAFF_PKC primary key (STAFF_ID)
) comment '管理者' ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=Compressed;

-- 会員-パスワード変更
create table T_USER_ONETIME_PASS (
  USER_ID INT(11) not null comment '会員ID'
  , ONETIME_KEY CHAR(32) not null comment 'ワンタイムキー'
  , ONETIME_VALID_TIME DATETIME not null comment 'ワンタイム有効期限'
  , constraint T_USER_ONETIME_PASS_PKC primary key (USER_ID)
) comment '会員-パスワード変更' ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=Compressed;

-- 投稿タグマスタ
create table M_POST_TAG (
  POST_TAG_ID INT(11) auto_increment not null comment '投稿タグID'
  , NAME VARCHAR(20) not null comment '名称'
  , REGIST_TIME DATETIME not null comment '登録日時'
  , UPDATE_TIME DATETIME not null comment '更新日時'
  , DELETE_FLG TINYINT(1) default 0 not null comment '削除フラグ'
  , VERSION BIGINT default 1 not null comment '楽観チェック用バージョン'
  , constraint M_POST_TAG_PKC primary key (POST_TAG_ID)
) comment '投稿タグマスタ' ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=Compressed;

-- 投稿タグID
create table T_POST_TAG (
  POST_ID INT(11) not null comment '投稿ID'
  , POST_TAG_ID INT(11) not null comment '投稿タグID'
  , constraint T_POST_TAG_PKC primary key (POST_ID,POST_TAG_ID)
) comment '投稿タグID' ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=Compressed;

-- 画像
create table T_IMAGE (
  IMAGE_ID INT(11) not null comment '画像ID'
  , REGIST_TIME DATETIME not null comment '登録日時'
  , UPDATE_TIME DATETIME not null comment '更新日時'
  , DELETE_FLG TINYINT(1) default 0 not null comment '削除フラグ'
  , constraint T_IMAGE_PKC primary key (IMAGE_ID)
) comment '画像' ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=Compressed;

-- 投稿画像
create table T_POST_IMAGE (
  POST_ID INT(11) not null comment '投稿ID'
  , IMAGE_ID INT(11) not null comment '画像ID'
  , constraint T_POST_IMAGE_PKC primary key (POST_ID,IMAGE_ID)
) comment '投稿画像' ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=Compressed;

-- 投稿
create table T_POST (
  POST_ID INT(11) auto_increment not null comment '投稿ID'
  , USER_ID INT(11) not null comment '会員ID'
  , TITLE VARCHAR(100) not null comment 'タイトル'
  , TEXT VARCHAR(500) not null comment '本文'
  , REGIST_TIME DATETIME not null comment '登録日時'
  , UPDATE_TIME DATETIME not null comment '更新日時'
  , DELETE_FLG TINYINT(1) default 0 not null comment '削除フラグ'
  , VERSION BIGINT default 1 not null comment '楽観チェック用バージョン'
  , constraint T_POST_PKC primary key (POST_ID)
) comment '投稿' ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=Compressed;

-- 会員-初期承認
create table T_USER_ONETIME_VALID (
  USER_ID INT(11) not null comment '会員ID'
  , ONETIME_KEY CHAR(32) not null comment 'ワンタイムキー'
  , ONETIME_VALID_TIME DATETIME not null comment 'ワンタイム有効期限'
  , constraint T_USER_ONETIME_VALID_PKC primary key (USER_ID)
) comment '会員-初期承認' ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=Compressed;

-- 会員
create table T_USER (
  USER_ID INT(11) auto_increment not null comment '会員ID'
  , EMAIL VARCHAR(256) not null comment 'メールアドレス'
  , PASSWORD VARCHAR(100) not null comment 'パスワード'
  , FAMILY_NAME VARCHAR(20) not null comment '姓'
  , NAME VARCHAR(20) not null comment '名'
  , FAMILY_NAME_KANA VARCHAR(20) not null comment '姓（カナ）'
  , NAME_KANA VARCHAR(20) not null comment '名（カナ）'
  , ZIP VARCHAR(11) comment '郵便番号'
  , PREFECTURE_ID INT(11) comment '都道府県'
  , AREA VARCHAR(100) comment '市区町村'
  , ADDRESS VARCHAR(100) comment '町名番地'
  , BUILDING VARCHAR(100) comment '建物名'
  , TEL VARCHAR(13) comment '電話番号'
  , SEX INT(11) comment '性別'
  , BIRTHDAY DATE comment '生年月日'
  , LAST_LOGIN_TIME DATETIME comment '最終ログイン日時'
  , STATUS INT(11) not null comment 'ステータス'
  , REGIST_TIME DATETIME not null comment '登録日時'
  , UPDATE_TIME DATETIME not null comment '更新日時'
  , DELETE_FLG TINYINT(1) default 0 not null comment '削除フラグ'
  , VERSION BIGINT default 1 not null comment '楽観チェック用バージョン'
  , constraint T_USER_PKC primary key (USER_ID)
) comment '会員' ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=Compressed;

alter table T_USER_ONETIME_VALID
  add constraint T_USER_ONETIME_VALID_FK1 foreign key (USER_ID) references T_USER(USER_ID);

alter table T_USER_ONETIME_PASS
  add constraint T_USER_ONETIME_PASS_FK1 foreign key (USER_ID) references T_USER(USER_ID);

alter table T_POST_TAG
  add constraint T_POST_TAG_FK1 foreign key (POST_ID) references T_POST(POST_ID);

alter table T_POST_TAG
  add constraint T_POST_TAG_FK2 foreign key (POST_TAG_ID) references M_POST_TAG(POST_TAG_ID);

alter table T_POST_IMAGE
  add constraint T_POST_IMAGE_FK1 foreign key (IMAGE_ID) references T_IMAGE(IMAGE_ID);

alter table T_POST_IMAGE
  add constraint T_POST_IMAGE_FK2 foreign key (POST_ID) references T_POST(POST_ID);

alter table T_POST
  add constraint T_POST_FK1 foreign key (USER_ID) references T_USER(USER_ID);
