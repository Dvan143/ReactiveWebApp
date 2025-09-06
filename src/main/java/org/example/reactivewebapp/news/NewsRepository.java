package org.example.reactivewebapp.news;

import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface NewsRepository extends ReactiveCrudRepository<News, Long> {
    @Query("SELECT n.data, n.date_of_publication From News n")
    Flux<NewsDto> getNews(Pageable pageable);
    @Query("SELECT n.data, n.date_of_publication FROM News n ORDER BY n.date_of_publication DESC LIMIT 1")
    Mono<NewsDto> getLatestNews();
}
