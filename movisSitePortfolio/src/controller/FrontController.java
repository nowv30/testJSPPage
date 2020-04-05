package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Dispatch;

import command.AdLoginCommand;
import command.Command;
import command.LoginCommand;
import command.MovieRegistCommand;
import command.ScreenInfoCommand;
import command.ScreenRegistCommand;
import command.ScreenSelectCommand;
import command.ScreenSelectCommand2;
import command.ScreenSelectOkCommand;
import command.SignUpCommand;

/**
 * Servlet implementation class MemberFrontCon
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FrontController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet으로 받음");
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost로 받음");
		actionDo(request,response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo메소드 호출받음");
		request.setCharacterEncoding("UTF-8");
		
		Command command = null;
		String viewPage = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String cmd = uri.substring(conPath.length());
		
		System.out.println("cmd주소: "+cmd);
		
		//로그인 로그아웃 회원가입 관련 요청 start
		if(cmd.equals("/login.do")) {
			System.out.println("login.do요청받음(로그인)");
			viewPage="/login/login.jsp";
			
		}else if(cmd.equals("/signUp.do")) {
			System.out.println("signUp.do요청받음(외원가입)");
			viewPage="/login/signUp.jsp";
		
		}else if(cmd.equals("/signOk.do")){
			System.out.println("signOk.do요청받음(id,pw,name,tel)");
			command = new SignUpCommand();
			command.execute(request, response);
			viewPage="/login/signOk.jsp";
			
		}else if(cmd.equals("/loginOk.do")) {
			System.out.println("loginOk.do 요청받음(id,pw)");
			command = new LoginCommand();
			command.execute(request, response);
			viewPage="/login/loginOk.jsp";
		
		
		}else if(cmd.equals("/memberMain.do")) {
			viewPage="/member/memberMain.jsp";
		
		}else if(cmd.equals("/logout.do")){
			System.out.println("logout.do요청받음(로그인해제)");
			viewPage="/login/logout.jsp";
			
		}else if(cmd.equals("/main.do")) {
			System.out.println("main.do요청받음(매인페이지로 이동)");
			viewPage="/main.jsp";
		//로그인 로그아웃 회원가입 관련 요청 end
		
		//관리자 관련 요청 start
		}else if(cmd.equals("/adminOk.do")) {
		command = new AdLoginCommand();	
		command.execute(request, response);
		viewPage="/admin/adminLogin/adminOk.jsp";
			
		}else if(cmd.equals("/adminMain.do")) {
			viewPage="/admin/adminMain.jsp";
			
		}else if(cmd.equals("/adminRegistInfo.do")) {
			viewPage="/admin/adminRegistInfo/adminRegistInfo.jsp";
		
		}else if(cmd.equals("/registOk.do")) {
			command = new MovieRegistCommand();
			command.execute(request, response);
			viewPage="/admin/adminRegistInfo/registOk.jsp";
			
		}else if(cmd.equals("/adminRegistScreen.do")) {//상영등록
			command = new ScreenInfoCommand();
			command.execute(request, response);
			viewPage="/admin/adminRegistScreen/screenOk.do";
			
		}else if(cmd.equals("/screenOk.do")) {	
			command = new ScreenRegistCommand();
			command.execute(request, response);
			viewPage="/admin/adminRegistScreen/screenOk.jsp";
				
		//관리자 관련 요청 end
			
		//영화소개 관련 요청 start
		}else if(cmd.equals("/infoMain.do")) {
			System.out.println("infoMain.do요청받음(영화소개로 이동)");
			viewPage="/movieInfo/infoMain.jsp";
		
		//영화소개 관련 요청 end
			
		//영화예매 관련 요청 start
		}else if(cmd.equals("/screenSelect.do")){	
			command = new ScreenSelectCommand();
			command.execute(request, response);
			viewPage="/member/memberScreenSelect.jsp";
			
			
		}else if(cmd.equals("/screenSelect2.do")){
			command = new ScreenSelectCommand2();
			command.execute(request, response);
			viewPage="/member/memberScreenSelect2.jsp";
			
		}else if(cmd.equals("/screenOk.do")){	
			command = new ScreenSelectOkCommand();
			command.execute(request, response);
			viewPage="/member/screenOk.jsp";
		//영화예매 관련 요청 end
		
		//영화리뷰 관련 요청 start
		}else if(cmd.equals("/movieReview.do")){
			System.out.println("movieReview.do요청받음(영화리뷰)");
			viewPage="/movieReview/reviewMain.jsp";
		}
		
		//영화리뷰 관련 요청 end
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
