package com.bce.leadership.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeadershipResponse {

    private Long id;

    private String name;

    private String role;

    private String company;

    private String image;

    private String bio;

    private String linkedinUrl;

    private Integer displayOrder;

    private Boolean active;
}