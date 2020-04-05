<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/css.css">
<style>
	.signUpMenu{width: 350px; height:600px; position:relative; border: solid 1px; top:170px ; position: inline-block; margin: 0 auto;}
	 form{ width:250px; height:244px; margin: 0 auto; top:43px;}
	 input { width:250px;  height:80px;  font-size:18px; margin: 4px;}
	 h3{text-align: center; padding: 10px;}
</style>
<body>
	<div id=wapper>
		<%@include file="../header.jsp" %>
		<!--섹션시작-->
             <section>
                <div class=signUpMenu>
                	<h3>회원정보를 입력하세요</h3>
                	<form action="signOk.do" method="post">
                		<input type="text" name="id" placeholder="아이디를 입력하세요"/><br>
                		<input type="password" name="pw" placeholder="비밀번호를 입력하세요"/><br>
                		<input type="text" name="name" placeholder="이름을 입력하세요"/><br>
                		<input type="tel" name="tel" placeholder="전화번호를 입력하세요"/><br>
                		<input type="submit" value="회원가입"/> <input type="reset" value="다시작성"/>
                	</form>
                </div>
          	</section>
        <!-- 섹션 끝 -->
        <%@include file="../footer.jsp"%>
	</div>
</body>
</html>
