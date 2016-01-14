package jp.araki;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CheckName")
public class CheckName extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		String login = (String)session.getAttribute("login");
		if (login == null || !login.equals("OK")){
			//セッションなしで進んで来たら戻す
			session.setAttribute("login", login);
			response.sendRedirect("login.jsp");
		}else{

		//サニタイジング
		Escape xss = new Escape();
		String FIRST_NAME = request.getParameter("FIRST_NAME");
		String LAST_NAME = request.getParameter("LAST_NAME");
		FIRST_NAME = xss.escapeXSS(FIRST_NAME);
		LAST_NAME = xss.escapeXSS(LAST_NAME);

		request.setAttribute("FIRST_NAME",FIRST_NAME);
		request.setAttribute("LAST_NAME",LAST_NAME);

		// トークンをセッションに保存
		session.setAttribute("token", session.getId());

		getServletConfig().getServletContext()
		.getRequestDispatcher("/checkName.jsp")
		.forward(request, response);
		}
	}
}