package com.bce.leadership.service;

import java.util.List;

import com.bce.leadership.dto.*;

public interface LeadershipService {

    LeadershipResponse create(
            LeadershipRequest request);

    LeadershipResponse update(
            Long id,
            LeadershipRequest request);

    void delete(Long id);

    LeadershipResponse getById(Long id);

    List<LeadershipResponse> getAll();

    List<LeadershipResponse> getPublicLeadership();
}