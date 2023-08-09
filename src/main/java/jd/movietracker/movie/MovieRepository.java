package jd.movietracker.movie;

import java.util.List;
import java.util.UUID;

public interface MovieRepository {
    int insert(Movie movie);
    int delete(String id);
    List<Movie> getAll();
    Movie getById(String id);
    List<Movie> getRandomMovies(long seed, int amount);
}
