<%@page import="dto.MovieDTO"%>
<%@page import="dao.MovieInfoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kobisAPI.JsonToObject" %>
<%@ page import="kobisAPI.BoxOffice" %>
<%@ page import="kobisAPI.BoxOfficeResult" %>
<%@ page import="kobisAPI.DailyBoxOfficeList" %>
<%@ page import="java.util.ArrayList" %>

<!-- 아티클시작 -->
<article>
    <div class="poster" style="background:#21212166;">
        <div class="posterRemote">
            <ul class="posterTitle">
                <li>
                    <h2>오늘의 박스오피스</h2>
                        <ul class="posterBtn">     
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
								<div class=movieInfo style="color:gainsboro; font-size: 7pt;">
							<%
		    					String imgPath = request.getContextPath()+
		    					"/uploadedFile/"+mDto.getMoviePoster();
		    				%>		    				
		    						<img src="<%=imgPath%>" border="0" width="125" height="204">
														
								</div>
							</li>		
<%
		}else{
%>		
							<li>
								<div class=movieInfo style="color:gainsboro; font-size: 7pt;">
								이름:<%=dlist.getMovieNm()%><br/>
								개봉일:<%=dlist.getOpenDt()%><br/>
								영화코드:<%=dlist.getMovieCd()%><br/>
								영화순위:<%=dlist.getRank()%><br/>
								</div>
							</li>								
<%
		}
	}
%>
                        </ul>
                </li>
            </ul>
        </div>
    </div>
  
    <div class="board">
        <ul class="ulTitle">
            <!-- 게시물 목록 -->
            <li>
                <h2>영화리뷰</h2>
                <ul class ="ulTable">
                    <li>
                        <ul>
                            <li>No</li>
                            <li>제목</li>
                            <li>작성일</li>
                            <li>작성자</li>
                            <li>조회수</li>
                        </ul>
                    </li>
                    <!-- 게시물 출력 -->
                    <li>
                        <ul>
                            <li>1</li>
                            <li class="left">제목제목제목제목1</li>
                            <li>2020.02.16</li>
                            <li>작성자1</li>
                            <li>0</li>
                        </ul>
                    </li>
                    <li>
                        <ul>
                            <li>1</li>
                            <li class="left">제목제목제목제목1</li>
                            <li>2020.02.16</li>
                            <li>작성자1</li>
                            <li>0</li>
                        </ul>
                    </li><li>
                        <ul>
                            <li>1</li>
                            <li class="left">제목제목제목제목1</li>
                            <li>2020.02.16</li>
                            <li>작성자1</li>
                            <li>0</li>
                        </ul>
                    </li> 

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
</article>
<!-- 아티클 끝 -->
