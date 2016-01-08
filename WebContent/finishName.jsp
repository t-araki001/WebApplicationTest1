<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*,jp.araki.MyDBAccess,jp.araki.Escape"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登録完了画面</title>
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

Escape xss = new Escape();
FIRST_NAME = xss.escapeXSS(FIRST_NAME);
LAST_NAME = xss.escapeXSS(LAST_NAME);

%>

	<h1>登録完了</h1>
	<p><%=FIRST_NAME %> <%=LAST_NAME %>さんの登録が完了しました！</p>
	<p></p>

	<p><a href = showName.jsp>Topに戻る</a></p>
</body>
</html>