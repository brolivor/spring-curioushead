package com.curioushead.miscellaneous.service;

import com.curioushead.miscellaneous.model.Dictionary;
import com.curioushead.miscellaneous.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Override
    public Dictionary saveDictionary(Dictionary dictionary) {
        return dictionaryRepository.save(dictionary);
    }

    @Override
    public List<Dictionary> fetchDictionaryList() {
        return dictionaryRepository.findAll();
    }

    @Override
    public Dictionary updateDictionary(Dictionary dictionary, Integer id) {
        Dictionary dictionaryDB = dictionaryRepository.findById(id).orElse(null);

        if (Objects.nonNull(dictionary.getKeyword())
                && !"".equalsIgnoreCase(dictionary.getKeyword())) {
            dictionaryDB.setKeyword(dictionary.getKeyword());
        }
        if (Objects.nonNull(dictionary.getDefinition())
                && !"".equalsIgnoreCase(dictionary.getDefinition())) {
            dictionaryDB.setKeyword(dictionary.getDefinition());
        }
        return dictionaryRepository.save(dictionaryDB);
    }

    @Override
    public void deleteDictionary(Integer id) {
        dictionaryRepository.deleteById(id);
    }
}
