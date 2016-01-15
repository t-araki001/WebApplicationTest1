<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ユーザ登録画面</title>
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
	<h1>ユーザ削除</h1>
	<h2>削除したい名字か名前をそれぞれ入力</h2>
	<form action="./CheckNameDel" method="POST" onsubmit="return check(this);">
		<p>
		<input type="radio" name="key" value="1" checked>名字
		<input type="radio" name="key" value="2"  >名前
		</p>
		<table>
			<tr>
				<td><input type="text" name=NAME></td>
			</tr>
			<tr>
				<td><input type="submit" value="削除"></td>
			</tr>
		</table>
	</form>

	<hr>

	<form action="./Logout" method="GET" onsubmit="return check2();">
		<table>
			<tr>
				<td><input type="submit" value="ログアウト" ></td>
			</tr>
		</table>
	</form>

	<form action="./Start" method="GET">
		<table>
			<tr>
				<td><input type="submit" value="Topに戻る"></td>
			</tr>
		</table>
	</form>

	<script type="text/javascript">
		function check(chk) {
			if (chk.elements["FIRST_NAME"].value == ""
					|| chk.elements["FIRST_NAME"].value == null) {
				alert("名字が未入力です");
				return false;
			} else if (chk.elements["LAST_NAME"].value == ""
					|| chk.elements["LAST_NAME"].value == null) {
				alert("名前が未入力です");
				return false;
			}
		}

		function check2() {
			if (window.confirm('ログアウトしますよ？')) {
			} else {
				return false;
			}
		}
	</script>
</body>
</html>