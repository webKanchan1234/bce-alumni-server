package com.bce.alumni.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlumniRequest {

    private String company;

    private String designation;

    private String location;

    private Integer experienceYears;

    private String bio;

    private String linkedinUrl;

    private String githubUrl;

    private String profileImage;
}