package com.bce.gallery.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GalleryResponse {

    private Long id;

    private String title;

    private String imageUrl;

    private String category;

    private String uploadedBy;

    private LocalDateTime createdAt;
}