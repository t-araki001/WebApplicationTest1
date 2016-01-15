package jp.araki;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddUser() {
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
			// DB登録
			try {
				String firstName = request.getParameter("FIRST_NAME");
				String lastName = request.getParameter("LAST_NAME");

				MyDBAccess db = new MyDBAccess();
				db.open();
				//INSERTのSQL文実施
				db.getResultSetAdd(firstName,lastName);
				db.close();

			    //サニタイジング
				Escape xss = new Escape();
				firstName = xss.escapeXSS(firstName);
				lastName = xss.escapeXSS(lastName);

				// 完了画面に登録者を受け渡し
				request.setAttribute("FIRST_NAME", firstName);
				request.setAttribute("LAST_NAME", lastName);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			getServletConfig().getServletContext()
					.getRequestDispatcher("/finishName.jsp")
					.forward(request, response);

		}
	}
}
