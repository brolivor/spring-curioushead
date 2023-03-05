package com.curioushead.controllers;

import com.curioushead.models.ProfileModel;
import com.curioushead.records.ProfileRegistrationRequest;
import com.curioushead.services.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public record ProfileController(ProfileService profileService) {

    @PostMapping("/data-view-service")
    public String registerProfile(@RequestBody ProfileRegistrationRequest profileRegistrationRequest) {
        String service;
        log.info("New profile registration {}", profileRegistrationRequest);
        service = profileService.registerProfile(profileRegistrationRequest);
        return service;
    }

    @GetMapping(value = "/data-view-service")
    public ResponseEntity<List<ProfileModel>> getAll() {
        return new ResponseEntity<>(profileService.profileRepository().findAll(), HttpStatus.OK);
    }
}
