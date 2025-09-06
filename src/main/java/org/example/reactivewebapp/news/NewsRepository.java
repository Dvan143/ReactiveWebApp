package org.example.reactivewebapp.news;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.data.jpa.repository.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReactiveNewsRepository extends ReactiveCrudRepository<News, Long> {
    @Query("SELECT new org.example.reactivewebapp.news.NewsDto(n.data, n.dateOfPublication) From News n")
    Flux<NewsDto> getNews(Pageable pageable);
    @Query("SELECT new org.example.reactivewebapp.news.NewsDto(n.data, n.dateOfPublication) FROM News n ORDER BY n.dateOfPublication DESC LIMIT 1")
    Mono<NewsDto> getLatestNews();
}
