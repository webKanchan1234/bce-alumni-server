package com.bce.user.service;

import com.bce.user.dto.ChangePasswordRequest;
import com.bce.user.dto.UpdateProfileRequest;
import com.bce.user.dto.UserProfileResponse;
import com.bce.user.entity.User;
import com.bce.user.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;



    @Override
    public UserProfileResponse getCurrentUser() {

        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        String email =
                authentication.getName();

        User user =
                userRepository
                        .findByEmail(email)
                        .orElseThrow();

        return mapToResponse(user);
    }

    @Override
    public UserProfileResponse getUserById(
            Long id
    ) {

        User user =
                userRepository
                        .findById(id)
                        .orElseThrow();

        return mapToResponse(user);
    }

    @Override
    public UserProfileResponse updateProfile(
            UpdateProfileRequest request
    ) {

        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        String email =
                authentication.getName();

        User user =
                userRepository
                        .findByEmail(email)
                        .orElseThrow();

        if (request.getFirstName() != null) {
            user.setFirstName(request.getFirstName());
        }

        if (request.getLastName() != null) {
            user.setLastName(request.getLastName());
        }

        if (request.getGraduationYear() != null) {
            user.setGraduationYear(request.getGraduationYear());
        }

        if (request.getBranch() != null) {
            user.setBranch(request.getBranch());
        }

        if (request.getCompany() != null) {
            user.setCompany(request.getCompany());
        }

        if (request.getDesignation() != null) {
            user.setDesignation(request.getDesignation());
        }

        if (request.getLocation() != null) {
            user.setLocation(request.getLocation());
        }

        if (request.getBio() != null) {
            user.setBio(request.getBio());
        }

        if (request.getProfileImage() != null) {
            user.setProfileImage(request.getProfileImage());
        }

        if (request.getLinkedinUrl() != null) {
            user.setLinkedinUrl(request.getLinkedinUrl());
        }

        if (request.getGithubUrl() != null) {
            user.setGithubUrl(request.getGithubUrl());
        }

        userRepository.save(user);

        return mapToResponse(user);
    }

    private UserProfileResponse mapToResponse(
            User user
    ) {

        return UserProfileResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .graduationYear(
                        user.getGraduationYear()
                )
                .branch(user.getBranch())
                .company(user.getCompany())
                .designation(
                        user.getDesignation()
                )
                .location(user.getLocation())
                .bio(user.getBio())
                .profileImage(
                        user.getProfileImage()
                )
                .linkedinUrl(
                        user.getLinkedinUrl()
                )
                .githubUrl(
                        user.getGithubUrl()
                )
                .role(
                        user.getRole().name()
                )
                .active(
                        user.getActive()
                )
                .verified(
                        user.getVerified()
                )
                .build();
    }


    @Transactional
    public void changePassword(
            ChangePasswordRequest request
    ) {

        String email =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getName();

        User user =
                userRepository
                        .findByEmail(email)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "User not found"
                                ));

        if (!passwordEncoder.matches(
                request.getOldPassword(),
                user.getPassword()
        )) {

            throw new RuntimeException(
                    "Current password is incorrect"
            );
        }

        user.setPassword(
                passwordEncoder.encode(
                        request.getNewPassword()
                )
        );

        userRepository.save(user);
    }
}