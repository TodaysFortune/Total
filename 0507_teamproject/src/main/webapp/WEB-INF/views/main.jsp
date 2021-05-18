<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <a class="navbar-brand" href="#">Navbar</a>
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
            <a class="dropdown-item" href="#">It 시사</a>
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
      <form method="get" action="Login" id="userLogin">
      	<button type="submit" class="btn me-sm-1 rounded-pill btn-info">Login</button>
      </form>
      <form method="get" action="Signin" id="userSign">
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
	        img.src = "images/userlogin.png"; 
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
 	 		logoutForm.setAttribute('action','Logout');
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
<div class="d-flex gap-md-1 flex-wrap" style="justify-content:center; height:100%;">
	
    <!--중단1 -->
  <div class="card text-white bg-warning mt-sm-4" style="width:34%; height:250px;align-item: center; justify-content:center; ">
  	<div class="card-header" style="align-item: center;">New</div>
  	<div class="card-body" style="align-item: center;">
    
    
		<table class="table table-hover" style="width:99%; height:99%; background-color: #fff; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; align-item: center; margin:1px;">
			  <thead>
			    <tr class="th-user-fonesize">
			      <th scope="col" class="col-2 text-center">번호</th>
			      <th scope="col" class="col-8 text-center">제목</th>
			      <th scope="col" class="col-2 text-center">추천</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr class="table-active td-user-fontsize">
			      <th scope="row" class="text-center">Active</th>
			      <td>Column content</td>
			      <td class="text-center">1</td>
			    </tr>
			    <tr class="table-active td-user-fontsize">
			      <th scope="row" class="text-center">Default</th>
			      <td>Column content</td>
			      <td class="text-center">1</td>
			    </tr>
			    <tr class="table-active td-user-fontsize">
			      <th scope="row" class="text-center">Primary</th>
			      <td>Column content</td>
			      <td class="text-center">1</td>
			    </tr>
			    <tr class="table-active td-user-fontsize">
			      <th scope="row" class="text-center">Secondary</th>
			      <td>Column content</td>
			      <td  class="text-center">1</td>
			    </tr>
			    <tr class="table-active td-user-fontsize">
			      <th scope="row" class="text-center">Success</th>
			      <td>Column content</td>
			      <td  class="text-center">1</td>
			    </tr>
			    <tr class="table-active td-user-fontsize">
			      <th scope="row" class="text-center">Danger</th>
			      <td>Column content</td>
			      <td class="text-center">1</td>
			    </tr>
			    <tr class="table-active td-user-fontsize">
			      <th scope="row"  class="text-center">Warning</th>
			      <td>Column content</td>
			      <td  class="text-center">1</td>
			    </tr>
			    <tr class="table-active td-user-fontsize">
			      <th scope="row"  class="text-center">Info</th>
			      <td>Column content</td>
			      <td  class="text-center">1</td>
			    </tr>
			  </tbody>
		</table>
  	</div>
 </div>
 <!--//중단1 -->
 <!--중단2 -->
    
<div class="card text-white bg-danger mt-sm-4" style="width:34%; height:250px; align-item: center; justify-content:center;">
  <div class="card-header" style="align-item: center;">Best</div>
  <div class="card-body" style="align-item: center;">
    
    
	<table class="table table-hover" style="width:99%; height:99%; background-color: #fff; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; margin:1px;">
		  <thead>
		    <tr class="th-user-fonesize">
		      <th scope="col" class="col-2 text-center">번호</th>
		      <th scope="col" class="col-8 text-center">제목</th>
		      <th scope="col" class="col-2 text-center">추천</th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr class="table-active td-user-fontsize">
		      <th scope="row" class="text-center">Active</th>
		      <td>Columncontent</td>
		      <td class="text-center">1</td>
		    </tr>
		    <tr class="table-active td-user-fontsize">
		      <th scope="row" class="text-center">Default</th>
		      <td>Column content</td>
		      <td class="text-center">1</td>
		    </tr>
		    <tr class="table-active td-user-fontsize">
		      <th scope="row" class="text-center">Primary</th>
		      <td>Column content</td>
		      <td class="text-center">1</td>
		    </tr>
		    <tr class="table-active td-user-fontsize">
		      <th scope="row" class="text-center">Secondary</th>
		      <td>Column content</td>
		      <td class="text-center">1</td>
		    </tr>
		    <tr class="table-active td-user-fontsize">
		      <th scope="row" class="text-center">Success</th>
		      <td>Column content</td>
		      <td class="text-center">1</td>
		    </tr>
		    <tr class="table-active td-user-fontsize">
		      <th scope="row" class="text-center">Danger</th>
		      <td>Column content</td>
		      <td class="text-center">1</td>
		    </tr>
		    <tr class="table-active td-user-fontsize">
		      <th scope="row" class="text-center">Warning</th>
		      <td>Column content</td>
		      <td class="text-center">1</td>
		    </tr>
		    <tr class="table-active td-user-fontsize">
		      <th scope="row" class="text-center">Info</th>
		      <td>Column content</td>
		      <td class="text-center">1</td>
		    </tr>
		  </tbody>
	</table>
	

  </div>
</div>   
    <!--//중단2 -->
     <!--중단3 -->
  <div class="card text-white bg-info mt-sm-1" style="width:34%; height:250px;align-item: center; justify-content:center;">
  	<div class="card-header" style="align-item: center;">IT</div>
  	<div class="card-body" style="align-item: center;">
    
    
		<table class="table table-hover" style="width:99%; height:99%; background-color: #fff; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; align-item: center; margin:1px;">
			  <thead>
			    <tr class="th-user-fonesize">
			      <th scope="col" class="col-2 text-center">번호</th>
			      <th scope="col" class="col-8 text-center">제목</th>
			      <th scope="col" class="col-2 text-center">추천</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr class="table-active td-user-fontsize">
			      <th scope="row" class="text-center">Active</th>
			      <td>Column content</td>
			      <td class="text-center">1</td>
			    </tr>
			    <tr class="table-active td-user-fontsize">
			      <th scope="row" class="text-center">Default</th>
			      <td>Column content</td>
			      <td class="text-center">1</td>
			    </tr>
			    <tr class="table-active td-user-fontsize">
			      <th scope="row" class="text-center">Primary</th>
			      <td>Column content</td>
			      <td class="text-center">1</td>
			    </tr>
			    <tr class="table-active td-user-fontsize">
			      <th scope="row" class="text-center">Secondary</th>
			      <td>Column content</td>
			      <td  class="text-center">1</td>
			    </tr>
			    <tr class="table-active td-user-fontsize">
			      <th scope="row" class="text-center">Success</th>
			      <td>Column content</td>
			      <td  class="text-center">1</td>
			    </tr>
			    <tr class="table-active td-user-fontsize">
			      <th scope="row" class="text-center">Danger</th>
			      <td>Column content</td>
			      <td class="text-center">1</td>
			    </tr>
			    <tr class="table-active td-user-fontsize">
			      <th scope="row"  class="text-center">Warning</th>
			      <td>Column content</td>
			      <td  class="text-center">1</td>
			    </tr>
			    <tr class="table-active td-user-fontsize">
			      <th scope="row"  class="text-center">Info</th>
			      <td>Column content</td>
			      <td  class="text-center">1</td>
			    </tr>
			  </tbody>
		</table>
  	</div>
 </div>
 <!--//중단3 -->
 <!--중단4 -->
    
<div class="card text-white bg-success mt-sm-1" style="width:34%; height:250px; align-item: center; justify-content:center;">
  <div class="card-header" style="align-item: center;">유머</div>
  <div class="card-body" style="align-item: center;">
    
    
	<table class="table table-hover" style="width:99%; height:99%; background-color: #fff; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; margin:1px;">
		  <thead>
		    <tr class="th-user-fonesize">
		      <th scope="col" class="col-2 text-center">번호</th>
		      <th scope="col" class="col-8 text-center">제목</th>
		      <th scope="col" class="col-2 text-center">추천</th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr class="table-active td-user-fontsize">
		      <th scope="row" class="text-center">Active</th>
		      <td>Columncontent</td>
		      <td class="text-center">1</td>
		    </tr>
		    <tr class="table-active td-user-fontsize">
		      <th scope="row" class="text-center">Default</th>
		      <td>Column content</td>
		      <td class="text-center">1</td>
		    </tr>
		    <tr class="table-active td-user-fontsize">
		      <th scope="row" class="text-center">Primary</th>
		      <td>Column content</td>
		      <td class="text-center">1</td>
		    </tr>
		    <tr class="table-active td-user-fontsize">
		      <th scope="row" class="text-center">Secondary</th>
		      <td>Column content</td>
		      <td class="text-center">1</td>
		    </tr>
		    <tr class="table-active td-user-fontsize">
		      <th scope="row" class="text-center">Success</th>
		      <td>Column content</td>
		      <td class="text-center">1</td>
		    </tr>
		    <tr class="table-active td-user-fontsize">
		      <th scope="row" class="text-center">Danger</th>
		      <td>Column content</td>
		      <td class="text-center">1</td>
		    </tr>
		    <tr class="table-active td-user-fontsize">
		      <th scope="row" class="text-center">Warning</th>
		      <td>Column content</td>
		      <td class="text-center">1</td>
		    </tr>
		    <tr class="table-active td-user-fontsize">
		      <th scope="row" class="text-center">Info</th>
		      <td>Column content</td>
		      <td class="text-center">1</td>
		    </tr>
		  </tbody>
	</table>
	

  </div>
</div>   
    <!--//중단4 -->
 </div>
 <!--//중단-->

</body>
</html>
