package com.bce.leadership.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bce.leadership.entity.Leadership;

public interface LeadershipRepository
        extends JpaRepository<Leadership, Long> {

    List<Leadership> findByActiveTrueOrderByDisplayOrderAsc();
}