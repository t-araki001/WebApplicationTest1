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
String name = (String)request.getAttribute("NAME");
%>
	<h1>削除内容確認</h1>
	<h2>以下の内容で削除します</h2>
	<form action="./DelUser" method="POST">
		<table>
			<tr>
				<td>対象：<%=name %></td>
				<td><input type="hidden" name="NAME" value=<%=name %>></td>
				<td><input type="hidden" name="token" value="<%=session.getAttribute("token") %>"></td>
				<td><input type="hidden" name="key" value="<%=request.getParameter("key")%>"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="削除"></td>
				<td><INPUT type="button" value="中止" onClick="history.back()">

			</tr>
		</table>
	</form>
	<hr>

</body>
</html>