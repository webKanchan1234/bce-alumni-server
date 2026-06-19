//package com.bce.alumni.service;
//
//import com.bce.alumni.dto.AlumniRequest;
//import com.bce.alumni.dto.AlumniResponse;
//import com.bce.alumni.dto.PublicAlumniDto;
//import com.bce.alumni.entity.AlumniProfile;
//import com.bce.alumni.repository.AlumniProfileRepository;
//import com.bce.user.entity.User;
//import com.bce.user.repository.UserRepository;
//
//import lombok.RequiredArgsConstructor;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class AlumniServiceImpl
//        implements AlumniService {
//
//    private final AlumniProfileRepository alumniRepository;
//
//    private final UserRepository userRepository;
//
//    @Override
//    public AlumniResponse createProfile(
//            AlumniRequest request
//    ) {
//
//        Authentication authentication =
//                SecurityContextHolder
//                        .getContext()
//                        .getAuthentication();
//
//        String email =
//                authentication.getName();
//
//        User user =
//                userRepository
//                        .findByEmail(email)
//                        .orElseThrow();
//
//        AlumniProfile profile =
//                AlumniProfile.builder()
//                        .user(user)
//                        .company(
//                                request.getCompany()
//                        )
//                        .designation(
//                                request.getDesignation()
//                        )
//                        .location(
//                                request.getLocation()
//                        )
//                        .experienceYears(
//                                request.getExperienceYears()
//                        )
//                        .bio(
//                                request.getBio()
//                        )
//                        .linkedinUrl(
//                                request.getLinkedinUrl()
//                        )
//                        .githubUrl(
//                                request.getGithubUrl()
//                        )
//                        .profileImage(
//                                request.getProfileImage()
//                        )
//                        .build();
//
//        alumniRepository.save(profile);
//
//        return mapToResponse(profile);
//    }
//
//    @Override
//    public List<AlumniResponse> getAllAlumni() {
//
//        return alumniRepository
//                .findAll()
//                .stream()
//                .map(this::mapToResponse)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public AlumniResponse getAlumniById(
//            Long id
//    ) {
//
//        AlumniProfile profile =
//                alumniRepository
//                        .findById(id)
//                        .orElseThrow();
//
//        return mapToResponse(profile);
//    }
//
//    @Override
//    public AlumniResponse updateProfile(
//            Long id,
//            AlumniRequest request
//    ) {
//
//        AlumniProfile profile =
//                alumniRepository
//                        .findById(id)
//                        .orElseThrow();
//
//        profile.setCompany(
//                request.getCompany()
//        );
//
//        profile.setDesignation(
//                request.getDesignation()
//        );
//
//        profile.setLocation(
//                request.getLocation()
//        );
//
//        profile.setExperienceYears(
//                request.getExperienceYears()
//        );
//
//        profile.setBio(
//                request.getBio()
//        );
//
//        profile.setLinkedinUrl(
//                request.getLinkedinUrl()
//        );
//
//        profile.setGithubUrl(
//                request.getGithubUrl()
//        );
//
//        profile.setProfileImage(
//                request.getProfileImage()
//        );
//
//        alumniRepository.save(profile);
//
//        return mapToResponse(profile);
//    }
//
//    @Override
//    public void deleteProfile(
//            Long id
//    ) {
//
//        alumniRepository.deleteById(id);
//    }
//
//    private AlumniResponse mapToResponse(
//            AlumniProfile profile
//    ) {
//
//        return AlumniResponse.builder()
//                .id(profile.getId())
//                .name(
//                        profile.getUser().getFirstName()
//                                + " "
//                                + profile.getUser().getLastName()
//                )
//                .email(
//                        profile.getUser().getEmail()
//                )
//                .graduationYear(
//                        profile.getUser().getGraduationYear()
//                )
//                .branch(
//                        profile.getUser().getBranch()
//                )
//                .company(
//                        profile.getCompany()
//                )
//                .designation(
//                        profile.getDesignation()
//                )
//                .location(
//                        profile.getLocation()
//                )
//                .profileImage(
//                        profile.getProfileImage()
//                )
//                .build();
//    }
//
//    @Override
//    public List<PublicAlumniDto> getPublicAlumni() {
//
//        return alumniRepository
//                .findAll()
//                .stream()
//                .map(profile -> {
//
//                    PublicAlumniDto dto =
//                            new PublicAlumniDto();
//
//                    dto.setId(
//                            profile.getId()
//                    );
//
//                    if (profile.getUser() != null) {
//
//                        dto.setFirstName(
//                                profile.getUser().getFirstName()
//                        );
//
//                        dto.setEmail(
//                                profile.getUser().getEmail()
//                        );
//                    }
//
//                    dto.setProfileImage(
//                            profile.getProfileImage()
//                    );
//
//                    dto.setCompany(
//                            profile.getCompany()
//                    );
//
//                    dto.setDesignation(
//                            profile.getDesignation()
//                    );
//
//                    dto.setLocation(
//                            profile.getLocation()
//                    );
//
//                    dto.setExperienceYears(
//                            profile.getExperienceYears()
//                    );
//
//                    dto.setBio(
//                            profile.getBio()
//                    );
//
//                    return dto;
//
//                })
//                .toList();
//    }
//}