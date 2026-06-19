package com.bce.auth.controller;

import com.bce.auth.dto.*;
import com.bce.auth.service.AuthService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor

@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(
            @Valid
            @RequestBody
            RegisterRequest request
    ) {

        return authService.register(
                request
        );
    }

    @PostMapping("/login")
    public AuthResponse login(
            @Valid
            @RequestBody
            LoginRequest request
    ) {

        return authService.login(
                request
        );
    }


//    @PostMapping("/forgot-password")
//    public ResponseEntity<?> forgotPassword(
//            @RequestBody
//            ForgotPasswordRequest request
//    ) {
//
//        authService.sendResetOtp(
//                request.getEmail()
//        );
//
//        return ResponseEntity.ok(
//                Map.of(
//                        "message",
//                        "OTP sent successfully"
//                )
//        );
//    }
//
//
//    @PostMapping("/verify-reset-otp")
//    public ResponseEntity<?> verifyOtp(
//            @RequestBody
//            VerifyOtpRequest request
//    ) {
//
//        authService.verifyResetOtp(
//                request.getEmail(),
//                request.getOtp()
//        );
//
//        return ResponseEntity.ok(
//                Map.of(
//                        "message",
//                        "OTP verified"
//                )
//        );
//    }
//
//
//    @PostMapping("/reset-password")
//    public ResponseEntity<?> resetPassword(
//            @RequestBody
//            ResetPasswordRequest request
//    ) {
//
//        authService.resetPassword(
//                request.getEmail(),
//                request.getOtp(),
//                request.getNewPassword()
//        );
//
//        return ResponseEntity.ok(
//                Map.of(
//                        "message",
//                        "Password reset successful"
//                )
//        );
//    }

}