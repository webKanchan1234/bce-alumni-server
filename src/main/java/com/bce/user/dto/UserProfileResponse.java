package com.bce.user.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private Integer graduationYear;

    private String branch;

    private String company;

    private String designation;

    private String location;

    private String bio;

    private String profileImage;

    private String linkedinUrl;

    private String githubUrl;

    private String role;

    private Boolean active;

    private Boolean verified;
}