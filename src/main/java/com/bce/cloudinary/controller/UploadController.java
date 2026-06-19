package com.bce.cloudinary.controller;

import com.bce.cloudinary.service.CloudinaryService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/upload")
@RequiredArgsConstructor
public class UploadController {

    private final CloudinaryService cloudinaryService;

    @PostMapping
    public Map<String, String> uploadImage(
            @RequestParam("file")
            MultipartFile file
    ) {

        String imageUrl =
                cloudinaryService
                        .uploadFile(file);

        return Map.of(
                "imageUrl",
                imageUrl
        );
    }
}