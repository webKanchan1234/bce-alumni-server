package com.bce.leadership.entity;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "leadership")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Leadership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String role;

    private String company;

    private String image;

    @Column(length = 3000)
    private String bio;

    private String linkedinUrl;

    private Integer displayOrder;

    private Boolean active;
}