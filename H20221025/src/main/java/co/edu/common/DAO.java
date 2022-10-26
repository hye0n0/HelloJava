package co.edu.common;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

// DB연결 Connection 생성
public class DAO {
	public Connection conn;
	public Statement stmt;
	public ResultSet rs;
	public PreparedStatement psmt;

	// Connection 반환 getConnect
	public Connection getConnect() {
		try {
			
			Properties prop = new Properties();
			prop.load(new FileReader("C:/temp/database.properties"));
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String id = prop.getProperty("user");
			String pass = prop.getProperty("passwd");
			Class.forName(driver);
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.125:1521:xe", "jsh", "jsh");
			conn = DriverManager.getConnection(url, id, pass);
			System.out.println("연결성공");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("연결실패");
		}
		return conn;
	}

	// Resource 해제하는 disconnect
	public void disconnect() {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
