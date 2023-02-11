package com.curioushead;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @Test
    void testStudent() {
        List<String> subject = Arrays.asList("Bioinformatics", "Computer Science");
        Address address = new Address("India", "Uttar Pradesh", "Aligarh", "Quarsi",
                "202001");
        Student student = new Student("Richa", "Katiyar", "ricspics@gmail.com",
                Gender.FEMALE,
                address, subject, LocalDateTime.MAX);
        assertEquals("Richa", student.getFirstName());
        assertEquals("Katiyar", student.getLastName());
        assertEquals("ricspics@gmail.com", student.getEmail());
        assertEquals(Gender.FEMALE, Gender.valueOf("FEMALE"));
        assertEquals("India", address.getCountry());
        assertEquals("Uttar Pradesh", address.getState());
        assertEquals("Aligarh", address.getCity());
        assertEquals("Quarsi", address.getSuburb());
        assertEquals("202001", address.getPostCode());
        assertEquals("Bioinformatics", subject.get(0));
        assertEquals("Computer Science", subject.get(1));
    }
}