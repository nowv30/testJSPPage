package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ScreenDAO;
import dto.ScreenDTO;

public class ScreenInfoCommand implements Command{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	
		ArrayList<ScreenDTO> sDtos = new ArrayList<ScreenDTO>();
		ScreenDAO sDao = ScreenDAO.getInstance();

//		int currentPage=1;//현제 페이지 번호
//		int limit=5;//한 화면에 보여줄 레코드 수

		
		sDtos = sDao.selectScreenInfo();
		
//		int count =sDao.countScreenInfo();
		
		request.setAttribute("sDtos", sDtos);
	
	}
}
