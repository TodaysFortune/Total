<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <form style="margin-top:10px;" action="/itboard/write" method="post" onsubmit="return emptySubjectContentCheck();">
                <div style="margin-bottom:5px;">
                    <input type="text" name="subject" onkeyup="fn_checkByte_subject(this,100)" placeholder="제목을 입력해주세요" style="height:1.7rem; width:40rem"/>
                </div>
                <div style="display:flex; justify-content:space-between; margin-bottom:5px; ">
                    <div style="position:relative; left:10px;">
                        <span>${name}</span>&nbsp;<span>|</span>&nbsp;
                        <span>${id} 님</span>
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
                    <textarea  name="content" onkeydown="resize(this)" onkeyup="fn_checkByte(this,6000)" style="resize: none; width: 99%; min-height: 15rem; padding:0;border:0;margin:0;"></textarea>
                </div>
                <div><hr/></div>
                <div style="display:flex; justify-content: flex-end;">
                	<input type="hidden" name="id" value="${id}"/>
                	<input type="hidden" name="name" value="${name}"/>
                    <input class="BlackWhite"style="width:12%; height:6vh; font-size:1rem;" type="submit" value="등록"/>
                    <input class="GrayWhite"style="margin-left:7px;width:12%; height:6vh; font-size:1rem;" type="button" value="돌아가기" onclick="location.href='/itboard?currentPage=${currentPage}'"/>
                </div>
            </form>
        </div>
    </div>
<!-- //중단 -->
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/js/board.js"></script>
</body>
</html>