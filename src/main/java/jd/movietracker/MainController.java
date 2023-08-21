package jd.movietracker;

import jd.movietracker.mediaitems.movie.Movie;
import jd.movietracker.mediaitems.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private MovieService movieService;

    @GetMapping({"", "/", "/index"})
    public String index(Model model) {
        List<Movie> movies = movieService.getFeaturedToday();
        model.addAttribute("featured_today", movies);
        return "index";
    }
}
