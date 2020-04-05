package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AdminDAO {
	public static final int adLoginOk = 1;
	public static final int adLoginFail = -1;

	private static AdminDAO insAdm = new AdminDAO();

	private AdminDAO() {

	}

	public static AdminDAO getInstance() {
		return insAdm;
	}

	public int CheckAdmin(String id, String pw) {
		Connection dbconn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			dbconn = getConnection();
			String sql = "select pw from admin where id=?";
			pstmt = dbconn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String dbpw = rs.getString("pw");
				if (dbpw.equals(pw)) {
					System.out.println("로그인성공");
					result = adLoginOk;
				} else {
					System.out.println("로그인실패");
					result = adLoginFail;
				}
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(dbconn != null) dbconn.close();
			} catch (SQLException e) {
				System.out.println(e);
			}		
		}
		return result;
	}
	
	

	// 커넥션 풀에 있는커넥션 확보
	private Connection getConnection() {
		Context ctx = null;
		DataSource dataSource = null;
		Connection dbconn = null;

		try {
			ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			dbconn = dataSource.getConnection();
		} catch (Exception e) {
			System.out.println(e);
		}
		return dbconn;

	}
}
