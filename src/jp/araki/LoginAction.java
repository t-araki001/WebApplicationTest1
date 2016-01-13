package jp.araki;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected Connection conn = null;
	protected ResultSet rs = null;

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

		// SELECTで判断
		boolean check = checkUser(id, pass);

		if (check) {
			/* 認証済みにセット */
			session.setAttribute("login", "OK");
			/* セッション設定(60分) tomcat設定のため除外
			session.setMaxInactiveInterval(3600);*/
			/* 本来のアクセス先へ飛ばす */
			response.sendRedirect("setName.jsp");
		} else {
			/* 認証に失敗したら、ログイン画面に戻す */
			session.setAttribute("login", "ログイン失敗");
			response.sendRedirect("login.jsp");
		}

	}

	private boolean checkUser(String id, String pass) {
		// 値がなければ返す
		if (id == null || id.length() == 0 || pass == null || pass.length() == 0) {
			return false;
		}

		try {
			String url = "jdbc:mysql://localhost/login1";
			MyDBAccess db = new MyDBAccess(url);
			db.open();
			// のSQL文実施
			rs = db.getResultSetLogin(id, pass);

			if (rs.next()) {
				db.close();
				return true;
			} else {
				db.close();
				return false;
			}
		} catch (SQLException e) {
			log("SQLException:" + e.getMessage());
			return false;

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return false;
		}

	}

}
