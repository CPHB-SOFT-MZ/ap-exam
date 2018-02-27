import facade.MovieFacade;
import facade.MovieFacadeImpl;
import model.Movie;
import model.Rating;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
        Movie result = assertTimeout(Duration.ofMillis(10), () -> movieFacade.longestMovieWithHighRating(60.0, movies));

        assertAll("60.0 as minimum rating",
                () -> {
                    assertNotNull(result);

                    assertAll("Value check", () -> {
                        assertEquals(Duration.ofSeconds(16491), result.getDuration());
                        assertEquals("ad consectetur adipisicing", result.getTitle());
                        assertEquals(7, result.getRatings().size());
                    });
                }

        );

        Movie result2 = assertTimeout(Duration.ofMillis(10), () -> movieFacade.longestMovieWithHighRating(55.0, movies));

        assertAll("55.0 as minimum rating",
            () -> {
                assertNotNull(result2);

                assertAll("Value check", () -> {
                    assertNotEquals(Duration.ofSeconds(16491), result2.getDuration());
                    assertNotEquals(result2, result);
                    assertEquals(12, result2.getRatings().size());
                    assertEquals("ea officia nostrud", result2.getTitle());
                    assertEquals(17856, result2.getDuration().getSeconds());
                });
            }
        );


        Movie result3 = assertTimeout(Duration.ofMillis(5), () -> movieFacade.longestMovieWithHighRating(100.0, movies));
        assertNull(result3);

        Movie result4 = assertTimeout(Duration.ofMillis(10), () -> movieFacade.longestMovieWithHighRating(0.0, movies));
        assertNotNull(result4);
    }

    @Test
    void shortestMovieWithLowRating() {
    }

    @Test
    void topRatedMovies() {
    }

    @Test
    void sortByTimeDescending() {
        List<Movie> sorted = assertTimeout(Duration.ofMillis(50), () -> movieFacade.sortByTimeDescending(movies));

        assertAll("Check if not null", () -> {
            assertNotNull(sorted);

            assertAll("Check if elements are not the same",
                () -> {
                    assertNotEquals(movies.get(0), sorted.get(0));
                    assertNotEquals(movies.get(99), sorted.get(99));

                    assertAll("Check if sorted", () -> {
                        for (int i = 0; i < sorted.size() - 2; i++) {
                            assertTrue(sorted.get(i).getDuration().getSeconds() > sorted.get(i+1).getDuration().getSeconds());
                        }
                    });
                }
            );
        });
    }

    @Test
    void ratingDifference() {
    }

    @Test
    void moviesBetweenRatings() {
    }

    @Test
    void fbRatings() {
        String div3 = "Divisble by 3";
        String div5 = "Divisble by 5";
        String div3and5 = "Divisble by 3 and 5";

        assertAll("Check if comments are changed", () -> {
            for (Rating rate : movieFacade.fbRatings(movies.get(99)).getRatings()) {
                if (rate.getRating() % 3 == 0 && rate.getRating() % 5 == 0) {
                    assertEquals(div3and5, rate.getComment());
                } else if (rate.getRating() % 3 == 0) {
                    assertEquals(div3, rate.getComment());
                } else if (rate.getRating() % 5 == 0) {
                    assertEquals(div5, rate.getComment());
                }
            }
        });

    }

    @Test
    void searchByTitle() {
        String title3 = "ut tempor voluptate";
        //String title3 = movies.get(3).getTitle();
        assertEquals(movies.get(3), movieFacade.searchByTitle(title3, movies));

        String title23 = "dolor aliqua reprehenderit";
        //String title23 = movies.get(23).getTitle();
        assertEquals(movies.get(23), movieFacade.searchByTitle(title23, movies));

        String title83 = "do id adipisicing";
        //String title83 = movies.get(83).getTitle();
        assertEquals(movies.get(83), movieFacade.searchByTitle(title83, movies));
    }

    @Test
    void findByKeywords() {
    }

}