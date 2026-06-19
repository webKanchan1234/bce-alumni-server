package com.bce.event.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventResponse {

    private Long id;

    private String title;

    private String description;

    private String location;

    private LocalDate eventDate;
    private LocalTime eventTime;

    private String imageUrl;

    private String registrationLink;

    private Boolean featured;
}