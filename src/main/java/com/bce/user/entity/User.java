package com.bce.user.entity;

import com.bce.common.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Basic Information

    @Column(nullable = false)
    private String firstName;

    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    // Alumni Information

    private Integer graduationYear;

    private String branch;

    private String company;

    private String designation;

    private String location;

    // Profile

    @Column(length = 2000)
    private String bio;

    private String profileImage;

    private String linkedinUrl;

    private String githubUrl;

    // Role

    @Enumerated(EnumType.STRING)
    private Role role;

    // Status

    private Boolean active;

    private Boolean verified;

    // Audit

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


    private String resetOtp;

    private LocalDateTime otpExpiry;



    @PrePersist
    public void prePersist() {

        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();

        role = role == null ? Role.ALUMNI : role;
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}