package jd.movietracker.mediaitems.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("JdbcMovieRepository")
public class JdbcMovieRepository implements MovieRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Movie movie) {
        String sql = "INSERT INTO movie (id, title, director, language, running_time) VALUES(?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, movie.getId().toString(), movie.getTitle(), movie.getDirector(), movie.getLanguage(), movie.getRunningTime());
    }

    @Override
    public int delete(String id) {
        String sql = "DELETE FROM movie WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int update(String id, Movie movie) {
        String query = "UPDATE movie SET title=?, director=?, language=?, running_time=? WHERE id=?";
        return jdbcTemplate.update(query, movie.getTitle(), movie.getDirector(), movie.getLanguage(), movie.getRunningTime(), id);
    }

    @Override
    public List<Movie> getAll() {
        String sql = "SELECT * FROM movie";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Movie.class));
    }

    @Override
    public Movie getById(String id) {
        String sql = "SELECT * FROM movie WHERE id=?";
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Movie.class), id);
    }

    @Override
    public List<Movie> getRandomMovies(long seed, int amount) {
        String sql = "SELECT * FROM movie ORDER BY RAND(?) LIMIT ?";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Movie.class), seed, amount);
    }
}
