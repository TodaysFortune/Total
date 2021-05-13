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
      
      
      <form class="d-flex">
      	<button type="button" class="btn me-sm-1 rounded-pill btn-info" onclick="location.href='Login'">Login</button>
      </form>
      <form class="d-flex" method="get">
      	<button type="button" class="btn me-sm-5 rounded-pill btn-outline-info" onclick="location.href='Signin'">Sign</button>
      </form>

    </div>
  </div>
</nav>
    <!--//상단 -->
  
  <section>
    <h1>회원가입</h1>
  </section>
  
  <section>
    <form id="login" action="Signin" method="post">
      아이디<br>
      <input type="text" name="id" id="user_ID" placeholder="아이디 입력" >
      <input type="button" id="user_IDcheck" value="아이디 확인">
      <br>
      비밀번호<br> 
      <input type="password" name="password" id="user_PW1" value="123456"><br>
      비밀번호 재확인<br> 
      <input type="password" id="user_PW2" value="123456">
      <input type="button" id="user_PWcheck" value="비밀번호 재확인">
      <br><br>
      이름<br>  <input type="text" name="name" id="user_name" value=""> <br>
      생년월일<br> 
      <select id="year">
        <option value="">-- 선택 --</option>
        <option value="1995">1995</option>
        <option value="1996">1996</option>
        <option value="1997">1997</option>
        <option value="1998">1998</option>
        <option value="1999">1999</option>
        <option value="2000">2000</option>
      </select>
      <select id="month">
        <option value="">-- 선택 --</option>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>
        <option value="11">11</option>
        <option value="12">12</option>
      </select>
      <select id="day">
        <option value="">-- 선택 --</option>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>
        <option value="11">11</option>
        <option value="12">12</option>
        <option value="13">13</option>
        <option value="14">14</option>
        <option value="15">15</option>
        <option value="16">16</option>
        <option value="17">17</option>
        <option value="18">18</option>
        <option value="19">19</option>
        <option value="20">20</option>
        <option value="21">21</option>
        <option value="22">22</option>
        <option value="23">23</option>
        <option value="24">24</option>
        <option value="25">25</option>
        <option value="26">26</option>
        <option value="27">27</option>
        <option value="28">28</option>
        <option value="29">29</option>
        <option value="30">30</option>
        <option value="31">31</option>
      </select>
      <br><br>
      성별<br>  
      <label for="man">남자</label>
      <input type="radio" id="gender" value="m" id="man">
      <label for="woman">여자</label>
      <input type="radio" id="gender" value="m" id="woman"> <br><br>
      이메일<br><input type="email" name="email" id="user_email" placeholder="email@gmail.com"><br><br>
      휴대전화<br>  
      <input type="text" name="phone" id="user_phone" placeholder="010-****-****">
      <input type="button" id="certification" value="인증번호 받기"><br>
      <input type="text" id="certification" placeholder="인증번호를 입력하세요">
      <input type="button" id="certification" value="확인"><br><br>
      <div>
      	<h3>[필수] 개인정보 수집 및 이용 동의</h3>
      	<div class="content">
      		<p>동철우정컴퍼니 (이하’회사는’) 고객님의 개인정보를 중요시하며,”정보통신망 이용촉진 및 정보보호”에 관한 법률을 준수하고 있습니다.

회사는 개인정보취급방침을 통하여 고객님께서 제공하시는 개인정보가 어떠한 용도와 방식으로 이용되고 있으며, 개인정보보호를 위해 어떠한 조치가 취해지고 있는지 알려드립니다.

회사는 개인정보취급방침을 개정하는 경우 웹사이트 공지사항(또는 개별공지)을 통하여 공지할 것입니다.

본 방침은 2013년 9월 1일부터 시행됩니다.</p>
      	</div>
      </div>
      <span>개인정보 수집 및 이용에 동의하십니까?</span>
      <input type="checkbox" id="check">
      <input type="submit" value="확인"><br><br>
    </form>
  </section>

</body>
</html>