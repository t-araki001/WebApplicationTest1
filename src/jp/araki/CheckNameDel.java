package jp.araki;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CheckNameDel")
public class CheckNameDel extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		String login = (String) session.getAttribute("login");
		if (login == null || !login.equals("OK")) {
			// セッションなしで進んで来たら戻す
			session.setAttribute("login", "ログインが必要です");
			response.sendRedirect("login.jsp");
		} else {

			// サニタイジング
			Escape xss = new Escape();
			String name = request.getParameter("NAME");
			name = xss.escapeXSS(name);

			request.setAttribute("NAME", name);

			// トークンをセッションに保存
			session.setAttribute("token", session.getId());

			getServletConfig().getServletContext()
					.getRequestDispatcher("/checkNameDel2.jsp")
					.forward(request, response);
		}
	}
}