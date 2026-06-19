package com.bce.event.controller;

import com.bce.event.dto.EventRequest;
import com.bce.event.dto.EventResponse;
import com.bce.event.service.EventService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    /*
     * Create Event
     */

    @PostMapping("/api/admin/events")
    @PreAuthorize("hasRole('ADMIN')")
    public EventResponse createEvent(
            @RequestBody EventRequest request
    ) {

        return eventService.createEvent(
                request
        );
    }

    /*
     * Get All Events
     */

    @GetMapping("/api/events")
    public List<EventResponse> getAllEvents() {

        return eventService.getAllEvents();
    }

    /*
     * Get Event By Id
     */

    @GetMapping("/api/events/{id}")
    public EventResponse getEventById(
            @PathVariable Long id
    ) {

        return eventService.getEventById(id);
    }

    /*
     * Get Featured Events
     */

    @GetMapping("/api/events/featured")
    public List<EventResponse> getFeaturedEvents() {

        return eventService.getFeaturedEvents();
    }

    /*
     * Update Event
     */

    @PutMapping("/api/admin/events/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public EventResponse updateEvent(
            @PathVariable Long id,
            @RequestBody EventRequest request
    ) {

        return eventService.updateEvent(
                id,
                request
        );
    }

    /*
     * Delete Event
     */

    @DeleteMapping("/api/admin/events/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteEvent(
            @PathVariable Long id
    ) {

        eventService.deleteEvent(id);
    }
}