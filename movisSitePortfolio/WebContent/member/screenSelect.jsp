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
<script type="text/javascript" src="<%=request.getContextPath()%>/js/js.js"></script>
</head>
	<body>
	
	<form name="reserveForm" method="post" action="screenSelect2.do">
		<select id="movieNm" name="movieNm">
			<option>영화선택,상영시간</option>
			 <%
			 ArrayList<MovieDTO> mDtos = new ArrayList<MovieDTO>();
			 mDtos=(ArrayList<MovieDTO>)request.getAttribute("mDtos");
			for(MovieDTO mDto:mDtos){
		    %>
			<option value="<%=mDto.getMovieNm()%>"><%=mDto.getMovieNm()%>,상영시간<%=mDto.getMovieTime()%>분</option>
			<%
			}
			%>
			</select>
		  
		<select id="theater" name="theater">
			<option>영화관 선택</option>	
			<option value="영화관1">영화관1</option>	
			<option value="영화관2">영화관2</option>	
			<option value="영화관3">영화관3</option>
			<!-- 영화관 전부 출력 -->	
		</select>
	
		<select id="reservDay" name="reservDay">
			<option>날짜선택</option>
			<!-- js에서 날짜데이터 가져오기 -->
		</select>
	
	
	<input type="submit" value="좌석선택">
	</form>
	
	</body>

</html>












