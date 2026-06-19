package com.bce.eventregistration.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventRegistrationResponse {

    private Long registrationId;

    private Long eventId;

    private String eventTitle;

    private String userName;

    private LocalDateTime registeredAt;
}