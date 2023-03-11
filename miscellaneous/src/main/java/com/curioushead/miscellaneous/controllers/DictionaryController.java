package com.curioushead.miscellaneous.controllers;

import com.curioushead.miscellaneous.AddKeywordRequest;
import com.curioushead.miscellaneous.models.DictionaryModel;
import com.curioushead.miscellaneous.repositories.DictionaryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class DictionaryController {
    @Autowired
    private DictionaryRepository dictionaryRepository;

    @PostMapping(path = "/add-keyword")
    @ExceptionHandler(DataIntegrityViolationException.class)
    public String addDefinition(@RequestBody AddKeywordRequest addKeywordRequest) {
        final String VALID = "Definition Created";
        final String INVALID = "Definition already exists";
        DictionaryModel dictionaryModel = new DictionaryModel();
        dictionaryModel.setKeyword(addKeywordRequest.keyword());
        dictionaryModel.setDefinition(addKeywordRequest.definition());

        if (dictionaryRepository.findById(addKeywordRequest.keyword()).isEmpty()) {

            try {
                dictionaryRepository.save(dictionaryModel);
                log.info("New keyword registration {}", addKeywordRequest);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                throw e;
            }
            return VALID;
        } else {
            return INVALID;
        }
    }

    @GetMapping(path = "/definitions")
    public @ResponseBody Iterable<DictionaryModel> getAllDefinitions() {
        return dictionaryRepository.findAll();
    }
}
