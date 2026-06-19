package com.bce.jobs.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobResponse {

    private Long id;

    private String company;

    private String title;

    private String location;

    private String experience;

    private String salary;

    private String description;

    private String applyLink;

    private String postedBy;

    private Boolean active;

    private LocalDateTime createdAt;
}