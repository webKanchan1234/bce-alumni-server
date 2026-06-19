package com.bce.mentorship.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MentorResponse {

    private Long id;

    private String name;

    private String company;

    private String designation;

    private String expertise;

    private Integer experienceYears;

    private String bio;

    private String profileImage;

    private String linkedinUrl;

    private Boolean available;
}