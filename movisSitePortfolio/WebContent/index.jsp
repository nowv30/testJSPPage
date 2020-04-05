<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자로그인</title>
</head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/css.css">
<style>
	.loginManu{width: 350px; height:330px; position:relative; border: solid 1px; top:200px ; position: inline-block; margin: 0 auto;}
	 form{ width:252px; height:244px; margin: 0 auto; top:43px;}
	 input { width:250px;  height:80px;  font-size:18px; margin: 4px;}
	 h3{text-align: center;}
</style>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/js2.js"></script>
<body>
	<div id=wapper>
		
		
		<!--섹션시작-->
             <section>

	              <div class="loginManu">
            		 <h3>관리자로그인</h3>
	                <form action="adminOk.do" id="aForm" method="post" onsubmit="return checkForm();">
		                <input type="text" id="aId" name="id" placeholder="아이디를 입력하세요" focus()/>
		                <br>
		                <input type="password" id="aPw" name="pw" placeholder="패스워드를 입력하세요"/>
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