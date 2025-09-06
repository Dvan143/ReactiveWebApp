package org.example.reactivewebapp.news;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.Instant;

@Getter
@NoArgsConstructor
public class News {
    @Id
    private Long id;
    @Setter
    private String data;
    @Setter
    @Column("date_of_publication")
    private Instant dateOfPublication;

    public News(String data) {
        this.data = data;
        dateOfPublication = Instant.now();
    }

}
