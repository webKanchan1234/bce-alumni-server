package com.bce.mentorship.repository;

import com.bce.mentorship.entity.Mentor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MentorRepository
        extends JpaRepository<Mentor, Long> {

    List<Mentor> findByAvailableTrue();
}