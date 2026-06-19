package com.bce.news.controller;

import com.bce.news.dto.NewsRequest;
import com.bce.news.dto.NewsResponse;
import com.bce.news.service.NewsService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    /*
     * Create News
     */

    @PostMapping("/api/admin/news")
    @PreAuthorize("hasRole('ADMIN')")
    public NewsResponse createNews(
            @RequestBody NewsRequest request
    ) {

        return newsService.createNews(
                request
        );
    }

    /*
     * Get All News
     */

    @GetMapping("/api/news")
    public List<NewsResponse> getAllNews() {

        return newsService.getAllNews();
    }

    /*
     * Get News By Id
     */

    @GetMapping("/api/news/{id}")
    public NewsResponse getNewsById(
            @PathVariable Long id
    ) {

        return newsService.getNewsById(id);
    }

    /*
     * Get Featured News
     */

    @GetMapping("/api/news/featured")
    public List<NewsResponse> getFeaturedNews() {

        return newsService.getFeaturedNews();
    }

    /*
     * Update News
     */

    @PutMapping("/api/admin/news/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public NewsResponse updateNews(
            @PathVariable Long id,
            @RequestBody NewsRequest request
    ) {

        return newsService.updateNews(
                id,
                request
        );
    }

    /*
     * Delete News
     */

    @DeleteMapping("/api/admin/news/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteNews(
            @PathVariable Long id
    ) {

        newsService.deleteNews(id);
    }
}