package project.movie.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import project.movie.api.MovieApiClient;
import project.movie.controller.dto.RequestMovie;
import project.movie.controller.dto.RequestMovieDto;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MovieService {

    private final RestTemplate restTemplate;

    public List<RequestMovie> search(String query) {
        HttpHeaders headers = new MovieApiClient().getHeaders();
        List<RequestMovieDto> movies = null;
        String url = "https://openapi.naver.com/v1/search/movie.json" + "?query=" + query;
        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), RequestMovieDto.class)
                .getBody().getItems().stream()
                .map(m -> RequestMovie.builder()
                        .actor(m.getActor())
                        .pubDate(m.getPubDate())
                        .link(m.getLink())
                        .image(m.getImage())
                        .director(m.getDirector())
                        .userRating(m.getUserRating())
                        .title(m.getTitle())
                        .subtitle(m.getSubtitle())
                        .build())
                .collect(Collectors.toList());
    }

    public List<RequestMovie> sort(List<RequestMovie> movies) {
        return movies.stream()
                .filter(x -> (Float) x.getUserRating() != 0.0f)
                .sorted((a, b) -> a.getUserRating() > b.getUserRating() ? -1 : 1)
                .collect(Collectors.toList());
    }
}
