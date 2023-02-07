package com.curioushead;

import lombok.Data;
@Data
public class Address {
    private String country;
    private String state;
    private String city;
    private String suburb;
    private String postCode;

    public Address(String country, String state, String city, String suburb, String postCode) {
        this.country = country;
        this.state = state;
        this.city = city;
        this.suburb = suburb;
        this.postCode = postCode;
    }
}
