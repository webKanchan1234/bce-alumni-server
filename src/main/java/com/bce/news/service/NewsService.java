package com.bce.news.service;

import com.bce.news.dto.NewsRequest;
import com.bce.news.dto.NewsResponse;

import java.util.List;

public interface NewsService {

    NewsResponse createNews(
            NewsRequest request
    );

    List<NewsResponse> getAllNews();

    NewsResponse getNewsById(
            Long id
    );

    List<NewsResponse> getFeaturedNews();

    NewsResponse updateNews(
            Long id,
            NewsRequest request
    );

    void deleteNews(
            Long id
    );
}