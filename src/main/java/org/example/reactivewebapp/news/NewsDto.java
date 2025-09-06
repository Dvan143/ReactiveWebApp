package org.example.reactivewebapp.news;

import java.time.Instant;

public record NewsDto(String data, Instant dateOfPublication) {
    public NewsDto(News news) {
        this(news.getData(), news.getDateOfPublication());
    }
}
