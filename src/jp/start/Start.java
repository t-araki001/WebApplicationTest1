package jp.start;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.araki.Escape;
import jp.araki.MyDBAccess;

/**
 * Servlet implementation class Start
 */
@WebServlet("/Start")
public class Start extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Start() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try{
		MyDBAccess db = new MyDBAccess();
		Escape xss = new Escape();
		db.open();
		ResultSet result = db.getResultSet("select * from user");
		List<Str> list = new ArrayList<Str>();
		while (result.next()) {
			String firstName = result.getString("FIRST_NAME");
			String lastName = result.getString("LAST_NAME");
			firstName = xss.escapeXSS(firstName);
			lastName = xss.escapeXSS(lastName);

			list.add(new Str(firstName,lastName));
		}
		request.setAttribute("result", list);

		getServletConfig().getServletContext()
		.getRequestDispatcher("/showName.jsp")
		.forward(request, response);

		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyDBAccess db = new MyDBAccess();
			try {
				db.close();
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
