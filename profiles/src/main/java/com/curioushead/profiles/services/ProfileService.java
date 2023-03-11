package com.curioushead.profiles.services;

import com.curioushead.profiles.models.ProfileModel;
import com.curioushead.profiles.records.ProfileRegistrationRequest;
import com.curioushead.profiles.repositories.ProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public record ProfileService(ProfileRepository profileRepository) {
    public static final String INVALID = "Profile already exists!!!";
    public String registerProfile(ProfileRegistrationRequest profileRegistrationRequest) {
        ProfileModel profileModel = ProfileModel.builder()
                .name(profileRegistrationRequest.name())
                .schema(profileRegistrationRequest.schema()).build();
        try {
            profileRepository.save(profileModel);
        } catch (DataIntegrityViolationException e) {
            return INVALID;
        }
        return profileModel.getName();
    }
}
