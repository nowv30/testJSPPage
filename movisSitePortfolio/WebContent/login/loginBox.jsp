<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="loginBox">
<%
	if(session.getAttribute("memId")!=null){	
%>
		<ul>
	     	<li><a href="logout.do">로그아웃</a></li>
	      <li><a href="#">마이페이지</a></li>
	  </ul>
<%  
	}else if(session.getAttribute("adId")!=null){
%>
	   <ul>
	      <li><a href="logout.do">로그아웃</a></li>
	  </ul>
<%
	}else{
%>
	  <ul>
	     
	      <li><a href="login.do">로그인</a></li>
	      <li><a href="signUp.do">회원가입</a></li>
	  </ul>
<%
}
%>                  
	</div>