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

<form name="reserveForm" method="post" action="screenOk.do">

<select id="movieNm" name="movieCdTm">
	<option>영화선택,상영시간</option>
	 <%
    JsonToObject jto = new JsonToObject();
    String yesterday = jto.getYesterday();
    ArrayList<DailyBoxOfficeList> dlists = jto.parsingObject(yesterday);
           
  	MovieDTO mDto = new MovieDTO();
  	MovieInfoDAO mDao = MovieInfoDAO.getInstance();
  	  	
  	
    for(DailyBoxOfficeList dlist : dlists){
    	mDto = mDao.getMovieInfo(dlist.getMovieCd());
    	if(mDto!=null){	
		
    %>
	<option value="<%=mDto.getMovieCd() %>,<%=mDto.getMovieTime() %>"><%=mDto.getMovieNm() %>, 상영시간:<%=mDto.getMovieTime() %>분</option>
		    	
    <%
    	}else{
    %>
    <option value="<%=dlist.getMovieCd() %>"><%=dlist.getMovieNm() %>, 상영신청불가(미등록된 영화)</option>	
    <%
    	}
    }
    %>
	</select>
    
	<!-- 박스오피스순위대로 영화 출력 -->
	<!-- 상영시간, 누적관객, 일일관객 수 표시 -->
	<!-- 클릭시 영화의 상영시간 정보가 상영시간선택 태그로 넘어간다. -->
	

<select id="theater" name="theater">
	<option>영화관 선택</option>	
	<option value="t1">영화관1</option>	
	<option value="t2">영화관2</option>	
	<option value="t3">영화관3</option>
	<!-- 영화관 전부 출력 -->	
</select>


<select id="reservDay" name="reservDay">
	<option>날짜선택</option>
	<!-- js에서 날짜데이터 가져오기 -->
</select>


<select id="room" name="room">
	<option>상영관 선택</option>
	<!-- 영화관마다 다르게? -->
</select>
 
 
<input type="time" id="startTime" name="startTime">


<!-- 확인하면 상영정보테이블에 영화이름,영화관,날짜,상영관,상영시간이 저장된다. -->
<!-- 영화정보테이블에서 영화이름을 가져오고, 영화관테이블에서 영화관이름, 상영관테이블에서 상영관이름을 가져오고
	  날짜와 상영시간은 영화상영테이블에 직접 저장된다.
 -->
 <!-- 상영정보페이지에서는 상영날짜에 따라 왼쪽부터 오늘 상영정보--n일 상영정보가 나타나며
 	    시간이 지나면 왼쪽으로 넘어가며 나중에는 선택할 수 없게 된다.
  -->
<input type="submit" value="확인하기">
</form>



<div class="board">
        <ul class="ulTitle">
            <!-- 게시물 목록 -->
            <li>
                <h2>상영목록</h2>
                <ul class ="ulTable">
                    <li>
                        <ul>
                            <li>No</li>
                            <li>영화관/상영관/영화제목</li>
                            <li>상영일</li>
                            <li>시작시간</li>
                            <li>종료시간</li>
                        </ul>
                    </li>
                    <!-- 게시물 출력 -->
<%
	ArrayList<ScreenDTO> sDtos = new ArrayList<ScreenDTO>();	
	sDtos =(ArrayList<ScreenDTO>)request.getAttribute("sDtos");
	
		for(ScreenDTO sDto : sDtos){
%>              
	                    <li>
	                        <ul>
	                            <li>번호</li>
	                            <li class="left"><%=sDto.getTheaterNm() %>/<%=sDto.getRoomNm() %>/<%=sDto.getMovieNm() %></li>
	                            <li><%=sDto.getScreenDate() %></li>
	                            <li><%=sDto.getScreenStart() %></li>
	                            <li><%=sDto.getScreenEnd() %></li>
	                        </ul>
	                    </li>
 <%

	}
 %>                
                        <!-- 게시판 페이징-->
                    <li>
                        <div class="divPaging">
                            <div>◀</div>
                            <div><b>1</b></div>
                            <div>2</div>
                            <div>3</div>
                            <div>4</div>
                            <div>5</div>
                            <div>▶</div>
                        </div>
                    </li>

                    <!-- 검색 폼 -->
                    <li class='liSearchOption'>
                        <div>
                            <select class='selSearchOption' >
                                <option value='A'>제목+내용</option>
                                <option value='T'>제목</option>
                                <option value='C'>내용</option>
                            </select>
                            <input id='txtKeyWord' />
                            <input type='button' value='검색'/>
                        </div>
                    </li>                                         
                </ul>
            </li>
        </ul>
    </div>




</body>

</html>