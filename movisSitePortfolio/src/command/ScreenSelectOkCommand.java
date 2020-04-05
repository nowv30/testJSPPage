package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ScreenDAO;
import dao.TicketDAO;
import dto.ScreenDTO;
import dto.TicketDTO;

public class ScreenSelectOkCommand implements Command{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String movieNm = request.getParameter("movieNm");
		String theaterNm = request.getParameter("theater");
		String screenDate = request.getParameter("reservDay");
		String roomNm = request.getParameter("roomNm");
		String screenStart = request.getParameter("screenStart");
		String screenEnd = request.getParameter("screenEnd");
		String seatCd = request.getParameter("seat");
		
		ArrayList<ScreenDTO> sDtos1 = new ArrayList<ScreenDTO>();
		
		ScreenDTO sDto = null;
		
		ScreenDAO sDao = ScreenDAO.getInstance();
		sDtos1 = sDao.selectScreenInfo();
		
		for(ScreenDTO sDto1:sDtos1) {
			if(sDto1.getMovieNm().contentEquals(movieNm)
					&&sDto1.getTheaterNm().contentEquals(theaterNm)
					&&sDto1.getScreenDate().contentEquals(screenDate)
					&&sDto1.getRoomNm().contentEquals(roomNm)
					&&sDto1.getScreenStart().contentEquals(screenStart)
					&&sDto1.getScreenEnd().contentEquals(screenEnd)) {
				
					String screenCd= sDto1.getScreenCd();
					String ticketCd= screenCd+seatCd;
									
					TicketDAO tDao = TicketDAO.getInstance();
					int n = tDao.insertTicket(ticketCd, screenCd, seatCd);
					
						
			}
		}	    
	}

}

