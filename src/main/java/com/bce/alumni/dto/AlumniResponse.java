package com.bce.alumni.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlumniResponse {

    private Long id;

    private String name;

    private String email;

    private Integer graduationYear;

    private String branch;

    private String company;

    private String designation;

    private String location;

    private String profileImage;
}