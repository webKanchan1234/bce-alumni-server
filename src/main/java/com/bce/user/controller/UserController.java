package com.bce.user.controller;

import com.bce.user.dto.ChangePasswordRequest;
import com.bce.user.dto.UpdateProfileRequest;
import com.bce.user.dto.UserProfileResponse;
import com.bce.user.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public UserProfileResponse me() {

        return userService.getCurrentUser();
    }

    @GetMapping("/{id}")
    public UserProfileResponse getUser(
            @PathVariable Long id
    ) {

        return userService.getUserById(id);
    }

    @PutMapping("/profile")
    public UserProfileResponse updateProfile(
            @RequestBody
            UpdateProfileRequest request
    ) {

        return userService.updateProfile(
                request
        );
    }

    @PutMapping("/change-password")
    public ResponseEntity<?> changePassword(
            @RequestBody
            ChangePasswordRequest request
    ) {

        userService.changePassword(
                request
        );

        return ResponseEntity.ok(
                Map.of(
                        "message",
                        "Password updated successfully"
                )
        );
    }

//    @PostMapping("/forgot-password")
//    public ResponseEntity<?> forgotPassword(
//            @RequestBody ForgotPasswordRequest request
//    ) {
//
//        authService.sendResetOtp(
//                request.getEmail()
//        );
//
//        return ResponseEntity.ok(
//                "OTP sent successfully"
//        );
//    }


//    @PostMapping("/verify-reset-otp")
//    public ResponseEntity<?> verifyOtp(
//            @RequestBody VerifyOtpRequest request
//    ) {
//
//        authService.verifyResetOtp(
//                request.getEmail(),
//                request.getOtp()
//        );
//
//        return ResponseEntity.ok(
//                "OTP verified"
//        );
//    }



//    @PostMapping("/reset-password")
//    public ResponseEntity<?> resetPassword(
//            @RequestBody ResetPasswordRequest request
//    ) {
//
//        authService.resetPassword(
//                request.getEmail(),
//                request.getOtp(),
//                request.getNewPassword()
//        );
//
//        return ResponseEntity.ok(
//                "Password reset successful"
//        );
//    }
}