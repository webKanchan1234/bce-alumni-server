package com.bce.eventregistration.service;

import com.bce.event.entity.Event;
import com.bce.event.repository.EventRepository;

import com.bce.eventregistration.dto.EventRegistrationResponse;
import com.bce.eventregistration.entity.EventRegistration;
import com.bce.eventregistration.repository.EventRegistrationRepository;

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
public class EventRegistrationServiceImpl
        implements EventRegistrationService {

    private final EventRegistrationRepository registrationRepository;

    private final EventRepository eventRepository;

    private final UserRepository userRepository;

    @Override
    public EventRegistrationResponse registerForEvent(
            Long eventId
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

        Event event =
                eventRepository
                        .findById(eventId)
                        .orElseThrow();

        boolean alreadyRegistered =
                registrationRepository
                        .existsByUserIdAndEventId(
                                user.getId(),
                                eventId
                        );

        if (alreadyRegistered) {
            throw new RuntimeException(
                    "Already registered for this event"
            );
        }

        EventRegistration registration =
                EventRegistration.builder()
                        .user(user)
                        .event(event)
                        .build();

        registrationRepository.save(registration);

        return mapToResponse(registration);
    }

    @Override
    public List<EventRegistrationResponse>
    getMyRegistrations() {

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

        return registrationRepository
                .findByUserId(user.getId())
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<EventRegistrationResponse>
    getEventRegistrations(
            Long eventId
    ) {

        return registrationRepository
                .findByEventId(eventId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private EventRegistrationResponse mapToResponse(
            EventRegistration registration
    ) {

        return EventRegistrationResponse
                .builder()
                .registrationId(
                        registration.getId()
                )
                .eventId(
                        registration.getEvent().getId()
                )
                .eventTitle(
                        registration
                                .getEvent()
                                .getTitle()
                )
                .userName(
                        registration
                                .getUser()
                                .getFirstName()
                                + " "
                                + registration
                                .getUser()
                                .getLastName()
                )
                .registeredAt(
                        registration.getRegisteredAt()
                )
                .build();
    }
}