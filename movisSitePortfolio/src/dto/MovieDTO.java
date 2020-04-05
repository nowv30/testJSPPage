package dto;

public class MovieDTO {

	private String movieNm;
	private String movieCd;
	private String movieDirector;
	private String movieActors;
	private String movieTime;
	private String movieDescribe;
	private String moviePoster; 
	
	public MovieDTO() {
		
	}

	

	public MovieDTO(String movieNm, String movieTime) {
		super();
		this.movieNm = movieNm;
		
		this.movieTime = movieTime;
	}



	public MovieDTO(String movieNm, String movieCd, String movieDirector, String movieActors, String movieTime,
			String movieDescribe, String moviePoster) {
		super();
		this.movieNm = movieNm;
		this.movieCd = movieCd;
		this.movieDirector = movieDirector;
		this.movieActors = movieActors;
		this.movieTime = movieTime;
		this.movieDescribe = movieDescribe;
		this.moviePoster = moviePoster;
	}

	public String getMovieNm() {
		return movieNm;
	}

	public void setMovieNm(String movieNm) {
		this.movieNm = movieNm;
	}

	public String getMovieCd() {
		return movieCd;
	}

	public void setMovieCd(String movieCd) {
		this.movieCd = movieCd;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public String getMovieActors() {
		return movieActors;
	}

	public void setMovieActors(String movieActors) {
		this.movieActors = movieActors;
	}

	public String getMovieTime() {
		return movieTime;
	}

	public void setMovieTime(String movieTime) {
		this.movieTime = movieTime;
	}

	public String getMovieDescribe() {
		return movieDescribe;
	}

	public void setMovieDescribe(String movieDescribe) {
		this.movieDescribe = movieDescribe;
	}

	public String getMoviePoster() {
		return moviePoster;
	}

	public void setMoviePoster(String moviePoster) {
		this.moviePoster = moviePoster;
	}

	
}
