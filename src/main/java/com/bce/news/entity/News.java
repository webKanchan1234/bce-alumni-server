package com.bce.news.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "news")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 5000)
    private String content;

    private String imageUrl;

    private String author;

    private Boolean featured;

    private LocalDateTime publishedAt;

    @PrePersist
    public void prePersist() {

        publishedAt = LocalDateTime.now();

        if (featured == null) {
            featured = false;
        }
    }
}