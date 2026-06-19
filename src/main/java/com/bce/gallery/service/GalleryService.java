package com.bce.gallery.service;

import com.bce.gallery.dto.GalleryRequest;
import com.bce.gallery.dto.GalleryResponse;

import java.util.List;

public interface GalleryService {

    GalleryResponse createGallery(
            GalleryRequest request
    );

    List<GalleryResponse> getAllGallery();

    GalleryResponse getGalleryById(
            Long id
    );

    List<GalleryResponse> getGalleryByCategory(
            String category
    );

    void deleteGallery(
            Long id
    );
}