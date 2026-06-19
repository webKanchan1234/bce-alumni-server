package com.bce.news.repository;

import com.bce.news.entity.News;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository
        extends JpaRepository<News, Long> {

    List<News> findByFeaturedTrue();
}