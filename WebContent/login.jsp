<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ログイン画面</title>
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
	<h1>ログイン画面</h1>
	<h2>ログインIDとパスワードを入力してください</h2>
	<font color = red >
	<%=(String)session.getAttribute("login") %>

</font>

	<form action="./LoginAction" method="post">
		<table>
			<tr>
				<td>ID:</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>PASS:</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="送信"><input type="reset"
					value="リセット"></td>
			</tr>
		</table><hr>
	</form>
		<form action="./Start" method="GET" >
		<table>
			<tr>
				<td><input type="submit" value="Topに戻る"></td>
			</tr>
		</table>
	</form>

</body>
</html>