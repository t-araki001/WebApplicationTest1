<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");

		String id_str = "araki";
		String pass_str = "keyport01";

		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		if (id.equals(id_str) && pass.equals(pass_str)) {
			session.setMaxInactiveInterval(600);
			session.setAttribute("login", "true");
			pageContext.forward("./setName.jsp");
		} else {
			session.setAttribute("login", "false");
			pageContext.forward("./login.jsp");
		}
	%>
</body>
</html>