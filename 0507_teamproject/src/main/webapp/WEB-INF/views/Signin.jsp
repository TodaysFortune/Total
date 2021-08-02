<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>회원가입</title>
        <!-- Bootstrap or etc core CSS , js -->
        <link type="text/css" href="/css/bootstrap.min.css" rel="stylesheet"> 
        <script type="text/javascript" src="/js/bootstrap.js"></script>
       	<script type="text/javascript" src="/js/jquery-3.6.0.min.js"></script>
        
        <!-- Custom styles for this template -->
        <link type="text/css" href="/css/navbar.css" rel="stylesheet">
        <link type="text/css" href="/css/board.css" rel="stylesheet" />
        <link type="text/css" href="/css/modal.css" rel="stylesheet" />
    </head>
    
<body>
 <!--상단 https://bootswatch.com/sketchy/-->
 <nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <jsp:include page="/WEB-INF/views/common/nav.jsp" flush="false"/>
</nav>

<!-- //상단 -->
<!-- 중단 -->
  <div class="container-column-align" style="height: 100%; margin-top: 1rem;">
        <form id="login" action="/signin" method="post" class="container-column border-blue" onsubmit="return completedCheck();"
         style="width: 70vw; min-width: 259.2px;">
            <div style="font: normal normal bold 1.5rem arial;">회원가입</div>
            <div><hr/></div>
            <div style="display:flex; justify-content: flex-start;"
            	class="form-floating mb-3">																		<!--ID-->
                <input type="text" style="min-width: 20rem;"
                class="form-control empty_confirm_Check" name="id" id="Input_id" placeholder=" "/>
                <label for="Input_id" class="signin-font-color">아이디</label>
                <input type="button" class="btn btn-lg btn-primary ms-3" value="중복확인" onclick="Isunique('id')"/>
                <div id="id_guide" class="text_guide_hidden"></div>
            </div>
            <div class="form-floating mb-3">								    								<!--password-->
                <input type="password" style="min-width:20rem;"
                	class="form-control empty_confirm_Check" 
                	id="Input_pw" placeholder=" " onkeydown="IsSamePassword()" onkeyup="IsSamePassword()"/>
                <label for="Input_pw" class="signin-font-color">비밀번호</label>
            </div>
            <div style="display:flex; justify-content: flex-start;"
            	class="form-floating mb-3">																		<!--re-password-->
                <input type="password" style="min-width:20rem;"
                	class="form-control empty_confirm_Check"  
                	name="password" id="Input_re_pw" placeholder=" " onkeydown="IsSamePassword()" onkeyup="IsSamePassword()"/>
                <label for="Input_re_pw" class="signin-font-color">비밀번호 확인</label>
                <div id="password_guide" class="text_guide_hidden"></div>
            </div>
            <div style="display:flex; justify-content: flex-start;"
            	class="form-floating mb-3">																		<!-- nick-name -->
                <input type="text" style="min-width:20rem;"
                	class="form-control empty_confirm_Check" name="name" id="Input_name" placeholder=" "/>
                <label for="Input_name" class="signin-font-color">이름</label>
                <input type="button" class="btn btn-lg btn-primary ms-3" value="중복확인" onclick="Isunique('name')"/>
                <div id="name_guide" class="text_guide_hidden"></div>
            </div>
            <div style="display:flex; justify-content: flex-start;"
            	class="form-floating mb-3">																		<!-- email -->
                <input type="email" style="min-width:20rem;"
                	class="form-control empty_confirm_Check" name="email" id="Input_email" placeholder=" "/>
                <label for="Input_email" class="signin-font-color">이메일</label>
                <input type="button" class="btn btn-lg btn-primary ms-3" value="인증" id="AuthButton" onclick="createemailAuthKey()"/>
                <div id="email_guide" class="text_guide_hidden"></div>
            </div>
            <div class="form-floating mb-3">																	<!-- phone -->
                <input type="tel" style="min-width:20rem;"
                	class="form-control empty_confirm_Check" name="phone" id="Input_phone" placeholder=" "/>
                <label for="Input_phone" class="signin-font-color"  pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" required>휴대전화 010-1234-6867</label>
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
      <button class="modal-button" id="modal_close">OK</button>
    </div>
  </div>
  
  <div class="email_modal hidden">
    <div class="email_modal__overlay"></div> 
    <div class="email_modal__content">
      <div class="email_modal_text_parent">
      	<div class="email_modal_text">만료시간 </div><div style="color:red; margin-left:1rem;" id="email_time">03:00</div>
      </div>
      	<input id="email_modal_keyText" type="text" placeholder="인증번호 8자리를 입력해주세요"/>
      <div class="email_modal_buttons_parent">
	      <button class="email_modal_button email_modal_button_ok" id="email_modal_ok" onclick="emailAuth('email')">확인</button>
	      <button class="email_modal_button email_modal_button_cancel" id="email_modal_close">취소</button>
      </div>
    </div>
  </div>
	<!-- //modal -->
   <div style="height:30px;">
   &nbsp;
   </div>
 <!-- //중단 -->
 <script type="text/javascript" src="/js/signin.js"></script>
  <script type="text/javascript" src="/js/common.js"></script>
</body>
</html>