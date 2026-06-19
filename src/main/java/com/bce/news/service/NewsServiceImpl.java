package com.bce.news.service;

import com.bce.news.dto.NewsRequest;
import com.bce.news.dto.NewsResponse;
import com.bce.news.entity.News;
import com.bce.news.repository.NewsRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl
        implements NewsService {

    private final NewsRepository newsRepository;

    @Override
    public NewsResponse createNews(
            NewsRequest request
    ) {

        News news = News.builder()
                .title(
                        request.getTitle()
                )
                .content(
                        request.getContent()
                )
                .imageUrl(
                        request.getImageUrl()
                )
                .author(
                        request.getAuthor()
                )
                .featured(
                        request.getFeatured()
                )
                .build();

        newsRepository.save(news);

        return mapToResponse(news);
    }

    @Override
    public List<NewsResponse> getAllNews() {

        return newsRepository
                .findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public NewsResponse getNewsById(
            Long id
    ) {

        News news =
                newsRepository
                        .findById(id)
                        .orElseThrow();

        return mapToResponse(news);
    }

    @Override
    public List<NewsResponse> getFeaturedNews() {

        return newsRepository
                .findByFeaturedTrue()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public NewsResponse updateNews(
            Long id,
            NewsRequest request
    ) {

        News news =
                newsRepository
                        .findById(id)
                        .orElseThrow();

        news.setTitle(
                request.getTitle()
        );

        news.setContent(
                request.getContent()
        );

        news.setImageUrl(
                request.getImageUrl()
        );

        news.setAuthor(
                request.getAuthor()
        );

        news.setFeatured(
                request.getFeatured()
        );

        newsRepository.save(news);

        return mapToResponse(news);
    }

    @Override
    public void deleteNews(
            Long id
    ) {

        newsRepository.deleteById(id);
    }

    private NewsResponse mapToResponse(
            News news
    ) {

        return NewsResponse.builder()
                .id(news.getId())
                .title(news.getTitle())
                .content(news.getContent())
                .imageUrl(news.getImageUrl())
                .author(news.getAuthor())
                .featured(news.getFeatured())
                .publishedAt(news.getPublishedAt())
                .build();
    }
}