function loginCheck(userID){
	if(userID.trim().length==0){
		alert("로그인을 먼저 해주세요.");
		return false;
	}else{
		return true;
	}
}
function emptySubjectContentCheck(){
	var subject=document.getElementsByName('subject')[0];
	var content=document.getElementsByName('content')[0];
	if(subject.value.trim().length==0 || content.value.trim().length==0){
		alert('제목 혹은 내용을 입력해주세요.');
		return false;
	}
}   