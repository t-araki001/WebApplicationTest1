# WebApplicationTest1

ようこそ！
荒木 拓郎 さま
石丸 圭 さま

上記のように
DBのUSERテーブルに登録されているユーザ全員の指名を表示するページを
Tomcat&JSPを使って(ローカルでhttp://localhost:8080/xxxxxにアクセスして)作成。
（Spring/Hibernate等のフレームワークの使用禁止）

DBの「USER」テーブル定義
カラム
「FIRST_NAME」 VARCHAR型(255)
「LAST_NAME」 VARCHAR型(255)


2015/01/08 
SQLインジェクション対策にprepareStatementを追加
合わせてSQLの処理および内容もMyDBAccessクラスに移動

XSS対策をEscapeクラスに移動
検索機能(仮)を追加