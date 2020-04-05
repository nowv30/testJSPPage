
	
function checkForm(){
	    // 아이디 입력 유무 체크
	
		var aId = document.getElementById("aId");		
	    if(aId.value == '' || !(aId.value.length >= 3 && aId.value.length <= 12)) {
	    	alert("아이디를3자 이상~12자 이하로 입력하세요");
	    	aId.focus();
	        return false; // 아이디 입력이 안되어 있다면 submint 이벤트를 중지
	    }
	    var aPw = document.getElementById('aPw');
	    // 암호 입력 유무 체크
	    if(aPw.value == ''|| !(aPw.value.length >= 3 && aPw.value.length <= 12)){
	        alert('패스워드를3자 이상~12자 이하로 입력하세요');
	        aId.focus();
	        return false;
	    }
	   
}
