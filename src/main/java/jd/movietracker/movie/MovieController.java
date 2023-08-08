package jd.movietracker.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MovieController {
    @Autowired
    private MovieService service;

    @GetMapping("/movies")
    @ResponseBody
    public List<Movie> movies() {
        return service.getAll();
    }
}