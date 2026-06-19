package com.bce.gallery.repository;

import com.bce.gallery.entity.Gallery;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GalleryRepository
        extends JpaRepository<Gallery, Long> {

    List<Gallery> findByCategory(
            String category
    );
}