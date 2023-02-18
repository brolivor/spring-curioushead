package com.curioushead.model;

import lombok.Getter;
import lombok.Setter;

public class RawDataViewModel {
    @Getter
    @Setter
    private Integer id;

    public RawDataViewModel(Integer id) {
        super();
        this.id = id;
    }
}
