package com.curioushead;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenderTest {

    @Test
    void valueOf() {
        assertEquals(Gender.valueOf("MALE"), Gender.MALE);
        assertEquals(Gender.valueOf("FEMALE"), Gender.FEMALE);
    }
}