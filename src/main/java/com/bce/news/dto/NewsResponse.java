package com.bce.news.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewsResponse {

    private Long id;

    private String title;

    private String content;

    private String imageUrl;

    private String author;

    private Boolean featured;

    private LocalDateTime publishedAt;
}