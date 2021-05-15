<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- 대입문,제어문 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><!-- 서식지정 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%><!-- 함수 -->
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="#"> <!-- favicon -->
<meta charset="UTF-8">
<title>Insert title here</title>

<link type="text/css" href="css/modal.css" rel="stylesheet"> 

</head>
<body>
	<form action="/teamproject" method="post" onsubmit="return func();">
		<input type="text" style="border:1px solid red;"  name="text"/>
		<input type="submit" value="버튼"/>
	</form>
	
	
	<!-- modal -->
	<div class="custom_modal custom_hidden">
		<div class="custom_md_overlay"></div>
		<div class="custom_md_content">
			<h1 class="custom_h1">샘플 모달창</h1>
			<div class="custom_modal_text">
				자바스크립트로 모달창을 만들어 봤습니다. 
			</div>
			<button class="custom_button">X</button>
		</div>
	</div>
	<!-- //modal -->
	
	<!-- script -->
	<script>
	window.onload = function(){
		//필요한 엘리먼트들을 선택한다.
		var openButton = document.getElementById("open");
		var modal = document.querySelector(".custom_modal");
		var overlay = modal.querySelector(".custom_md_overlay");
		var closeButton = modal.querySelector("button");
			
		//함수정의
		function closeModal(){
			modal.classList.add("custom_hidden");
		}
		//클릭 이벤트
		closeButton.addEventListener("click", closeModal);
	}
	
	function func(){
		var text=document.getElementsByName('text')[0].value.trim();
		console.log(text);
		if(text=='1'){
			//조건없이 수행
			alert("아이디 비밀번호가 정확하지 않습니다.");
			//modal.classList.remove("custom_hidden");
			return false;
		}
		alert("야호");
	}
</script>
	<!-- //script -->

	
	
	
</body>
</html>