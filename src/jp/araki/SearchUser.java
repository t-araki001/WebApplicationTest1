package jp.araki;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

	protected void doPost(HttpServletRequest request,
			HttpServletResponse responce) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String Search_NAME = request.getParameter("Search_NAME");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection users = DriverManager.getConnection(
					"jdbc:mysql://localhost/webtest1", "root", "keyport01");
			Statement state = users.createStatement();
			try {
				state.executeUpdate("SELECT * FROM user WHERE (CONVERT(`FIRST_NAME` USING utf8) LIKE '%Search_NAME%' OR CONVERT(`LAST_NAME` USING utf8) LIKE Search_NAME");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			state.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("Search_NAME", Search_NAME);
		getServletConfig().getServletContext()
				.getRequestDispatcher("/finishName.jsp")
				.forward(request, responce);

	}
}
