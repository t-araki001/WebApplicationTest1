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
		String FIRST_NAME = request.getParameter("FIRST_NAME");
		String LAST_NAME = request.getParameter("LAST_NAME");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection users = DriverManager.getConnection(
					"jdbc:mysql://localhost/webtest1", "root", "keyport01");
			Statement state = users.createStatement();
			try{
				int res = state.executeUpdate("insert into user set FIRST_NAME=\"" + FIRST_NAME + "\", LAST_NAME=\"" + LAST_NAME + "\"");
			}catch(Exception ex){
				ex.printStackTrace();
			}
			state.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		responce.sendRedirect("showName.jsp");

	}
}
