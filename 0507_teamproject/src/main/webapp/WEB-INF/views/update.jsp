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
        <!-- Bootstrap core CSS , js -->
        <link type="text/css" href="../../css/bootstrap.min.css" rel="stylesheet"> 
        <script type="text/javascript" src="../../js/bootstrap.js"></script>
        
        <!-- Custom styles for this template -->
        <link type="text/css" href="../../css/navbar.css" rel="stylesheet"> 
        <link type="text/css" href="../../css/boardwrite.css" rel="stylesheet"> 
    </head>
    
<body>
	
    <!--상단 https://bootswatch.com/sketchy/-->
   <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="../../..">Navbar</a>
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
            <a class="dropdown-item" href="main/itboard">It 시사</a>
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
	      <form method="get" action="main/login" id="userLogin">
	      	<button type="submit" class="btn me-sm-1 rounded-pill btn-info">Login</button>
	      </form>
	      <form method="get" action="main/signin" id="userSign">
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
	        img.src = "../../images/userlogin.png"; 
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
 	 		logoutForm.setAttribute('action','../../logout');
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
	<div class="container-column-align" style="height: 100%; margin-top:1rem;">
        <div class="container-column" style="width: 80vw; min-width: 259.2px;">
            <div style="font-size:1.5rem; font-weight:900; position:relative; top:5px; left:5px;">IT 게시판</div>
            <div><hr/></div>
            <form style="margin-top:10px;" action="updateBoard" method="post" onsubmit="return emptyCheck();">
                <div style="margin-bottom:5px; display:flex; justify-content:space-between;">
                	
                    <input type="text" name="subject" onkeyup="fn_checkByte_subject(this,100)" placeholder="제목을 입력해주세요" style="height:1.7rem; width:40rem" value="${iTboardDTO.subject}"/>
                	<div>
                		<span>조회수 ${iTboardDTO.board_hit}</span>&nbsp;<span>|</span>&nbsp;
                		<span>추천</span>&nbsp;<span style="color:red;">${iTboardDTO.good}</span>
                	</div>
                </div>
                <div style="display:flex; justify-content:space-between; margin-bottom:5px; ">
                    <div style="position:relative; left:10px;">
                    	<jsp:useBean id="date" class="java.util.Date"/>
                        <span>${iTboardDTO.name}</span>&nbsp;<span>|</span>&nbsp;
                        <span>마지막 수정 : </span>
                        <span>
                        	<c:if test="${date.year==iTboardDTO.recentupdate.year && date.month==iTboardDTO.recentupdate.month && date.date==iTboardDTO.recentupdate.date}">
							<fmt:formatDate value="${iTboardDTO.recentupdate}" pattern="HH:mm:ss" />
							</c:if>
							<c:if test="${date.year!=iTboardDTO.recentupdate.year || 
							date.month!=iTboardDTO.recentupdate.month || date.date!=iTboardDTO.recentupdate.date}">
							<fmt:formatDate value="${iTboardDTO.recentupdate}" pattern="yy-MM-dd(E)" />
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
                    <textarea  name="content" onkeydown="resize(this)" onkeyup="fn_checkByte(this,6000)" style="resize: none; width: 99%; min-height: 15rem; padding:0;border:0;margin:0;">${iTboardDTO.content}</textarea>
                </div>
                <div><hr/></div>
                <input type="hidden" name="currentPage" value="${currentPage}"/>
                <input type="hidden" name="bidx" value="${iTboardDTO.bidx}"/>
                <div style="display:flex; justify-content: flex-end;">
                	<input type="hidden" name="id" value="${id}"/>
                	<input type="hidden" name="name" value="${name}"/>
                    <input class="BlackWhite"style="width:12%; height:6vh; font-size:1rem;" type="submit" value="등록"/>
                    <input class="GrayWhite"style="margin-left:7px;width:12%; height:6vh; font-size:1rem;" type="button" value="돌아가기" onclick="location.href='../../itboard/contentView?currentPage=${currentPage}&bidx=${iTboardDTO.bidx}'"/>
                </div>
            </form>
        </div>
    </div>
<!-- //중단 -->
<script>
	function emptyCheck(){
		var subject=document.getElementsByName('subject')[0];
		var content=document.getElementsByName('content')[0];
		if(subject.value.trim().length==0 || content.value.trim().length==0){
			alert('제목 혹은 내용을 입력해주세요.');
			return false;
		}
	}    
</script>
<script type="text/javascript" src="../../js/board.js"></script>
</body>
</html>