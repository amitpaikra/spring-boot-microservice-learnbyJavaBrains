package project.amit.moviecatalogservice.models;

public class Rating {
	private String movieId;
	private int rating;
	
	public Rating(){}
	
	public Rating(String movieId, int name) {
		super();
		this.movieId = movieId;
		this.rating = name;
	}
	
	
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int name) {
		this.rating = name;
	}
	
}
