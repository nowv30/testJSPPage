package command;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ScreenDAO;


public class ScreenRegistCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String msg = "", url="";
		
		String movieCdTm = request.getParameter("movieCdTm");//<%=movieNm %>,<%=movieCd %>,<%=movieTime %>
		
		String[] str= movieCdTm.split(",");
		
		int movieCd=Integer.parseInt(str[0]);//영화코드 ex)20199842
		int movieTime=Integer.parseInt(str[1]);//영화시간(분) ex)120, 128
		String theaterCd = request.getParameter("theater");//영화관 t1,t2,t3
		String screenDate = request.getParameter("reservDay");//날짜ex)2020-1-1		
		String roomCd = request.getParameter("room");//상영관r1,r2,r3,r4,r5		
		String screenStart = request.getParameter("startTime");//시작시간 ex)HH:mm
		String screenEnd = null;
		
		System.out.println(movieCd);//영화코드
		System.out.println(movieTime);//상영시간
		System.out.println(screenDate);//상영일자
		System.out.println(roomCd);//상영관번호
		System.out.println(screenStart);//시작시간
		
		SimpleDateFormat sdt = new SimpleDateFormat("HH:mm");
		Calendar cal = Calendar.getInstance();
		ScreenDAO sDao = ScreenDAO.getInstance();
		
			try {
				Date dscreenStart = sdt.parse(screenStart);
				cal.setTime(dscreenStart);
				cal.add(Calendar.MINUTE, movieTime);
				screenEnd = sdt.format(cal.getTime());
				System.out.println(screenEnd);//종료시간
			
				int n =sDao.registScreen(theaterCd, roomCd, movieCd, screenDate, screenStart, screenEnd);
				
				if(n==1) {
					msg="상영정보가 등록되었습니다.";
					url="adminRegistScreen.do";
				}else {
					msg="상영정보가 등록 실패.";
					url="adminRegistScreen.do";
				}
			} catch (ParseException e) {
				msg="상영정보 등록 실패.";
				url="adminRegistScreen.do";

			}
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
	}

}
