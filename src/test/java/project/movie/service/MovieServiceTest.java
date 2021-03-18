package project.movie.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project.movie.controller.dto.RequestMovie;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class MovieServiceTest {

    @Autowired
    MovieService movieService;

    @Test
    @DisplayName("검색 테스트")
    void search() throws Exception {
        //given
        String query = "기생충";
        List<RequestMovie> search = getSearch(query);

        //when //then
        for (RequestMovie movie : search) {
            assertThat(movie.getTitle()).contains(query);
        }
    }

    @Test
    @DisplayName("평점 정렬 테스트")
    void sort() throws Exception {
        //given
        String query = "코난";
        List<RequestMovie> search = getSearch(query);
        //when
        List<RequestMovie> sorted = movieService.sort(search);
        for (RequestMovie movie : sorted) {
            assertThat(sorted.get(0).getUserRating()).isGreaterThanOrEqualTo(movie.getUserRating());
        }
    }

    private List<RequestMovie> getSearch(String query) {
        return movieService.search(query);
    }
}