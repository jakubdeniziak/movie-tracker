package jd.movietracker.movie;

import java.util.List;
import java.util.UUID;

public interface MovieRepository {
    int insert(Movie movie);
    int delete(UUID id);
    List<Movie> getAll();
    List<Movie> getRandomMovies(long seed, int amount);
}
