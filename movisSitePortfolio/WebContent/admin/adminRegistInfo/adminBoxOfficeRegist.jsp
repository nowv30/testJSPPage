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

.posterReview li{border: 1px solid black; margin:2px; text-align: left; }

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
%>     	                      

							<li>
							<form method="post" action="registOk.do" enctype="multipart/form-data">
<%
	for(DailyBoxOfficeList dlist:dlists){   
%>	
						
							<label for="<%=dlist.getMovieNm() %>"><%=dlist.getRank()%>등 : <%=dlist.getMovieNm() %></label>
							<input type="radio" id="<%=dlist.getMovieNm() %>" value="<%=dlist.getMovieNm() %>,<%=dlist.getMovieCd() %>" name="choiceMovie" enctype="multipart/form-data" style="resize:none;">
                           	<a href="http://kobis.or.kr/kobis/business/mast/mvie/searchMovieList.do?dtTp=movie&dtCd=<%=dlist.getMovieCd()%>" style= "color: gainsboro;" target="_blank">영화정보확인(클릭)</a>
							<br/>                         									 							
<%
	}							     
%>                            
								<input type="text" name="movieDirector" placeHolder="감독입력"/><br/>
								<input type="text" name="movieActors" placeHolder="주연입력"/><br/>
								<input type="number" name="movieTime" placeHolder="상영시간입력(분)"/><br/>
                           		<textarea  name="movieDescribe" rows="10" cols="70" placeholder="줄거리를 입력하세요"></textarea><br/>
                           		
                           		
                           		
								<input type="file" accept="image/*" name="moviePoster" />
                           	                          	
								<input type="submit" value="영화정보등록">
							</form>
							</li>
							
                        </ul>
                        
                </li>
            </ul>
        </div>
    </div>
</article>
<!-- 아티클 끝 -->
