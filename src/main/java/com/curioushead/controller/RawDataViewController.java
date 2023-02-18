package com.curioushead.controller;

import com.curioushead.repository.RawDataViewDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RawDataViewController {
    @Autowired
    RawDataViewDAO dataViewDAO;

    @GetMapping(path="/raw-data-view", produces="application/json")
    public int getDataViewModel() {
        return dataViewDAO.getDataView();
    }
}
