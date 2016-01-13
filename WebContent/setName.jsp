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
<%
request.setCharacterEncoding("utf-8");
String login = (String)session.getAttribute("login");
if (login == null || !login.equals("OK")){
	//直接飛んできたらログインに返す
	session.setAttribute("login", "ログインしないと利用できません");
	response.sendRedirect("login.jsp");
}
%>
<%=login %>
	<h1>ユーザ登録</h1>
	<h2>登録したい名字、名前をそれぞれ入力</h2>
	<form action="./CheckName" method="POST" onsubmit="return check(this);">
		<table>
			<tr>
				<td>名字：</td>
				<td><input type="text" name=FIRST_NAME></td>
			</tr>
			<tr>
				<td>名前：</td>
				<td><input type="text" name="LAST_NAME"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="登録"></td>
			</tr>
		</table>
			<p><a href = showName.jsp>Topに戻る</a></p>
	</form>
	<hr>

	<form action="./Logout" method="GET" onsubmit="return check2();">
		<table>
			<tr>
				<td></td>
				<td><input type="submit" value="ログアウト"></td>
			</tr>
		</table>
	</form>

	<script type="text/javascript">
		function check(chk) {
			if(chk.elements["FIRST_NAME"].value=="" || chk.elements["FIRST_NAME"].value == null){
	            alert("名字が未入力です");
	            return false;
	        }else if(chk.elements["LAST_NAME"].value=="" || chk.elements["LAST_NAME"].value == null){
	            alert("名前が未入力です");
	            return false;
	        }
		}

		function check2(){
			if(window.confirm('ログアウトしますよ？')){
			}else{
		        return false;
			}
		}
	</script>
</body>
</html>