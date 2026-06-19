package com.bce.jobs.controller;

import com.bce.jobs.dto.JobRequest;
import com.bce.jobs.dto.JobResponse;
import com.bce.jobs.service.JobService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    /*
     * Create Job
     */

    @PostMapping("/api/admin/jobs")
    @PreAuthorize("hasRole('ADMIN')")
    public JobResponse createJob(
            @RequestBody JobRequest request
    ) {

        return jobService.createJob(request);
    }

    /*
     * Get All Jobs
     */

    @GetMapping("/api/jobs")
    public List<JobResponse> getAllJobs() {

        return jobService.getAllJobs();
    }

    /*
     * Get Job By Id
     */

    @GetMapping("/api/jobs/{id}")
    public JobResponse getJobById(
            @PathVariable Long id
    ) {

        return jobService.getJobById(id);
    }

    /*
     * Get Active Jobs
     */

    @GetMapping("/api/jobs/active")
    public List<JobResponse> getActiveJobs() {

        return jobService.getActiveJobs();
    }

    /*
     * Update Job
     */

    @PutMapping("/api/admin/jobs/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public JobResponse updateJob(
            @PathVariable Long id,
            @RequestBody JobRequest request
    ) {

        return jobService.updateJob(
                id,
                request
        );
    }

    /*
     * Delete Job
     */

    @DeleteMapping("/api/admin/jobs/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteJob(
            @PathVariable Long id
    ) {

        jobService.deleteJob(id);
    }
}