package com.bce.jobs.repository;

import com.bce.jobs.entity.Job;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository
        extends JpaRepository<Job, Long> {

    List<Job> findByActiveTrue();

    List<Job> findByCompanyContainingIgnoreCase(
            String company
    );
}