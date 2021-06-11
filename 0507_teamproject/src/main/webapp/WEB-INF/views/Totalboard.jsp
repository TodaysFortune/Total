<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- 대입문,제어문 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><!-- 서식지정 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%><!-- 함수 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	 <link rel="shortcut icon" href="#"> <!-- favicon -->
     <meta charset="utf-8">
     <meta name="viewport" content="width=device-width, initial-scale=1">
     <title>레이아웃</title>
     <!-- Bootstrap core CSS , js -->
     <link type="text/css" href="css/bootstrap.min.css" rel="stylesheet"> 
     <script type="text/javascript" src="js/bootstrap.js"></script>
        
    <!-- Custom styles for this template -->
	<link type="text/css" href="css/navbar.css" rel="stylesheet"> 
	<link type="text/css" href="css/board.css" rel="stylesheet"> 
</head>
<body>
	 <!--상단 https://bootswatch.com/sketchy/-->
 <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="../">Home</a>
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
      
      
      <form class="d-flex" action="totalBoard" method="get">
	         	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">
	  				<input type="button" class="btn btn-primary" id="searchType_view" value="전체"/>
	  				<input type="hidden" id="searchType" name="searchType" value="all"/>
	  				<div class="btn-group" role="group">
		    			<button id="btnGroupDrop1" type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></button>
		    			<div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
			      			<a class="dropdown-item" href="#" onclick="dropdown(this)" id="all">전체</a>
			      			<a class="dropdown-item" href="#" onclick="dropdown(this)" id="subject">제목</a>
			      			<a class="dropdown-item" href="#" onclick="dropdown(this)" id="content">내용</a>
			      			<a class="dropdown-item" href="#" onclick="dropdown(this)" id="name">작성자</a>
		    			</div>
	  				</div>
				</div>
	       	 	<input name="searchText" class="form-control ms-sm-2 me-sm-2 board-search" type="text" placeholder="검색">
    	   	 	<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
      </form>
      
      <div style="display:flex;">
	      <div id="greet"></div>
	      <form id="logoutForm"></form>
	      <form method="get" action="login" id="userLogin">
	      	<button type="submit" class="btn me-sm-1 rounded-pill btn-info">Login</button>
	      </form>
	      <form method="get" action="signin" id="userSign">
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
	        img.src = "images/userlogin.png"; 
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
 	 		logoutForm.setAttribute('action','logout');
 	 		logoutForm.append(logoutButton);
 	 		
 	 		document.getElementById('greet').setAttribute('style','margin-right:10px; font-size:0.5em');

 		}
 	})(2);
     </script>
     
     
    </div>
  </div>
</nav>
    <!--//상단 -->

	<div class="container-column-align" style="height: 100%; margin-top: 1rem;">
	
	
	<!-- Total게시판 -->
    
        <div class="container-column" style="width: 80vw; min-width: 259.2px;">
            <div style="font-size:1.5rem; font-weight:900; position:relative; top:5px; left:5px;">Total</div>
            <div><hr/></div>
            <div style="margin-top:10px;">
            	<!--  오늘 날짜를 기억하는 Date클래스 객체를 만든다. -->
				<jsp:useBean id="date" class="java.util.Date"/>
				<!--  메인글을 받는다. -->
				<c:set var="boardList" value="${totalboardList}"/>
				<c:set var="list" value="${boardList.list}"/>
				<!-- 게시글번호를 받는다. -->
				<c:set var="No" value="${boardList.totalCount-boardList.startNo}"/>
				
                <!--테이블-->
                <div style="margin-bottom:5px;">
                    <table border-spacing=0; class="table-menu" style="border-radius:3px; line-height: 1.5rem; border:2px solid gray; width:100%;">   
                        <tr style="font-weight:600; font-size:1.1rem;">
                            <td align="center" style="width:8.3%;">번호</td>
                            <td align="center" style="width:54.2%;">제목</td>
                            <td align="center" style="width:9.4%;">글쓴이</td>
                            <td align="center" style="width:11.5%;">작성일</td>
                            <td align="center" style="width:8.3%;">조회</td>
                            <td align="center" style="width:8.3%;">추천</td>
                        </tr>
                        <tr>
                            <td colspan="6"><hr style="border:0;margin:0;height:2px; background-color:gray;"/></td>
                        </tr>
                        <!-- 반복 태그 수행-->
                        <!-- 메인글이 1건도 없으면 없다고 출력한다. -->
						<c:if test="${list.size()==0}">
						<tr>
							<td colspan="6" align="center">
								<marquee>글이 없습니다.</marquee>
							</td>
						</tr>
						</c:if>
                        
                        <c:if test="${list.size()!=0}">
							<c:forEach var="dto" items="${list}">
								<tr>
									<td align="center">${No}</td>
									<c:set var="No" value="${No-1}"/>
									<td align="left">
										<!-- 오늘 입력된 글에 new 아이콘을 표시 -->
										<c:if test="${date.year==dto.writedate.year && date.month==dto.writedate.month && date.date==dto.writedate.date}">
											<img src="images/new1.png"/>
										</c:if>
										<c:set var="subject" value="${fn:replace(dto.subject,'<','&lt;')}" />
										<c:set var="subject" value="${fn:replace(subject,'>','&gt;')}" />
										<c:if test='${dto.url.equals("itboard")}'>
											<a href="itboard/increment?bidx=${dto.bidx}&currentPage=${boardList.currentPage}" class="subject all">
										</c:if>
										<c:if test='${dto.url.equals("humorboard")}'>
											<a href="humorboard/increment?bidx=${dto.bidx}&currentPage=${boardList.currentPage}" class="subject all">
										</c:if>
											${subject}
										</a>
									</td>
									<c:set var="name" value="${fn:replace(fn:trim(dto.name),'<','&lt;')}"/>
									<c:set var="name" value="${fn:replace(name,'>','&gt;')}"/>
									<td align="center" class="name">${name}</td>
									<td align="center">
										<c:if test="${date.year==dto.writedate.year && date.month==dto.writedate.month && date.date==dto.writedate.date}">
											<fmt:formatDate value="${dto.writedate}" pattern="HH:mm:ss" />
										</c:if>
										<c:if test="${date.year!=dto.writedate.year || 
										date.month!=dto.writedate.month || date.date!=dto.writedate.date}">
											<fmt:formatDate value="${dto.writedate}" pattern="yy-MM-dd(E)" />
										</c:if>
									</td>
									<td align="center">
										${dto.board_hit}
									</td>
									<td align="center">
										<c:if test="${dto.good>=10}">
										<img src="images/hot.gif"/>
										</c:if>
										${dto.good}
									</td>
								</tr>
							</c:forEach>
						</c:if>
						<!--  //게시글목록 -->
                        <!-- //반복 태그 수행-->
                    </table>
                </div>
                <!--//테이블-->
                

		
		 <!--버튼 + 페이징-->
                <div style="margin-bottom:5px; display:flex; align-items:center; justify-content:center;">
                    <span style="display:flex; width:70%; height:6vh;justify-content:center;align-items: center;">
                        <div style="display:flex; justify-content:center; width:80%;height:80%;">
                            <!--  맨 앞으로 -->
                            <c:if test="${boardList.currentPage> 1}">
                            	<button class="pageButton"  title="첫 번째 페이지로 이동" onclick="location.href='?totalcurrentPage=1&searchType=${searchType}&searchText=${searchText}'">처음</button>
                            </c:if>
                            <c:if test="${boardList.currentPage <= 1}">
                            	<button class="pageButton" disabled="disabled" title="이미 첫 번째 페이지입니다.">처음</button>
                            </c:if>	
                            <!--  10페이지 앞으로 -->	
                            <c:if test='${boardList.startPage>1}'>
                            	<button class="pageButton" title="이전 10페이지로 이동" onclick="location.href='?totalcurrentPage=${boardList.startPage -1}&searchType=${searchType}&searchText=${searchText}'">이전</button>
                            </c:if>
                            <c:if test='${boardList.startPage<=1}'>
                            	<button class="pageButton" disabled="disabled">이전</button>
                            </c:if>
                            <!--  페이지 이동 -->
                            <c:forEach var="i" begin="${boardList.startPage}" end="${boardList.endPage}">
                            	<c:if test="${boardList.currentPage==i}">
                            		<button class="pageButton" disabled="disabled">${i}</button>
                            	</c:if>
                            	<c:if test="${boardList.currentPage!=i}">
                            		<button class="pageButton" onclick="location.href='?totalcurrentPage=${i}&searchType=${searchType}&searchText=${searchText}'">${i}</button>
                            	</c:if>
                            </c:forEach>
                            <!--  10페이지 뒤로 -->
                            <c:if test="${boardList.endPage < boardList.totalPage}">
                            	<button class="pageButton" title="다음 10페이지로 이동" onclick="location.href='?totalcurrentPage=${boardList.endPage +1}&searchType=${searchType}&searchText=${searchText}'">다음</button>
                            </c:if>
                            
                            <c:if test="${boardList.endPage >= boardList.totalPage}">
                            	<button class="pageButton" disabled="disabled" title="이미 마지막 10페이지입니다.">다음</button>
                            </c:if>
                            <!--  맨 뒤로 -->
                            <c:if test="${boardList.currentPage < boardList.totalPage}">
                            	<button class="pageButton" title="마지막 페이지로 이동" onclick="location.href='?totalcurrentPage=${boardList.totalPage}&searchType=${searchType}&searchText=${searchText}'">끝</button>
                            </c:if>
                            <c:if test="${boardList.currentPage >= boardList.totalPage}">
                           		<button class="pageButton" disabled="disabled" title="이미 마지막 페이지입니다.">끝</button>
                           	</c:if>
                        </div>
                    </span>
                </div>
        <!--//버튼 + 페이징-->
            </div>
        </div>
        
        <!-- //Total게시판 -->
	
	
	
	<!-- IT게시판 -->
    
        <div class="container-column" style="width: 80vw; min-width: 259.2px;">
            <div style="font-size:1.5rem; font-weight:900; position:relative; top:5px; left:5px;">IT 게시판</div>
            <div><hr/></div>
            <div style="margin-top:10px;">
				<!--  메인글을 받는다. -->
				<c:set var="boardList" value="${itboardList}"/>
				<c:set var="list" value="${boardList.list}"/>
				<!-- 게시글번호를 받는다. -->
				<c:set var="No" value="${boardList.totalCount-boardList.startNo}"/>
				
                <!--테이블-->
                <div style="margin-bottom:5px;">
                    <table border-spacing=0; class="table-menu" style="border-radius:3px; line-height: 1.5rem; border:2px solid gray; width:100%;">   
                        <tr style="font-weight:600; font-size:1.1rem;">
                            <td align="center" style="width:8.3%;">번호</td>
                            <td align="center" style="width:54.2%;">제목</td>
                            <td align="center" style="width:9.4%;">글쓴이</td>
                            <td align="center" style="width:11.5%;">작성일</td>
                            <td align="center" style="width:8.3%;">조회</td>
                            <td align="center" style="width:8.3%;">추천</td>
                        </tr>
                        <tr>
                            <td colspan="6"><hr style="border:0;margin:0;height:2px; background-color:gray;"/></td>
                        </tr>
                        <!-- 반복 태그 수행-->
                        <!-- 메인글이 1건도 없으면 없다고 출력한다. -->
						<c:if test="${list.size()==0}">
						<tr>
							<td colspan="6" align="center">
								<marquee>글이 없습니다.</marquee>
							</td>
						</tr>
						</c:if>
                        
                        <c:if test="${list.size()!=0}">
							<c:forEach var="dto" items="${list}">
								<tr>
									<td align="center">${No}</td>
									<c:set var="No" value="${No-1}"/>
									<td align="left">
										<c:if test="${current_ref==dto.board_ref}">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</c:if>
										<c:set var="current_ref" value="${dto.board_ref}"/>
										<!-- 오늘 입력된 글에 new 아이콘을 표시 -->
										<c:if test="${date.year==dto.writedate.year && date.month==dto.writedate.month && date.date==dto.writedate.date}">
											<img src="images/new1.png"/>
										</c:if>
										<c:set var="subject" value="${fn:replace(dto.subject,'<','&lt;')}" />
										<c:set var="subject" value="${fn:replace(subject,'>','&gt;')}" />
										<a href="itboard/increment?bidx=${dto.bidx}&currentPage=${boardList.currentPage}" class="subject all">
											${subject}
										</a>
									</td>
									<c:set var="name" value="${fn:replace(fn:trim(dto.name),'<','&lt;')}"/>
									<c:set var="name" value="${fn:replace(name,'>','&gt;')}"/>
									<td align="center" class="name">${name}</td>
									<td align="center">
										<c:if test="${date.year==dto.writedate.year && date.month==dto.writedate.month && date.date==dto.writedate.date}">
											<fmt:formatDate value="${dto.writedate}" pattern="HH:mm:ss" />
										</c:if>
										<c:if test="${date.year!=dto.writedate.year || 
										date.month!=dto.writedate.month || date.date!=dto.writedate.date}">
											<fmt:formatDate value="${dto.writedate}" pattern="yy-MM-dd(E)" />
										</c:if>
									</td>
									<td align="center">
										${dto.board_hit}
									</td>
									<td align="center">
										<c:if test="${dto.good>=10}">
										<img src="images/hot.gif"/>
										</c:if>
										${dto.good}
									</td>
								</tr>
							</c:forEach>
						</c:if>
						<!--  //게시글목록 -->
                        <!-- //반복 태그 수행-->
                    </table>
                </div>
                <!--//테이블-->
                

		
		 <!--버튼 + 페이징-->
                <div style="margin-bottom:5px; display:flex; align-items:center; justify-content:center;">
                    <span style="display:flex; width:70%; height:6vh;justify-content:center;align-items: center;">
                        <div style="display:flex; justify-content:center; width:80%;height:80%;">
                            <!--  맨 앞으로 -->
                            <c:if test="${boardList.currentPage> 1}">
                            	<button class="pageButton"  title="첫 번째 페이지로 이동" onclick="location.href='?itcurrentPage=1&searchType=${searchType}&searchText=${searchText}'">처음</button>
                            </c:if>
                            <c:if test="${boardList.currentPage <= 1}">
                            	<button class="pageButton" disabled="disabled" title="이미 첫 번째 페이지입니다.">처음</button>
                            </c:if>	
                            <!--  10페이지 앞으로 -->	
                            <c:if test='${boardList.startPage>1}'>
                            	<button class="pageButton" title="이전 10페이지로 이동" onclick="location.href='?itcurrentPage=${boardList.startPage -1}&searchType=${searchType}&searchText=${searchText}'">이전</button>
                            </c:if>
                            <c:if test='${boardList.startPage<=1}'>
                            	<button class="pageButton" disabled="disabled">이전</button>
                            </c:if>
                            <!--  페이지 이동 -->
                            <c:forEach var="i" begin="${boardList.startPage}" end="${boardList.endPage}">
                            	<c:if test="${boardList.currentPage==i}">
                            		<button class="pageButton" disabled="disabled">${i}</button>
                            	</c:if>
                            	<c:if test="${boardList.currentPage!=i}">
                            		<button class="pageButton" onclick="location.href='?itcurrentPage=${i}&searchType=${searchType}&searchText=${searchText}'">${i}</button>
                            	</c:if>
                            </c:forEach>
                            <!--  10페이지 뒤로 -->
                            <c:if test="${boardList.endPage < boardList.totalPage}">
                            	<button class="pageButton" title="다음 10페이지로 이동" onclick="location.href='?itcurrentPage=${boardList.endPage +1}&searchType=${searchType}&searchText=${searchText}'">다음</button>
                            </c:if>
                            
                            <c:if test="${boardList.endPage >= boardList.totalPage}">
                            	<button class="pageButton" disabled="disabled" title="이미 마지막 10페이지입니다.">다음</button>
                            </c:if>
                            <!--  맨 뒤로 -->
                            <c:if test="${boardList.currentPage < boardList.totalPage}">
                            	<button class="pageButton" title="마지막 페이지로 이동" onclick="location.href='?itcurrentPage=${boardList.totalPage}&searchType=${searchType}&searchText=${searchText}'">끝</button>
                            </c:if>
                            <c:if test="${boardList.currentPage >= boardList.totalPage}">
                           		<button class="pageButton" disabled="disabled" title="이미 마지막 페이지입니다.">끝</button>
                           	</c:if>
                        </div>
                    </span>
                </div>
        <!--//버튼 + 페이징-->
            </div>
        </div>
        
        <!-- //IT게시판 -->
        <!-- Humor게시판 -->
        
        <div class="container-column" style="width: 80vw; min-width: 259.2px;">
            <div style="font-size:1.5rem; font-weight:900; position:relative; top:5px; left:5px;">유머 게시판</div>
            <div><hr/></div>
            <div style="margin-top:10px;">
				<!--  메인글을 받는다. -->
				<c:set var="boardList" value="${humorboardList}"/>
				<c:set var="list" value="${boardList.list}"/>
				<!-- 게시글번호를 받는다. -->
				<c:set var="No" value="${boardList.totalCount-boardList.startNo}"/>
				
                <!--테이블-->
                <div style="margin-bottom:5px;">
                    <table border-spacing=0; class="table-menu" style="border-radius:3px; line-height: 1.5rem; border:2px solid gray; width:100%;">   
                        <tr style="font-weight:600; font-size:1.1rem;">
                            <td align="center" style="width:8.3%;">번호</td>
                            <td align="center" style="width:54.2%;">제목</td>
                            <td align="center" style="width:9.4%;">글쓴이</td>
                            <td align="center" style="width:11.5%;">작성일</td>
                            <td align="center" style="width:8.3%;">조회</td>
                            <td align="center" style="width:8.3%;">추천</td>
                        </tr>
                        <tr>
                            <td colspan="6"><hr style="border:0;margin:0;height:2px; background-color:gray;"/></td>
                        </tr>
                        <!-- 반복 태그 수행-->
                        <!-- 메인글이 1건도 없으면 없다고 출력한다. -->
						<c:if test="${list.size()==0}">
						<tr>
							<td colspan="6" align="center">
								<marquee>글이 없습니다.</marquee>
							</td>
						</tr>
						</c:if>
                        
                        <c:if test="${list.size()!=0}">
							<c:forEach var="dto" items="${list}">
								<tr>
									<td align="center">${No}</td>
									<c:set var="No" value="${No-1}"/>
									<td align="left">
										<c:if test="${current_ref==dto.board_ref}">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</c:if>
										<c:set var="current_ref" value="${dto.board_ref}"/>
										<!-- 오늘 입력된 글에 new 아이콘을 표시 -->
										<c:if test="${date.year==dto.writedate.year && date.month==dto.writedate.month && date.date==dto.writedate.date}">
											<img src="images/new1.png"/>
										</c:if>
										<c:set var="subject" value="${fn:replace(dto.subject,'<','&lt;')}" />
										<c:set var="subject" value="${fn:replace(subject,'>','&gt;')}" />
										<a href="itboard/increment?bidx=${dto.bidx}&currentPage=${boardList.currentPage}" class="subject all">
											${subject}
										</a>
									</td>
									<c:set var="name" value="${fn:replace(fn:trim(dto.name),'<','&lt;')}"/>
									<c:set var="name" value="${fn:replace(name,'>','&gt;')}"/>
									<td align="center" class="name">${name}</td>
									<td align="center">
										<c:if test="${date.year==dto.writedate.year && date.month==dto.writedate.month && date.date==dto.writedate.date}">
											<fmt:formatDate value="${dto.writedate}" pattern="HH:mm:ss" />
										</c:if>
										<c:if test="${date.year!=dto.writedate.year || 
										date.month!=dto.writedate.month || date.date!=dto.writedate.date}">
											<fmt:formatDate value="${dto.writedate}" pattern="yy-MM-dd(E)" />
										</c:if>
									</td>
									<td align="center">
										${dto.board_hit}
									</td>
									<td align="center">
										<c:if test="${dto.good>=10}">
										<img src="images/hot.gif"/>
										</c:if>
										${dto.good}
									</td>
								</tr>
							</c:forEach>
						</c:if>
						<!--  //게시글목록 -->
                        <!-- //반복 태그 수행-->
                    </table>
                </div>
                <!--//테이블-->
                

		
		 <!--버튼 + 페이징-->
                <div style="margin-bottom:5px; display:flex; align-items:center; justify-content:center;">
                    <span style="display:flex; width:70%; height:6vh;justify-content:center;align-items: center;">
                        <div style="display:flex; justify-content:center; width:80%;height:80%;">
                            <!--  맨 앞으로 -->
                            <c:if test="${boardList.currentPage> 1}">
                            	<button class="pageButton"  title="첫 번째 페이지로 이동" onclick="location.href='?humorcurrentPage=1&searchType=${searchType}&searchText=${searchText}'">처음</button>
                            </c:if>
                            <c:if test="${boardList.currentPage <= 1}">
                            	<button class="pageButton" disabled="disabled" title="이미 첫 번째 페이지입니다.">처음</button>
                            </c:if>	
                            <!--  10페이지 앞으로 -->	
                            <c:if test='${boardList.startPage>1}'>
                            	<button class="pageButton" title="이전 10페이지로 이동" onclick="location.href='?humorcurrentPage=${boardList.startPage -1}&searchType=${searchType}&searchText=${searchText}'">이전</button>
                            </c:if>
                            <c:if test='${boardList.startPage<=1}'>
                            	<button class="pageButton" disabled="disabled">이전</button>
                            </c:if>
                            <!--  페이지 이동 -->
                            <c:forEach var="i" begin="${boardList.startPage}" end="${boardList.endPage}">
                            	<c:if test="${boardList.currentPage==i}">
                            		<button class="pageButton" disabled="disabled">${i}</button>
                            	</c:if>
                            	<c:if test="${boardList.currentPage!=i}">
                            		<button class="pageButton" onclick="location.href='?humorcurrentPage=${i}&searchType=${searchType}&searchText=${searchText}'">${i}</button>
                            	</c:if>
                            </c:forEach>
                            <!--  10페이지 뒤로 -->
                            <c:if test="${boardList.endPage < boardList.totalPage}">
                            	<button class="pageButton" title="다음 10페이지로 이동" onclick="location.href='?humorcurrentPage=${boardList.endPage +1}&searchType=${searchType}&searchText=${searchText}'">다음</button>
                            </c:if>
                            
                            <c:if test="${boardList.endPage >= boardList.totalPage}">
                            	<button class="pageButton" disabled="disabled" title="이미 마지막 10페이지입니다.">다음</button>
                            </c:if>
                            <!--  맨 뒤로 -->
                            <c:if test="${boardList.currentPage < boardList.totalPage}">
                            	<button class="pageButton" title="마지막 페이지로 이동" onclick="location.href='?humorcurrentPage=${boardList.totalPage}&searchType=${searchType}&searchText=${searchText}'">끝</button>
                            </c:if>
                            <c:if test="${boardList.currentPage >= boardList.totalPage}">
                           		<button class="pageButton" disabled="disabled" title="이미 마지막 페이지입니다.">끝</button>
                           	</c:if>
                        </div>
                    </span>
                </div>
        <!--//버튼 + 페이징-->
            </div>
        </div>
        <!-- //Humor게시판 -->
    </div>
    <script type="text/javascript" src="js/common.js"></script>
    <script>
		window.onload = function() {
			colorizeText('${searchText}','${searchType}');
		}
	</script>
	
</body>
</html>