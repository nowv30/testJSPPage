<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--헤더시작-->
<header>
	<div class="title">
<%
	if(session.getAttribute("memId")!=null){
%>
		<a href="memberMain.do">
			<h1>영화예매사이트</h1>
		</a>
	</div>

	<div class="menuRemote">
		<ul class="menuBtn">
			<li><a href="infoMain.do">영화소개</a></li>
			<li><a href="screenSelect.do">영화예매</a></li>
			<li><a href="movieReview.do">영화리뷰</a></li>

<%
	}else if(session.getAttribute("adId")!=null){
%>
		<a href="adminMain.do">
			<h1>영화예매사이트</h1>
		</a>
	</div>

	<div class="menuRemote">
		<ul class="menuBtn">
			<li><a href="adminRegistInfo.do">영화소개관리</a></li>
			<li><a href="adminRegistScreen.do">영화상영등록</a></li>
			<li><a href="movieReview.do">영화리뷰관리</a></li>
		</ul>
	</div>
<%                	   
	}else{
%>
	<a href="main.do">
		<h1>영화예매사이트</h1>
	</a>
	</div>

	<div class="menuRemote">
		<ul class="menuBtn">
			<li><a href="infoMain.do">영화소개</a></li>
			<li><a href="#">영화예매</a></li>
			<li><a href="movieReview.do">영화리뷰</a></li>
		</ul>
	</div>
<%
	}
%>
</header>
<!-- 헤더 끝 -->