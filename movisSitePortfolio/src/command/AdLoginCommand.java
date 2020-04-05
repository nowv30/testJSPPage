package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;

public class AdLoginCommand implements Command{

	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		AdminDAO aDao = AdminDAO.getInstance();
		int result = aDao.CheckAdmin(id, pw);
		if(result!=AdminDAO.adLoginOk) {
			System.out.println("db에 없는 관리자입니다.");
		}else {
			System.out.println("관리자아이디로 로그인합니다.");
			request.setAttribute("adId", id);
		}
	}
}
