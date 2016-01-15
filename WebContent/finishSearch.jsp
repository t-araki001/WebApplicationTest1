<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.sql.*,java.util.*,jp.start.*"%>
<%
	ArrayList<Str> result = (ArrayList<Str>)request.getAttribute("result");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>検索結果画面</title>
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
	<h1>検索結果</h1>
	<h2>【<%=request.getAttribute("NAME")%>】に該当するユーザは以下の通りです。</h2>
	<table>
	<%
		for(Str res : result)
			out.println("<tr>"+"<td>" + res.getFirstName() + " " +res.getLastName() + "</td></tr>");
	%>
	</table>
	<p><%=request.getAttribute("count")%>名該当してました。</p>
	<p>
		<a href=searchName.jsp>再検索</a>
	</p>

	<form action="./Start" method="GET" >
		<table>
			<tr>
				<td><input type="submit" value="Topに戻る"></td>
			</tr>
		</table>
	</form>
	<hr>
	<p>ここで検索も可能</p>
		<form action="./SearchUser" method="POST">
				<p>
		<input type="radio" name="key" value="1" checked>名字or名前
		<input type="radio" name="key" value="2" >名字
		<input type="radio" name="key" value="3"  >名前
		</p>
		<table>
			<tr>
				<td><input type="text" name=NAME><input type="submit" value="検索"></td>
			</tr>
		</table>
	</form>
</body>
</html>