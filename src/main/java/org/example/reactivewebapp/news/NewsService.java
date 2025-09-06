package org.example.reactivewebapp.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NewsService {
    @Autowired
    NewsRepository newsRepository;

    public void save(News news) {
        newsRepository.save(news);
    }

    public List<News> getLastNews() {
        return newsRepository.getNews(PageRequest.of(0, 5));
    }

}
