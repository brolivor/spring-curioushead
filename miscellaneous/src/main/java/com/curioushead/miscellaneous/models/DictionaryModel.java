package com.curioushead.miscellaneous.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "dictionary")
public class DictionaryModel {
    @Id
    @Column
    private String keyword;
    @Column
    private String definition;
}
