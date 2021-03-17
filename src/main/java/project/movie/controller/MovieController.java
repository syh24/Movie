package project.movie.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.movie.controller.dto.RequestMovie;
import project.movie.service.MovieService;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public String home() {
        return "movie";
    }

    @GetMapping("/movies")
    public String findMovie(@RequestParam("query") String query, Model model) {
        List<RequestMovie> movies = movieService.sort(movieService.search(query));
        model.addAttribute("movies", movies);
        return "search";
    }
}