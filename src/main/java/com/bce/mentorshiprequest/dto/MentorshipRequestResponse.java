package com.bce.mentorshiprequest.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MentorshipRequestResponse {

    private Long id;

    private String requesterName;

    private String mentorName;

    private String message;

    private String status;

    private LocalDateTime createdAt;
}