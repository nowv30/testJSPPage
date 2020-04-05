package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.TicketDTO;

public class TicketDAO {
	
	
	public static TicketDAO insTicket = new TicketDAO();
	
	private TicketDAO() {}
	
	public static TicketDAO getInstance() {
		return insTicket;
	}
	
	//상영관정보등록
	public int insertTicket(String ticketCd, String screenCd, String seatCd) {
		Connection dbconn = null;
		PreparedStatement pstmt = null;
		int n = 0;
		try {
			dbconn = getConnection();
			String sql ="insert * into ticket"
					+ "values ?,?,?";
			pstmt = dbconn.prepareStatement(sql);
			pstmt.setString(1, ticketCd);
			pstmt.setString(2, screenCd);
			pstmt.setString(3, seatCd);
			
			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(dbconn!=null)dbconn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n;
	}
	

	// connection pool에서 connection 얻어오기
		private Connection getConnection() {
			Context ctx = null;
			DataSource ds = null;
			Connection dbconn = null;

			try {
				ctx = new InitialContext();
				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
				dbconn = ds.getConnection();
			} catch (Exception e) {
				System.out.println(e);
			}

			return dbconn;
		}
}
