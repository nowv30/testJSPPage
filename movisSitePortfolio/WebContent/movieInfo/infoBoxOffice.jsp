<%@page import="dto.MovieDTO"%>
<%@page import="dao.MovieInfoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" import="kobisAPI.JsonToObject" %>
<%@ page import="kobisAPI.JsonToObject" %>
<%@ page import="kobisAPI.BoxOffice" %>
<%@ page import="kobisAPI.BoxOfficeResult" %>
<%@ page import="kobisAPI.DailyBoxOfficeList" %>
<%@ page import="java.util.ArrayList" %>
<!-- 아티클시작 -->
<style>
.posterReview{height: 1000px;}
.posterReview li:nth-child(odd){width:125px; border: 1px solid black; margin: 2px; text-align: center;display:inline-block; float: left;}

.posterReview li:nth-child(even){border: 1px solid black; margin:2px; text-align: left; }
.posterReview li:nth-child(even) p{margin:2px; text-align: left; }
.posterReview li:nth-child(even)::after{display: block; content: ""; clear: both;}

</style>

<article>
    <div class="poster" style="background:#21212166;">
        <div class="posterRemote">
            <ul class="posterTitle" >
                <li>
                    <h2>오늘의 박스오피스</h2>
                        <ul class="posterReview"style="overflow:scroll; color: gainsboro"> 
<%
 	JsonToObject jto = new JsonToObject();	
  	String yesterday = jto.getYesterday();
  	ArrayList<DailyBoxOfficeList> dlists= jto.parsingObject(yesterday);
  	
  	MovieInfoDAO mDao = MovieInfoDAO.getInstance();
  	MovieDTO mDto = new MovieDTO();
  	for(DailyBoxOfficeList dlist:dlists){    
  		mDto = mDao.getMovieInfo(dlist.getMovieCd());
  		if(mDto!= null){
 %>     
                            <li>
                            <%
                            	String imgPath = request.getContextPath()+
                            	"/uploadedFile/"+mDto.getMoviePoster();
                            %>
                            <img src="<%=imgPath%>" border="0" width="125" height="204">
                            </li>
                            
                            <li>                            
                                                               제목 :<%=mDto.getMovieNm()%><br/>
							감독:<%=mDto.getMovieDirector() %><br/>
							주연:<%=mDto.getMovieActors() %>                                                               
                                                               상영시간 :<%=mDto.getMovieTime()%>분<br/><br/> 
 						         줄거리 : <%=mDto.getMovieDescribe() %>					                                                             
                            </li>
<%
		}else{
%>                            
							<li><%=dlist.getMovieNm() %></li>
                            <li>내용1</li>						
<%
		}
	}
%>                           
                        </ul>
                </li>
            </ul>
        </div>
    </div>
</article>
<!-- 아티클 끝 -->
