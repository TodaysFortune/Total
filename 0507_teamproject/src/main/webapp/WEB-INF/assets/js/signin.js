 var timeID=null; 
 let stackedTime=0;

//modal
const closeBtn = document.getElementById('modal_close');
const modal = document.querySelector('.modal');
const overlay = document.querySelector('.modal__overlay');
const email_closeBtn = document.getElementById('email_modal_close');
const email_modal = document.querySelector('.email_modal');
const email_overlay = document.querySelector('.email_modal__overlay');
const openModal = function(){
 modal.classList.remove('hidden');
}
const closeModal = function(){
 modal.classList.add('hidden');
} 
const email_openModal = function(){
	email_modal.classList.remove('hidden');
}
const email_closeModal = function(){
	email_modal.classList.add('hidden');
	timeclear();
	var item=document.getElementById('email_modal_keyText');
	item.value="";
}
closeBtn.addEventListener('click', closeModal);
overlay.addEventListener('click', closeModal);
email_closeBtn.addEventListener('click', email_closeModal);
email_overlay.addEventListener('click', email_closeModal);
 
//completedCheck 클래스를 이용하여서       총 제출전 비어있는지 검사 , text_guide_success가 총 4개 인지 검사(id와name중복확인,인증,비번일치 전부 포함됨)
 function completedCheck(){
	 var classLen=document.getElementsByClassName('text_guide_success').length;
	 if(classLen!=4){
		 alert('정보를 입력해주세요!');
		 return false;
	 }
 }
 //password matching검사 
 function IsSamePassword(){
	var Input_re_pw=document.getElementById('Input_re_pw').value; 
	if(Input_re_pw.trim().length==0){
		return false;
	}
	var Input_pw=document.getElementById('Input_pw').value;
	var password_guide=document.getElementById('password_guide');
	if(Input_pw==Input_re_pw){
		password_guide.textContent='비밀번호가 일치합니다.';
		password_guide.className='text_guide_success';
	}else{
		password_guide.textContent='비밀번호가 일치하지 않습니다';
		password_guide.className='text_guide_fail';
	}
 }
//email 인증 확인
 function emailAuth(obj){
 	var item=document.getElementById('email_modal_keyText');
 	if(item.value.trim().length==0){
 		alert("인증번호를 입력해주세요!");
 		return;
 	}
	var jsonData={
			data4Check: item.value,
			dataType: obj
	 }
	//인증키 비동기로전달
	var signal=ajax_communication(jsonData,'data_confirm');
	email_closeModal();
	if(signal==0){
		alert("인증키가 옳바르지 않습니다!");
	}else if(signal==1){
		AuthButton=document.getElementById('AuthButton');
		Input_email=document.getElementById('Input_email');
		AuthButton.setAttribute('disabled','disabled');
		Input_email.readOnly=true;//readonly 활성화 
		item_guide=document.getElementById('email_guide');
		item_guide.textContent="인증완료";
		item_guide.className='text_guide_success';
	}else{
		alert("시간이 초과되었습니다.");
	}
 } 
 //email 인증키 생성
 function createemailAuthKey(){
 	 var item=document.getElementById("Input_email");
 	 if(item.value.trim().length==0){//email이 비어있으면 경고창후 종료
 		 alert('이메일을 먼저 입력해주세요!');
 	 	 return;
 	 }
 	 var jsonData={
 		 usermail: item.value
 	 }
 	 var signal=ajax_communication(jsonData,'signin/createEmailKey');
 	 if(signal==0){
 		alert('중복된이메일입니다!'); 
 		item.value="";
 		return;
 	 }
 	 PrintTime();
 	 email_openModal();
 	 timeID=setInterval(PrintTime,1000);
  }
//모달창에서 만료시간변경해주기
 PrintTime=function(totalTime=180){
	 email_time=document.getElementById('email_time');
	 currentTime=totalTime-stackedTime;
	 var minute=parseInt(currentTime/60);
	 var second=currentTime%60;
	 email_time.textContent=""+numberPad(minute,2)+":"+numberPad(second,2);
	 if(minute==0 && second==0){
		 timeclear();
		 return;
	 }
	 stackedTime++;
 }
 //숫자앞에 0붙여주는 함수
 function numberPad(n, width) {
	    n = n + '';
	    return n.length >= width ? n : new Array(width - n.length + 1).join('0') + n;
}
function timeclear(){
	clearInterval(timeID);
	 stackedTime=0;
}
//name,id의 unique검사
function Isunique(obj){
	 var modal_item=document.getElementById("modal__text");
	 var modal_button=document.getElementById("modal_close");
	var item=document.getElementById("Input_"+obj);
		if(item.value.trim().length==0){
			alert(obj.toUpperCase()+"를 입력해주세요");
		 	return;
		}
		var jsonData={
			data4Check: item.value,
			dataType: obj
		}
		var signal=ajax_communication(jsonData,'data_confirm');
		if(signal==0){
			modal_item.textContent="이미 존재하는 "+obj+" 입니다.";
			modal_button.setAttribute('style','background-color:#F78B8B;color:black;');
			openModal();
			item_guide=document.getElementById(obj+"_guide");
			item_guide.textContent="중복된 "+obj+"가 있습니다.";
			item_guide.className='text_guide_fail';
		}else{ 
			modal_item.textContent="사용가능한 "+obj+" 입니다.";
			modal_button.setAttribute('style','background-color:#2E9AFE;color:white;');
			openModal();
			item_guide=document.getElementById(obj+"_guide");
			item_guide.textContent="사용가능한 "+obj+" 입니다.";
			item_guide.className='text_guide_success';
		}
}
function ajax_communication(obj,link){
	 var success_data;
    $.ajax({
        url: link,
        type: "POST",
        async:false,
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