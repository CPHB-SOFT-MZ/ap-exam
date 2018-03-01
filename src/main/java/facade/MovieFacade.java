package facade;

import model.Movie;

import java.util.List;

public interface MovieFacade {
    /**
     * Return the calculated average rating for a movie
     * @param movie
     * @return
     */
    Double averageRating(Movie movie);

    /**
     * Return the longest movie with a rating above the minimum rating
     * @param movies
     * @return
     */
    Movie longestMovieWithHighRating(Double minimumRating, List<Movie> movies);

    /**
     * Return the shortest movie with a rating below the maximum rating
     * @param movies
     * @return
     */
    Movie shortestMovieWithLowRating(Double maximumRating, List<Movie> movies);

    /**
     * Return a list containing N movies with the highest ratings
     * @param N
     * @param movies
     * @return
     */
    List<Movie> topRatedMovies(int N, List<Movie> movies);

    /**
     * Return a sorted list of movies with the longest duration first and the rest descending
     * @param movies
     * @return
     */
    List<Movie> sortByTimeDescending(List<Movie> movies);

    /**
     * Find the average rating of the upper half movies and lower half of a list
     * (assume it's already sorted by rating: highest to lowest) and return the difference
     * @param movies
     * @return
     */
    Double ratingDifference(List<Movie> movies);

    /**
     * Return a list with all movies between the two given ratings
     * @param lowerRating
     * @param higherRating
     * @return
     */
    List<Movie> moviesBetweenRatings(Double lowerRating, Double higherRating, List<Movie> movies);

    /**
     * Change all the comments of ratings.
     * If the rating is divisible by 3 change the comment to "Divisble by 3"
     * If it's divisible by 5, change the comment to "Divisble by 5"
     * If it's divisible by 5 and 3, change the comment to "Divisble by 3 and 5"
     * @param movie
     * @return
     */
    Movie fbRatings(Movie movie);

    /**
     * Return a movie with the given title. Assume there is no duplicates of titles.
     * @param title
     * @return
     */
    Movie searchByTitle(String title, List<Movie> movies);

    /**
     * Return a list of movies where the title contains one or more of the provided keywords
     * @param keywords
     * @param movies
     * @return
     */
    List<Movie> findByKeywords(String[] keywords, List<Movie> movies);
}
