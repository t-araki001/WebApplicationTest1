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
			HttpServletResponse responce) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse responce) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// トークンチェック(CSRF)
		HttpSession session = request.getSession(true);
		String token = (String) session.getAttribute("token");
		if (token == null || !(token.equals(request.getParameter("token")))) {
			// エラー画面へ
			responce.sendRedirect("error.jsp");
		} else {
			// DB登録
			try {
				String FIRST_NAME = request.getParameter("FIRST_NAME");
				String LAST_NAME = request.getParameter("LAST_NAME");

				MyDBAccess db = new MyDBAccess();
				db.open();
				//INSERTのSQL文実施
				db.getResultSetAdd(FIRST_NAME,LAST_NAME);
				db.close();
				// 完了画面に登録者を受け渡し
				request.setAttribute("FIRST_NAME", FIRST_NAME);
				request.setAttribute("LAST_NAME", LAST_NAME);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			getServletConfig().getServletContext()
					.getRequestDispatcher("/finishName.jsp")
					.forward(request, responce);

		}
	}
}
