package com.bce.news.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsRequest {

    private String title;

    private String content;

    private String imageUrl;

    private String author;

    private Boolean featured;
}