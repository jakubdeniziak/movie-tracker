package jd.movietracker.mediaitems.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    @GetMapping("/movies/{id}")
    public String movie(@PathVariable("id") String id, Model model) {
        Movie movie = service.getById(id);
        model.addAttribute("movie", movie);
        return "movie";
    }

    @GetMapping("/movies/{id}/edit")
    public String editMovie(@PathVariable("id") String id, Model model) {
        Movie movie = service.getById(id);
        model.addAttribute("movie", movie);
        return "edit-movie";
    }

    @PostMapping("/movies/{id}/edit")
    public String editMovieSubmit(@ModelAttribute Movie movie, Model model) {
        service.editMovie(movie);
        return movies(model);
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

    @GetMapping("/delete-movies")
    public String deleteMovies(Model model) {
        List<Movie> movies = service.getAll();
        model.addAttribute("movies", movies);
        return "delete-movies";
    }

    @PostMapping("/delete-movies")
    public String deleteMoviesSubmit(@RequestBody String requestBody, Model model) {
        service.deleteMovies(requestBody);
        return movies(model);
    }
}
