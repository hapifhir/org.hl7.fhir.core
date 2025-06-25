package org.hl7.fhir.validation.service.model;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationContextTests {
    @Test
    @DisplayName("test locale set and get")
    public void testSetAndGetLocale() {
        ValidationContext validationContext = new ValidationContext();
        validationContext.setLocale(Locale.GERMAN);
        assertEquals(Locale.GERMAN, validationContext.getLocale());
    }
}