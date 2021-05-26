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
    function fn_checkByte_subject(obj,maxByte){ //maxByte:최대바이트
        const text_val = obj.value; //입력한 문자
        const text_len = text_val.length; //입력한 문자수
        var cropped_text="";
        var texting_len=0;//글자단위(모든문자,한글포함)

        let totalByte=0;
        for(let i=0; i<text_len; i++){
            const each_char = text_val.charAt(i);//한 글자
            const uni_char = escape(each_char) //유니코드 형식으로 변환
            if(uni_char.length>4){
                totalByte += 2;
            }else{
                totalByte += 1;
            }
            if(totalByte <=maxByte){//return할 문자열 갯수
                texting_len=i+1;
            }
        }
        if(totalByte>maxByte){
            alert("최대 "+maxByte+"Byte까지만 입력가능합니다.");
            cropped_text =text_val.substr(0,texting_len);//오바된만큼 자르기
            obj.value=cropped_text;
            fn_checkByte_subject(obj,maxByte);
        }
    }