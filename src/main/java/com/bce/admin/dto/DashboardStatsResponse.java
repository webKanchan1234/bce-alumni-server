package com.bce.admin.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardStatsResponse {

    private Long totalUsers;

    private Long totalAlumni;

    private Long totalEvents;

    private Long totalNews;

    private Long totalJobs;

    private Long totalMentors;

    private Long totalGalleryImages;
}