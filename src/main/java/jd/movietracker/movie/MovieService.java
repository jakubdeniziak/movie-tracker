package jd.movietracker.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    @Qualifier("JdbcMovieRepository")
    private MovieRepository repository;

    public List<Movie> getAll() {
        return repository.getAll();
    }
}
