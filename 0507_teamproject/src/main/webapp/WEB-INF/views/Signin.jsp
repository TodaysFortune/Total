<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>회원가입</title>
        <!-- Bootstrap core CSS , js -->
        <!-- <link type="text/css" href="css/bootstrap.css" rel="stylesheet">  -->
        <link type="text/css" href="css/bootstrap.min.css" rel="stylesheet"> 
        <script type="text/javascript" src="js/bootstrap.js"></script>
        
        <!-- Custom styles for this template -->
        <style type="text/css">
			.th-user-fonesize{
				font-size:	0.8125rem;
			}
			.td-user-fontsize{
				font-size:	0.625rem;
			}
			.table>:not(caption)>*>*{
				border-bottom-width:0px;
				padding : 0px;
			}
			.card-header {
				padding: 0.2rem 1.5rem;
			}
			.card-body{
			    padding: .1rem .1rem;
			}
			.form-control{
				width:300px;
			}			
        </style>
        <link type="text/css" href="css/Signpage.css" rel="stylesheet" />
    </head>
    
<body>
    <input="hidden" value="pull테스트입니다"/>
    <input="hidden" value="pull테스트입니다"/>
    <input="hidden" value="pull테스트입니다"/>
	
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
          <a class="nav-link active" href="#">나의 운세
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
       	 	<input class="form-control me-sm-2" type="text" placeholder="검색">
       	 	<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
    	 </form>
    	</li>
      </ul>
      
      
      <form class="d-flex">
      	<button type="button" class="btn me-sm-1 rounded-pill btn-info" onclick="location.href='Login'">로그인</button>
      </form>
      <form class="d-flex">
      	<button type="button" class="btn me-sm-5 rounded-pill btn-outline-info" onclick="location.href='Signin'">회원가입</button>
      </form>

    </div>
  </div>
</nav>
<body>
  <div class="signbox">
  	<form id="login" action="Signin" method="post">
    <h1 class="sign">회원가입</h1>
 	<hr class="one">
		<div class="sign-info">
		
		<div class="form-group">
		  	<div class="idcheck">	
			  <div class="form-floating mb-3">
			    <input type="text" class="form-control" name="id" id="floatingInput" placeholder="아이디 입력">
			    <label for="floatingInput">아이디</label>
			  </div>
			 </div>
			  <div class="idcheck">	
			  <div class="form-floating mb-3">
			    <input type="password" class="form-control" id="floatingInput" placeholder="비밀번호 입력">
			    <label for="floatingInput">비밀번호</label>
			  </div>
			 </div>
			 <div class="idcheck">	
			  <div class="form-floating mb-3">
			    <input type="password" class="form-control" name="password" id="floatingInput" placeholder="비밀번호 재확인">
			    <label for="floatingInput">비밀번호 확인</label>
			  </div>
			 </div>
			 <div class="idcheck">	
			  <div class="form-floating mb-3">
			    <input type="text" class="form-control" name="name" id="floatingInput" placeholder="이름">
			    <label for="floatingInput">이름</label>
			  </div>
			 </div>
			 <div class="idcheck">	
			  <div class="form-floating mb-3">
			    <input type="email" class="form-control" name="email" id="floatingInput" placeholder="name@example.com">
			    <label for="floatingInput">이메일</label>
			  </div>
			 </div>
			 <div class="idcheck">	
			  <div class="form-floating mb-3">
			    <input type="text" class="form-control" name="phone" id="floatingInput" placeholder="휴대전화">
			    <label for="floatingInput">휴대전화</label>
			  </div>
			 </div>
		</div>
		</div>
			
	
	<hr class="one">
	<div class="content-consent">
	<p>동철우정컴퍼니 (이하’회사는’) 고객님의 개인정보를 중요시하며,”정보통신망 이용촉진 및 정보보호”에 관한 법률을 준수하고 있습니다.

회사는 개인정보취급방침을 통하여 고객님께서 제공하시는 개인정보가 어떠한 용도와 방식으로 이용되고 있으며, 개인정보보호를 위해 어떠한 조치가 취해지고 있는지 알려드립니다.

회사는 개인정보취급방침을 개정하는 경우 웹사이트 공지사항(또는 개별공지)을 통하여 공지할 것입니다.

본 방침은 2013년 9월 1일부터 시행됩니다.</p>
	</div>
	<div class="check-consent-box">
	        <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked="">
	        <label class="form-check-label" for="flexCheckChecked">&nbsp동의</label>
	 </div>
	 <hr class="one">
	 <div class="SignAndRewrite">
	 	<button class="btn btn-lg btn-primary" type="submit">가입</button>
  		<button class="btn btn-lg btn-primary" type="button">다시쓰기</button>
	 </div>
	</form>
  </div>
  

</body>
</html>