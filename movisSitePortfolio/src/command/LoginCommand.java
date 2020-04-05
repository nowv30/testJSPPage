package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

public class LoginCommand implements Command{
@Override
public void execute(HttpServletRequest request, HttpServletResponse response) {
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	MemberDAO mDao = MemberDAO.getInstance();
	
	int result = mDao.CheckMember(id, pw);
	
		if(result!=MemberDAO.loginOk) {
			System.out.println("DB에 없는 회원아이디입니다.");
		}else {
			System.out.println("고객아이디로 로그인합니다.");
			request.setAttribute("memId", id);//내가입력한 id를 memId란 이름으로 request에 보낸다.
		}
	}
}

