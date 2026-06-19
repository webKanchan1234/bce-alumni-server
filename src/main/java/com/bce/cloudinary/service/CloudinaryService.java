package com.bce.cloudinary.service;

import com.cloudinary.Cloudinary;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CloudinaryService {

    private final Cloudinary cloudinary;

    public String uploadFile(
            MultipartFile file
    ) {

        try {

            Map<?, ?> result =
                    cloudinary.uploader()
                            .upload(
                                    file.getBytes(),
                                    Map.of()
                            );

            return result
                    .get("secure_url")
                    .toString();

        } catch (IOException e) {

            throw new RuntimeException(
                    "Upload failed"
            );
        }
    }
}