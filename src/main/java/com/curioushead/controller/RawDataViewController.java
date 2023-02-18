package com.curioushead.controller;

import com.curioushead.model.RawDataViewModel;
import com.curioushead.repository.DataViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RawDataViewController {
    private final DataViewRepository dataViewRepository;
    @Autowired
    public RawDataViewController(DataViewRepository dataViewRepository) {
        this.dataViewRepository = dataViewRepository;
    }

    @PostMapping(value = "/raw-data-view")
    public String addUser(@RequestBody RawDataViewModel dataViewModel){
        dataViewRepository.save(dataViewModel);
        return "Data View created Successfully!!!";
    }
}
