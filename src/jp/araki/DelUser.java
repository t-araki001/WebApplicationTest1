package jp.araki;

import java.io.IOException;
import java.sql.SQLException;

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
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String FIRST_NAME = request.getParameter("FIRST_NAME");

		try{
				MyDBAccess db = new MyDBAccess();
				Escape xss = new Escape();
				db.open();
				FIRST_NAME = xss.escapeXSS(FIRST_NAME);
				db.getResultSetDel(FIRST_NAME);
				db.close();

		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("Start");

	}
}
