package com.bce.mentorship.service;

import com.bce.mentorship.dto.MentorRequest;
import com.bce.mentorship.dto.MentorResponse;

import java.util.List;

public interface MentorService {

    MentorResponse createMentor(
            MentorRequest request
    );

    List<MentorResponse> getAllMentors();

    MentorResponse getMentorById(
            Long id
    );

    List<MentorResponse> getAvailableMentors();

    MentorResponse updateMentor(
            Long id,
            MentorRequest request
    );

    void deleteMentor(
            Long id
    );
}