package com.curioushead.miscellaneous.repositories;

import com.curioushead.miscellaneous.models.DictionaryModel;
import com.curioushead.miscellaneous.records.AddKeywordRequest;
import org.apache.commons.lang3.BooleanUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class DictionaryRepositoryTest {
    @Autowired
    private TestH2Repository testH2Repository;

    @Test
    void checkIfDictionaryExists() {
        AddKeywordRequest addKeywordRequest = new AddKeywordRequest("test", "this is definition");
        DictionaryModel dictionaryModel = new DictionaryModel();
        dictionaryModel.setKeyword(addKeywordRequest.keyword());
        dictionaryModel.setDefinition(addKeywordRequest.definition());
        testH2Repository.save(dictionaryModel);

        boolean expected = testH2Repository.checkIfDictionaryExists(addKeywordRequest.keyword());
        assertEquals(BooleanUtils.isTrue(Boolean.TRUE), expected);
    }
}