package project.movie.api;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

@Configuration
public class MovieApiClient {

    private String clientId = "[ Client-Id ]";
    private String clientSecret = "[ Client-Secret ]";

    public HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", clientId);
        headers.add("X-Naver-Client-Secret", clientSecret);
        return headers;
    }
}
