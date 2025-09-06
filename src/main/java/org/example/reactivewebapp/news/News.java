package org.example.reactivewebapp.news;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "news-seq")
    private UUID id;
    private String data;
    private Instant dateOfPublication;

    public News(String data) {
        this.data = data;
        dateOfPublication = Instant.now();
    }

}
