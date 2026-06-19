package com.bce.alumni.repository;

import com.bce.alumni.entity.AlumniProfile;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumniProfileRepository
        extends JpaRepository<AlumniProfile, Long> {
}