package com.bce.mentorshiprequest.repository;

import com.bce.mentorshiprequest.entity.MentorshipRequest;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MentorshipRequestRepository
        extends JpaRepository<MentorshipRequest, Long> {

    List<MentorshipRequest> findByRequesterId(
            Long requesterId
    );

    List<MentorshipRequest> findByMentorId(
            Long mentorId
    );
}