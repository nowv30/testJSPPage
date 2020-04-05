<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

String adId = (String)request.getAttribute("adId");
	if(adId!=null){
		session.setAttribute("adId", adId);
		response.sendRedirect("adminMain.do");	
	}
%>
<script>
	alert("잘못된 회원정보입니다.");
	location.href="index.jsp";
</script>

