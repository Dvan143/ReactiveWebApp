package org.example.reactivewebapp.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class NewsService {
    @Autowired
    NewsRepository newsRepository;

    @Transactional
    public Mono<News> save(News news) {
        return newsRepository.save(news);
    }

    @Transactional(readOnly = true)
    public Flux<NewsDto> getLastNewsReact() {
        return newsRepository.getNews(PageRequest.of(0, 5));
    }

    @Transactional(readOnly = true)
    public Mono<NewsDto> getLatestNews() {
        return newsRepository.getLatestNews();
    }
}
