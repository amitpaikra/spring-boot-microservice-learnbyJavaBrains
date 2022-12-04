package project.amit.ratingsdataservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.amit.ratingsdataservice.models.Rating;
import project.amit.ratingsdataservice.models.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {
	
	@RequestMapping("/{ratingId}")
	public Rating getRating(@PathVariable("ratingId") String ratingId) {
		return new Rating("mvoi id", 4);
	}
	
	@RequestMapping("users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		
		List<Rating> ratings = Arrays.asList(
				new Rating("1234", 4),
				new Rating("5678", 4)
			);
		
		return new UserRating(ratings);
		
		
	}

}
