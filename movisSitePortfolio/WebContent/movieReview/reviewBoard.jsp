<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 아티클시작 -->
<article>
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