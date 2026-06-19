package com.bce.alumni.controller;

import com.bce.alumni.dto.PublicAlumniDto;
import com.bce.alumni.service.PublicAlumniService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumni")
@RequiredArgsConstructor
public class AlumniController {

    private final PublicAlumniService alumniService;

    @GetMapping("/public")
    public List<PublicAlumniDto>
    getPublicAlumni() {

        return alumniService
                .getPublicAlumni();
    }

    @GetMapping("/{id}")
    public PublicAlumniDto getAlumniById(
            @PathVariable Long id
    ) {
        return alumniService.getAlumniById(id);
    }
}