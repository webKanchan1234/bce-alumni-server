package com.bce.jobs.service;

import com.bce.jobs.dto.JobRequest;
import com.bce.jobs.dto.JobResponse;

import java.util.List;

public interface JobService {

    JobResponse createJob(JobRequest request);

    List<JobResponse> getAllJobs();

    JobResponse getJobById(Long id);

    List<JobResponse> getActiveJobs();

    JobResponse updateJob(
            Long id,
            JobRequest request
    );

    void deleteJob(Long id);
}