package project.amit.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import project.amit.moviecatalogservice.models.CatalogItem;
import project.amit.moviecatalogservice.models.Movie;
import project.amit.moviecatalogservice.models.Rating;
import project.amit.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
//		RestTemplate restTemplate = new RestTemplate();
		
		//get all rated movie IDs
		
		
		UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/" + userId, UserRating.class );
		
		//For each movie ID, call movie info service and get details
		return ratings.getUserRating().stream()
		.map(rating->{
			//for each movie Id, call movie info service and get details
			Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getName(), "Test", rating.getRating() ) ;} )
		.collect(Collectors.toList()) ;
		//put them all together
		
		
		
//		return Collections.singletonList(new CatalogItem("Transformer", "Test", 4));
	}
	
}
//		    Movie movie =	webClientBuilder.build()
//				.get()//GET POST
//				.uri("http://localhost:8082/movies/" + rating.getMovieId())
//				.retrieve()
//				.bodyToMono(Movie.class)
//				.block();//this tell until mono is finished

