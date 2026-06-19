package com.bce.alumni.service;

import com.bce.alumni.dto.PublicAlumniDto;

import java.util.List;

public interface PublicAlumniService {

    List<PublicAlumniDto>
    getPublicAlumni();

    PublicAlumniDto getAlumniById(
            Long id
    );
}