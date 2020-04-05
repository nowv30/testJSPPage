package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MovieInfoDAO;
import dao.ScreenDAO;
import dto.MovieDTO;
import dto.ScreenDTO;

public class ScreenSelectCommand implements Command{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<MovieDTO> mDtos = new ArrayList<MovieDTO>();
		MovieInfoDAO mDao = MovieInfoDAO.getInstance();
		mDtos=mDao.selectMovie();
		
	
		ArrayList<ScreenDTO> sDtos= new ArrayList<ScreenDTO>();
		ScreenDAO sDao = ScreenDAO.getInstance();
		sDtos = sDao.selectScreenInfo();
		
		request.setAttribute("mDtos", mDtos);
		request.setAttribute("sDtos", sDtos);
		
		
	}
}
