package jp.araki;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginCheckDel")
public class LoginCheckDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected Connection conn = null;
	protected ResultSet rs = null;

	public LoginCheckDel() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);


		String login = (String) session.getAttribute("login");
		if (login == null || !login.equals("OK")) {
			//直接飛んできたらログインに返す
			session.setAttribute("login", "ログインしないと利用できません");
			response.sendRedirect("login.jsp");
		}else{
			session.setAttribute("login", "OK");
			response.sendRedirect("setDel.jsp");
		}
	}
}
