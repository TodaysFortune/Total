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

<!-- js,css path set -->
<link type="text/css" href="css/modal.css" rel="stylesheet"> 
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>

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
</script>
<!-- //script -->


</head>
<body>
	
	<!-- modal -->
	<div class="custom_modal custom_hidden" style="display:none;">
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
	
	<!-- fetch process -->
	<div>
		<input type="text" id="ajaxText" placeholder="넘겨주는 데이터가 1이라면 10을 가져오고 ,그외에는 100을 가져옵니다. "/>
		<button type="button" onclick="ajaxTest()">버튼</button>
		<button type="button" onclick="ajaxTest2()">버튼</button>
	</div>
	
	
	
<!-- script -->
<script>
// 일반 텍스트 데이터  주도받는 함수
function ajaxTest(){
        var form = {
                name: "jamong",
                age: 23
        }
        $.ajax({
            url: "requestObject",
            type: "POST",
            data: form,
            success: function(data){
                $('#ajaxText').val(data);
            },
            error: function(){
                alert("simpleWithObject err");
            }
        });
} 
/*
 
 */
//JSON 데이터  주도받는 함수
function ajaxTest2(){
	        var formarian = {
	                name: "jamong",
	                age: 100
	        }
	        $.ajax({
	            url: "stringify",
	            type: "POST",
	            data: JSON.stringify(formarian),
	            contentType: "application/json",
	            dataType: "json",
	            success: function(data){
	                var txt = data.name + data.age;
	                $('#ajaxText').val(txt);
	            },
	            error: function(){
	                alert("stringify err");
	            }
	        });
} 	
	
	
</script>
	<!-- //script -->
</body>
</html>