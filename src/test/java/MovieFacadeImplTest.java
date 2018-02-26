import facade.MovieFacade;
import facade.MovieFacadeImpl;
import model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class MovieFacadeImplTest {

    MovieFacade movieFacade;
    List<Movie> movies;

    @BeforeEach
    void beforeEach() {
        movieFacade = new MovieFacadeImpl();
        movies = new ArrayList<>();

        String[] words = new String[]
        for(int i = 0; i < 1000; i++) {
            Movie movie = new Movie();
            long duration = ThreadLocalRandom.current().nextLong(1, 18001);
            movie.setDuration(Duration.ofSeconds(duration));
            movie.setTitle();
        }
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