package project.movie.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.movie.controller.dto.RequestMovie;
import project.movie.service.MovieService;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/movies")
    public String findMovie(@RequestParam String query, Model model) {
        try {
            List<RequestMovie> movies = movieService.sort(movieService.search(query));
            model.addAttribute("movies", movies);
            return "search";
        } catch (Exception e) {
            return "redirect:/";
        }
    }
}