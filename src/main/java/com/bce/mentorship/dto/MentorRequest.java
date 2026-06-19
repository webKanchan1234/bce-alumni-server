package com.bce.mentorship.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MentorRequest {

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