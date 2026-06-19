package com.bce.leadership.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import com.bce.leadership.dto.*;
import com.bce.leadership.service.LeadershipService;

@RestController
@RequestMapping("/api/leadership")
@RequiredArgsConstructor
@CrossOrigin("*")
public class LeadershipController {

    private final LeadershipService service;

    @PostMapping
    public LeadershipResponse create(
            @RequestBody
            LeadershipRequest request) {

        return service.create(request);
    }

    @PutMapping("/{id}")
    public LeadershipResponse update(
            @PathVariable Long id,
            @RequestBody LeadershipRequest request) {

        return service.update(
                id,
                request);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id) {

        service.delete(id);
    }

    @GetMapping("/{id}")
    public LeadershipResponse getById(
            @PathVariable Long id) {

        return service.getById(id);
    }

    @GetMapping("/admin")
    public List<LeadershipResponse> getAll() {

        return service.getAll();
    }

    @GetMapping
    public List<LeadershipResponse>
    getPublicLeadership() {

        return service.getPublicLeadership();
    }
}