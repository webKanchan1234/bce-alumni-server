package com.bce.admin.service;

import com.bce.admin.dto.DashboardStatsResponse;
import com.bce.alumni.dto.PublicAlumniDto;
import com.bce.common.enums.Role;
import com.bce.user.entity.User;
import com.bce.user.repository.UserRepository;

import com.bce.event.repository.EventRepository;
import com.bce.news.repository.NewsRepository;
import com.bce.jobs.repository.JobRepository;
import com.bce.mentorship.repository.MentorRepository;
import com.bce.gallery.repository.GalleryRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminDashboardServiceImpl
        implements AdminDashboardService {

    private final UserRepository userRepository;

    private final EventRepository eventRepository;

    private final NewsRepository newsRepository;

    private final JobRepository jobRepository;

    private final MentorRepository mentorRepository;

    private final GalleryRepository galleryRepository;

    @Override
    public DashboardStatsResponse getDashboardStats() {

        long totalAlumni =
                userRepository
                        .findByRole(Role.ALUMNI)
                        .size();

        return DashboardStatsResponse.builder()
                .totalUsers(
                        userRepository.count()
                )
                .totalAlumni(
                        totalAlumni
                )
                .totalEvents(
                        eventRepository.count()
                )
                .totalNews(
                        newsRepository.count()
                )
                .totalJobs(
                        jobRepository.count()
                )
                .totalMentors(
                        mentorRepository.count()
                )
                .totalGalleryImages(
                        galleryRepository.count()
                )
                .build();
    }

    @Override
    public List<PublicAlumniDto> getAllAlumniForAdmin() {

        return userRepository
                .findByRole(Role.ALUMNI)
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

                .verified(
                        user.getVerified()
                )

                .build();
    }
}