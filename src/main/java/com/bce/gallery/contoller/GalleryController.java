package com.bce.gallery.controller;

import com.bce.gallery.dto.GalleryRequest;
import com.bce.gallery.dto.GalleryResponse;
import com.bce.gallery.service.GalleryService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GalleryController {

    private final GalleryService galleryService;

    /*
     * Create Gallery
     */

    @PostMapping("/api/admin/gallery")
    @PreAuthorize("hasRole('ADMIN')")
    public GalleryResponse createGallery(
            @RequestBody GalleryRequest request
    ) {

        return galleryService.createGallery(
                request
        );
    }

    /*
     * Get All Gallery
     */

    @GetMapping("/api/gallery")
    public List<GalleryResponse> getAllGallery() {

        return galleryService.getAllGallery();
    }

    /*
     * Get Gallery By Id
     */

    @GetMapping("/api/gallery/{id}")
    public GalleryResponse getGalleryById(
            @PathVariable Long id
    ) {

        return galleryService.getGalleryById(id);
    }

    /*
     * Get Gallery By Category
     */

    @GetMapping("/api/gallery/category/{category}")
    public List<GalleryResponse> getGalleryByCategory(
            @PathVariable String category
    ) {

        return galleryService.getGalleryByCategory(
                category
        );
    }

    /*
     * Delete Gallery
     */

    @DeleteMapping("/api/admin/gallery/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteGallery(
            @PathVariable Long id
    ) {

        galleryService.deleteGallery(id);
    }
}