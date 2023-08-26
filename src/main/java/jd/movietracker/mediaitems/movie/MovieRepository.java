package jd.movietracker.mediaitems.movie;

import java.util.List;
import java.util.UUID;

public interface MovieRepository {
    int insert(Movie movie);
    int delete(String id);
    int update(String id, Movie updatedMovie);
    List<Movie> getAll();
    Movie getById(String id);
    List<Movie> getRandomMovies(long seed, int amount);
}
