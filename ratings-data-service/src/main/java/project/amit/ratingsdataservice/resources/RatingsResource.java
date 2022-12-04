package project.amit.ratingsdataservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.amit.ratingsdataservice.models.Rating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {
	
	@RequestMapping("/{ratingId}")
	public Rating getRating(@PathVariable("ratingId") String ratingId) {
		return new Rating("mvoi id", "4");
	}

}
