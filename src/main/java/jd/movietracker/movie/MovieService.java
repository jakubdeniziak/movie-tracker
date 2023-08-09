package jd.movietracker.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Service
public class MovieService {
    @Autowired
    @Qualifier("JdbcMovieRepository")
    private MovieRepository repository;

    public List<Movie> getAll() {
        return repository.getAll();
    }

    public void insertNew(Movie movie) {
        if(movie.getId() == null) {
            movie.setId(UUID.randomUUID());
        }
        repository.insert(movie);
    }

    public List<Movie> getFeaturedToday() {
        int numberOfFeaturedMovies = 2;
        long seed = getSeedBasedOnTodayDate();
        return repository.getRandomMovies(seed, numberOfFeaturedMovies);
    }

    private long getSeedBasedOnTodayDate() {
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);
        return today.getTimeInMillis();
    }
}
