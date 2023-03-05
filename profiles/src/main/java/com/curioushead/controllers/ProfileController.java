package com.curioushead.controllers;

import com.curioushead.records.ProfileRegistrationRequest;
import com.curioushead.services.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/data-view-service")
public record ProfileController(ProfileService profileService) {
    @PostMapping
    public String registerProfile(@RequestBody ProfileRegistrationRequest profileRegistrationRequest) {
        String service;
        log.info("New profile registration {}", profileRegistrationRequest);
        service = profileService.registerProfile(profileRegistrationRequest);
        return service;
    }
}
