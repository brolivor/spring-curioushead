package com.curioushead;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddressTest {
    @Test
    void testAddress() {
        Address address = new Address("India", "Uttar Pradesh", "Aligarh", "Quarsi",
                "202001");
        assertEquals("India", address.getCountry());
        assertEquals("Uttar Pradesh", address.getState());
        assertEquals("Aligarh", address.getCity());
        assertEquals("Quarsi", address.getSuburb());
        assertEquals("202001", address.getPostCode());
    }
}