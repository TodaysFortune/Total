<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
    	<link rel="shortcut icon" href="#"> <!-- favicon -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>회원가입</title>
        <!-- Bootstrap core CSS , js -->
        <link type="text/css" href="css/bootstrap.min.css" rel="stylesheet"> 
        <script type="text/javascript" src="js/bootstrap.js"></script>
        
        <!-- Custom styles for this template -->
        <link type="text/css" href="css/navbar.css" rel="stylesheet"> 
        <link type="text/css" href="css/woojeong.css" rel="stylesheet" />
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
          <a class="nav-link active" href="#">Luck
            <span class="visually-hidden">(current)</span>
          </a>
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
      
      
      <form class="d-flex">
      	<button type="button" class="btn me-sm-1 rounded-pill btn-info" onclick="location.href='Login'">Login</button>
      </form>
      <form class="d-flex">
      	<button type="button" class="btn me-sm-5 rounded-pill btn-outline-info" onclick="location.href='Signin'">Sign</button>
      </form>

    </div>
  </div>
</nav>
<body>


<div class="IdinputAndPwinputbox">
	<h1>오늘의 운세는?</h1>
	<hr class="one">
	
	
	<form action="/teamproject" method="post" onsubmit="return id_pw_Check();">
		<div class="form-group"  style="margin-bottom:10px;">
	  
		  <div class="form-floating mb-3">
		    <input type="text" class="form-control" style="width:100%;" name="id" placeholder="name@example.com">
		    <label for="floatingInput">아이디 입력(필수)</label>
		  </div>
		  <div class="form-floating">
		    <input type="password" class="form-control" style="width:100%;" name="password" placeholder="Password">
		    <label for="floatingPassword">비밀번호 입력(필수)</label>
		  </div>
		</div>
		

	
		<div class="myway1">
			<div class="form-check1" style="padding-left: 0px;margin-top: 3px;">
				<div>
		        	<input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked="">
		        	<label class="form-check-label" for="flexCheckChecked">자동로그인</label>
		    	</div>
				<ul class="IdsearchAndPwsearch">
		        	<a href="#">아이디찾기 </a>
		        		<div>&nbsp;|&nbsp; </div>
		        	<a href="#"> 비밀번호찾기</a>
		        </ul>
		    </div>
		 </div>
     	<div class="d-grid gap-2 Btnoption1">
  			<button class="btn btn-lg btn-primary" type="submit">로그인</button>
  			<button class="btn btn-lg btn-primary" type="button" onclick="location.href='Signin'">회원가입</button>
		</div>
	</form>
	
</div>


<script>
	function id_pw_Check(){
		var id=document.getElementsByName('id')[0].value.trim();
		var password=document.getElementsByName('password')[0].value.trim();
		if( ! (id.length && password.length) ){ //id or pw 입력 안할경우
			alert("아이디 또는 비밀번호를 입력해주세요.");
			if(id.length==0)
				document.getElementsByName('id')[0].focus();
			else
				document.getElementsByName('password')[0].focus();
			return false;
		}
		//서버로데이터전송
	}
</script>


</body>
</html>