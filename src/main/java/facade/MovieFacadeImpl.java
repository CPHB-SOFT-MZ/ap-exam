package facade;

import model.Movie;
import model.Rating;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MovieFacadeImpl implements MovieFacade{

    @Override
    public Double averageRating(Movie movie) {
        int total = 0;
        int divisor = 0;
        for (Rating rating : movie.getRatings()) {
            total += rating.getRating();
            divisor++;
        }
        return (total * 1.0) / (divisor * 1.0);
    }

    @Override
    public Movie longestMovieWithHighRating(Double minimumRating, List<Movie> movies) {
        List<Movie> moviesSort = new ArrayList<>();
        for(Movie mov : movies) {
            if (this.averageRating(mov) > minimumRating) {
                moviesSort.add(mov);
            }
        }

        return moviesSort.stream().sorted(Comparator.comparing(Movie::getDuration).reversed()).findFirst().orElse(null);
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
        return movies.stream().sorted(Comparator.comparing(Movie::getDuration).reversed()).collect(Collectors.toList());
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
        for (Movie mov : movies) {
            if (mov.getTitle().equals(title)) {
                return mov;
            }
        }
        return null;
    }

    @Override
    public List<Movie> findByKeywords(String[] keywords, List<Movie> movies) {
        return null;
    }
}
