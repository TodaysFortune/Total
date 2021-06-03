<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
    	<link rel="shortcut icon" href="#"> <!-- favicon -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>회원가입</title>
        <!-- Bootstrap or etc core CSS , js -->
        <link type="text/css" href="css/bootstrap.min.css" rel="stylesheet"> 
        <script type="text/javascript" src="js/bootstrap.js"></script>
       	<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
        
        <!-- Custom styles for this template -->
        <link type="text/css" href="css/navbar.css" rel="stylesheet">
        <link type="text/css" href="css/board.css" rel="stylesheet" />
        <link type="text/css" href="css/modal.css" rel="stylesheet" />
    </head>
    
<body>
 <!--상단 https://bootswatch.com/sketchy/-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="../">Navbar</a>
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
	      <form method="get" action="login" id="userLogin">
	      	<button type="submit" class="btn me-sm-1 rounded-pill btn-info">Login</button>
	      </form>
	      <form method="get" action="signin" id="userSign">
	      	<button type="submit" class="btn rounded-pill btn-outline-info">Sign</button>
	      </form>
      </div>

    </div>
  </div>
</nav>
<!-- //상단 -->
<!-- 중단 -->
  <div class="container-column-align" style="height: 100%; margin-top: 1rem;">
        <form id="login" action="signin" method="post" class="container-column border-blue" style="width: 70vw; min-width: 259.2px;">
            <div style="font: normal normal bold 1.5rem arial;">회원가입</div>
            <div><hr/></div>
            <div style="display:flex; justify-content: flex-start;"
            	class="form-floating mb-3">											<!--ID-->
                <input type="text" style="min-width: 20rem;"
                class="form-control empty_confirm_Check" name="id" id="Input_id" placeholder=" "/>
                <label for="Input_id" class="signin-font-color">아이디</label>
                <input type="button" class="btn btn-lg btn-primary ms-3" value="중복확인" onclick="Isunique('id')"/>
                <div id="id_guide" class="text_guide_hidden">사용가능한 ID 입니다.</div>
            </div>
            <div class="form-floating mb-3">								    	<!--password-->
                <input type="password" style="min-width:20rem;"
                	class="form-control empty_confirm_Check" id="Input_pw" placeholder=" "/>
                <label for="Input_pw" class="signin-font-color">비밀번호</label>
            </div>
            <div style="display:flex; justify-content: flex-start;"
            	class="form-floating mb-3">											<!--re-password-->
                <input type="password" style="min-width:20rem;"
                	class="form-control empty_confirm_Check"  name="password" id="Input_re_pw" placeholder=" "/>
                <label for="Input_re_pw" class="signin-font-color">비밀번호 확인</label>
                <!--비밀번호일치하지않음을 알려주기-->
            </div>
            <div style="display:flex; justify-content: flex-start;"
            	class="form-floating mb-3">											<!-- nick-name -->
                <input type="text" style="min-width:20rem;"
                	class="form-control empty_confirm_Check" name="name" id="Input_name" placeholder=" "/>
                <label for="Input_name" class="signin-font-color">이름</label>
                <input type="button" class="btn btn-lg btn-primary ms-3" value="중복확인" onclick="Isunique('name')"/>
                <div id="name_guide" class="text_guide_hidden">사용가능한 이름 입니다.</div>
            </div>
            <div style="display:flex; justify-content: flex-start;"
            	class="form-floating mb-3">											<!-- email -->
                <input type="email" style="min-width:20rem;"
                	class="form-control empty_confirm_Check" name="email" id="Input_email" placeholder=" "/>
                <label for="Input_email" class="signin-font-color">이메일</label>
                <input type="button" class="btn btn-lg btn-primary ms-3" value="인증"/>
                <!--인증완료 보여주기 -->
            </div>
            <div class="form-floating mb-3">										<!-- phone -->
                <input type="tel" style="min-width:20rem;"
                	class="form-control empty_confirm_Check" name="tel" id="Input_phone" placeholder=" "/>
                <label for="Input_phone" class="signin-font-color"  pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" required>휴대전화</label>
            </div>
            <div><hr/></div>
            <div style="display:flex; justify-content: center;">
                <input type="submit" value="가입" class="btn btn-lg btn-primary"/>
                <input type="reset" value="다시쓰기" class="btn btn-lg btn-primary ms-2"/>
            </div>
        </form>    
    </div>
    
    <!-- modal -->
  <div class="modal hidden">
    <div class="modal__overlay"></div><!-- 외부클릭시 닫을 용도 ,외부색깔담당 -->
    <div class="modal__content">
      <div id="modal__text">사용 가능한 아이디입니다.</div>
      <button class="modal-button" style="background-color: #2E9AFE;" id="modal_close">OK</button>
    </div>
  </div>
	<!-- //modal -->
    
    
 <!-- //중단 -->
 <script>
 //emptyCheck 클래스를 이용하여서       총 제출전 비어있는지 검사 , 중복확인도 완료되었는지 검사 , 인증도 완료되었는지 검사.
 //unique검사
 function Isunique(obj){
	//-1 먼저 모달관련 태그를 선택해온다
	 var modal_item=document.getElementById("modal__text");
	 var modal_button=document.getElementById("modal_close");
	 if(obj=='id'){							//id check
		 //0.데이터를 모셔와서 않비어있다면  json 화 한다.
		 var Input_id=document.getElementById("Input_id");
		 if(Input_id.value.trim().length==0){
			 alert(obj.toUpperCase()+"를 입력해주세요");
		 	return;
		 }
		 var jsonData={
				 data4Check: Input_id.value,
				 dataType: obj
		 }
		 //1.동기식 ajax로 서버로부터 중복되는가 검사받고
		 var signal=ajax_function(jsonData);
		 //2.상황에 맞게 모달창으로 텍스트 띄우고 , guide 텍스트 생성
		 if(signal==0){
			 modal_item.textContent="이미 존재하는 아이디 입니다.";
			 modal_button.setAttribute('style','background-color:#F78B8B;color:black;');
			 openModal();
			 id_guide=document.getElementById("id_guide");
			 id_guide.textContent="중복된 아이디가 있습니다.";
			 id_guide.className='text_guide_fail';
		 }else{ 
			 modal_item.textContent="사용가능한 아이디 입니다.";
			 modal_button.setAttribute('style','background-color:#2E9AFE;color:white;');
			 openModal();
			 id_guide=document.getElementById("id_guide");
			 id_guide.textContent="사용가능한 아이디 입니다.";
			 id_guide.className='text_guide_success';
		 }
	 }else{										//name check
		 //0.데이터를 모셔와서 않비어있다면  json 화 한다.
		 var Input_name=document.getElementById("Input_name");
		 if(Input_name.value.trim().length==0){
			 alert(obj.toUpperCase()+"를 입력해주세요");
		 	return;
		 }
		 var jsonData={
				 data4Check: Input_name.value,
				 dataType: obj
		 }
		 //1.동기식 ajax로 서버로부터 중복되는가 검사받고
		 var signal=ajax_function(jsonData);
		 //2.상황에 맞게 모달창으로 텍스트 띄우고 , guide 텍스트 생성
		 if(signal==0){
			 modal_item.textContent="이미 존재하는 이름 입니다.";
			 modal_button.setAttribute('style','background-color:#F78B8B;color:black;');
			 openModal();
			 name_guide=document.getElementById("name_guide");
			 name_guide.textContent="중복된 이름이 있습니다.";
			 name_guide.className='text_guide_fail';
		 }else{ 
			 modal_item.textContent="사용가능한 이름 입니다.";
			 modal_button.setAttribute('style','background-color:#2E9AFE;color:white;');
			 openModal();
			 name_guide=document.getElementById("name_guide");
			 name_guide.textContent="사용가능한 아이디 입니다.";
			 name_guide.className='text_guide_success';
		 } 
	 }
 }
 function ajax_function(obj){
	 var success_data;
     $.ajax({
         url: "data_confirm",
         type: "POST",
         async: false,
         data: JSON.stringify(obj),
         contentType: "application/json",
         dataType: "json",
         success: function(data){
        	 success_data = data.name;
         },
         error: function(){
             alert("communication-err");
         }
     });
     return success_data;
 }
 
 //modal
const closeBtn = document.getElementById('modal_close');
const modal = document.querySelector('.modal');
const overlay = document.querySelector('.modal__overlay');
const openModal = function(){
  modal.classList.remove('hidden');
}
const closeModal = function(){
  modal.classList.add('hidden');
} 
closeBtn.addEventListener('click', closeModal);
overlay.addEventListener('click', closeModal);
 </script>
</body>
</html>