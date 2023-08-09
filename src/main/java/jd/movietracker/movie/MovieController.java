package jd.movietracker.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
public class MovieController {
    @Autowired
    private MovieService service;

    @GetMapping("/movies")
    public String movies(Model model) {
        List<Movie> movies = service.getAll();
        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping("/new-movie")
    public String newMovie(Model model) {
        model.addAttribute("movie", new Movie());
        return "new-movie";
    }

    @PostMapping("/new-movie")
    public String newMovieSubmit(@ModelAttribute Movie movie, Model model) {
        service.insertNew(movie);
        return movies(model);
    }
}
