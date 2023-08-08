package jd.movietracker.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("JdbcMovieRepository")
public class JdbcMovieRepository implements MovieRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int insert(Movie movie) {
        return jdbcTemplate.update("INSERT INTO movie (id, title) VALUES(?, ?)", movie.getId(), movie.getTitle());
    }

    public int delete(UUID id) {
        return jdbcTemplate.update("DELETE FROM movie WHERE id=?", id);
    }

    public List<Movie> getAll() {
        return jdbcTemplate.query("SELECT * FROM movie", BeanPropertyRowMapper.newInstance(Movie.class));
    }
}
