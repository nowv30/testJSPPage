package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {

	public static final int loginOk = 1;
	public static final int loginFail = -1;
	
	private static MemberDAO insMem = new MemberDAO();
	
	private MemberDAO() {
		
	}
	
	public static MemberDAO getInstance() {
		return insMem;
	}
	
	public int CheckMember(String bid, String bpw) {
		 Connection dbconn = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 int result = 0;
		 
		 try {
			dbconn = getConnection();
			String sql = "select pw from member where id=?";
			pstmt = dbconn.prepareStatement(sql);
			pstmt.setString(1, bid);
			rs = pstmt.executeQuery();	
			
			if(rs.next()) {
				String pw = rs.getString("pw");
				
				if(pw.equals(bpw)) {
					System.out.println("로그인 성공");
					result = loginOk;
				}else {
					System.out.println("로그인 실패");
					result=-loginFail;
				}
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
				try {					
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(dbconn!=null)dbconn.close();
				} catch (SQLException e) {
					System.out.println(e);
				}
		}
		return result;	 
	}
	
	public void CreateMember(String id, String pw, String name, int tel) {
		
			Connection dbconn = null;
			PreparedStatement pstmt = null;
			try {
				dbconn=getConnection();
				String sql = "insert into member values(?, ?, ?, ?)";
				pstmt = dbconn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, pw);
				pstmt.setString(3, name);
				pstmt.setInt(4, tel);
				int n = pstmt.executeUpdate();
				System.out.println("가입정보 DB저장");
				
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
					try {
						if(pstmt!=null)pstmt.close();
						if(dbconn!=null)dbconn.close();
					} catch (SQLException e) {
						System.out.println(e);
					}
			}				 
	}
	
	
	// 커넥션 풀에 있는 커넥션 확보
	private Connection getConnection() {
				
			Context ctx = null;
			DataSource dataSource = null;
			Connection dbconn = null;
			
			try {
				ctx = new InitialContext();
				dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
				dbconn = dataSource.getConnection();
			} catch (Exception e) {
				System.out.println(e);
			}
			
			return dbconn;	
	}
}




