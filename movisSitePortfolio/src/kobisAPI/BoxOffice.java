package kobisAPI;

public class BoxOffice {
	 private BoxOfficeResult boxOfficeResult;
	 private DailyBoxOfficeList dailyBoxOfficeList;
	 
	    public BoxOfficeResult getBoxOfficeResult ()
	    {
	        return boxOfficeResult;
	    }

	    public void setBoxOfficeResult (BoxOfficeResult boxOfficeResult)
	    {
	        this.boxOfficeResult = boxOfficeResult;
	    }

	    public DailyBoxOfficeList getdailyBoxOfficeList() {
	    	return dailyBoxOfficeList;
	    }
	    
	    public void setDailyBoxOfficeList(DailyBoxOfficeList dailyBoxOfficeList) {
	    	this.dailyBoxOfficeList = dailyBoxOfficeList;
	    }
	    
	    @Override
	    public String toString()
	    {
	        return "[boxOfficeResult = "+boxOfficeResult+"]";
	    	
	    }
}
