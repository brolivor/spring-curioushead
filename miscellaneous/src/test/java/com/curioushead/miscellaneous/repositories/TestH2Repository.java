package com.curioushead.miscellaneous.repositories;

import com.curioushead.miscellaneous.models.DictionaryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface TestH2Repository extends JpaRepository<DictionaryModel, String> {
    @Query
            ("" +
            "SELECT CASE WHEN COUNT(d) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM DictionaryModel d " +
                    "WHERE d.keyword = ?1"
            )
    Boolean checkIfDictionaryExists(String keyword);
}
