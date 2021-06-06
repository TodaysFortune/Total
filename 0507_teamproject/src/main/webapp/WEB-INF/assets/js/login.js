function id_pw_Check(){
	var id=document.getElementsByName('id')[0].value.trim();
	var password=document.getElementsByName('password')[0].value.trim();
	if( ! (id.length && password.length) ){ //id or pw 입력 안할경우
		alert("아이디 또는 비밀번호를 입력해주세요.");
		if(id.length==0)
			document.getElementsByName('id')[0].focus();
		else
			document.getElementsByName('password')[0].focus();
		return false;
	}
}