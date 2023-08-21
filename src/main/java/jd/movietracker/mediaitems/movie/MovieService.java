package jd.movietracker.mediaitems.movie;

import jd.movietracker.seedproviders.DailySeedProvider;
import jd.movietracker.seedproviders.SeedProvider;
import jd.movietracker.responseparser.BasicResponseParser;
import jd.movietracker.responseparser.ResponseParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MovieService {
    private final SeedProvider seedProvider = new DailySeedProvider();
    @Autowired
    @Qualifier("JdbcMovieRepository")
    private MovieRepository repository;

    public List<Movie> getAll() {
        return repository.getAll();
    }

    public Movie getById(String id) {
        return repository.getById(id);
    }

    public void insertNew(Movie movie) {
        if(movie.getId() == null) {
            movie.setId(UUID.randomUUID());
        }
        repository.insert(movie);
    }

    public void deleteMovies(String request) {
        ResponseParser parser = new BasicResponseParser();
        List<String> moviesToDelete = parser.parseRequestWithCheckboxesWithoutValue(request);
        moviesToDelete.forEach(movieId -> repository.delete(movieId));
    }

    public List<Movie> getFeaturedToday() {
        int numberOfFeaturedMovies = 2;
        return repository.getRandomMovies(seedProvider.getSeed(), numberOfFeaturedMovies);
    }
}
