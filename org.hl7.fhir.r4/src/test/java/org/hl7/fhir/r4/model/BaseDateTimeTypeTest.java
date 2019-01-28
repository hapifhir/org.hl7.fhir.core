package org.hl7.fhir.r4.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class BaseDateTimeTypeTest {

    /**
     * <ul>
     *     <li>true if the given datetimes represent the exact same instant with the same precision (irrespective of the timezone)</li>
     *     <li>true if the given datetimes represent the exact same instant but one includes milliseconds of <code>.[0]+</code> while the other includes only SECONDS precision (irrespecitve of the timezone)</li>
     *     <li>true if the given datetimes represent the exact same year/year-month/year-month-date (if both operands have the same precision)</li>
     *     <li>false if the given datetimes have the same precision but do not represent the same instant (irrespective of timezone)</li>
     *     <li>null otherwise (since these datetimes are not comparable)</li>
     * </ul>
     */
    @Test
    public void equalsUsingFhirPathRules() {
        // Exact same - Same timezone
        assertTrue(compareDateTimes("2001-01-02T11:22:33.444Z", "2001-01-02T11:22:33.444Z"));
        // Exact same - Different timezone
        assertTrue(compareDateTimes("2001-01-02T11:22:33.444-03:00", "2001-01-02T10:22:33.444-04:00"));
        // Exact same - Dates
        assertTrue(compareDateTimes("2001", "2001"));
        assertTrue(compareDateTimes("2001-01", "2001-01"));
        assertTrue(compareDateTimes("2001-01-02", "2001-01-02"));
        // Same precision but different values - Dates
        assertFalse(compareDateTimes("2001", "2002"));
        assertFalse(compareDateTimes("2001-01", "2001-02"));
        assertFalse(compareDateTimes("2001-01-02", "2001-01-03"));
        // Different instant - Same timezone
        assertFalse(compareDateTimes("2001-01-02T11:22:33.444Z", "2001-01-02T11:22:33.445Z"));
        // Different precision
        assertNull(compareDateTimes("2001-01-02T11:22:33.444Z", "2001-01-02T11:22:33Z"));
    }

    private Boolean compareDateTimes(String theLeft, String theRight) {
        return new DateTimeType(theLeft).equalsUsingFhirPathRules(new DateTimeType(theRight));
    }

}