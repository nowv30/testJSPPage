package kobisAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.fasterxml.jackson.databind.ObjectMapper;





public class JsonToObject2 {
	
	public static void main(String[] args) {
	String urlStr = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json"
			+ "?key=b528a0481070181cd539d38954517c81&itemPerPage=10&targetDt=";
	
	
	BoxOffice boxOffice = null;
	BufferedReader br = null;

	//일일박스오피스 선정 날짜 구하기(어제날짜)
	Calendar calendar = new GregorianCalendar();
	calendar.add(Calendar.DATE, -1); // 오늘날짜로부터 -1
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); // 날짜 포맷 
	String yesterday = sdf.format(calendar.getTime()); // String으로 저장
	
	System.out.println(yesterday);
	//일일박스오피스 선정 날짜 구하기(어제날짜)END
	
	//박스오피스 api 실행, json 값 받아오기
	try {
		URL url = new URL(urlStr+yesterday);
		HttpURLConnection urlconnection =(HttpURLConnection) url.openConnection();
		urlconnection.setRequestMethod("GET");
		
		
		br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"utf-8"));
		String result="";
		String line;
		while((line = br.readLine())!= null) {
			result +=line+"\n";
		}
		
		//json값 파싱하여 javaObject로 저장하기
		ObjectMapper mapper = new ObjectMapper();
		
		boxOffice =mapper.readValue(result, BoxOffice.class);
		DailyBoxOfficeList[] list = boxOffice.getBoxOfficeResult().getDailyBoxOfficeList();
		System.out.println(list[0]);
		  for(DailyBoxOfficeList dailyBoxOfficeList : list) {
//			  System.out.println(dailyBoxOfficeList);
			  System.out.println("영화재목 :"+dailyBoxOfficeList.getMovieNm());
			  System.out.println("상영일자 :"+dailyBoxOfficeList.getOpenDt());
			  System.out.println("영화코드 :"+dailyBoxOfficeList.getMovieCd());			  
			 
		  }
	//박스오피스 api 실행, json 값 받아오기END	  	  
		  
 
		  

	 
	} catch (Exception e) {
		System.out.println(e);
	}

	}
}

