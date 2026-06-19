package com.bce.analytics.controller;

import com.bce.analytics.dto.AnalyticsResponse;
import com.bce.analytics.service.AnalyticsService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    @GetMapping("/analytics")
    public AnalyticsResponse analytics() {

        return analyticsService.getAnalytics();
    }
}