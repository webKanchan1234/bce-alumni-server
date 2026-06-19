package com.bce.alumni.entity;

import com.bce.user.entity.User;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "alumni_profiles")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlumniProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    private String company;

    private String designation;

    private String location;

    private Integer experienceYears;

    @Column(length = 3000)
    private String bio;

    private String linkedinUrl;

    private String githubUrl;

    private String profileImage;
}