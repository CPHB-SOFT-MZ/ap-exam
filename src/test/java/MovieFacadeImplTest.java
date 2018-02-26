import facade.MovieFacade;
import facade.MovieFacadeImpl;
import model.Movie;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieFacadeImplTest {

    MovieFacade movieFacade;
    List<Movie> movies;


    @BeforeEach
    void beforeEach() throws IOException {
        movieFacade = new MovieFacadeImpl();
        ObjectMapper mapper = new ObjectMapper();
        movies = mapper.readValue(new File("movies.json"), mapper.getTypeFactory().constructCollectionType(List.class, Movie.class));
    }

    @Test
    void averageRating() {
        
    }

    @Test
    void longestMovieWithHighRating() {
    }

    @Test
    void shortestMovieWithLowRating() {
    }

    @Test
    void topRatedMovies() {
    }

    @Test
    void sortByTimeDescending() {
    }

    @Test
    void ratingDifference() {
    }

    @Test
    void moviesBetweenRatings() {
    }

    @Test
    void fbRatings() {
    }

    @Test
    void searchByTitle() {
    }

    @Test
    void findByKeywords() {
    }

}