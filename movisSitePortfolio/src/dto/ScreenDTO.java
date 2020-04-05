package dto;

public class ScreenDTO {
	private String screenCd;
	private String theaterNm;
	private String roomNm;
	private String movieNm;
	private String screenDate;
	private String screenStart;
	private String screenEnd;
	
	public ScreenDTO() {
		
	}
	
	public ScreenDTO(String screenCd, String theaterNm, String roomNm, String movieNm, String screenDate,
			String screenStart, String screenEnd) {
		super();
		this.screenCd = screenCd;
		this.theaterNm = theaterNm;
		this.roomNm = roomNm;
		this.movieNm = movieNm;
		this.screenDate = screenDate;
		this.screenStart = screenStart;
		this.screenEnd = screenEnd;
	}
	
	
	public ScreenDTO(String screenCd, String roomNm, String movieNm, String screenStart, String screenEnd) {
		super();
		this.screenCd = screenCd;
		this.roomNm = roomNm;
		this.movieNm = movieNm;
		this.screenStart = screenStart;
		this.screenEnd = screenEnd;
	}

	public String getScreenCd() {
		return screenCd;
	}
	public void setScreenCd(String screenCd) {
		this.screenCd = screenCd;
	}
	public String getTheaterNm() {
		return theaterNm;
	}
	public void setTheaterNm(String theaterNm) {
		this.theaterNm = theaterNm;
	}
	public String getRoomNm() {
		return roomNm;
	}
	public void setRoomNm(String roomNm) {
		this.roomNm = roomNm;
	}
	public String getMovieNm() {
		return movieNm;
	}
	public void setMovieNm(String movieNm) {
		this.movieNm = movieNm;
	}
	public String getScreenDate() {
		return screenDate;
	}
	public void setScreenDate(String screenDate) {
		this.screenDate = screenDate;
	}
	public String getScreenStart() {
		return screenStart;
	}
	public void setScreenStart(String screenStart) {
		this.screenStart = screenStart;
	}
	public String getScreenEnd() {
		return screenEnd;
	}
	public void setScreenEnd(String screenEnd) {
		this.screenEnd = screenEnd;
	}
	
	
}
