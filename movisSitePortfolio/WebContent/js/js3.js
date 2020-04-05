
window.onload = function() {
	
	var screenTime = document.getElementById("screenTime");
	screenTime.addEventListener('change', function(){
		var scr=screenTime.options[screenTime.selectedIndex].value;
		var scrSplit = scr.split(',');
		

		document.getElementsByName("roomNm")[0].value=scrSplit[0];
		document.getElementsByName("screenStart")[0].value=scrSplit[1];
		document.getElementsByName("screenEnd")[0].value=scrSplit[2];
		
	});

	
}

function myFunction(seated){
	document.getElementsByName("seat")[0].value=seated;
}

//function myFunction() {
//	var layer=document.getElementById("layer");
//	layer.style.visibility = "visible";
//	
//	var movieNm = docuemnt.getElementById("movieNm");
//	var theater = docuemnt.getElementById("theater");
//	var reservDay = docuemnt.getElementById("reservDay");
//	
//	movieNm.getAttribute("movieNm");
//	theater.getAttribute("theater");
//	reservDay.getAttribute("reservDay");
//	
//	var screenTime=document.getElementById("screenTime");
//	if(movieNm==screenTime.value){
//		
//	}
//}


//영화를 선택하면 영화의 이름이  선택된다.
//screenDTO에서 영화 이름이 같은 screen테이블이 있다면
//그 스크린 테이블의 영화관, 상영날짜, 









