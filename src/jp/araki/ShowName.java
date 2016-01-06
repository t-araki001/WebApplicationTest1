package jp.araki;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;

public class ShowName extends HttpServlet {
	private String driver;
	private String url;
	private String user;
	private String password;
	private Connection conn;
	private Statement state;
	private ResultSet res;

	public ShowName(String driver, String url, String user, String password) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public ShowName() {
		driver = "org.postgresql.Driver";
		url = "jdbc:mysql://localhost/webtest1";
		user = "root";
		password = "keyport01";
	}

	public synchronized void open() throws Exception {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
		state = conn.createStatement();
	}

	public ResultSet getResultSet(String sql) throws Exception {
		if (state.execute(sql)) {
			return state.getResultSet();
		}
		return null;
	}

	public void execute(String sql) throws Exception {
		state.execute(sql);
	}

	public synchronized void close() throws Exception {
		if (res != null)
			res.close();
		if (state != null)
			state.close();
		if (conn != null)
			conn.close();
	}
}
