package project.movie.controller.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
public class RequestMovieDto {

    private List<MovieItem> items;

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MovieItem {
        private String title;
        private String link;
        private String image;
        private String subtitle;
        private Date pubDate;
        private String director;
        private String actor;
        private float userRating;
    }
}
