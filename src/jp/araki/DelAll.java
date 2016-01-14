package jp.araki;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DelAll")
public class DelAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DelAll() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse responce) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse responce) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try{
				MyDBAccess db = new MyDBAccess();
				db.open();
				db.getResultSet("delete from user");
				db.close();

		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		responce.sendRedirect("Start");

	}
}
