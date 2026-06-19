package com.bce.jobs.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobRequest {

    private String company;

    private String title;

    private String location;

    private String experience;

    private String salary;

    private String description;

    private String applyLink;

    private String postedBy;

    private Boolean active;
}