package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;

public class SignUpCommand implements Command{
@Override
public void execute(HttpServletRequest request, HttpServletResponse response) {
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	int tel = Integer.parseInt(request.getParameter("tel"));
	
	MemberDAO mDao = MemberDAO.getInstance();
	mDao.CreateMember(id, pw, name, tel);
	

	}
}
