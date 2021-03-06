<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- 대입문,제어문 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><!-- 서식지정 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%><!-- 함수 -->
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>회원가입</title>
        <!-- Bootstrap core CSS , js -->
        <link type="text/css" href="/css/bootstrap.min.css" rel="stylesheet"> 
        <script type="text/javascript" src="/js/bootstrap.js"></script>
        
        <!-- Custom styles for this template -->
        <link type="text/css" href="/css/navbar.css" rel="stylesheet"> 
        <link type="text/css" href="/css/login.css" rel="stylesheet" />
    </head>
    
<body>
	
    <!--상단 https://bootswatch.com/sketchy/-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <jsp:include page="/WEB-INF/views/common/nav.jsp" flush="false"/>
</nav>
<!-- //상단 -->

<div class="IdinputAndPwinputbox" style="margin-top:1rem;">
	<h1 style="color:#3459e6; font-weight:bold;">LOGIN</h1>
	<hr class="one">
	
	
	<form action="/login-process" method="post" onsubmit="return id_pw_Check();">
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
		        	<input class="form-check-input" name="_spring_security_remember_me" type="checkbox" id="remember_me"><!-- <input class="form-check-input" type="checkbox" name="checkbox" id="flexCheckChecked"> -->
		        	<label class="form-check-label" for="flexCheckChecked">자동로그인</label>
		    	</div>
		    </div>
		 </div>
     	<div class="d-grid gap-2 Btnoption1">
  			<button class="btn btn-lg btn-primary" type="submit">로그인</button>
  			<button class="btn btn-lg btn-primary" type="button" onclick="location.href='/signin'">회원가입</button>
		</div>
	</form>
	
</div>

<script type="text/javascript" src="/js/login.js"></script>
 <script type="text/javascript" src="/js/common.js"></script>
<script>
	window.onload = function(){
		var success='${success}';
		if(success=="no"){
			alert("아이디 또는 비밀번호가 옳바르지 않습니다.");
		}
		
		var userid='${userid}';
		if(userid.trim().length!=0){
			document.getElementsByName('id')[0].value=userid;
		}
	}
</script>


</body>
</html>