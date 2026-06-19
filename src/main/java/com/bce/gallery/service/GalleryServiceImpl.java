package com.bce.gallery.service;

import com.bce.gallery.dto.GalleryRequest;
import com.bce.gallery.dto.GalleryResponse;
import com.bce.gallery.entity.Gallery;
import com.bce.gallery.repository.GalleryRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GalleryServiceImpl
        implements GalleryService {

    private final GalleryRepository galleryRepository;

    @Override
    public GalleryResponse createGallery(
            GalleryRequest request
    ) {

        Gallery gallery = Gallery.builder()
                .title(request.getTitle())
                .imageUrl(request.getImageUrl())
                .category(request.getCategory())
                .uploadedBy(request.getUploadedBy())
                .build();

        galleryRepository.save(gallery);

        return mapToResponse(gallery);
    }

    @Override
    public List<GalleryResponse> getAllGallery() {

        return galleryRepository
                .findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public GalleryResponse getGalleryById(
            Long id
    ) {

        Gallery gallery =
                galleryRepository
                        .findById(id)
                        .orElseThrow();

        return mapToResponse(gallery);
    }

    @Override
    public List<GalleryResponse> getGalleryByCategory(
            String category
    ) {

        return galleryRepository
                .findByCategory(category)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteGallery(
            Long id
    ) {

        galleryRepository.deleteById(id);
    }

    private GalleryResponse mapToResponse(
            Gallery gallery
    ) {

        return GalleryResponse.builder()
                .id(gallery.getId())
                .title(gallery.getTitle())
                .imageUrl(gallery.getImageUrl())
                .category(gallery.getCategory())
                .uploadedBy(gallery.getUploadedBy())
                .createdAt(gallery.getCreatedAt())
                .build();
    }
}