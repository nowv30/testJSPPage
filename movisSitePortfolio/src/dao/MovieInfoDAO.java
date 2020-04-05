package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.spi.DirStateFactory.Result;
import javax.sql.DataSource;

import com.oreilly.servlet.MultipartRequest;

import dto.MovieDTO;

public class MovieInfoDAO {

	private static MovieInfoDAO insMovieInfo = new MovieInfoDAO();

	private MovieInfoDAO() {
	};

	public static MovieInfoDAO getInstance() {
		return insMovieInfo;
	}

	public int registerMovieInfo(MultipartRequest multi) throws SQLException {
		Connection dbconn = null;
		PreparedStatement pstmt = null;
		int n = 0;
		try {
			dbconn = getConnection();
			String sql = "insert into movieInfo values(?,?,?,?,?,?,?)";
			pstmt = dbconn.prepareStatement(sql);

			String choiceMovie = multi.getParameter("choiceMovie");
			String[] str = choiceMovie.split(",");
			
			String movieNm = str[0];
			int movieCd = Integer.parseInt(str[1]);
			String movieDirector = multi.getParameter("movieDirector");
			String movieActors = multi.getParameter("movieActors");
			int movieTime = Integer.parseInt(multi.getParameter("movieTime"));
			String movieDescribe = multi.getParameter("movieDescribe");
			String moviePoster = multi.getFilesystemName("moviePoster");
			
			pstmt.setString(1, movieNm);
			pstmt.setInt(2, movieCd);
			pstmt.setString(3, movieDescribe);
			pstmt.setString(4, moviePoster);
			pstmt.setString(5, movieDirector);
			pstmt.setString(6, movieActors);
			pstmt.setInt(7, movieTime);

			n = pstmt.executeUpdate();
			return n;
		} finally {
			if (pstmt != null)pstmt.close();
			if (dbconn != null)dbconn.close();	
		}
	}

	
	public MovieDTO getMovieInfo(String movieCdj) {
		Connection dbconn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		MovieDTO mInfo = null;

		try {
			dbconn = getConnection();
			String sql = "select * from movieInfo where movieCd=?";
			pstmt = dbconn.prepareStatement(sql);
			pstmt.setString(1, movieCdj);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String movieNm = rs.getString("movieNm");
				String movieCd = rs.getString("movieCd");
				String movieDirector = rs.getString("movieDirector");
				String movieActors = rs.getString("movieActors");
				String movieTime = rs.getString("movieTime");
				String movieDescribe = rs.getString("movieDescribe");
				String moviePoster = rs.getString("moviePoster");
				mInfo = new MovieDTO(movieNm, movieCd, movieDirector, movieActors, movieTime ,movieDescribe, moviePoster);
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
		return mInfo;
	}

	//회원 영화선택(정보등록된 영화들)
	public ArrayList<MovieDTO> selectMovie() {
		Connection dbconn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MovieDTO> mDtos = new ArrayList<MovieDTO>();
		try {
			dbconn=getConnection();
			String sql = "select movieNm, movieTime from movieInfo";
			pstmt=dbconn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String movieNm=rs.getString("movieNm");
				String movieTime=rs.getString("movieTime");
				
				MovieDTO mDto = new MovieDTO(movieNm, movieTime);
				mDtos.add(mDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(dbconn!=null)dbconn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return mDtos;
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
