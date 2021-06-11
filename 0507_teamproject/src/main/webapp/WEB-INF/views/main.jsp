<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<html lang="ko">
    <head>
    	<link rel="shortcut icon" href="#"> <!-- favicon -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>레이아웃</title>
        <!-- Bootstrap core CSS , js -->
        <link type="text/css" href="css/bootstrap.min.css" rel="stylesheet"> 
        <script type="text/javascript" src="js/bootstrap.js"></script>
        
        <!-- Custom styles for this template -->
        <link type="text/css" href="css/navbar.css" rel="stylesheet"> 
    </head>
    
<body>
	
    <!--상단 https://bootswatch.com/sketchy/-->
 <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="main">Home</a>
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
            <a class="dropdown-item" href="main/humorboard">유머</a>
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
      
      
      <form class="d-flex" action="main/totalBoard" method="get">
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
	        img.src = "images/userlogin.png"; 
	        
	        img.setAttribute('style','width:2.5rem; height:2.5rem;');
	        
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
 	 		logoutForm.setAttribute('action','main/logout');
 	 		logoutForm.append(logoutButton);
 	 		
 	 		document.getElementById('greet').setAttribute('style','margin-right:10px; font-size:0.5em');

 		}
 	})(2);
     </script>
     
     
    </div>
  </div>
</nav>
    <!--//상단 -->
 <!--중단-->  
<div class="d-flex gap-md-2 flex-wrap" style="justify-content:center; height:100%; margin-top:1rem;">
	
    <!--중단1 -->
  <div class="card text-white bg-warning" style="width:34%; height:auto;align-item: center; justify-content:center; ">
  	<div class="card-header" style="align-item: center;">New</div>
  	<div class="card-body" style="align-item: center;">
    
    
		<table class="table table-hover" style="width:99%; min-height:99%; height:auto; background-color: #fff; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; align-item: center; margin:1px;">
			  <thead>
			    <tr class="th-user-fonesize">
			      <th scope="col" class="col-2 text-center">분류</th>
			      <th scope="col" class="col-8 text-center">제목</th>
			      <th scope="col" class="col-2 text-center">추천</th>
			    </tr>
			  </thead>
			  <tbody>
			  			<!--                      NEW                        -->
			  	<c:set var="NewList" value="${totalNewList.list}"/>
			  	<c:forEach var="dto" items="${NewList}">
			  		<tr class="table-active td-user-fontsize">
			      		<th scope="row" class="text-center">${dto.url.substring(0,dto.url.length()-5)}</th>
			      		<td onclick="location.href='main/moveBoard?bidx=${dto.bidx}&url=${dto.url}'">${dto.subject}</td>
			      		<td class="text-center">${dto.good}</td>
			    	</tr>
			  	</c:forEach>
			  	<c:set var="LeftNewListlength" value="${num-NewList.size()}"/>
			  	<c:forEach begin="1" end="${LeftNewListlength}" step="1">
			  		<tr class="table-active td-user-fontsize">
			  			<th scope="row" class="text-center">&nbsp;</th>
			  			<td>&nbsp;</td>
			      		<td class="text-center">&nbsp;</td>
			  		</tr>
			  	</c:forEach>
			  </tbody>
		</table>
  	</div>
 </div>
 <!--//중단1 -->
 <!--중단2 -->
    
<div class="card text-white bg-danger" style="width:34%; height:auto; align-item: center; justify-content:center;">
  <div class="card-header" style="align-item: center;">Best</div>
  <div class="card-body" style="align-item: center;">
    
    
	<table class="table table-hover" style="width:99%; min-height:99%; height:auto; background-color: #fff; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; margin:1px;">
		  <thead>
		    <tr class="th-user-fonesize">
		      <th scope="col" class="col-2 text-center">분류</th>
		      <th scope="col" class="col-8 text-center">제목</th>
		      <th scope="col" class="col-2 text-center">추천</th>
		    </tr>
		  </thead>
		  <tbody>
		  			<!--                      BEST                        -->
		    	<c:set var="GoodList" value="${totalGoodList.list}"/>
			  	<c:forEach var="dto" items="${GoodList}">
			  		<tr class="table-active td-user-fontsize">
			      		<th scope="row" class="text-center">${dto.url.substring(0,dto.url.length()-5)}</th>
			      		<td onclick="location.href='main/moveBoard?bidx=${dto.bidx}&url=${dto.url}'">${dto.subject}</td>
			      		<td class="text-center">${dto.good}</td>
			    	</tr>
			  	</c:forEach>
			  	<c:set var="LeftGoodListlength" value="${num-GoodList.size()}"/>
			  	<c:forEach begin="1" end="${LeftGoodListlength}" step="1">
			  		<tr class="table-active td-user-fontsize">
			  			<th scope="row" class="text-center">&nbsp;</th>
			  			<td>&nbsp;</td>
			      		<td class="text-center">&nbsp;</td>
			  		</tr>
			  	</c:forEach>
		  </tbody>
	</table>
	

  </div>
</div>   
    <!--//중단2 -->
     <!--중단3 -->
  <div class="card text-white bg-info" style="width:34%; height:auto;align-item: center; justify-content:center;">
  	<div class="card-header" style="align-item: center;">IT</div>
  	<div class="card-body" style="align-item: center;">
    
    
		<table class="table table-hover" style="width:99%; min-height:99%; height:auto; background-color: #fff; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; align-item: center; margin:1px;">
			  <thead>
			    <tr class="th-user-fonesize">
			      <th scope="col" class="col-2 text-center">최신글</th>
			      <th scope="col" class="col-8 text-center">제목</th>
			      <th scope="col" class="col-2 text-center">추천</th>
			    </tr>
			  </thead>
			  <tbody>
			  			<!--                      IT                        -->
			    	<c:set var="itList" value="${iTboardList.list}"/>
			  		<c:forEach var="dto" items="${itList}">
				  		<tr class="table-active td-user-fontsize">
				      		<th scope="row" class="text-center">${dto.bidx}</th>
				      		<td onclick="location.href='main/moveBoard?bidx=${dto.bidx}&url=${dto.categoryname}'">${dto.subject}</td>
				      		<td class="text-center">${dto.good}</td>
				    	</tr>
			  		</c:forEach>
			    	<c:set var="LeftitListlength" value="${num-itList.size()}"/>
			  		<c:forEach begin="1" end="${LeftitListlength}" step="1">
			  			<tr class="table-active td-user-fontsize">
				  			<th scope="row" class="text-center">&nbsp;</th>
				  			<td>&nbsp;</td>
				      		<td class="text-center">&nbsp;</td>
			  			</tr>
			  		</c:forEach>
			    
			  </tbody>
		</table>
  	</div>
 </div>
 <!--//중단3 -->
 <!--중단4 -->
    
<div class="card text-white bg-success" style="width:34%; height:auto; align-item: center; justify-content:center;">
  <div class="card-header" style="align-item: center;">유머</div>
  <div class="card-body" style="align-item: center;">
    
    
	<table class="table table-hover" style="width:99%; min-height:99%; height:auto; background-color: #fff; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; margin:1px;">
		  <thead>
		    <tr class="th-user-fonesize">
		      <th scope="col" class="col-2 text-center">최신글</th>
		      <th scope="col" class="col-8 text-center">제목</th>
		      <th scope="col" class="col-2 text-center">추천</th>
		    </tr>
		  </thead>
		  <tbody>
		  			<!--                      Humor                        -->
		    	<c:set var="humorList" value="${humorboardList.list}"/>
			  		<c:forEach var="dto" items="${humorList}">
				  		<tr class="table-active td-user-fontsize">
				      		<th scope="row" class="text-center">${dto.bidx}</th>
				      		<td onclick="location.href='main/moveBoard?bidx=${dto.bidx}&url=${dto.categoryname}'">${dto.subject}</td>
				      		<td class="text-center">${dto.good}</td>
				    	</tr>
			  	</c:forEach>
		    	<c:set var="LefthumorListlength" value="${num-humorList.size()}"/>
			  		<c:forEach begin="1" end="${LefthumorListlength}" step="1">
			  			<tr class="table-active td-user-fontsize">
				  			<th scope="row" class="text-center">&nbsp;</th>
				  			<td>&nbsp;</td>
				      		<td class="text-center">&nbsp;</td>
			  			</tr>
			  		</c:forEach>
		  </tbody>
	</table>
	

  </div>
</div>   
    <!--//중단4 -->
 </div>
 <!--//중단-->
 <div style="height:30px;">
 </div>
 <script type="text/javascript" src="js/common.js"></script>
</body>
</html>
