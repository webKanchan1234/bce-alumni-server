package com.bce.jobs.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "jobs")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company;

    private String title;

    private String location;

    private String experience;

    private String salary;

    @Column(length = 5000)
    private String description;

    private String applyLink;

    private String postedBy;

    private Boolean active;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {

        createdAt = LocalDateTime.now();

        if (active == null) {
            active = true;
        }
    }
}