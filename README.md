# java-springboot-sample

## ローカル環境

ソースのダウンロード
```bash
$ git clone https://github.com/isystk/java-springboot-sample.git
```

### 開発環境（Eclipse）

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

#### Docker Toolboxの場合
* 後述の`Dockerの起動`の手順を実施する。

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
| 管理側画面| http://localhost/admin|
| 管理側API| http://localhost/admin/api/v1/users|
| フロント側| http://localhost/|

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
| [mybatis](https://mybatis.org/mybatis-3/ja/index.html)| O/Rマッパー|
| [mybatis-spring-boot](https://mybatis.org/spring/ja/getting-started.html)| mybatisとSpring Bootを連携する|
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


