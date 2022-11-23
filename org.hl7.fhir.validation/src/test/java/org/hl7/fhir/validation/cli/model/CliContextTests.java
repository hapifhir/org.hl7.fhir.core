package org.hl7.fhir.validation.cli.model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Locale;
import static org.junit.Assert.assertEquals;

public class CliContextTests {
    @Test
    @DisplayName("test locale set and get")
    public void testSetAndGetLocale() {
        CliContext cliContext = new CliContext();
        cliContext.setLocale(Locale.GERMAN);
        assertEquals(Locale.GERMAN, cliContext.getLocale());
    }
}