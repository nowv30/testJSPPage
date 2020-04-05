package command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.MovieInfoDAO;

public class MovieRegistCommand implements Command{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String msg = "", url="";

		String uploadPath = request.getRealPath("uploadedFile");
		int maxSize = 1024*1024*10;//10MB
		
		
		try {
			request.setCharacterEncoding("utf-8");
			MultipartRequest multi = new MultipartRequest(request, uploadPath, maxSize, "utf-8",
					new DefaultFileRenamePolicy());

			MovieInfoDAO mDao = MovieInfoDAO.getInstance();
			int n = mDao.registerMovieInfo(multi);
			if(n>0){
				msg = "영화정보가 등록되었습니다.";
				url = "main.do";
					}else{
				msg = "영화정보 등록 실패";
				url = "adminBoxOfficeRegist.jsp";
					}
				
		} catch (IOException | SQLException e) {
			msg = "이미지파일 업로드 실패";
			url = "adminBoxOfficeRegist.jsp";
			e.printStackTrace();
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
	}
}
