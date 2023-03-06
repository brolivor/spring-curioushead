package com.curioushead.miscellaneous.service;

import com.curioushead.miscellaneous.model.Dictionary;

import java.util.List;

public interface DictionaryService {

    Dictionary saveDictionary(Dictionary dictionary);
    List<Dictionary> fetchDictionaryList();
    Dictionary updateDictionary(Dictionary dictionary, Integer id);

    void deleteDictionary(Integer id);
}
