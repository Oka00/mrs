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
https://www.baeldung.com/spring-boot-security-autoconfiguration
```

# 自分用メモ

https://docs.google.com/document/d/1o53_4NgJoax7UDZJE3jC0z-wglhNdWwpE5EJS_XLrBM/edit?usp=sharing
