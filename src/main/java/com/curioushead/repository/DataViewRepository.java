package com.curioushead.repository;

import com.curioushead.model.RawDataViewModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DataViewRepository extends MongoRepository<RawDataViewModel, String> {

}
