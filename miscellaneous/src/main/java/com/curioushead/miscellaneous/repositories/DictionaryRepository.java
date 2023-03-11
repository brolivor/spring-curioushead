package com.curioushead.miscellaneous.repositories;

import com.curioushead.miscellaneous.models.DictionaryModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DictionaryRepository extends CrudRepository<DictionaryModel, String> {
}
