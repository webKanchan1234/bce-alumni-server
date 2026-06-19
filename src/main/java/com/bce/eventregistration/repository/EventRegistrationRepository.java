package com.bce.eventregistration.repository;

import com.bce.eventregistration.entity.EventRegistration;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRegistrationRepository
        extends JpaRepository<EventRegistration, Long> {

    List<EventRegistration> findByUserId(
            Long userId
    );

    List<EventRegistration> findByEventId(
            Long eventId
    );

    boolean existsByUserIdAndEventId(
            Long userId,
            Long eventId
    );
}