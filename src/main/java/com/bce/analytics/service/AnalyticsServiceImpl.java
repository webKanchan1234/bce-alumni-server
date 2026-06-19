package com.bce.analytics.service;

import com.bce.analytics.dto.AnalyticsResponse;

import com.bce.user.repository.UserRepository;
import com.bce.alumni.repository.AlumniProfileRepository;
import com.bce.event.repository.EventRepository;
import com.bce.news.repository.NewsRepository;
import com.bce.jobs.repository.JobRepository;
import com.bce.gallery.repository.GalleryRepository;
import com.bce.mentorship.repository.MentorRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalyticsServiceImpl
        implements AnalyticsService {

    private final UserRepository userRepository;
    private final AlumniProfileRepository alumniRepository;
    private final EventRepository eventRepository;
    private final NewsRepository newsRepository;
    private final JobRepository jobRepository;
    private final MentorRepository mentorRepository;
    private final GalleryRepository galleryRepository;

    @Override
    public AnalyticsResponse getAnalytics() {

        return AnalyticsResponse.builder()
                .totalUsers(userRepository.count())
                .totalAlumni(alumniRepository.count())
                .totalEvents(eventRepository.count())
                .totalNews(newsRepository.count())
                .totalJobs(jobRepository.count())
                .totalMentors(mentorRepository.count())
                .totalGalleryImages(galleryRepository.count())
                .monthlyUsers(List.of())
                .monthlyEvents(List.of())
                .monthlyJobs(List.of())
                .build();
    }
}