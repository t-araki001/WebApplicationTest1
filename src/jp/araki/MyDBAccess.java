package jp.araki;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;

//DBに関連するのはここで一括管理
public class MyDBAccess extends HttpServlet {
	private String driver;
	private String url;
	private String user;
	private String password;
	private String sql;
	private Connection conn;
	private Statement state;
	private PreparedStatement pstate;
	private ResultSet res;

	// 引数指定されたらその値で設定
	public MyDBAccess(String driver, String url, String user, String password) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;
	}

	// 引数なしで呼ばれたらこっち
	public MyDBAccess() {
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost/webtest1";
		user = "root";
		password = "keyport01";
	}

	// DB接続
	public void open() throws Exception {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
	}

	// SQL(入力系なし)実施
	public ResultSet getResultSet(String sql) throws Exception {
		state = conn.createStatement();
		if (state.execute(sql)) {
			return state.getResultSet();
		}
		return null;
	}

	public void execute(String sql) throws Exception {
		state.execute(sql);
	}

	// ユーザ追加処理SQL実施
	public ResultSet getResultSetAdd(String FIRST_NAME, String LAST_NAME) throws Exception {
		sql = "insert into user (FIRST_NAME,LAST_NAME) values (?,?)";
		pstate = conn.prepareStatement(sql);
		// ？に値を格納
		pstate.setString(1, FIRST_NAME);
		pstate.setString(2, LAST_NAME);

		pstate.executeUpdate();
		return pstate.getResultSet();
	}

	// ユーザ検索処理SQL実施
	public ResultSet getResultSetSearch(String Search_NAME, String key)	throws Exception {
		if (Integer.parseInt(key) == 1) {
			sql = "SELECT * FROM user WHERE FIRST_NAME=? OR LAST_NAME=?";
			pstate = conn.prepareStatement(sql);
			// ？に値を格納
			pstate.setString(1, Search_NAME);
			pstate.setString(2, Search_NAME);
			pstate.executeQuery();
			return pstate.getResultSet();

		} else if (Integer.parseInt(key) == 2) {
			sql = "SELECT * FROM user WHERE FIRST_NAME=?";
			pstate = conn.prepareStatement(sql);
			// ？に値を格納
			pstate.setString(1, Search_NAME);
			pstate.executeQuery();
			return pstate.getResultSet();

		}else if (Integer.parseInt(key) == 3){
			sql = "SELECT * FROM user WHERE LAST_NAME=?";
			pstate = conn.prepareStatement(sql);
			// ？に値を格納
			pstate.setString(1, Search_NAME);
			pstate.executeQuery();
			return pstate.getResultSet();
		}
		return null;
	}

	// ユーザ削除処理SQL実施
	public ResultSet getResultSetDel(String FIRST_NAME) throws Exception {
		sql = "delete from user where FIRST_NAME=?";
		pstate = conn.prepareStatement(sql);
		// ？に値を格納
		pstate.setString(1, FIRST_NAME);
		pstate.executeUpdate();
		return pstate.getResultSet();
	}

	// DB閉鎖
	public synchronized void close() throws Exception {
		if (res != null)
			res.close();
		if (state != null)
			state.close();
		if (pstate != null)
			pstate.close();
		if (conn != null)
			conn.close();
	}

}
