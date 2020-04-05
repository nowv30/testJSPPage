
window.onload = function() {
	
	
	var movieNm = document.getElementById('movieNm');
	movieNm.addEventListener('change', function() {
	
	});
	//영화관선택
	var theater = document.getElementById("theater");
	theater.addEventListener('change', function() {
		
		//날짜선택
		var reservDay = document.getElementById("reservDay");
		reservDay.options.length=1;
		for (i = 0; i < 4; i++) {
			var opt = document.createElement('option');
			var date = new Date();
			var year = date.getFullYear();//현제년도
			var month = date.getMonth() + 1;//현재 달
			var date = date.getDate()+ i;//현재 일+i[0~3까지]
			
			opt.value = year + "-" + month + "-" + date;			
			opt.innerHTML = year + "년" + month + "월" + date + "일";
			reservDay.appendChild(opt);
		}
		
		
		
		reservDay.addEventListener('change',function(){
			
		var room = document.getElementById("room");
		room.options.length=1;
		
		var r = ['r1','r2','r3','r4','r5'];//상영관 value
		var r1 = ['상영관1','상영관2','상영관3'];
		var r2 = ['상영관1','상영관2','상영관3','상영관4'];
		var r3 = ['상영관1','상영관2','상영관3','상영관4','상영관5'];
		var tr = null;
		
		if(theater.value=="t1")
			tr=r1;
		else if(theater.value=="t2")
			tr=r2;
		else if(theater.value=="t3")
			tr=r3;
	
		for(x in tr){
			var opt =document.createElement('option');
			opt.value = r[x];
			opt.innerHTML = tr[x];
			room.appendChild(opt);
		}
		});
	});
}
