package project.movie.api;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;


@Configuration
@ConfigurationProperties(prefix = "naver.openapi")
public class MovieApiClient {

    private String clientId;
    private String clientSecret;

    public HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", this.clientId);
        headers.add("X-Naver-Client-Secret", this.clientSecret);
        return headers;
    }
}
