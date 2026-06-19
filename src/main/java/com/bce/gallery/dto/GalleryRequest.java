package com.bce.gallery.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GalleryRequest {

    private String title;

    private String imageUrl;

    private String category;

    private String uploadedBy;
}