<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page import="java.sql.*"%>
<%
	Class.forName("com.mysql.jdbc.Driver");
	Connection users = DriverManager.getConnection(
			"jdbc:mysql://localhost/webtest1", "root", "primrose0");
	Statement state = users.createStatement();
	ResultSet result = state.executeQuery("select * from user");
	String html = "<table width=500>";

	while (result.next()) {
		String FIRST_NAME = result.getString("FIRST_NAME");
		String LAST_NAME = result.getString("LAST_NAME");
		html += "<tr nowrap>" + FIRST_NAME + LAST_NAME + "さま" + "</tr>";
	}
	html += "</table>";
	result.close();
	state.close();
	users.close();
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
	<hr>

	<h2>ユーザ追加</h2>
	<form action="./AddUser" method="POST">
		<table>
			<tr>
				<td>FIRST_NAME</td>
				<td><input type="text" name=FIRST_NAME></td>
			</tr>
			<tr>
				<td>END_NAME</td>
				<td><input type="text" name="LAST_NAME"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="送信"></td>
			</tr>
		</table>
	</form>
	<hr>

	<h2>ユーザ削除(未完成)</h2>
	<form action="./DelUser" method="POST">
		<table>
			<tr>
				<td>FIRST_NAME</td>
				<td><input type="text" name="FIRST_NAME"></td>
			</tr>
						<tr>
				<td>END_NAME</td>
				<td><input type="text" name="LAST_NAME"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="送信"></td>
			</tr>
		</table>
	</form>

</body>
</html>