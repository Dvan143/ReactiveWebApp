package org.example.reactivewebapp.controllers;

import org.example.reactivewebapp.news.News;
import org.example.reactivewebapp.news.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class NewsController {
    @Autowired
    private NewsService newsService;

    @PostMapping("/getLastNews")
    public List<News> getLastNews() {
        return newsService.getLastNews();
    }

}
