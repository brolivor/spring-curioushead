package com.curioushead.profiles.repositories;

import com.curioushead.profiles.models.ProfileModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileRepository extends MongoRepository<ProfileModel, String> {
}
