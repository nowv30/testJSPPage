<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>infoMain</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/css.css">
</head>
<body>
	<div id=wapper>
		<%@include file="/header.jsp" %>
		<!--섹션시작-->
             <section>
                <%@include file="/login/loginBox.jsp" %>
				<%@include file="screenRegist.jsp"%>
          	</section>
        <!-- 섹션 끝 -->
        <%@include file="/footer.jsp"%>
	</div>
</body>