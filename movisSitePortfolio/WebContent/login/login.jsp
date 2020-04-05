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
	.loginManu{width: 350px; height:330px; position:relative; border: solid 1px; top:200px ; position: inline-block; margin: 0 auto;}
	 form{ width:252px; height:244px; margin: 0 auto; top:43px;}
	 input { width:250px;  height:80px;  font-size:18px; margin: 4px;}
	 h3{text-align: center;}
</style>
<script>

</script>
<body>
	<div id=wapper>
		
		<%@include file="../header.jsp" %>
		<!--섹션시작-->
             <section>

	              <div class="loginManu">
            		 <h3>로그인하세요</h3>
	                <form action="loginOk.do" method="post">
		                <input type="text" name="id" placeholder="아이디를 입력하세요"/>
		                <br>
		                <input type="password" name="pw" placeholder="패스워드를 입력하세요"/>
		                <br>
		                <input type="submit" value="로그인">
	                </form>
	              </div>
          	</section>
        <!-- 섹션 끝 -->
        
        <%@include file="../footer.jsp"%>
	</div>
</body>
</html>