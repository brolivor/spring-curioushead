package com.curioushead.repositories;

import com.curioushead.models.ProfileModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileRepository extends MongoRepository<ProfileModel, String> {
}
