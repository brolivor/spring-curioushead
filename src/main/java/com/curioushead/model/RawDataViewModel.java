package com.curioushead.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter
@Setter
@Document(collection = "profile_configuration")
public class RawDataViewModel {

    @Id
    String id;
    String name;
    String schema;
}
