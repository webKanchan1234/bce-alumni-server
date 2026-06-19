package com.bce.mentorshiprequest.controller;

import com.bce.mentorshiprequest.dto.MentorshipRequestDto;
import com.bce.mentorshiprequest.dto.MentorshipRequestResponse;
import com.bce.mentorshiprequest.service.MentorshipRequestService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mentorship")
@RequiredArgsConstructor
public class MentorshipRequestController {

    private final MentorshipRequestService
            mentorshipRequestService;

    /*
     * Request Mentor
     */

    @PostMapping("/request")
    public MentorshipRequestResponse createRequest(
            @RequestBody
            MentorshipRequestDto request
    ) {

        return mentorshipRequestService
                .createRequest(request);
    }

    /*
     * My Requests
     */

    @GetMapping("/my-requests")
    public List<MentorshipRequestResponse>
    getMyRequests() {

        return mentorshipRequestService
                .getMyRequests();
    }

    /*
     * Approve Request
     */

    @PutMapping("/{id}/approve")
    public MentorshipRequestResponse approveRequest(
            @PathVariable Long id
    ) {

        return mentorshipRequestService
                .approveRequest(id);
    }

    /*
     * Reject Request
     */

    @PutMapping("/{id}/reject")
    public MentorshipRequestResponse rejectRequest(
            @PathVariable Long id
    ) {

        return mentorshipRequestService
                .rejectRequest(id);
    }
}