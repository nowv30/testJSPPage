package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ScreenDAO;
import dto.ScreenDTO;

public class ScreenSelectCommand2 implements Command{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String movieNm2 = request.getParameter("movieNm");
		String theater = request.getParameter("theater");
		String reservDay= request.getParameter("reservDay");
		
		ArrayList<ScreenDTO> sDtos1 = new ArrayList<ScreenDTO>();
		ArrayList<ScreenDTO> sDtos2 = new ArrayList<ScreenDTO>();
		
		ScreenDTO sDto = null;
		
		ScreenDAO sDao = ScreenDAO.getInstance();
		sDtos1 = sDao.selectScreenInfo();
		
		for(ScreenDTO sDto1:sDtos1) {
			if(sDto1.getMovieNm().contentEquals(movieNm2)
			   &&sDto1.getTheaterNm().contentEquals(theater)
			   &&sDto1.getScreenDate().contentEquals(reservDay)) {
				
				String screenCd = sDto1.getScreenCd();
				System.out.println(screenCd);
				String roomNm = sDto1.getRoomNm();
				String movieNm = sDto1.getMovieNm();
				String screenStart=sDto1.getScreenStart();
				String screenEnd=sDto1.getScreenEnd();
				
			    sDto = new ScreenDTO(screenCd, roomNm, movieNm, screenStart, screenEnd);
			    sDtos2.add(sDto);
			    
			}
		}
		request.setAttribute("movieNm", movieNm2);
		request.setAttribute("theater", theater);
		request.setAttribute("reservDay", reservDay);
		
		request.setAttribute("sDtos2", sDtos2);
	}
}
