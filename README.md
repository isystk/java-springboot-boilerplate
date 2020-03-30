# java-springboot-sample
====

## Description

SpringBoot-Doma を利用したマルチモジュールのボイラープレートです。

## 利用している技術

#### インフラ
NginX 1.15
MySQL 5.7
Solr 8.4
phpMyAdmin
MailHog

#### アプリ
Java 11
Maven2
SpringBoot 2.2.5
Doma2
AdminLTE3
Vuejs2


### ディレクトリ構造
```
.
├── docker
│   ├── mysql （DBサーバー）
│   │   ├── conf.d (mysqlの設定ファイル)
│   │   ├── data (mysqlのデータファイル)
│   │   ├── doma2 (doma2のGenファイル)
│   │   ├── init （mysqlの初期DDL）
│   │   ├── logs （mysqlのログ）
│   │   └── script （mysql関連のスクリプト）
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


## 開発環境

### ソースのダウンロード
```bash
$ git clone https://github.com/isystk/java-springboot-sample.git
```

### Eclipseの場合

#### 必要な設定

- Lombok pluginをインストールする。
https://qiita.com/ponsuke0531/items/c2dac01e444f510310ae

- Annotation Processingを有効にする。
https://doma.readthedocs.io/en/2.5.0/annotation-processing/#eclipse

businessプロジェクトの「プロパティ」－「Javaコンパイラ」－「注釈処理」を有効にする
ファクトリーパスで「JARの追加」を選択後に以下のJARを追加する
docker\mysql\doma2\lib\doma-2.27.0.jar
"business\target\classes\com\isystk\sample\domain\dao" 以下に "XXImpl.class"が追加されていれば成功です。

### Docker APIの有効化

#### Windows10の場合
* Settings > General > `Expose daemon on tcp://...`をONにする。

#### MacOSXの場合
* デフォルトで`unix:///var/run/docker.sock`に接続できる。
* TCPでAPIを利用したい場合は、下記を実施する。

```bash
$ brew install socat
$ socat -4 TCP-LISTEN:2375,fork UNIX-CONNECT:/var/run/docker.sock &
```

### Dockerの起動
NginX、MySQLなどのサーバーを立ち上げる。

#### Windows10、MacOSXの場合
```bash
$ ./dc.sh start
```

### アプリケーションの設定
```bash
$ cd /path/to/java-springboot-sample
$ ./mvnw -X -U eclipse:clean eclipse:eclipse -P ut -f pom.xml
```

### アプリケーションの起動

```bash
$ # front application
$ cd /path/to/java-springboot-sample
$ ./mvnw spring-boot:run
```

### 接続先情報
#### テストユーザー test@sample.com / passw0rd

| 接続先| URL|
| :-----| :---------------------------------------|
| 管理側画面| https://localhost/admin|
| フロント側| https://localhost/|
| フロントAPI| https://localhost/api/v1/post|
| :-----| :---------------------------------------|
| phpMyAdmin| http://localhost:8888/|
| Solr| http://localhost:8983/solr/|
| MailHog| http://localhost:8025/|

#### データベース接続先

```bash
# Windows10、MacOSXの場合
mysql -h 127.0.0.1 -P 3306 -uroot -ppassword sample
```

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

[MIT](https://github.com/isystk/java-springboot-sample/LICENCE)

## Author

[isystk](https://github.com/isystk)


