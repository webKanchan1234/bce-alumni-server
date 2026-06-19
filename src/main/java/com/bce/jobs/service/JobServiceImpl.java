package com.bce.jobs.service;

import com.bce.jobs.dto.JobRequest;
import com.bce.jobs.dto.JobResponse;
import com.bce.jobs.entity.Job;
import com.bce.jobs.repository.JobRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobServiceImpl
        implements JobService {

    private final JobRepository jobRepository;

    @Override
    public JobResponse createJob(
            JobRequest request
    ) {

        Job job = Job.builder()
                .company(request.getCompany())
                .title(request.getTitle())
                .location(request.getLocation())
                .experience(request.getExperience())
                .salary(request.getSalary())
                .description(request.getDescription())
                .applyLink(request.getApplyLink())
                .postedBy(request.getPostedBy())
                .active(request.getActive())
                .build();

        jobRepository.save(job);

        return mapToResponse(job);
    }

    @Override
    public List<JobResponse> getAllJobs() {

        return jobRepository
                .findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public JobResponse getJobById(
            Long id
    ) {

        Job job =
                jobRepository
                        .findById(id)
                        .orElseThrow();

        return mapToResponse(job);
    }

    @Override
    public List<JobResponse> getActiveJobs() {

        return jobRepository
                .findByActiveTrue()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public JobResponse updateJob(
            Long id,
            JobRequest request
    ) {

        Job job =
                jobRepository
                        .findById(id)
                        .orElseThrow();

        job.setCompany(request.getCompany());
        job.setTitle(request.getTitle());
        job.setLocation(request.getLocation());
        job.setExperience(request.getExperience());
        job.setSalary(request.getSalary());
        job.setDescription(request.getDescription());
        job.setApplyLink(request.getApplyLink());
        job.setPostedBy(request.getPostedBy());
        job.setActive(request.getActive());

        jobRepository.save(job);

        return mapToResponse(job);
    }

    @Override
    public void deleteJob(
            Long id
    ) {

        jobRepository.deleteById(id);
    }

    private JobResponse mapToResponse(
            Job job
    ) {

        return JobResponse.builder()
                .id(job.getId())
                .company(job.getCompany())
                .title(job.getTitle())
                .location(job.getLocation())
                .experience(job.getExperience())
                .salary(job.getSalary())
                .description(job.getDescription())
                .applyLink(job.getApplyLink())
                .postedBy(job.getPostedBy())
                .active(job.getActive())
                .createdAt(job.getCreatedAt())
                .build();
    }
}