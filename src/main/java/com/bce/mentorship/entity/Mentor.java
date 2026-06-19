package com.bce.mentorship.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mentors")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String company;

    private String designation;

    private String expertise;

    private Integer experienceYears;

    @Column(length = 3000)
    private String bio;

    private String profileImage;

    private String linkedinUrl;

    private Boolean available;
}