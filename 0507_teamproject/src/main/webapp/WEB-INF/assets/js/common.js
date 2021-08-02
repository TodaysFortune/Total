function loginCheck(userID){
	if(userID=='anonymousUser'){
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
function dropdown(obj){
	var searchType_view=document.getElementById("searchType_view");
	var searchType=document.getElementById("searchType");
	var type_text=obj.getAttribute('id')
	if(type_text=="all"){
		type_text="전체";
	}else if(type_text=="subject"){
		type_text="제목";
	}else if(type_text=="content"){
		type_text="내용";
	}else{
		type_text="작성자";
	}
	searchType_view.setAttribute('value',type_text);
	searchType.setAttribute('value',obj.getAttribute('id'));
}
function colorizeText(inputText, inputType) {
	/*select specified things*/
	var items;
	if (inputType == "subject") {
		items = document.getElementsByClassName("subject");
	} else if (inputType == "all") {
		items = document.getElementsByClassName("all");
	} else if (inputType == "name") {
		items = document.getElementsByClassName("name");
	} else {
		return;
	}

	for (var i = 0; i < items.length; i++) {
		var item_text = items[i].textContent;
		item_text = item_text.replaceAll(inputText,
				'<span style="background-color:#F4F895;">'
						+ inputText + '</span>');
		items[i].innerHTML = item_text;
	}
}
