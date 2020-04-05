<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
	alert("회원가입이 되었습니다. 로그인해주세요");
</script>
<%
	response.sendRedirect("login.do");
%>