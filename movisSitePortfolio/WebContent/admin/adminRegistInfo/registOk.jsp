<%@page import="dao.MovieInfoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>

<%
	String msg = (String)request.getAttribute("msg");
	String url = (String)request.getAttribute("url");
	
%>

<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>