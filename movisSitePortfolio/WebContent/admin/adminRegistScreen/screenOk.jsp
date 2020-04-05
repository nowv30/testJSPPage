
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
   String msg = request.getParameter("msg");
   String url = request.getParameter("url");
   %>
   
    <script type="text/javascript">
   		alert(<%=msg %>);
    	url(<%=url%>);
    </script>
