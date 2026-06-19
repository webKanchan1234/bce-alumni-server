package com.bce.event.service;

import com.bce.event.dto.EventRequest;
import com.bce.event.dto.EventResponse;
import com.bce.event.entity.Event;
import com.bce.event.repository.EventRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventServiceImpl
        implements EventService {

    private final EventRepository eventRepository;

    @Override
    public EventResponse createEvent(
            EventRequest request
    ) {

        Event event = Event.builder()
                .title(
                        request.getTitle()
                )
                .description(
                        request.getDescription()
                )
                .location(
                        request.getLocation()
                )
                .eventDate(
                        request.getEventDate()
                )
                .eventTime(
                        request.getEventTime()
                )
                .imageUrl(
                        request.getImageUrl()
                )
                .registrationLink(
                        request.getRegistrationLink()
                )
                .featured(
                        request.getFeatured()
                )
                .build();

        eventRepository.save(event);

        return mapToResponse(event);
    }

    @Override
    public List<EventResponse> getAllEvents() {

        return eventRepository
                .findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EventResponse getEventById(
            Long id
    ) {

        Event event =
                eventRepository
                        .findById(id)
                        .orElseThrow();

        return mapToResponse(event);
    }

    @Override
    public List<EventResponse> getFeaturedEvents() {

        return eventRepository
                .findByFeaturedTrue()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EventResponse updateEvent(
            Long id,
            EventRequest request
    ) {

        Event event =
                eventRepository
                        .findById(id)
                        .orElseThrow();

        event.setTitle(
                request.getTitle()
        );

        event.setDescription(
                request.getDescription()
        );

        event.setLocation(
                request.getLocation()
        );

        event.setEventDate(
                request.getEventDate()
        );
        event.setEventTime(
                request.getEventTime()
        );

        event.setImageUrl(
                request.getImageUrl()
        );

        event.setRegistrationLink(
                request.getRegistrationLink()
        );

        event.setFeatured(
                request.getFeatured()
        );

        eventRepository.save(event);

        return mapToResponse(event);
    }

    @Override
    public void deleteEvent(
            Long id
    ) {

        eventRepository.deleteById(id);
    }

    private EventResponse mapToResponse(
            Event event
    ) {

        return EventResponse.builder()
                .id(event.getId())
                .title(event.getTitle())
                .description(
                        event.getDescription()
                )
                .location(
                        event.getLocation()
                )
                .eventDate(
                        event.getEventDate()
                )
                .eventTime(
                        event.getEventTime()
                )
                .imageUrl(
                        event.getImageUrl()
                )
                .registrationLink(
                        event.getRegistrationLink()
                )
                .featured(
                        event.getFeatured()
                )
                .build();
    }
}