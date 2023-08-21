package jd.movietracker.mediaitems.movie;

import java.util.List;

public interface MovieRepository {
    int insert(Movie movie);
    int delete(String id);
    List<Movie> getAll();
    Movie getById(String id);
    List<Movie> getRandomMovies(long seed, int amount);
}
