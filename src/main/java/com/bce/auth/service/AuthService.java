package com.bce.auth.service;

import com.bce.auth.dto.AuthResponse;
import com.bce.auth.dto.LoginRequest;
import com.bce.auth.dto.RegisterRequest;
import com.bce.common.enums.Role;
import com.bce.security.JwtService;
import com.bce.user.entity.User;
import com.bce.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;
//    private final EmailService emailService;

    public AuthResponse register(
            RegisterRequest request
    ) {

        if (userRepository.existsByEmail(
                request.getEmail()
        )) {

            throw new RuntimeException(
                    "Email already exists"
            );
        }

        User user = User.builder()
                .firstName(
                        request.getFirstName()
                )
                .lastName(
                        request.getLastName()
                )
                .email(
                        request.getEmail()
                )
                .password(
                        passwordEncoder.encode(
                                request.getPassword()
                        )
                )
                .graduationYear(
                        request.getGraduationYear()
                )
                .branch(
                        request.getBranch()
                )
                .role(Role.ALUMNI)
                .active(true)
                .verified(false)
                .build();

        userRepository.save(user);

        String token =
                jwtService.generateToken(
                        user.getEmail()
                );

        return AuthResponse.builder()
                .token(token)
                .userId(user.getId())
                .firstName(
                        user.getFirstName()
                )
                .email(
                        user.getEmail()
                )
                .role(
                        user.getRole().name()
                )
                .build();
    }

    public AuthResponse login(
            LoginRequest request
    ) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user =
                userRepository
                        .findByEmail(
                                request.getEmail()
                        )
                        .orElseThrow();

        String token =
                jwtService.generateToken(
                        user.getEmail()
                );

        return AuthResponse.builder()
                .token(token)
                .userId(user.getId())
                .firstName(
                        user.getFirstName()
                )
                .email(
                        user.getEmail()
                )
                .role(
                        user.getRole().name()
                )
                .build();
    }


//    public void sendResetOtp(
//            String email
//    ) {
//
//        User user =
//                userRepository
//                        .findByEmail(email)
//                        .orElseThrow(() ->
//                                new RuntimeException(
//                                        "User not found"
//                                ));
//
//        String otp =
//                String.valueOf(
//                        100000 +
//                                new Random()
//                                        .nextInt(900000)
//                );
//
//        user.setResetOtp(
//                otp
//        );
//
//        user.setOtpExpiry(
//                LocalDateTime.now()
//                        .plusMinutes(10)
//        );
//
//        userRepository.save(
//                user
//        );
//
//        emailService.sendOtp(
//                email,
//                otp
//        );
//    }


//    public void verifyResetOtp(
//            String email,
//            String otp
//    ) {
//
//        User user =
//                userRepository
//                        .findByEmail(email)
//                        .orElseThrow(() ->
//                                new RuntimeException(
//                                        "User not found"
//                                ));
//
//        if (
//                user.getResetOtp() == null ||
//                        !user.getResetOtp().equals(otp)
//        ) {
//
//            throw new RuntimeException(
//                    "Invalid OTP"
//            );
//        }
//
//        if (
//                user.getOtpExpiry() == null ||
//                        user.getOtpExpiry()
//                                .isBefore(
//                                        LocalDateTime.now()
//                                )
//        ) {
//
//            throw new RuntimeException(
//                    "OTP expired"
//            );
//        }
//    }



//    public void resetPassword(
//            String email,
//            String otp,
//            String newPassword
//    ) {
//
//        User user =
//                userRepository
//                        .findByEmail(email)
//                        .orElseThrow(() ->
//                                new RuntimeException(
//                                        "User not found"
//                                ));
//
//        if (
//                user.getResetOtp() == null ||
//                        !user.getResetOtp().equals(otp)
//        ) {
//
//            throw new RuntimeException(
//                    "Invalid OTP"
//            );
//        }
//
//        if (
//                user.getOtpExpiry() == null ||
//                        user.getOtpExpiry()
//                                .isBefore(
//                                        LocalDateTime.now()
//                                )
//        ) {
//
//            throw new RuntimeException(
//                    "OTP expired"
//            );
//        }
//
//        user.setPassword(
//                passwordEncoder.encode(
//                        newPassword
//                )
//        );
//
//        user.setResetOtp(
//                null
//        );
//
//        user.setOtpExpiry(
//                null
//        );
//
//        userRepository.save(
//                user
//        );
//    }
}