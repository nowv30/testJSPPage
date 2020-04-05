package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter{
	
	@Override
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
				throws IOException, ServletException {
			
			//서블릿 세션 생성
			HttpServletRequest httpRequest = (HttpServletRequest)request;
			HttpSession session = httpRequest.getSession();
			String memId = (String)session.getAttribute("memId");
			String adId = (String) session.getAttribute("adId");
			//필터
			boolean login=false;
			boolean adLogin = false;
			if(session!=null) {
				System.out.println("세션에 회원아이디가 저장되있습니다.");
				if(memId!=null) {
					System.out.println("저장된 회원아이디는"+memId+"입니다.");
					login=true;
				}else if(adId!=null) {
					System.out.println("저장된 회원아이디는 "+adId+"입니다.");
					adLogin = true;
				}
			}
			
			System.out.println("필터를 넘어갑니다.");
			if(login) {
				chain.doFilter(request, response);
			}else if(adLogin){
				chain.doFilter(request, response);
				
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.do");
				dispatcher.forward(request, response);
			}
		}
	
//@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//	
//		//서블릿은 세션객체를 만들어야 한다.
//		HttpServletRequest httpRequest = (HttpServletRequest)request;
//		HttpSession session = httpRequest.getSession();
//		
//		boolean login=false;
//
//		//필터
//		if(session!=null) {
//			if(session.getAttribute("loginId")!=null) {
//				login = true;
//			}
//		}
//		if(login) {
//			chain.doFilter(request, response);//체인간 이동, 마지막에 자원으로 이동
//		}else {
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/loginForm.jsp");
//			dispatcher.forward(request, response);
//		}
//	}


}
