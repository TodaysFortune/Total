<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- 대입문,제어문 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><!-- 서식지정 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%><!-- 함수 -->
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>레이아웃</title>
        <!-- Bootstrap core CSS , js -->
        <link type="text/css" href="/css/bootstrap.min.css" rel="stylesheet"> 
        <script type="text/javascript" src="/js/bootstrap.js"></script>
        
        <!-- Custom styles for this template -->
        <link type="text/css" href="/css/navbar.css" rel="stylesheet"> 
        <link type="text/css" href="/css/boardwrite.css" rel="stylesheet"> 
    </head>
    
<body>
	
    <!--상단 https://bootswatch.com/sketchy/-->
   <nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <jsp:include page="/WEB-INF/views/common/nav.jsp" flush="false"/>
	</nav>
    <!--//상단 -->
<!-- 중단 -->
	<div class="container-column-align" style="height: 100%; margin-top:1rem;">
        <div class="container-column" style="width: 80vw; min-width: 259.2px;">
            <div style="font-size:1.5rem; font-weight:900; position:relative; top:5px; left:5px;">IT 게시판</div>
            <div><hr/></div>
            <form style="margin-top:10px;" action="/itboard/contentView/updateBoard" method="post" onsubmit="return emptySubjectContentCheck();">
                <div style="margin-bottom:5px; display:flex; justify-content:space-between;">
                	
                    <input type="text" name="subject" onkeyup="fn_checkByte_subject(this,100)" placeholder="제목을 입력해주세요" style="height:1.7rem; width:40rem" value="${boardDTO.subject}"/>
                	<div>
                		<span>조회수 ${boardDTO.board_hit}</span>&nbsp;<span>|</span>&nbsp;
                		<span>추천</span>&nbsp;<span style="color:red;">${boardDTO.good}</span>
                	</div>
                </div>
                <div style="display:flex; justify-content:space-between; margin-bottom:5px; ">
                    <div style="position:relative; left:10px;">
                    	<jsp:useBean id="date" class="java.util.Date"/>
                        <span>${boardDTO.name}</span>&nbsp;<span>|</span>&nbsp;
                        <span>마지막 수정 : </span>
                        <span>
                        	<c:if test="${date.year==boardDTO.recentupdate.year && date.month==boardDTO.recentupdate.month && date.date==boardDTO.recentupdate.date}">
							<fmt:formatDate value="${boardDTO.recentupdate}" pattern="HH:mm:ss" />
							</c:if>
							<c:if test="${date.year!=boardDTO.recentupdate.year || 
							date.month!=boardDTO.recentupdate.month || date.date!=boardDTO.recentupdate.date}">
							<fmt:formatDate value="${boardDTO.recentupdate}" pattern="yy-MM-dd(E)" />
						</c:if>
                        </span>
                    </div>
                    <div style="font-size: 0.8rem; position: relative; right:10px;">
	                    <div>
	                    	<span>Totalbyte</span>
	                    </div>
	                    <div>
	                    	<span>(</span><span id="nowByte">0</span><span>/</span><span>6000</span><span>)</span>
	                    </div>
                    </div>
                </div>
                <div style="align-items: center; border: 1px solid black;">
                    <textarea  name="content" onkeydown="resize(this)" onkeyup="fn_checkByte(this,6000)" style="resize: none; width: 99%; min-height: 15rem; padding:0;border:0;margin:0;">${boardDTO.content}</textarea>
                </div>
                <div><hr/></div>
                <input type="hidden" name="currentPage" value="${currentPage}"/>
                <input type="hidden" name="bidx" value="${boardDTO.bidx}"/>
                <div style="display:flex; justify-content: flex-end;">
                	<input type="hidden" name="id" value="${boardDTO.id}"/>
                	<input type="hidden" name="name" value="${boardDTO.name}"/>
                    <input class="BlackWhite"style="width:12%; height:6vh; font-size:1rem;" type="submit" value="등록"/>
                    <input class="GrayWhite"style="margin-left:7px;width:12%; height:6vh; font-size:1rem;" type="button" value="돌아가기" onclick="location.href='/itboard/contentView?currentPage=${currentPage}&bidx=${boardDTO.bidx}'"/>
                </div>
            </form>
        </div>
    </div>
<!-- //중단 -->
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/js/board.js"></script>
</body>
</html>