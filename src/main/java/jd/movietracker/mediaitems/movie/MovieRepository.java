package jd.movietracker.mediaitems.movie;

import java.util.List;
import java.util.UUID;

public interface MovieRepository {
    void insert(Movie movie);
    void delete(String id);
    void update(String id, Movie updatedMovie);
    List<Movie> getAll();
    Movie getById(String id);
    List<Movie> getRandomMovies(long seed, int amount);
}
