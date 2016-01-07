<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page import="java.sql.*,jp.araki.MyDBAccess"%>
<%
	MyDBAccess db = new MyDBAccess();
	db.open();
	ResultSet result = db.getResultSet("select * from user");
	String html = "<table width=0>";
	while (result.next()) {
		String FIRST_NAME = result.getString("FIRST_NAME");
		String LAST_NAME = result.getString("LAST_NAME");
		FIRST_NAME = db.escapeXSS(FIRST_NAME);
		LAST_NAME = db.escapeXSS(LAST_NAME);

		html += "<tr><td>" + FIRST_NAME + " " + LAST_NAME
		+ "</td> <td>さま</td>" + "</tr>";
	}
	html += "</table>";
	db.close();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>DataBase List</title>

<style>
h1 {
	font size: 10t;
	font-weight: bold;
	background-color: #DDF;
	padding: 3px;
}
</style>
</head>
<body>
	<h1>データベースアクセステスト</h1>
	<h2>ようこそ！！</h2>
	<%=html%>

	<p>※ユーザ追加を行う場合は<a href = setName.jsp>こちら</a></p>
	<p>※ユーザ検索を行う場合は<a href = searchName.jsp>こちら</a></p>
	<hr>


	<h2>ユーザ削除(掃除用。名字判定のみ)</h2>
	<form action="./DelUser" method="POST">
		<table>
			<tr>
				<td>名字：</td>
				<td><input type="text" name="FIRST_NAME"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="送信"></td>
			</tr>
		</table>
	</form>
	<hr>
	<form action="./DelAll" method="POST"  onsubmit="return check();">
		<table>
			<tr>
				<td></td>
				<td><input type="submit" value="全消し"></td>
			</tr>
		</table>
	</form>

<script type="text/javascript">
function check(){
	if(window.confirm('全消ししますよ？')){
	}else{
		alert('キャンセルされました');
        return false;
	}
}
</script>

</body>
</html>