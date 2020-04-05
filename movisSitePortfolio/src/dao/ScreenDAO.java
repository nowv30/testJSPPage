package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.ScreenDTO;

public class ScreenDAO {

	private static ScreenDAO insScreen = new ScreenDAO();

	private ScreenDAO() {
	};

	public static ScreenDAO getInstance() {
		return insScreen;
	}
	
	//상영관에 영화 등록하기
	public int registScreen(String theaterCd, String roomCd, int movieCd, String screenDate, String screenStart, String screenEnd) {
		Connection dbconn = null;
		PreparedStatement pstmt = null;
		SimpleDateFormat sdt = new SimpleDateFormat("yyMMddHHmmss");
		Date resDay = new Date();
		int n = 0;
		
		dbconn = getConnection();
		String sql = "insert into screen values(?,?,?,?,?,?,?)";
		String screenCd ="scr"+sdt.format(resDay);
		
		
		try {
			pstmt = dbconn.prepareStatement(sql);
			pstmt.setString(1, screenCd);
			pstmt.setString(2, theaterCd);
			pstmt.setString(3, roomCd);			
			pstmt.setInt(4, movieCd);
			pstmt.setString(5, screenDate);
			pstmt.setString(6, screenStart);
			pstmt.setString(7, screenEnd);
			
		n = pstmt.executeUpdate();
			
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
		return n;	
	}

	//등록한 영화상영관 목록 보기
	public ArrayList<ScreenDTO> selectScreenInfo() {
		Connection dbconn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ScreenDTO> sDtos = new ArrayList<ScreenDTO>();
		ScreenDTO sDto = null;
		
		
		dbconn=getConnection();
		String sql ="select s.screenCd, t.theaterNm, r.roomNm, m.movieNm, s.screenDate, s.screenStart, s.screenEnd "
				+ "from screen s, theater t, room r, movieInfo m "
				+ "where s.theaterCd=t.theaterCd and s.roomCd=r.roomCd and s.movieCd=m.movieCd";
				
		try {
			pstmt=dbconn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String screenCd=rs.getString("screenCd");
				String theaterNm=rs.getString("theaterNm");
				String roomNm=rs.getString("roomNm");
				String movieNm=rs.getString("movieNm");
				String screenDate=rs.getString("screenDate");
				String screenStart=rs.getString("screenStart");
				String screenEnd=rs.getString("screenEnd");
				
				sDto = new ScreenDTO(screenCd,theaterNm,roomNm,movieNm
						,screenDate,screenStart,screenEnd);
				sDtos.add(sDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(dbconn!=null)dbconn.close();
				} catch (SQLException e) {
					System.out.println(e);
				}
		}
		return sDtos;
	}
	
	
	//등록한 영화상영관 개수 입력
	public int countScreenInfo() {
		Connection dbconn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int n=0;
		try {
			dbconn=getConnection();
			String sql =" select conut(*) from screen;";
			pstmt=dbconn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs!=null) {
				n= rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}finally {
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(dbconn!=null)dbconn.close();
				} catch (SQLException e) {
					System.out.println(e);
				}
		}
		return n;
	}
	
	//맴버 상영가능 영화 선택
	//맴버가 선택한 영화, 영화관, 상영일자를 기준으로 시청가능한 영화 시간표를 표시
	
	
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
