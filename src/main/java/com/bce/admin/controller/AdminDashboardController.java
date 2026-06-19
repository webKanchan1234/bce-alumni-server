package com.bce.admin.controller;

import com.bce.admin.dto.DashboardStatsResponse;
import com.bce.admin.service.AdminDashboardService;

import com.bce.alumni.dto.PublicAlumniDto;

import com.bce.user.entity.User;
import com.bce.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminDashboardController {

    private final AdminDashboardService adminDashboardService;

    private final UserRepository userRepository;

    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('ADMIN')")
    public DashboardStatsResponse getDashboardStats() {

        return adminDashboardService
                .getDashboardStats();
    }

    @GetMapping("/alumni")
    public List<PublicAlumniDto> getAllAlumni() {

        return adminDashboardService
                .getAllAlumniForAdmin();
    }

    @PutMapping("/alumni/{id}/toggle-status")
    public String toggleStatus(
            @PathVariable Long id
    ) {

        User user =
                userRepository
                        .findById(id)
                        .orElseThrow();

        user.setVerified(
                !Boolean.TRUE.equals(
                        user.getVerified()
                )
        );

        userRepository.save(user);

        return Boolean.TRUE.equals(
                user.getVerified()
        )
                ? "Approved"
                : "Rejected";
    }
}