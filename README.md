# java-springboot-sample

![GitHub issues](https://img.shields.io/github/issues/isystk/java-springboot-sample)
![GitHub forks](https://img.shields.io/github/forks/isystk/java-springboot-sample)
![GitHub stars](https://img.shields.io/github/stars/isystk/java-springboot-sample)
![GitHub license](https://img.shields.io/github/license/isystk/java-springboot-sample)

====

SpringBoot を利用したマルチモジュールのボイラープレートです。
1. 管理画面(AdminLTE、ログイン/ログアウト、一覧/詳細/登録/更新/削除、CSV/Excel/PDFダウンロード)
2. フロント画面（Vuejs、Solr検索API、ログイン/ログアウト）
3. バッチ（Solrインデックス生成、CSV読み込み/DB登録）

## Description

### ディレクトリ構造
```
.
├── docker
│   ├── mysql （DBサーバー）
│   │   ├── conf.d (mysqlの設定ファイル)
│   │   ├── data (mysqlのデータファイル)
│   │   ├── doma-gen (doma2のジェネレータ)
│   │   ├── init （mysqlの初期DDL）
│   │   ├── logs （mysqlのログ）
│   │   ├── script （mysql関連のスクリプト）
│   │   └── sample.a5er （ER図）
│   ├── nginx （Webサーバー）
│   │   ├── conf.d (nginxの設定ファイル)
│   │   ├── public (WEB公開ディレクトリ)
│   │   │   └── thumb （アップロードした写真）
│   │   ├── logs （nginxのログ）
│   │   └── ssl （SSL自己証明書）
│   ├── phpmyadmin （DB管理画面）
│   ├── solr （検索エンジン）
│   │   ├── data (solrのデータファイル)
│   │   └── logs （solrのログ）
│   ├── .env
│   └── docker-compose.yml
├── batch (バッチ)
├── business (共通ロジック)
├── web (Web共通ロジック)
├── web-admin (管理画面)
├── web-front (フロント画面)
├── dc.sh （Dockerの起動用スクリプト）
└── pom.xml （Maven用設定ファイル）
```

## VS. 

### 利用している技術
- Docker
    - NginX 1.15　・・・　WebサーバーとしてNginXを採用しました。自己証明書を設定済みなので開発環境でSSLとして動作可能です。
    - MySQL 5.7　・・・　DBサーバーにはMySQLを採用しました。データファイルや設定ファイル、 ログなどはコンテナの外に出して 開発時に参照出来るようにしています。
    - Solr 8.4　・・・　フロント表示はSolrからデータ取得表示、また、バッチでDB取得したデータをインデックス生成させています。
    - phpMyAdmin　・・・　起動したMySQLのデータを参照・編集するためのツールです。
    - MailHog 　・・・　ダミーのSMTPサーバーです。送信したメールをブラウザで閲覧することが可能です。実際にはメールは送信されないので開発時の誤送信してしまう心配がありません。
- アプリケーション
    - SpringBoot 2.2.5
    - Spring Data Solr
    - Spring Batch
    - Doma2
    - AdminLTE3
    - Vuejs2

## Demo

管理画面
![管理画面](./admin.jpg "管理画面")

フロント画面.
![フロント画面](./front.jpg "フロント画面")

テーブル構成.
![テーブル構成](./er.jpg "テーブル構成")

## Requirement

推奨するJDKのバージョン 8以上 

## Usage

#### Dockerの起動
NginX、MySQL、Solrなどのサーバーを立ち上げる。

##### Windows10、MacOSXの場合
```bash
$ ./dc.sh start
```

#### Eclipse用の初期設定
```bash
$ cd /path/to/java-springboot-sample
$ ./mvnw -X -U eclipse:clean eclipse:eclipse -P ut -f pom.xml
```

#### 実行ファイルの生成

```bash
$ cd /path/to/java-springboot-sample
$ ./mvnw clean package -Dmaven.test.skip=true
```

```bash
$ cd /path/to/java-springboot-sample
# bootrun admin application
$ java -jar web-admin/target/web-admin.jar
# bootrun front application
$ java -jar web-front/target/web-front.jar
```

#### バッチの起動

```bash
$ # bootrun batch application
$ cd /path/to/java-springboot-sample
$ java -jar batch/target/batch.jar "--job=solrRegistJob"
```

#### 接続先情報
##### テストユーザー test@sample.com / password

| 接続先| URL|
| :-----| :---------------------------------------|
| 管理側画面| https://localhost/admin/|
| フロント側| https://localhost/|
| フロントAPI| https://localhost/api/v1/post/|
| phpMyAdmin| http://localhost:8888/|
| Solr| http://localhost:8983/solr/|
| MailHog| http://localhost:8025/|

## Install

### 開発環境構築

#### ソースのダウンロード
```bash
$ git clone https://github.com/isystk/java-springboot-sample.git
```

#### 必要な設定（Eclipseの場合）

- Lombok pluginをインストールする。
https://qiita.com/ponsuke0531/items/c2dac01e444f510310ae

- Annotation Processingを有効にする。
https://doma.readthedocs.io/en/2.5.0/annotation-processing/#eclipse

businessプロジェクトの「プロパティ」－「Javaコンパイラ」－「注釈処理」を有効にする
ファクトリーパスで「JARの追加」を選択後に以下のJARを追加する
docker\mysql\doma-gen\lib\doma-2.27.0.jar
"business\target\classes\com\isystk\sample\domain\dao" 以下に "XXImpl.class"が追加されていれば成功です。

#### Docker APIの有効化

##### Windows10の場合
* Settings > General > `Expose daemon on tcp://...`をONにする。

##### MacOSXの場合
* デフォルトで`unix:///var/run/docker.sock`に接続できる。

## Contribution

1. Fork it ( http://github.com/isystk/java-springboot-sample/fork )
2. Create your feature branch (git checkout -b my-new-feature)
3. Commit your changes (git commit -am 'Add some feature')
4. Push to the branch (git push origin my-new-feature)
5. Create new Pull Request

## 参考

| プロジェクト| 概要|
| :---------------------------------------| :-------------------------------|
| [Lombok Project](https://projectlombok.org/)| 定型的なコードを書かなくてもよくする|
| [Springframework](https://projects.spring.io/spring-framework/)| Spring Framework|
| [Spring Security](https://projects.spring.io/spring-security/)| セキュリティ対策、認証・認可のフレームワーク|
| [Doma2](https://doma.readthedocs.io/ja/stable/)| O/Rマッパー|
| [spring-boot-doma2](https://github.com/domaframework/doma-spring-boot)| Doma2とSpring Bootを連携する|
| [Flyway](https://flywaydb.org/)| DBマイグレーションツール|
| [Thymeleaf](http://www.thymeleaf.org/)| テンプレートエンジン|
| [Thymeleaf Layout Dialect](https://ultraq.github.io/thymeleaf-layout-dialect/)| テンプレートをレイアウト化する|
| [WebJars](https://www.webjars.org/)| jQueryなどのクライアント側ライブラリをJARとして組み込む|
| [ModelMapper](http://modelmapper.org/)| Beanマッピングライブラリ|
| [Ehcache](http://www.ehcache.org/)| キャッシュライブラリ|
| [Spock](http://spockframework.org/)| テストフレームワーク|
| [Mockito](http://site.mockito.org/)| モッキングフレームワーク |

## Licence

[MIT](https://github.com/isystk/java-springboot-sample/blob/master/LICENSE)

## Author

[isystk](https://github.com/isystk)


