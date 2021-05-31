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
    <a class="navbar-brand" href="../..">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor03" aria-controls="navbarColor03" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarColor03">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link active" href="#">Luck</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Notice</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">community</a>
          <div class="dropdown-menu">
            <a class="dropdown-item" href="../itboard">It 시사</a>
            <a class="dropdown-item" href="#">유머</a>
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
        <li class="nav-item">
         <form class="d-flex ms-sm-5">
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
       	 	<input class="form-control me-sm-2 board-search" type="text" placeholder="검색">
       	 	<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
    	 </form>
    	</li>
      </ul>
      
      <div id="greet"></div>
      <form id="logoutForm"></form>
      <form method="get" action="../login" id="userLogin">
      	<button type="submit" class="btn me-sm-1 rounded-pill btn-info">Login</button>
      </form>
      <form method="get" action="../signin" id="userSign">
      	<button type="submit" class="btn me-sm-5 rounded-pill btn-outline-info">Sign</button>
      </form>
      
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
 	 		document.getElementById('greet').append(Session_userID+" 님 안녕하세요.");
 	 		
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
	<div class="container-column-align" style="height: auto; margin-top: 3px;">
        <div class="container-column" style="width: 80vw; min-width: 259.2px;">
            <div style="font-size:1.5rem; font-weight:900; position:relative; top:5px; left:5px;">IT 게시판</div>
            <div><hr/></div>
            <div class="relative-left">
                <span>${itboardDTO.subject}</span>
            </div>
            <div style="display:flex; justify-content: space-between;">
                <div class="relative-left">
					<jsp:useBean id="date" class="java.util.Date"/>
                    <span>${itboardDTO.name}</span>&nbsp;<span>|</span>&nbsp;
                    <span>
	                    <c:if test="${date.year==itboardDTO.writedate.year && date.month==itboardDTO.writedate.month && date.date==itboardDTO.writedate.date}">
							<fmt:formatDate value="${itboardDTO.writedate}" pattern="HH:mm:ss" />
						</c:if>
						<c:if test="${date.year!=itboardDTO.writedate.year || 
							date.month!=itboardDTO.writedate.month || date.date!=itboardDTO.writedate.date}">
							<fmt:formatDate value="${itboardDTO.writedate}" pattern="yy-MM-dd(E)" />
						</c:if>
                    </span>
                </div>
                <div class="relative-right">
                    <span>조회수 ${itboardDTO.board_hit}</span>&nbsp;<span>|</span>&nbsp;<span>추천 </span><span style="color: red;">${itboardDTO.good}</span>
                </div>
            </div>
            <div><hr/></div>
            <!-- contents -->
            <div style="min-height: 5rem;">
                <form style="float:right;" class="relative-right unloginSet" method="post" onsubmit="return idmatching();">
                	<input type="hidden" name="bidx" value="${itboardDTO.bidx}"/>
                	<input type="hidden" name="currentPage" value="${currentPage}"/>
                    <button style="cursor:pointer;background-color: white;border:0;" type="submit" formaction="../itboard/contentView/update">수정</button>
                    &nbsp;<span>|</span>&nbsp;
                    <button style="cursor:pointer;background-color: white;border:0;" type="submit" formaction="../itboard/contentView/delete">삭제</button>
                </form>
                <textarea onkeydown="resize(this)" onkeyup="resize(this)" readonly
                    style="min-height: 10rem; width:95%; outline: none;
                    border:0; resize:none;" class="relative-left">${itboardDTO.content}</textarea>
            </div>
            <!-- //contents -->
            <div style="display:flex; justify-content: space-between; margin-bottom: 3px;">
	            <div class="relative-left">
	                <span>전체 댓글</span><span style="color:red;"> ${comment_totalCount} </span><span>개</span>
	            </div>
	            <div class="relative-right">
	            	<label  style="cursor:pointer" onclick="goodup()">
	            		<c:if test="${heart==0}">
		                <img alt="좋아요" src="../images/empty_heart.png" id="heartbeat" style="width:1rem; height:1rem;"/>&nbsp;
		                </c:if>
		                <c:if test="${heart!=0}">
		                <img alt="좋아요" src="../images/full_heart.png" id="heartbeat" style="width:1rem; height:1rem;"/>&nbsp;
		                </c:if>
	                	<span id="good_label">${itboardDTO.good}</span>
	                </label>
	            </div>
            </div>
            <div>
				<!--  덧글을 받는다. -->
				<c:set var="list" value="${iTcommentList.list}"/>
                <c:if test="${list.size()!=0}">
                	<c:forEach var="dto" items="${list}">
                <!-- 덧글 한 묶음-->
                <div style="width:100%;">
                    <hr/>
                    	<c:if test="${dto.comment_ref!=current_comment_ref}">
                    <!-- 메인댓글  + 대댓글까지(ref 오름차순)-->
                    <div style="display:flex;  justify-content: space-between; width:100%;" onclick="replyComment(this)">
                        <div style="width:75%; display:flex;" class="relative-left">
                            <div style="display:flex; width:100%;">
                                <div style="width:10%;">${dto.name}</div>
                                <div style="width:90%;">${dto.content}</div>
                            </div>
                        </div>
                        <div style="width:20%; display:flex; justify-content:flex-end;"
                         	class="relative-right">
                            <span style="display:block;" class="relative-right">
	                            <c:if test="${date.year==dto.writedate.year && date.month==dto.writedate.month && date.date==dto.writedate.date}">
								<fmt:formatDate value="${dto.writedate}" pattern="HH:mm:ss" />
								</c:if>
								<c:if test="${date.year!=dto.writedate.year || 
								date.month!=dto.writedate.month || date.date!=dto.writedate.date}">
								<fmt:formatDate value="${dto.writedate}" pattern="yy-MM-dd(E)" />
								</c:if>
                            </span>
                            <input style="width:1rem; height:1rem; padding:0; border-width:1px; font-size:0.4rem;"  type="submit"  value="x"/>
                        </div>
                    </div>
                    <!--대덧글작성-->
                    <div style="width:100%; margin-top: 5px; margin-bottom: 5px;" class="container-row display_visible">
		                <textarea  onkeydown="resize(this)" onkeyup="fn_checkByte(this,300)" placeholder="내용을 입력해주세요"
		                    style=" width:90%; min-height: 3rem; max-height: 9rem; resize: none;"
		                     class="relative-left"></textarea>
		                <div class="relative-left" style="width:7%; display:flex; align-items:flex-end; justify-content: flex-start;">
		                	<input style="max-height:2rem; max-width:3rem;" type="button" value="등록"/>
		                </div>
	                </div>
	                <!--//대덧글작성-->
	                	</c:if>
                    
                    	<c:if test="${dto.comment_ref==current_comment_ref}">
                    <!-- 이미작성된대댓글  -->
                    <div style="width:100%; display:flex; justify-content: flex-end;">
	                    <div style="display:flex; background-color:#E6E7EA; justify-content: space-between; width:95%;
	                    	position:relative; right:20px;">
	                        <div style="width:75%; display:flex;">
	                            <div style="display:flex; width:100%;">
	                                <div style="width:10%;" class="relative-left">${dto.name}</div>
	                                <div style="width:90%;">${dto.content}</div>
	                            </div>
	                        </div>
	                        <div style="width:20%; display:flex; justify-content:flex-end; align-items:center;">
	                            <span style="display:block;" class="relative-right">
	                            	<c:if test="${date.year==dto.writedate.year && date.month==dto.writedate.month && date.date==dto.writedate.date}">
									<fmt:formatDate value="${dto.writedate}" pattern="HH:mm:ss" />
									</c:if>
									<c:if test="${date.year!=dto.writedate.year || 
									date.month!=dto.writedate.month || date.date!=dto.writedate.date}">
									<fmt:formatDate value="${dto.writedate}" pattern="yy-MM-dd(E)" />
									</c:if>
	                            </span>
	                            <input style="width:1rem; height:1rem; padding:0; border-width:1px; font-size:0.4rem;" type="submit"  value="x"/>
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
            <form style="display:flex; justify-content: center; margin-bottom: 7px;" class="nocomment">
            	<input type="hidden" name="currentPage" value="${currentPage}"/>
            	<input type="hidden" name="bidx" value="${itboardDTO.bidx}"/>
	            <c:forEach var="page" begin="${iTcommentList.startPage}" end="${iTcommentList.totalPage}">
	            		<c:if test="${comment_currentPage==page}">
	            			<button style="inline;" class="pageButton" disabled="disabled">${page}</button>
	            		</c:if>
	            		<c:if test="${comment_currentPage!=page}">
	            			<button style="inline;" class="pageButton" type="submit" 
	            			name="comment_currentPage" value="${page}">${page}</button>
	            		</c:if>
	            </c:forEach>
            </form>
            <!-- //덧글페이지 -->
            <form id="clientToServerText" action="contentView/registerComment" method="post" onsubmit="return emptyContentCheck()">
            	<input type="hidden" name="bidx" value="${itboardDTO.bidx}"/>
                <input type="hidden" name="currentPage" value="${currentPage}"/>
                <!--덧글작성-->
                <textarea  name="content" onkeydown="resize(this)" onkeyup="fn_checkByte(this,300)" placeholder="내용을 입력해주세요"
                    style="width: 100%; min-height: 3rem; max-height: 9rem; resize: none;" class="unloginSet"
                ></textarea>
                <!--//덧글작성-->
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
                        <form class="unloginSet" action="../itboard/contentView/replyBoard" method="get" onsubmit="return loginCheck();" style="margin-left:7px; width:24%; height:6vh; font-size:1rem;">
                        	<input type="hidden" name="bidx" value="${itboardDTO.bidx}"/>
                        	<input type="hidden" name="board_ref" value="${itboardDTO.board_ref}"/>
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
    	function goodup(){
    		var Session_userID='${Session_userID}';
    		var bidx_='${itboardDTO.bidx}'
    		var form={
    				bidx: bidx_,
    				id: Session_userID
    		}
     		if(Session_userID.length!=0){
     			//로그인중임
     			$.ajax({
     	            url: "asyncGood",
     	            type: "POST",
     	            data: JSON.stringify(form),
     	            contentType: "application/json",
     	            dataType: "json",
     	            success: function(data){
     	            	if(data.clicked==0){
     	            		$('#heartbeat').attr('src','../images/empty_heart.png');
     	            	}else{
     	            		$('#heartbeat').attr('src','../images/full_heart.png');
     	            	}
     	                $('#good_label').text(data.goodCount);
     	            },
     	            error: function(){
     	                alert("asyncGood err");
     	            }
     	        });
     		}
     		else{
     			alert("로그인을 해주세요.");
     		}
    	}
    	function idmatching(){
    		var userID='${Session_userID}';
    		var boardUserID='${itboardDTO.id}';
    		console.log(userID);
    		console.log(boardUserID);
    		if(userID==boardUserID){
    			return true;
    		}
    		else{
    			alert('게시글 작성자만이 이용할 수 있습니다!');
    			return false;
    		}
    	}
    	function loginCheck(){
    		var userID='${Session_userID}';
    		if(userID.trim().length==0){
    			alert("로그인을 먼저 해주세요.");
    			return false;
    		}else{
    			return true;
    		}
    	}
    	function replyComment(obj){
    		if (loginCheck()==false ){
    			return false;
    		}else{
    			obj.nextElementSibling.classList.toggle("display_visible");
    		}
    	}
    	function emptyContentCheck(){
    		var content=document.getElementsByName('content')[0];
    		if(content.value.trim().length==0){
    			alert('내용을 입력해주세요.');
    			return false;
    		}
    	}    
    </script>
</body>
</html>