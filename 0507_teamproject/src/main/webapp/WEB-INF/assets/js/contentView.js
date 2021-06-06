function goodup(Session_userID,bidx_){
	var form={
			bidx: bidx_,
			id: Session_userID
	}
	if(Session_userID.length!=0){
		//로그인중임
		$.ajax({
			url: "asyncGood",
			type: "POST",
			data: JSON.stringify(form),
			contentType: "application/json",
			dataType: "json",
			success: function(data){
				if(data.clicked==0){
					$('#heartbeat').attr('src','../images/empty_heart.png');
				}else{
					$('#heartbeat').attr('src','../images/full_heart.png');
				}
				$('#good_label').text(data.goodCount);
			},
			error: function(){
				alert("asyncGood err");
			}
		});
	}
	else{
		alert("로그인을 해주세요.");
	}
}
function idmatching(obj,userID){
	var itemOwner=obj.firstElementChild.value;
	console.log(userID);
	console.log(itemOwner);
	if(userID==itemOwner){
		return true;
	}
	else{
		alert('게시글 작성자만이 이용할 수 있습니다!');
		return false;
	}
}
function replyComment(obj,userID){
	if (loginCheck(userID)==false ){
		return false;
	}else{
		obj.parentElement.nextElementSibling.classList.toggle("display_visible");
	}
}
function emptyTextCheck(obj){
	//var content=obj.firstElementChild;
	var content;
	var contentList=obj.children;
	for(var i=0;i<contentList.length;i++){
		if(contentList[i].getAttribute('name')=='content'){
			content=contentList[i];
			break;
		}
	}
	
	if(content.value.trim().length==0){
		alert('내용을 입력해주세요.');
		content.focus();
		return false;
	}
}    