<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>検索画面</title>
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

	<h1>検索画面</h1>
	<h2>検索ワードを入力(名字or名前一致)</h2>
	<p>※フルネーム非対応</p>
	<form action="./SearchUser" method="POST">

		<p>
		<input type="radio" name="key" value="1" checked>名字or名前
		<input type="radio" name="key" value="2" >名字
		<input type="radio" name="key" value="3"  >名前
		</p>
		<table>
			<tr>
				<td><input type="text" name=NAME></td>
				<td><input type="submit" value="検索"></td>
				<td><INPUT type="button" value="中止" onClick="window.location.href='showName.jsp'">
			</tr>
		</table>
	</form>

</body>
</html>