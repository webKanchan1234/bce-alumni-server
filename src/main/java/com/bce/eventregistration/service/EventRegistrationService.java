package com.bce.eventregistration.service;

import com.bce.eventregistration.dto.EventRegistrationResponse;

import java.util.List;

public interface EventRegistrationService {

    EventRegistrationResponse registerForEvent(
            Long eventId
    );

    List<EventRegistrationResponse> getMyRegistrations();

    List<EventRegistrationResponse> getEventRegistrations(
            Long eventId
    );
}