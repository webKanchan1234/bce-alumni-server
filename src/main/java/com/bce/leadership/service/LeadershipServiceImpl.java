package com.bce.leadership.service.impl;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.bce.leadership.dto.*;
import com.bce.leadership.entity.Leadership;
import com.bce.leadership.repository.LeadershipRepository;
import com.bce.leadership.service.LeadershipService;

@Service
@RequiredArgsConstructor
public class LeadershipServiceImpl
        implements LeadershipService {

    private final LeadershipRepository repository;

    @Override
    public LeadershipResponse create(
            LeadershipRequest request) {

        Leadership leadership =
                Leadership.builder()
                        .name(request.getName())
                        .role(request.getRole())
                        .company(request.getCompany())
                        .image(request.getImage())
                        .bio(request.getBio())
                        .linkedinUrl(
                                request.getLinkedinUrl())
                        .displayOrder(
                                request.getDisplayOrder())
                        .active(request.getActive())
                        .build();

        return map(
                repository.save(leadership));
    }

    @Override
    public LeadershipResponse update(
            Long id,
            LeadershipRequest request) {

        Leadership leadership =
                repository.findById(id)
                        .orElseThrow();

        leadership.setName(
                request.getName());

        leadership.setRole(
                request.getRole());

        leadership.setCompany(
                request.getCompany());

        leadership.setImage(
                request.getImage());

        leadership.setBio(
                request.getBio());

        leadership.setLinkedinUrl(
                request.getLinkedinUrl());

        leadership.setDisplayOrder(
                request.getDisplayOrder());

        leadership.setActive(
                request.getActive());

        return map(
                repository.save(leadership));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public LeadershipResponse getById(
            Long id) {

        return map(
                repository.findById(id)
                        .orElseThrow());
    }

    @Override
    public List<LeadershipResponse> getAll() {

        return repository.findAll()
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<LeadershipResponse>
    getPublicLeadership() {

        return repository
                .findByActiveTrueOrderByDisplayOrderAsc()
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    private LeadershipResponse map(
            Leadership leadership) {

        return LeadershipResponse
                .builder()
                .id(leadership.getId())
                .name(leadership.getName())
                .role(leadership.getRole())
                .company(
                        leadership.getCompany())
                .image(
                        leadership.getImage())
                .bio(
                        leadership.getBio())
                .linkedinUrl(
                        leadership.getLinkedinUrl())
                .displayOrder(
                        leadership.getDisplayOrder())
                .active(
                        leadership.getActive())
                .build();
    }
}