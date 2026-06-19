package com.bce.mentorship.controller;

import com.bce.mentorship.dto.MentorRequest;
import com.bce.mentorship.dto.MentorResponse;
import com.bce.mentorship.service.MentorService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MentorController {

    private final MentorService mentorService;

    /*
     * Create Mentor
     */

    @PostMapping("/api/admin/mentors")
    @PreAuthorize("hasRole('ADMIN')")
    public MentorResponse createMentor(
            @RequestBody MentorRequest request
    ) {

        return mentorService.createMentor(
                request
        );
    }

    /*
     * Get All Mentors
     */

    @GetMapping("/api/mentors")
    public List<MentorResponse> getAllMentors() {

        return mentorService.getAllMentors();
    }

    /*
     * Get Mentor By Id
     */

    @GetMapping("/api/mentors/{id}")
    public MentorResponse getMentorById(
            @PathVariable Long id
    ) {

        return mentorService.getMentorById(id);
    }

    /*
     * Get Available Mentors
     */

    @GetMapping("/api/mentors/available")
    public List<MentorResponse> getAvailableMentors() {

        return mentorService.getAvailableMentors();
    }

    /*
     * Update Mentor
     */

    @PutMapping("/api/admin/mentors/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public MentorResponse updateMentor(
            @PathVariable Long id,
            @RequestBody MentorRequest request
    ) {

        return mentorService.updateMentor(
                id,
                request
        );
    }

    /*
     * Delete Mentor
     */

    @DeleteMapping("/api/admin/mentors/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteMentor(
            @PathVariable Long id
    ) {

        mentorService.deleteMentor(id);
    }
}