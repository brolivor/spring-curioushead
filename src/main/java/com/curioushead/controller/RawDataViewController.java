package com.curioushead.controller;

import com.curioushead.model.RawDataViewModel;
import com.curioushead.repository.DataViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

@RestController
public class RawDataViewController {
    private final DataViewRepository dataViewRepository;

    final String INVALID = "Invalid property!!!";
    final String EXISTS = "Data View already exists!!!";
    final String VALID = "Data View created Successfully!!!";

    @Autowired
    public RawDataViewController(DataViewRepository dataViewRepository) {
        this.dataViewRepository = dataViewRepository;
    }

    @GetMapping(value = "/data-view-service")
    public Optional<RawDataViewModel> getRawDataView(@RequestBody RawDataViewModel dataViewModel) {
        return dataViewRepository.findById(dataViewModel.getName());
    }

    @PostMapping(value = "/data-view-service")
    public String addRawDataView(@RequestBody RawDataViewModel dataViewModel) {

        if (dataViewRepository.existsById(dataViewModel.getName())) {
            return EXISTS;
        }
        if (StringUtils.isNotEmpty(dataViewModel.getSchema())) {
            dataViewRepository.save(dataViewModel);
            return VALID;
        } else {
            return INVALID;
        }
    }
}
