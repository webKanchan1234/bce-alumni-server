package com.bce.admin.service;

import com.bce.admin.dto.DashboardStatsResponse;
import com.bce.alumni.dto.PublicAlumniDto;

import java.util.List;

public interface AdminDashboardService {

    DashboardStatsResponse getDashboardStats();

    List<PublicAlumniDto> getAllAlumniForAdmin();
}