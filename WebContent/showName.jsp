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

	<table>
	<%
		for(Str res : result)
			out.println("<tr>"+"<td>" + res.getFirstName() + " " +res.getLastName()+"さま"+"</td></tr>");
	%>
	</table>

	<p></p>
	※ユーザ追加を行う場合は↓
	<form action="./LoginCheck" method="POST">
		<input type="submit" value="登録">
	</form>

	<p></p>
	※ユーザ検索を行う場合は↓
	<form action="./searchName.jsp" method="POST">
		<input type="submit" value="検索">
	</form>

	<p></p>
	※ユーザ削除を行う場合は↓
	<form action="./LoginCheckDel" method="POST">
		<input type="submit" value="削除">
	</form>
	<hr>

	<form action="./DelAll" method="POST" onsubmit="return check();">
		<table>
			<tr>
				<td></td>
				<td><input type="submit" value="全消し"></td>
			</tr>
		</table>
	</form>

	<script type="text/javascript">
		function check() {
			if (window.confirm('全消ししますよ？')) {
			} else {
				alert('キャンセルされました');
				return false;
			}
		}
	</script>

</body>
</html>