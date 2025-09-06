package org.example.reactivewebapp.controllers;

import org.example.reactivewebapp.news.News;
import org.example.reactivewebapp.news.NewsDto;
import org.example.reactivewebapp.news.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping("/getLastNews")
    public Flux<NewsDto> getLastNewsReact() {
        return newsService.getLastNewsReact();
    }

    @GetMapping("/getLatestNews")
    public Mono<NewsDto> getLatestNews() {
        return newsService.getLatestNews();
    }

    @PostMapping("/addNewNews")
    public Mono<ResponseEntity<Void>> addNewNews(@RequestParam(name = "newsData") String newsData) {
        News news = new News(newsData);
        return newsService.save(news).then(Mono.just(ResponseEntity.status(HttpStatus.CREATED).build()));
    }

    @EventListener(ApplicationReadyEvent.class)
    private void init() {
        News news = new News("First news!!!!");
        newsService.save(news).subscribe();
    }
}
