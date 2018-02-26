import facade.MovieFacade;
import facade.MovieFacadeImpl;
import model.Movie;
import model.Rating;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MovieFacadeImplTest {

    private MovieFacade movieFacade;
    private List<Movie> movies;


    @BeforeEach
    void beforeEach() throws IOException {
        movieFacade = new MovieFacadeImpl();
        ObjectMapper mapper = new ObjectMapper();
        movies = mapper.readValue(new File("movies.json"), mapper.getTypeFactory().constructCollectionType(List.class, Movie.class));
    }

    @Test
    void averageRating() {
        Double average35 = 71.5;
        assertEquals(average35, movieFacade.averageRating(movies.get(35)));

        Double average0 = 55.416666666666664;
        assertEquals(average0, movieFacade.averageRating(movies.get(0)));

        Double average37 = 52.0;
        assertEquals(average37, movieFacade.averageRating(movies.get(37)));
    }

    @Test
    void longestMovieWithHighRating() {
        Movie result = movieFacade.longestMovieWithHighRating(60.0, movies);

        assertEquals(Duration.ofSeconds(16491), result.getDuration());
        assertEquals("ad consectetur adipisicing", result.getTitle());
        assertEquals(7, result.getRatings().size());
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