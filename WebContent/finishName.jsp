<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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

	<h1>登録完了</h1>
	<p><%=request.getAttribute("FIRST_NAME") %> <%=request.getAttribute("LAST_NAME") %>さんの登録が完了しました！</p>
	<p></p>

	<p><a href = showName.jsp>Topに戻る</a></p>
</body>
</html>