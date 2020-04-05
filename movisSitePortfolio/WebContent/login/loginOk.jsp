<%@page import="dto.MemberDTO"%>
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	
	String memId = (String)request.getAttribute("memId");//내가 입력한 id값이 든 memId이름을 memId스트링에 저장
	session.setAttribute("memId", memId);//memId의 값이 든 memId이름을 세션에 저장
	response.sendRedirect("memberMain.do");//로그인필터에 우선 걸린다.
	
%>
	
	
	
	

