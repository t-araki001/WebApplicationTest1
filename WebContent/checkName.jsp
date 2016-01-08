<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*,jp.araki.Escape"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>入力内容確認画面</title>
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
<%
request.setCharacterEncoding("UTF-8");
String FIRST_NAME = request.getParameter("FIRST_NAME");
String LAST_NAME = request.getParameter("LAST_NAME");

//サニタイジング
Escape xss = new Escape();
FIRST_NAME = xss.escapeXSS(FIRST_NAME);
LAST_NAME = xss.escapeXSS(LAST_NAME);

%>
	<h1>登録内容確認</h1>
	<h2>以下の内容で登録します</h2>
	<form action="./AddUser" method="POST">
		<table>
			<tr>
				<td>名字：<%=FIRST_NAME %></td>
				<td><input type="hidden" name="FIRST_NAME" value=<%=FIRST_NAME %>></td>
			</tr>
			<tr>
				<td>名前：<%=LAST_NAME %></td>
				<td><input type="hidden" name="LAST_NAME" value=<%=LAST_NAME %>></td>
				<td><input type="hidden" name="token" value="<%=session.getAttribute("token") %>"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="登録"></td>
				<td><INPUT type="button" value="中止" onClick="history.back()">

			</tr>
		</table>
	</form>
	<hr>

</body>
</html>