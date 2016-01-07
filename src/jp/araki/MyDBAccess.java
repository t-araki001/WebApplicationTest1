package jp.araki;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;

//DBに関連するのはここで一括管理
public class MyDBAccess extends HttpServlet {
	private String driver;
	private String url;
	private String user;
	private String password;
	private Connection conn;
	private Statement state;
	private ResultSet res;

	//引数指定されたらその値で設定
	public MyDBAccess(String driver, String url, String user, String password) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;
	}

	//引数なしで呼ばれたらこっち
	public MyDBAccess() {
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost/webtest1";
		user = "root";
		password = "keyport01";
	}

	//DB接続
	public void open() throws Exception {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
		state = conn.createStatement();
	}

	//SQL実施
	public ResultSet getResultSet(String sql) throws Exception {
		if (state.execute(sql)) {
			return state.getResultSet();
		}
		return null;
	}

	public void execute(String sql) throws Exception {
		state.execute(sql);
	}

	//DB閉鎖
	public synchronized void close() throws Exception {
		if (res != null)
			res.close();
		if (state != null)
			state.close();
		if (conn != null)
			conn.close();
	}

	//クロスサイト他対策
	 public String escapeXSS(String xss) {
		   if (xss == null){
			   return "";
			   }
		   xss = xss.replaceAll("&", "&amp;");
		   xss = xss.replaceAll("<", "&lt;");
		   xss = xss.replaceAll(">", "&gt;");
		   xss = xss.replaceAll("\"", "&quot;");
		   xss = xss.replaceAll("'", "&#39;");

		   return xss;
		 }

}



