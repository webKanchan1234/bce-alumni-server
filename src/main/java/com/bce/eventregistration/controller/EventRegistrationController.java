package com.bce.eventregistration.controller;

import com.bce.eventregistration.dto.EventRegistrationResponse;
import com.bce.eventregistration.service.EventRegistrationService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventRegistrationController {

    private final EventRegistrationService
            eventRegistrationService;

    /*
     * Register For Event
     */

    @PostMapping(
            "/api/events/{eventId}/register"
    )
    public EventRegistrationResponse registerForEvent(
            @PathVariable Long eventId
    ) {

        return eventRegistrationService
                .registerForEvent(eventId);
    }

    /*
     * My Registrations
     */

    @GetMapping(
            "/api/my/event-registrations"
    )
    public List<EventRegistrationResponse>
    getMyRegistrations() {

        return eventRegistrationService
                .getMyRegistrations();
    }

    /*
     * Admin Event Registrations
     */

    @GetMapping(
            "/api/admin/events/{eventId}/registrations"
    )
    public List<EventRegistrationResponse>
    getEventRegistrations(
            @PathVariable Long eventId
    ) {

        return eventRegistrationService
                .getEventRegistrations(eventId);
    }
}