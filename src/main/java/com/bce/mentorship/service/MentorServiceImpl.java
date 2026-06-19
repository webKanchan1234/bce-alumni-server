package com.bce.mentorship.service;

import com.bce.mentorship.dto.MentorRequest;
import com.bce.mentorship.dto.MentorResponse;
import com.bce.mentorship.entity.Mentor;
import com.bce.mentorship.repository.MentorRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MentorServiceImpl
        implements MentorService {

    private final MentorRepository mentorRepository;

    @Override
    public MentorResponse createMentor(
            MentorRequest request
    ) {

        Mentor mentor = Mentor.builder()
                .name(request.getName())
                .company(request.getCompany())
                .designation(request.getDesignation())
                .expertise(request.getExpertise())
                .experienceYears(
                        request.getExperienceYears()
                )
                .bio(request.getBio())
                .profileImage(
                        request.getProfileImage()
                )
                .linkedinUrl(
                        request.getLinkedinUrl()
                )
                .available(
                        request.getAvailable()
                )
                .build();

        mentorRepository.save(mentor);

        return mapToResponse(mentor);
    }

    @Override
    public List<MentorResponse> getAllMentors() {

        return mentorRepository
                .findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public MentorResponse getMentorById(
            Long id
    ) {

        Mentor mentor =
                mentorRepository
                        .findById(id)
                        .orElseThrow();

        return mapToResponse(mentor);
    }

    @Override
    public List<MentorResponse> getAvailableMentors() {

        return mentorRepository
                .findByAvailableTrue()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public MentorResponse updateMentor(
            Long id,
            MentorRequest request
    ) {

        Mentor mentor =
                mentorRepository
                        .findById(id)
                        .orElseThrow();

        mentor.setName(request.getName());
        mentor.setCompany(request.getCompany());
        mentor.setDesignation(
                request.getDesignation()
        );
        mentor.setExpertise(
                request.getExpertise()
        );
        mentor.setExperienceYears(
                request.getExperienceYears()
        );
        mentor.setBio(request.getBio());
        mentor.setProfileImage(
                request.getProfileImage()
        );
        mentor.setLinkedinUrl(
                request.getLinkedinUrl()
        );
        mentor.setAvailable(
                request.getAvailable()
        );

        mentorRepository.save(mentor);

        return mapToResponse(mentor);
    }

    @Override
    public void deleteMentor(
            Long id
    ) {

        mentorRepository.deleteById(id);
    }

    private MentorResponse mapToResponse(
            Mentor mentor
    ) {

        return MentorResponse.builder()
                .id(mentor.getId())
                .name(mentor.getName())
                .company(mentor.getCompany())
                .designation(
                        mentor.getDesignation()
                )
                .expertise(
                        mentor.getExpertise()
                )
                .experienceYears(
                        mentor.getExperienceYears()
                )
                .bio(mentor.getBio())
                .profileImage(
                        mentor.getProfileImage()
                )
                .linkedinUrl(
                        mentor.getLinkedinUrl()
                )
                .available(
                        mentor.getAvailable()
                )
                .build();
    }
}