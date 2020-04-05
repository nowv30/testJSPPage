package kobisAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;




public class JsonToObject {
	
	public JsonToObject() {
		
	}
	
	public String getYesterday() {
		//일일박스오피스 선정 날짜 구하기(어제날짜)
		Calendar calendar = new GregorianCalendar();
		calendar.add(Calendar.DATE, -1); // 오늘날짜로부터 -1
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); // 날짜 포맷 
		String yesterday = sdf.format(calendar.getTime()); // String으로 저장
		
		return yesterday;
	}
		//uri: 통합 자원 식별자(identifier), 인터넷 상의 자원을 식별하기 위한 문자열
		//url: 통합 자원 위치, 네트워크 상에서 자원이 어디있는지 알려주기 위한 규약. 인터넷상의 자원 위치
	/*
	 * http://tstory.com = 이 주소는 http://tstory.com라는 서버를 나타내기 때문에 url이면서 uri
	 * http://tstory.com/skin =서버는 http://tstory.com, skin은 인터넷상의 자원 위치, uri이면서 url
	 * http://tstory.com/?q=uri = q=uri는 식별자(identifier), 주소는 uri이지만 url은 아니게 된다.
	 * 
	 * 식별자에 적힌 값은 파일로 존재하지 않기 때문에 url은 아니다. 하지만 위 주소가 html 파일을 가리키기 때문에 uri가 된다.
	 * */
	public ArrayList<DailyBoxOfficeList> parsingObject(String yesterday) {
		
		ArrayList<DailyBoxOfficeList> dlists= new ArrayList<DailyBoxOfficeList>();
		String uriStr = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json"
				+ "?key=b528a0481070181cd539d38954517c81&itemPerPage=10&targetDt=";

		BoxOffice boxOffice = null;
		BufferedReader br = null;
		
		//박스오피스 api 실행, json 값 받아오기
		try {
			URL url = new URL(uriStr+yesterday);
			HttpURLConnection urlconnection =(HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			
			
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"utf-8"));
			String result="";
			String line;
			while((line = br.readLine())!= null) {
				result +=line+"\n";
			}
			
			//json값 파싱하여 javaObject로 저장하기
			ObjectMapper  mapper = new ObjectMapper();
			
			boxOffice =mapper.readValue(result, BoxOffice.class);
			DailyBoxOfficeList[] list = boxOffice.getBoxOfficeResult().getDailyBoxOfficeList();
		
	
			for(DailyBoxOfficeList dlist : list) {
//			  System.out.println(dailyBoxOfficeList);
				
				String movieNm = dlist.getMovieNm();//영화이름
				String openDt = dlist.getOpenDt();//개봉일
				String movieCd = dlist.getMovieCd();//영화코드
				String rank = dlist.getRank();//영화순위
				String salesAmt = dlist.getSalesAmt();//당일매출
				String salesAcc = dlist.getSalesAcc();//누적매출
				String audiAcc = dlist.getAudiAcc();//누적관객
				
				dlist = new DailyBoxOfficeList(salesAcc, movieNm, salesAmt, movieCd, rank, openDt, audiAcc);			
				dlists.add(dlist);
			
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dlists;
		
		
	}

	
}

