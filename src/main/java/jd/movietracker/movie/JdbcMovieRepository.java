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
        String sql = "INSERT INTO movie (id, title) VALUES(?, ?)";
        return jdbcTemplate.update(sql, movie.getId().toString(), movie.getTitle());
    }

    public int delete(String id) {
        String sql = "DELETE FROM movie WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }

    public List<Movie> getAll() {
        String sql = "SELECT * FROM movie";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Movie.class));
    }

    public List<Movie> getRandomMovies(long seed, int amount) {
        String sql = "SELECT * FROM movie ORDER BY RAND(?) LIMIT ?";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Movie.class), seed, amount);
    }
}
