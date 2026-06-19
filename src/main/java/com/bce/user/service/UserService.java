package com.bce.user.service;

import com.bce.user.dto.ChangePasswordRequest;
import com.bce.user.dto.UpdateProfileRequest;
import com.bce.user.dto.UserProfileResponse;

public interface UserService {

    UserProfileResponse getCurrentUser();

    UserProfileResponse getUserById(Long id);

    UserProfileResponse updateProfile(
            UpdateProfileRequest request
    );
    void changePassword(ChangePasswordRequest request
    );
}