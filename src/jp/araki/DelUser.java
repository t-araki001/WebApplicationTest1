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

@WebServlet("/DelUser")
public class DelUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DelUser() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse responce) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse responce) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String FIRST_NAME = request.getParameter("FIRST_NAME");

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection users = DriverManager.getConnection(
					"jdbc:mysql://localhost/webtest1", "root", "keyport01");
			Statement state = users.createStatement();
			int res = state.executeUpdate("delete from user where FIRST_NAME=\"" + FIRST_NAME + "\"");
			state.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		responce.sendRedirect("showName.jsp");

	}
}
