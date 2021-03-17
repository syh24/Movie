package project.movie.api;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

@Configuration
public class MovieApiClient {

    private final String clientId = "kmJcoKSSgomqKQx5z6zJ";
    private final String clientSecret = "D1ouh5MxCy";

    public HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", clientId);
        headers.add("X-Naver-Client-Secret", clientSecret);
        return headers;
    }
}
