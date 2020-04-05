<%@page import="dao.ScreenDAO"%>
<%@page import="dto.ScreenDTO"%>
<%@page import="dto.MovieDTO"%>
<%@page import="dao.MovieInfoDAO"%>
<%@ page import="kobisAPI.BoxOffice" %>
<%@ page import="kobisAPI.BoxOfficeResult" %>
<%@ page import="kobisAPI.DailyBoxOfficeList"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="kobisAPI.JsonToObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/js3.js"></script>
</head>
	<%
	String movieNm = (String)request.getAttribute("movieNm");
	String theater = (String)request.getAttribute("theater");
	String reservDay = (String)request.getAttribute("reservDay");
	ArrayList<ScreenDTO> sDtos2 = new ArrayList<ScreenDTO>();
	sDtos2 = (ArrayList<ScreenDTO>)request.getAttribute("sDtos2");
	%>
	<body>

		<select id="screenTime" name="screenime">
			<option>상영시간 선택</option>
			<%
			for(ScreenDTO sDto:sDtos2){
			%>
			<option value="<%=sDto.getRoomNm()%>,<%=sDto.getScreenStart() %>,<%=sDto.getScreenEnd() %>"><%=sDto.getRoomNm()%> :상영시간<%=sDto.getScreenStart() %>~<%=sDto.getScreenEnd() %></option>
			<%
			}
			%>
		</select><br>
<!-- option에서 선택한 sDto에서 원하는 screenCd값을 가져올 수 있다.
	좌석확인 버튼을 누르면 screenCd값을 ticketDAO로 보내어 screenCd값을 가진 행을 ticketDTO 객체배열로 저장한다.
	객체배열의 수 만큼 for문을 돌려 DTO의 seatCd를 배열로 저장한다.
	
	
	
	회원이 선택한 영화이름, 영화관, 상영일, 상영관, 상영시간을 screenCd와 비교한다.
	일치하는 screenCd를 가져와 같은screenCd를 가진 ticketDTO들을 가져온다.
	ticketDTO 수만큼 seatCd를 for문으로 돌려
	
	ticketCd
 -->
	
		<div id=seat>
			<p>스크린</p>
			<br>
			 <input type="button" onclick="myFunction('a1')" value="A-1"/>
			 <input type="button" onclick="myFunction('a2')" value="A-2"/>
			 <input type="button" onclick="myFunction('a3')" value="A-3"/>
			 <input type="button" onclick="myFunction('a4')" value="A-4"/>
			 <input type="button" onclick="myFunction('a5')" value="A-5"/>
			 <input type="button" onclick="myFunction('a6')" value="A-6"/>
			 <br/>
			 <input type="button" onclick="myFunction('b1')" value="B-1"/>
			 <input type="button" onclick="myFunction('b2')" value="B-2"/>
			 <input type="button" onclick="myFunction('b3')" value="B-3"/>
			 <input type="button" onclick="myFunction('b4')" value="B-4"/>
			 <input type="button" onclick="myFunction('b5')" value="B-5"/>
			 <input type="button" onclick="myFunction('b6')" value="B-6"/>
			 <br/>
			 <input type="button" onclick="myFunction('c1')" value="C-1"/>
			 <input type="button" onclick="myFunction('c2')" value="C-2"/>
			 <input type="button" onclick="myFunction('c3')" value="C-3"/>
			 <input type="button" onclick="myFunction('c4')" value="C-4"/>
			 <input type="button" onclick="myFunction('c5')" value="C-5"/>
			 <input type="button" onclick="myFunction('c6')" value="C-6"/>
			 <br/>
			 <input type="button" onclick="myFunction('d1')" value="D-1"/>
			 <input type="button" onclick="myFunction('d2')" value="D-2"/>
			 <input type="button" onclick="myFunction('d3')" value="D-3"/>
			 <input type="button" onclick="myFunction('d4')" value="D-4"/>
			 <input type="button" onclick="myFunction('d5')" value="D-5"/>
			 <input type="button" onclick="myFunction('d6')" value="D-6"/>
			 <br/>
			 <input type="button" onclick="myFunction('e1')" value="E-1"/>
			 <input type="button" onclick="myFunction('e2')" value="E-2"/>
			 <input type="button" onclick="myFunction('e3')" value="E-3"/>
			 <input type="button" onclick="myFunction('e4')" value="E-4"/>
			 <input type="button" onclick="myFunction('e5')" value="E-5"/>
			 <input type="button" onclick="myFunction('e6')" value="E-6"/>
			 <br/>
		</div>
		<br>
	
	<form name="reserveForm" method="post" action="screenOk.do">
	선택영화: <input type="text" name="movieNm" value="<%=movieNm %>" readonly><br>
	선택극장: <input type="text" name="theater" value="<%=theater %>" readonly><br>
	선택일자: <input type="text" name="reservDay" value="<%=reservDay %>" readonly><br>
	선택상영관:<input type="text" name="roomNm" value="" readonly><br>
	시작시간: <input type="text" name="screenStart" value="" readonly><br>
	종료시간: <input type="text" name="screenEnd" value="" readonly><br>
	선택좌석: <input type="text" name="seat" value="" readonly><br><!-- 중복선택, 좌석 수 만큼 티켓 생성 -->
	<input type="submit" value="전송"><br>
	<!-- 전송하는 값을 screen테이블의 행과 비교, 일치하는 행이 있다면 행의 screenCd를 ticket으로 보낸다
		좌석은 ticket으로 보내는데 좌석 수 만큼 ticket이 생성된다.
	 -->
	</form>
	</body>

</html>