package com.bce.mentorshiprequest.service;

import com.bce.mentorshiprequest.dto.MentorshipRequestDto;
import com.bce.mentorshiprequest.dto.MentorshipRequestResponse;

import java.util.List;

public interface MentorshipRequestService {

    MentorshipRequestResponse createRequest(
            MentorshipRequestDto request
    );

    List<MentorshipRequestResponse> getMyRequests();

    MentorshipRequestResponse approveRequest(
            Long requestId
    );

    MentorshipRequestResponse rejectRequest(
            Long requestId
    );
}