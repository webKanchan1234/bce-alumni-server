package com.bce.alumni.service;

import com.bce.alumni.dto.PublicAlumniDto;
import com.bce.common.enums.Role;
import com.bce.user.entity.User;
import com.bce.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublicAlumniServiceImpl
        implements PublicAlumniService {

    private final UserRepository userRepository;

    @Override
    public List<PublicAlumniDto>
    getPublicAlumni() {

        return userRepository
                .findByRoleAndVerified(
                        Role.ALUMNI,
                        true
                )
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    private PublicAlumniDto mapToDto(
            User user
    ) {

        return PublicAlumniDto.builder()

                .id(user.getId())

                .firstName(
                        user.getFirstName()
                )

                .lastName(
                        user.getLastName()
                )

                .email(
                        user.getEmail()
                )

                .graduationYear(
                        user.getGraduationYear()
                )

                .branch(
                        user.getBranch()
                )

                .company(
                        user.getCompany()
                )

                .designation(
                        user.getDesignation()
                )

                .location(
                        user.getLocation()
                )

                .bio(
                        user.getBio()
                )

                .profileImage(
                        user.getProfileImage()
                )

                .linkedinUrl(
                        user.getLinkedinUrl()
                )

                .githubUrl(
                        user.getGithubUrl()
                )

                .build();
    }

    @Override
    public PublicAlumniDto getAlumniById(
            Long id
    ) {

        User user =
                userRepository
                        .findById(id)
                        .orElseThrow();

        return mapToDto(user);
    }
}