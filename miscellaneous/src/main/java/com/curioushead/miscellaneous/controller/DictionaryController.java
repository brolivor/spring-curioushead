package com.curioushead.miscellaneous.controller;

import java.util.List;
import java.util.Objects;

import com.curioushead.miscellaneous.model.Dictionary;
import com.curioushead.miscellaneous.service.DictionaryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("/definitions")
    public List<Dictionary> fetchDictionaryList() {
        return dictionaryService.fetchDictionaryList();
    }

    @PostMapping("/add-keyword")
    public Object saveDictionary(@Valid @RequestBody Dictionary dictionary){
        if (Objects.nonNull(dictionary.getKeyword())
                && !"".equalsIgnoreCase(dictionary.getKeyword())) {
            return dictionaryService.saveDictionary(dictionary);
        } else
            return "Keyword or Definition cannot be empty/null";
    }
}
