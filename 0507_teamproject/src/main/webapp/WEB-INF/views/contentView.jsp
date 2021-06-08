<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- 대입문,제어문 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><!-- 서식지정 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%><!-- 함수 -->
<!DOCTYPE html>
<html lang="ko">
    <head>
    	<link rel="shortcut icon" href="#"> <!-- favicon -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>레이아웃</title>
        <script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
        <!-- Bootstrap core CSS , js -->
        <link type="text/css" href="../css/bootstrap.min.css" rel="stylesheet"> 
        <script type="text/javascript" src="../js/bootstrap.js"></script>
        
        <!-- Custom styles for this template -->
        <link type="text/css" href="../css/navbar.css" rel="stylesheet"> 
        <link type="text/css" href="../css/boardContentView.css" rel="stylesheet"> 
    </head>
<body>
	
    <!--상단 https://bootswatch.com/sketchy/-->
   <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="../..">Home</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor03" aria-controls="navbarColor03" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" style="justify-content: space-between">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" href="#">Luck</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Notice</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">community</a>
          <div class="dropdown-menu">
            <a class="dropdown-item" href="itboard">It 시사</a>
            <a class="dropdown-item" href="humorboard">유머</a>
            <a class="dropdown-item" href="#">좋은글</a>
            <a class="dropdown-item" href="#">Java</a>
            <a class="dropdown-item" href="#">JavaScript</a>
            <a class="dropdown-item" href="#">JSP</a>
            <a class="dropdown-item" href="#">Node.js</a>
            <a class="dropdown-item" href="#">React</a>
            <a class="dropdown-item" href="#">Vue.js</a>
            <a class="dropdown-item" href="#">angular.js</a>
            <a class="dropdown-item" href="#">Spring</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="https://opentutorials.org/course/1">생활코딩</a>
          </div>
        </li>
        
      </ul>
      
      
      <form class="d-flex">
	         	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">
	  				<button type="button" class="btn btn-primary">Subject</button>
	  				<div class="btn-group" role="group">
		    			<button id="btnGroupDrop1" type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></button>
		    			<div class="dropdown-menu" aria-labelledby="btnGroupDrop1" style="">
			      			<a class="dropdown-item" href="#">제목</a>
			      			<a class="dropdown-item" href="#">내용</a>
			      			<a class="dropdown-item" href="#">작성자</a>
		    			</div>
	  				</div>
				</div>
	       	 	<input class="form-control ms-sm-2 me-sm-2 board-search" type="text" placeholder="검색">
    	   	 	<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
      </form>
      
      <div style="display:flex;">
	      <div id="greet"></div>
	      <form id="logoutForm"></form>
	      <form method="get" action="../login" id="userLogin">
	      	<button type="submit" class="btn me-sm-1 rounded-pill btn-info">Login</button>
	      </form>
	      <form method="get" action="../signin" id="userSign">
	      	<button type="submit" class="btn rounded-pill btn-outline-info">Sign</button>
	      </form>
      </div>
      
      <script>
      (function () {//익명즉시실행함수 
    	  
 		var Session_userID='${Session_userID}';
 		if(Session_userID.length!=0){
 			var userLogin=document.getElementById('userLogin');
 	 		var userSign=document.getElementById('userSign');
 	 		userLogin.setAttribute('style','display:none');
 	 		userSign.setAttribute('style','display:none');
 	 		
 	 		var hyperlink = document.createElement("a");
 	 		hyperlink.href="http://www.naver.com";
 			var img = document.createElement("img");
	        img.src = "../images/userlogin.png"; 
	        img.height = 30; 
	        img.width = 30;
	        hyperlink.append(img);
	        document.getElementById('greet').append(hyperlink);
	        var WelcomUser = document.createElement("span");
	        WelcomUser.setAttribute('style','font-size:0.8rem;');
	        WelcomUser.textContent=Session_userID;
	        
 	 		document.getElementById('greet').append(WelcomUser);
 	 		
 	 		var logoutButton= document.createElement('button');
 	 		logoutButton.setAttribute('type','submit');
 	 		logoutButton.classList.add('btn','me-sm-1','rounded-pill','btn-info');
 	 		logoutButton.innerHTML='Logout';
 	 		
 	 		var logoutForm= document.getElementById('logoutForm');
 	 		logoutForm.setAttribute('method','post');
 	 		logoutForm.setAttribute('action','../logout');
 	 		logoutForm.append(logoutButton);
 	 		
 	 		document.getElementById('greet').setAttribute('style','margin-right:10px; font-size:0.5em');

 		}
 	})(2);
     </script>
     
     
    </div>
  </div>
</nav>
    <!--//상단 -->
	<!-- 중단 -->
	<div class="container-column-align" style="height: auto; margin-top: 1rem;">
        <div class="container-column" style="width: 80vw; min-width: 259.2px;">
            <div style="font-size:1.5rem; font-weight:900; position:relative; top:5px; left:5px;">IT 게시판</div>
            <div><hr/></div>
            <div class="relative-left">
            	<c:set var="boardSubject" value="${fn:replace(boardDTO.subject,'<','&lt;')}" />
				<c:set var="boardSubject" value="${fn:replace(boardSubject,'>','&gt;')}" />
                <span>${boardSubject}</span>
            </div>
            <div style="display:flex; justify-content: space-between;">
                <div class="relative-left">
					<jsp:useBean id="date" class="java.util.Date"/>
                    <span>${boardDTO.name}</span>&nbsp;<span>|</span>&nbsp;
                    <span>
	                    <c:if test="${date.year==boardDTO.writedate.year && date.month==boardDTO.writedate.month && date.date==boardDTO.writedate.date}">
							<fmt:formatDate value="${boardDTO.writedate}" pattern="HH:mm:ss" />
						</c:if>
						<c:if test="${date.year!=boardDTO.writedate.year || 
							date.month!=boardDTO.writedate.month || date.date!=boardDTO.writedate.date}">
							<fmt:formatDate value="${boardDTO.writedate}" pattern="yy-MM-dd(E)" />
						</c:if>
                    </span>
                </div>
                <div class="relative-right">
                    <span>조회수 ${boardDTO.board_hit}</span>&nbsp;<span>|</span>&nbsp;<span>추천 </span><span style="color: red;">${boardDTO.good}</span>
                </div>
            </div>
            <div><hr/></div>
            <!-- contents -->
            <div style="min-height: 5rem;">
                <form style="float:right;" class="relative-right unloginSet" method="post" onsubmit="return idmatching(this,'${Session_userID}');">
                	<input type="hidden" value="${boardDTO.id}"/>
                	<input type="hidden" name="bidx" value="${boardDTO.bidx}"/>
                	<input type="hidden" name="currentPage" value="${currentPage}"/>
                    <button style="cursor:pointer;background-color: white;border:0;" type="submit" formaction="../itboard/contentView/update">수정</button>
                    &nbsp;<span>|</span>&nbsp;
                    <button style="cursor:pointer;background-color: white;border:0;" type="submit" formaction="../itboard/contentView/delete">삭제</button>
                </form>
                <textarea onkeydown="resize(this)" onkeyup="resize(this)" readonly
                    style="min-height: 10rem; width:95%; outline: none;
                    border:0; resize:none;" class="relative-left">${boardDTO.content}</textarea>
            </div>
            <!-- //contents -->
            <div style="display:flex; justify-content: space-between; margin-bottom: 10px;">
	            <div class="relative-left">
	                <span>전체 댓글</span><span style="color:red;"> ${comment_totalCount} </span><span>개</span>
	            </div>
	            <div class="relative-right">
	            	<label  style="cursor:pointer" onclick="goodup('${Session_userID}','${boardDTO.bidx}')">
	            		<c:if test="${heart==0}">
		                <img alt="좋아요" src="../images/empty_heart.png" id="heartbeat" style="width:1rem; height:1rem;"/>&nbsp;
		                </c:if>
		                <c:if test="${heart!=0}">
		                <img alt="좋아요" src="../images/full_heart.png" id="heartbeat" style="width:1rem; height:1rem;"/>&nbsp;
		                </c:if>
	                	<span id="good_label">${boardDTO.good}</span>
	                </label>
	            </div>
            </div>
            <div>
				<!--  덧글을 받는다. -->
				<c:set var="list" value="${commentList.list}"/>
                <c:if test="${list.size()!=0}">
                	<c:forEach var="dto" items="${list}">
                	<c:set var="commentcontent" value="${fn:replace(fn:trim(dto.content),'<','&lt;')}"/>
					<c:set var="commentcontent" value="${fn:replace(commentcontent,'>','&gt;')}"/>
                	<c:set var="commentcontent" value='${fn:replace(commentcontent,enter,"<br>")}'/>

                <!-- 덧글 한 묶음-->
                <div style="width:100%;">
                	<c:if test="${dto.comment_ref!=current_comment_ref}">
                    	<hr style="margin-top:1px; margin-bottom:1px;"/>
                    </c:if>
                    <c:if test="${dto.comment_ref==current_comment_ref}">
                    	<hr style="margin-top:1px; margin-bottom:1px; color:white; background-color: white;"/>
                    </c:if>
                    	<c:if test="${dto.comment_ref!=current_comment_ref}">
                    <!-- 메인댓글  + 대댓글까지(ref 오름차순)-->
                    <div style="display:flex;  justify-content: space-between; width:100%; margin-top:1rem; margin-bottom:1rem;">
                        <div style="width:75%; display:flex;" class="relative-left" onclick="replyComment(this,'${Session_userID}')">
                            <div style="display:flex; width:100%;">
                                <div style="width:10%;">${dto.name}</div>
                                <div style="width:90%;">${commentcontent}</div>
                            </div>
                        </div>
                        <form action="contentView/deleteComment" method="post" onsubmit="return idmatching(this,'${Session_userID}')"
                         style="width:20%; display:flex; justify-content:flex-end; align-items: center;"
                         	class="relative-right">
                         	<input type="hidden" value="${dto.id}"/>
                         	<input type="hidden" name="cidx" value="${dto.cidx}"/>
                         	<input type="hidden" name="bidx" value="${boardDTO.bidx}"/>
                         	<input type="hidden" name="currentPage" value="${currentPage}"/>
                         	<input type="hidden" name="comment_currentPage" value="${comment_currentPage}"/>
                            <span style="display:block;" class="relative-right">
	                            <c:if test="${date.year==dto.writedate.year && date.month==dto.writedate.month && date.date==dto.writedate.date}">
								<fmt:formatDate value="${dto.writedate}" pattern="HH:mm:ss" />
								</c:if>
								<c:if test="${date.year!=dto.writedate.year || 
								date.month!=dto.writedate.month || date.date!=dto.writedate.date}">
								<fmt:formatDate value="${dto.writedate}" pattern="yy-MM-dd(E)" />
								</c:if>
                            </span>
                            <input type="image" src="../images/xbutton.png" style="width:1rem; height:1rem;"/>
                            <!-- type=submit과 같다. -->
                        </form>
                    </div>
                    <!--대덧글작성-->
                    <form action="contentView/registerComment" method="post" onsubmit="return emptyTextCheck(this);" style="width:100%; margin-top: 5px; margin-bottom: 5px;" class="container-row display_visible">
		                <textarea  onkeydown="resize(this)" onkeyup="fn_checkByte(this,300)" placeholder="내용을 입력해주세요"
		                    style=" width:90%; min-height: 3rem; max-height: 9rem; resize: none;" name="content"
		                     class="relative-left"></textarea>
		                <div class="relative-left" style="width:7%; display:flex; align-items:flex-end; justify-content: flex-start;">
		                	<input style="max-height:2rem; max-width:3rem;" type="submit" value="등록"/>
		                </div>
		                <input type="hidden" name="bidx" value="${boardDTO.bidx}"/>
		                <input type="hidden" name="currentPage" value="${currentPage}"/>
		                <input type="hidden" name="reply_comment_ref" value="${dto.comment_ref}"/>
		                <input type="hidden" name="comment_currentPage" value="${comment_currentPage}"/>		                
	                </form>
	                <!--//대덧글작성-->
	                	</c:if>
                    
                    	<c:if test="${dto.comment_ref==current_comment_ref}">
                    <!-- 이미작성된대댓글  -->
                    <div style="width:100%; display:flex; justify-content: flex-end;">
                    	<div style="width:95%; display:flex; justify-content: flex-end; background-color:#E6E7EA;">
                    
		                    <div style="margin-top:1rem;margin-bottom:1rem; display:flex; justify-content: space-between; width:95%;">
		                        <div style="width:75%; display:flex;">
		                            <div style="display:flex; width:100%;">
		                                <div style="width:10%;" class="relative-left">${dto.name}</div>
		                                <div style="width:90%;">${commentcontent}</div>
		                            </div>
		                        </div>
		                        <form action="contentView/deleteComment" method="post" onsubmit="return idmatching(this,'${Session_userID}')"
		                        style="width:20%; display:flex; justify-content:flex-end; align-items:center;">
		                        	<input type="hidden" value="${dto.id}"/>
		                        	<input type="hidden" name="cidx" value="${dto.cidx}"/>
		                        	<input type="hidden" name="bidx" value="${boardDTO.bidx}"/>
		                        	<input type="hidden" name="currentPage" value="${currentPage}"/>
		                        	<input type="hidden" name="comment_currentPage" value="${comment_currentPage}"/>
		                            <span style="display:block;" class="relative-right">
		                            	<c:if test="${date.year==dto.writedate.year && date.month==dto.writedate.month && date.date==dto.writedate.date}">
										<fmt:formatDate value="${dto.writedate}" pattern="HH:mm:ss" />
										</c:if>
										<c:if test="${date.year!=dto.writedate.year || 
										date.month!=dto.writedate.month || date.date!=dto.writedate.date}">
										<fmt:formatDate value="${dto.writedate}" pattern="yy-MM-dd(E)" />
										</c:if>
		                            </span>
		                            <input type="image" src="../images/xbutton.png" style="width:1rem; height:1rem;"/>
		                        </form>
		                    </div>
		                    <div style="width:20px;">
		                    </div>
	                    
	                    </div>
                    </div>
                    	</c:if>
                </div>
                <!-- //덧글 한 묶음-->
                	<c:set var="current_comment_ref" value="${dto.comment_ref}"/>
                	</c:forEach>
                </c:if>
            </div>
            <div class="nocomment"><hr/></div>
            <!-- 덧글페이지 -->
            <form action="contentView" style="display:flex; justify-content: center; margin-bottom: 7px;" class="nocomment">
            	<input type="hidden" name="currentPage" value="${currentPage}"/>
            	<input type="hidden" name="bidx" value="${boardDTO.bidx}"/>
	            <c:forEach var="page" begin="${commentList.startPage}" end="${commentList.totalPage}">
	            		<c:if test="${comment_currentPage==page}">
	            			<button class="pageButton" disabled="disabled">${page}</button>
	            		</c:if>
	            		<c:if test="${comment_currentPage!=page}">
	            			<button class="pageButton" type="submit" 
	            			name="comment_currentPage" value="${page}">${page}</button>
	            		</c:if>
	            </c:forEach>
            </form>
            <!-- //덧글페이지 -->
            <form id="clientToServerText" action="contentView/registerComment" method="post" onsubmit="return emptyTextCheck(this);">
                <!--덧글작성-->
                <textarea  name="content" onkeydown="resize(this)" onkeyup="fn_checkByte(this,300)" placeholder="내용을 입력해주세요"
                    style="width: 100%; min-height: 3rem; max-height: 9rem; resize: none;" class="unloginSet"
                ></textarea>
                <!--//덧글작성-->
            	<input type="hidden" name="bidx" value="${boardDTO.bidx}"/>
                <input type="hidden" name="currentPage" value="${currentPage}"/>
            </form>
            <div>
                <div style="display: flex; justify-content: space-between;" id="bottom_part">
                    <div style="font-size: 0.8rem;" class="relative-left unloginSet">
                        <div id="commentByte">
                            <div>
                                <span>Totalbyte</span>
                            </div>
                            <div>
                                <span>(</span><span id="nowByte">0</span><span>/</span><span>300</span><span>)</span>
                            </div>
                        </div>
                    </div>
                    <div style="width:50%; display: flex; justify-content: flex-end;">
                        <input form="clientToServerText" type="submit" value="댓글등록" class="BlackWhite unloginSet"style="width:24%; height:6vh; font-size:1rem;"/>
                        <form class="unloginSet" action="../itboard/contentView/replyBoard" method="get" onsubmit="return loginCheck('${Session_userID}');" style="margin-left:7px; width:24%; height:6vh; font-size:1rem;">
                        	<input type="hidden" name="bidx" value="${boardDTO.bidx}"/>
                        	<input type="hidden" name="board_ref" value="${boardDTO.board_ref}"/>
                        	<input type="hidden" name="currentPage" value="${currentPage}"/>
                        	<input class="GrayWhite" style="display:block; width:100%; height:100%;" type="submit" value="게시글답변"/>
                        </form>
                        <input class="BlackWhite"style="margin-left:7px; width:24%; height:6vh; font-size:1rem;" type="button" value="돌아가기" onclick="location.href='../itboard?currentPage=${currentPage}'"/>
                    </div>
                </div>
            </div>
        </div>
        <div style="height:50px;">
        </div>
    </div>
    <!-- 중단 끝 -->
    <script type="text/javascript" src="../js/board.js"></script>
    <script type="text/javascript" src="../js/contentView.js"></script>
    <script type="text/javascript" src="../js/common.js"></script>
    <script>
    	window.onload=function(){
    		//비로그인 일경우
    		var Session_userID='${Session_userID}';
    		if(Session_userID.trim().length==0){
    			var unloginSet=document. getElementsByClassName('unloginSet');
    			for(var i=0;i<unloginSet.length;i++){
    				unloginSet[i].setAttribute('style','display: none;');
    			}
     			var bottom_part=document.getElementById('bottom_part');
     			bottom_part.setAttribute('style','display: flex; justify-content: flex-end;');
    		}
    		
    		//덧글이없을경우
    		var comment_totalCount='${comment_totalCount}';
    		if(comment_totalCount==0){
    			var nocomment=document. getElementsByClassName('nocomment');
    			for(var i=0;i<nocomment.length;i++){
    				nocomment[i].setAttribute('style','display: none;');
    			}
    		}
    	}
    </script>
</body>
</html>