# 手順
spring intializerで springboot徹底入門に書いてある設定値で作成
(ただしjava11を選択)
pom.xml, application.propertiesは本の設定を参考

mysql 準備
```
sudo mysql --password
mysql> create database db_example; -- Creates the new database
mysql> create user 'springuser'@'%' identified by 'ThePassword'; -- Creates the user
mysql> grant all on db_example.* to 'springuser'@'%'; -- Gives all privileges to the new user on the newly created database
以降ののmysqlのログインは mysql --user=springuser --password 
で ThePasswordを入力

```
 参考
```
spring boot徹底入門 13章
以下URL
https://github.com/search?q=org%3Aspring-guides+kotlin
```

application.properties本での設定
```
# JPAで使用するデータベースと接続先の情報を記載
spring.jpa.database=POSTGRESQL 
spring.datasource.url=jdbc:postgresql://localhost:5432/mrs
spring.datasource.username=mrs
spring.datasource.password=mrs

# hibernateの機能でエンティティクラスからDDLをさくせうして自動実行するかどうかのプロパティ
# ここではvalidateを設定しDDLは実行せず、
# エンティティの設定が実際のカラムと矛盾してないかどうかを検査するようにする
spring.jpa.hibernate.ddl-auto=validate

# Sqlをフォーマットしてみやすくする
spring.jpa.properties.hibernate.format_sql=true

# sqlのスクリプトのencoding方法
spring.datasource.sql-script-encoding=UTF-8

# ログレベルの設定と バインドパラメータがログに出力されるようにログレベル設定
# logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
spring.datasource.separator=/;
```
