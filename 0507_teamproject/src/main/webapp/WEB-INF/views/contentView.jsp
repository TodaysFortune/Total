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
        <link type="text/css" href="../css/bootstrap.min.css" rel="stylesheet"> 
        <script type="text/javascript" src="../js/bootstrap.js"></script>
        
        <!-- Custom styles for this template -->
        <link type="text/css" href="../css/navbar.css" rel="stylesheet"> 
        <link type="text/css" href="../css/boardContentView.css" rel="stylesheet"> 
    </head>
    
<body>
	
    <!--상단 https://bootswatch.com/sketchy/-->
   <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="../..">Navbar</a>
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
            <a class="dropdown-item" href="../itboard">It 시사</a>
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
      <form method="get" action="main/login" id="userLogin">
      	<button type="submit" class="btn me-sm-1 rounded-pill btn-info">Login</button>
      </form>
      <form method="get" action="main/signin" id="userSign">
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
	        img.src = "../images/userlogin.png"; 
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
 	 		logoutForm.setAttribute('action','../logout');
 	 		logoutForm.append(logoutButton);
 	 		
 	 		document.getElementById('greet').setAttribute('style','margin-right:10px; font-size:0.5em');

 		}
 	})(2);
     </script>
     
     
    </div>
  </div>
</nav>
    <!--//상단 -->
	<!-- 중단 -->
	<div class="container-column-align" style="height: auto; margin-top: 3px;">
        <div class="container-column" style="width: 80vw; min-width: 259.2px;">
            <div style="font-size:1.5rem;">IT 게시판</div>
            <div><hr/></div>
            <div class="relative-left">
                <span>제목입니다</span>
            </div>
            <div style="display:flex; justify-content: space-between;">
                <div class="relative-left">
                    <span>닉네임</span>&nbsp;<span>|</span>&nbsp;<span>날짜</span>
                </div>
                <div class="relative-right">
                    <span>조회수 130</span>&nbsp;<span>|</span>&nbsp;<span>추천 </span><span style="color: red;">2</span>
                </div>
            </div>
            <div><hr/></div>
            <!-- contents -->
            <div style="min-height: 6rem;">
                <div style="float:right;" class="relative-right">
                    <span>수정</span>&nbsp;<span>|</span>&nbsp;<span>삭제</span>
                </div>
                <textarea onkeydown="resize(this)" onkeyup="resize(this)" readonly
                    style="min-height: 10rem; width:95%; outline: none;
                    border:0; resize: none;" class="relative-left"></textarea>
            </div>
            <!-- //contents -->
            <div style="display:flex; justify-content: space-between;">
	            <div class="relative-left">
	                <span>전체 댓글</span><span style="color:red;"> 3 </span><span>개</span>
	            </div>
	            <div class="relative-right">
	                <img id="good-id4label" alt="좋아요" src="../images/good.png" style="width:1rem; height:1rem;"/>&nbsp;
	                <label for="good-id4label" id="good_label">0</label>
	            </div>
            </div>
            <div>
                <!-- 덧글 한 묶음-->
                <div style="width:100%;">
                    <hr/>
                    <div style="display:flex; justify-content: space-between;">
                        <div style="width:80%;" class="relative-left">
                            <div style="display:flex;">
                                <div style="width:10%;">추이</div>
                                <div style="width:90%;">방가</div>
                            </div>
                        </div>
                        <div style="width:15%;">
                            <span>2021.05.10 18:16:18</span>
                            <input type="submit"  value="X"/>
                        </div>
                    </div>
                </div>
                <!-- //덧글 한 묶음-->
            </div>
            <div><hr/></div>
            <div>
                <!--덧글작성-->
                <textarea  onkeydown="resize(this)" onkeyup="fn_checkByte(this,300)" placeholder="내용을 입력해주세요"
                    style="width: 100%; min-height: 3rem; max-height: 9rem; resize: none;"
                ></textarea>
                <!--//덧글작성-->
            </div>
            <div>
                <div style="display: flex; justify-content: space-between;">
                    <div style="font-size: 0.8rem;" class="relative-left">
                        <div id="commentByte">
                            <div>
                                <span>Totalbyte</span>
                            </div>
                            <div>
                                <span>(</span><span id="nowByte">0</span><span>/</span><span>300</span><span>)</span>
                            </div>
                        </div>
                    </div>
                    <div style="width:50%; display: flex; justify-content: flex-end;">
                        <input class="BlackWhite"style="width:24%; height:6vh; font-size:1rem;" type="button" value="댓글등록" onclick="location.href='insert'"/>
                        <input class="GrayWhite"style="margin-left:7px; width:24%; height:6vh; font-size:1rem;" type="button" value="게시글답변" onclick="location.href='insert'"/>
                        <input class="BlackWhite"style="margin-left:7px; width:24%; height:6vh; font-size:1rem;" type="button" value="돌아가기" onclick="location.href='insert'"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 중단 끝 -->
    <script>
        function resize(obj) {
            obj.style.height = "1px";
            obj.style.height = (12+obj.scrollHeight)+"px";
        }
        function fn_checkByte(obj,maxByte){ //maxByte:최대바이트
                obj.style.height = "1px";
                obj.style.height = (12+obj.scrollHeight)+"px";//resize

                const text_val = obj.value; //입력한 문자
                const text_len = text_val.length; //입력한 문자수
                var cropped_text="";
                var texting_len=0;//글자단위(모든문자,한글포함)

                let totalByte=0;
                for(let i=0; i<text_len; i++){
                    const each_char = text_val.charAt(i);//한 글자
                    const uni_char = escape(each_char) //유니코드 형식으로 변환
                    if(uni_char.length>4){
                        // 한글 : 2Byte
                        totalByte += 2;
                    }else{
                        // 영문,숫자,특수문자 : 1Byte
                        totalByte += 1;
                    }
                    if(totalByte <=maxByte){//return할 문자열 갯수
                        texting_len=i+1;
                    }
                }
                
                if(totalByte>maxByte){
                    alert("최대 "+maxByte+"Byte까지만 입력가능합니다.");
                    document.getElementById("nowByte").innerText = totalByte;
                    document.getElementById("nowByte").style.color = "red";

                    cropped_text =text_val.substr(0,texting_len);//오바된만큼 자르기
                    obj.value=cropped_text;
                    fn_checkByte(obj,maxByte);
                }else{
                    document.getElementById("nowByte").innerText = totalByte;
                    document.getElementById("nowByte").style.color = "green";
                }

            }
    </script>
    <script type="text/javascript" src="../js/board.js"></script>
</body>
</html>