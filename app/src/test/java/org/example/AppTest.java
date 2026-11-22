package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void validSeverityShouldBeAccepted() {
        assertTrue(App.isValidSeverity("Low"));
        assertTrue(App.isValidSeverity("Medium"));
        assertTrue(App.isValidSeverity("High"));
        assertTrue(App.isValidSeverity("Critical"));
    }

    @Test
    void invalidSeverityShouldBeRejected() {
        assertFalse(App.isValidSeverity("Urgent"));
        assertFalse(App.isValidSeverity(""));
    }

    @Test
    void severityShouldIgnoreLetterCase() {
        assertTrue(App.isValidSeverity("high"));
        assertTrue(App.isValidSeverity("CRITICAL"));
    }

    @Test
    void validStatusShouldBeAccepted() {
        assertTrue(App.isValidStatus("Open"));
        assertTrue(App.isValidStatus("In Progress"));
        assertTrue(App.isValidStatus("Resolved"));
    }

    @Test
    void invalidStatusShouldBeRejected() {
        assertFalse(App.isValidStatus("Pending"));
        assertFalse(App.isValidStatus(""));
    }

    @Test
    void statusShouldIgnoreLetterCase() {
        assertTrue(App.isValidStatus("open"));
        assertTrue(App.isValidStatus("IN PROGRESS"));
    }
}