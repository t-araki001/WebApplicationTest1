package jp.araki;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchUser")
public class SearchUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchUser() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse responce) throws ServletException, IOException {
	}
//今は経由のみ
	protected void doPost(HttpServletRequest request,
			HttpServletResponse responce) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try {
			String Search_NAME = request.getParameter("NAME");

			MyDBAccess db = new MyDBAccess();
			db.open();
			db.getResultSet("SELECT * FROM user WHERE FIRST_NAME=\"" + Search_NAME + "\"OR LAST_NAME=\"" + Search_NAME + "\"");
			db.close();
			request.setAttribute("Search_NAME", Search_NAME);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		getServletConfig().getServletContext()
				.getRequestDispatcher("/finishSearch.jsp")
				.forward(request, responce);

	}
}
