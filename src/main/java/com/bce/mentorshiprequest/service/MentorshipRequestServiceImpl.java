package com.bce.mentorshiprequest.service;

import com.bce.mentorship.entity.Mentor;
import com.bce.mentorship.repository.MentorRepository;

import com.bce.mentorshiprequest.dto.MentorshipRequestDto;
import com.bce.mentorshiprequest.dto.MentorshipRequestResponse;
import com.bce.mentorshiprequest.entity.MentorshipRequest;
import com.bce.mentorshiprequest.repository.MentorshipRequestRepository;

import com.bce.user.entity.User;
import com.bce.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MentorshipRequestServiceImpl
        implements MentorshipRequestService {

    private final MentorshipRequestRepository requestRepository;

    private final MentorRepository mentorRepository;

    private final UserRepository userRepository;

    @Override
    public MentorshipRequestResponse createRequest(
            MentorshipRequestDto request
    ) {

        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        String email =
                authentication.getName();

        User user =
                userRepository
                        .findByEmail(email)
                        .orElseThrow();

        Mentor mentor =
                mentorRepository
                        .findById(
                                request.getMentorId()
                        )
                        .orElseThrow();

        MentorshipRequest mentorshipRequest =
                MentorshipRequest.builder()
                        .requester(user)
                        .mentor(mentor)
                        .message(
                                request.getMessage()
                        )
                        .build();

        requestRepository.save(
                mentorshipRequest
        );

        return mapToResponse(
                mentorshipRequest
        );
    }

    @Override
    public List<MentorshipRequestResponse>
    getMyRequests() {

        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        String email =
                authentication.getName();

        User user =
                userRepository
                        .findByEmail(email)
                        .orElseThrow();

        return requestRepository
                .findByRequesterId(
                        user.getId()
                )
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public MentorshipRequestResponse approveRequest(
            Long requestId
    ) {

        MentorshipRequest request =
                requestRepository
                        .findById(requestId)
                        .orElseThrow();

        request.setStatus("APPROVED");

        requestRepository.save(request);

        return mapToResponse(request);
    }

    @Override
    public MentorshipRequestResponse rejectRequest(
            Long requestId
    ) {

        MentorshipRequest request =
                requestRepository
                        .findById(requestId)
                        .orElseThrow();

        request.setStatus("REJECTED");

        requestRepository.save(request);

        return mapToResponse(request);
    }

    private MentorshipRequestResponse mapToResponse(
            MentorshipRequest request
    ) {

        return MentorshipRequestResponse
                .builder()
                .id(request.getId())
                .requesterName(
                        request.getRequester()
                                .getFirstName()
                                + " "
                                + request.getRequester()
                                .getLastName()
                )
                .mentorName(
                        request.getMentor()
                                .getName()
                )
                .message(
                        request.getMessage()
                )
                .status(
                        request.getStatus()
                )
                .createdAt(
                        request.getCreatedAt()
                )
                .build();
    }
}