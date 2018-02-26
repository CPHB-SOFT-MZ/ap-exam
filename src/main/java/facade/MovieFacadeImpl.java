package facade;

import model.Movie;

import java.util.List;

public class MovieFacadeImpl implements MovieFacade{

    @Override
    public Double averageRating(Movie movie) {
        return null;
    }

    @Override
    public Movie longestMovieWithHighRating(Double minimumRating, List<Movie> movies) {
        return null;
    }

    @Override
    public Movie shortestMovieWithLowRating(Double maximumRating, List<Movie> movies) {
        return null;
    }

    @Override
    public List<Movie> topRatedMovies(int N, List<Movie> movies) {
        return null;
    }

    @Override
    public List<Movie> sortByTimeDescending(List<Movie> movies) {
        return null;
    }

    @Override
    public Double ratingDifference(List<Movie> movies) {
        return null;
    }

    @Override
    public List<Movie> moviesBetweenRatings(Double lowerRating, Double higherRating) {
        return null;
    }

    @Override
    public Movie fbRatings(Movie movie) {
        return null;
    }

    @Override
    public Movie searchByTitle(String title, List<Movie> movies) {
        return null;
    }

    @Override
    public List<Movie> findByKeywords(String[] keywords, List<Movie> movies) {
        return null;
    }
}
