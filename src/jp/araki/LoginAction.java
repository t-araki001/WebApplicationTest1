package jp.araki;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginAction() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);

		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		//とりあえず認証条件ほぼなし
		boolean check = authUser(id, pass);

			if (check){
				/* 認証済みにセット */
				session.setAttribute("login", "OK");
				session.setMaxInactiveInterval(3600);
				/* 本来のアクセス先へ飛ばす */
				response.sendRedirect("setName.jsp");
			} else {
				/* 認証に失敗したら、ログイン画面に戻す */
				session.setAttribute("login", "false");
				response.sendRedirect("login.jsp");
			}


	}

	private boolean authUser(String id, String pass) {
		//値がなければ返す
		if(id == null || id.length() == 0 || pass == null || pass.length() == 0){
			return false;
		}

		return true;
	}

}
