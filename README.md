# 手順
spring intializerで springboot徹底入門に書いてある設定値で作成
(ただしjava11を選択)
pom.xml, application.propertiesは本の設定を参考

postgresqlの準備
```
 brew install postgresql
 brew services start postgresql
 psql postgres
 
 # ユーザーの作成
postgres=# CREATE ROLE mrs LOGIN
postgres-#     ENCRYPTED PASSWORD 'md586082399b5082acb54472ee195a57ce8'
postgres-#     NOSUPERUSER INHERIT NOCREATEROLE NOREPLICATION;

# データベースの作成
postgres=# CREATE DATABASE mrs
    WITH OWNER = mrs
    ENCODING = 'UTF8'
    TABLESPACE = pg_default
    LC_COLLATE = 'C'
    LC_CTYPE = 'C'
    TEMPLATE = template0
    CONNECTION LIMIT = -1;

postgres=# \q
```

# 本との違い
- java8でなくjava11を採用している  
    なのでthymeleaf-extras-java8timesとか
    それをつかうtymleafConfigとか作成してない
  
# メモ
このあたりの参考にする(modelとか)
https://github.com/search?q=org%3Aspring-guides+kotlin