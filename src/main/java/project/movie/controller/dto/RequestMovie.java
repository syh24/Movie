package project.movie.controller.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class RequestMovie {

    private String title;
    private String link;
    private String image;
    private String subtitle;
    private Date pubDate;
    private String director;
    private String actor;
    private float userRating;
}
