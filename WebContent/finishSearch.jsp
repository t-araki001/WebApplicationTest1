<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.sql.*,jp.araki.MyDBAccess,jp.araki.Escape"%>

<%

	MyDBAccess db = new MyDBAccess();
	Escape xss = new Escape();

	String Search_NAME = request.getParameter("NAME");
	String key = request.getParameter("key");
	Search_NAME = xss.escapeXSS(Search_NAME);

	db.open();
	//SQL実施
	ResultSet result = db.getResultSetSearch(Search_NAME,key);
	int count=0;

	String html = "<table width=0>";
	while (result.next()) {
		String FIRST_NAME = result.getString("FIRST_NAME");
		String LAST_NAME = result.getString("LAST_NAME");
		FIRST_NAME = xss.escapeXSS(FIRST_NAME);
		LAST_NAME  = xss.escapeXSS(LAST_NAME);

		html += "<tr><td>" + FIRST_NAME + " " + LAST_NAME + "</td>" + "</tr>";
		count++;
	}
	html += "</table>";
	db.close();
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
	<h2>【<%=Search_NAME %>】に該当するユーザは以下の通りです。</h2>
	<%=html%>
	<p><%=count %>名該当してました。</p>
	<p>
		<a href=searchName.jsp>再検索</a>
	</p>
	<p>
		<a href=showName.jsp>Topに戻る</a>
	</p>
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