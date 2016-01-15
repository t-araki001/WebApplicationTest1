package jp.araki;

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

import jp.start.Str;

@WebServlet("/SearchUser")
public class SearchUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchUser() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try{
			MyDBAccess db = new MyDBAccess();
			Escape xss = new Escape();

			db.open();

			String name = request.getParameter("NAME");
			String key = request.getParameter("key");
			int count = 0;

			ResultSet result = db.getResultSetSearch(name,key);
			List<Str> list = new ArrayList<Str>();

			while (result.next()) {
				String firstName = result.getString("FIRST_NAME");
				String lastName = result.getString("LAST_NAME");
				firstName = xss.escapeXSS(firstName);
				lastName = xss.escapeXSS(lastName);

				list.add(new Str(firstName,lastName));
				count++;
			}
			name = xss.escapeXSS(name);
			request.setAttribute("result", list);
			request.setAttribute("NAME",name);
			request.setAttribute("count",count);

			getServletConfig().getServletContext()
			.getRequestDispatcher("/finishSearch.jsp")
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
}
