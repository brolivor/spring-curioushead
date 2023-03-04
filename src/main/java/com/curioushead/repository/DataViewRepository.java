package com.curioushead.repository;

import com.curioushead.model.DataViewModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DataViewRepository extends MongoRepository<DataViewModel, String> {

}
