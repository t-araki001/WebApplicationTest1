package jp.araki;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DelUser")
public class DelUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DelUser() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// トークンチェック(CSRF)
		HttpSession session = request.getSession(true);
		String token = (String) session.getAttribute("token");
		if (token == null || !(token.equals(request.getParameter("token")))) {
			// エラー画面へ
			response.sendRedirect("error.jsp");
		} else {
			try {
				String name = request.getParameter("NAME");
				String key = request.getParameter("key");
				MyDBAccess db = new MyDBAccess();
				db.open();
				db.getResultSetDel(name, key);
				db.close();

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("Start");
		}
	}
}
