package com.bce.user.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProfileRequest {

    private String firstName;

    private String lastName;

    private Integer graduationYear;

    private String branch;

    private String company;

    private String designation;

    private String location;

    private String bio;

    private String profileImage;

    private String linkedinUrl;

    private String githubUrl;
}