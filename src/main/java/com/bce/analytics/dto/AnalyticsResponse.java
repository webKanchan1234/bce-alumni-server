package com.bce.analytics.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnalyticsResponse {

    private Long totalUsers;

    private Long totalAlumni;

    private Long totalEvents;

    private Long totalNews;

    private Long totalJobs;

    private Long totalMentors;

    private Long totalGalleryImages;

    private List<MonthlyStatDto> monthlyUsers;

    private List<MonthlyStatDto> monthlyEvents;

    private List<MonthlyStatDto> monthlyJobs;
}