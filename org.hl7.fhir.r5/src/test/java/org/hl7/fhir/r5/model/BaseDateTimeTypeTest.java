package org.hl7.fhir.r5.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.TimeZone;

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
  public void equalsUsingFhirPathRulesInSpec() {

    // from the spec
    Assertions.assertTrue(compareDateTimes("2012", "2012"));
    Assertions.assertFalse(compareDateTimes("2012", "2013"));
    Assertions.assertNull(compareDateTimes("2012-01", "2012"));
    Assertions.assertNull(compareDateTimes("2012-01-01", "2012-01-01T00:00:00"));
    Assertions.assertTrue(compareDateTimes("2012-01-01T10:30:00", "2012-01-01T10:30:00"));
    Assertions.assertFalse(compareDateTimes("2012-01-01T10:30:00", "2012-01-01T10:31:00"));
    Assertions.assertTrue(compareDateTimes("2012-01-01T10:30:31.0", "2012-01-01T10:30:31"));
    Assertions.assertFalse(compareDateTimes("2012-01-01T10:30:31.1", "2012-01-01T10:30:31"));
    Assertions.assertFalse(compareDateTimes("2017-11-05T01:30:00.0-04:00", "2017-11-05T01:15:00.0-05:00"));
    Assertions.assertTrue(compareDateTimes("2017-11-05T01:30:00.0-04:00", "2017-11-05T00:30:00.0-05:00"));
  }

  @Test
  public void equalsUsingFhirPathRulesOther() {
    // Setting timezone for this test. Grahame is in UTC+11, Travis is in GMT, and I'm here in Toronto, Canada with
    // all my time based tests failing locally...
    TimeZone.setDefault(TimeZone.getTimeZone("UTC+1100"));

    // Exact same - Same timezone
    Assertions.assertTrue(compareDateTimes("2001-01-02T11:22:33.444Z", "2001-01-02T11:22:33.444Z"));
    // Exact same - Different timezone
    Assertions.assertTrue(compareDateTimes("2001-01-02T11:22:33.444-03:00", "2001-01-02T10:22:33.444-04:00"));
    // Exact same - Dates
    Assertions.assertTrue(compareDateTimes("2001", "2001"));
    Assertions.assertTrue(compareDateTimes("2001-01", "2001-01"));
    Assertions.assertTrue(compareDateTimes("2001-01-02", "2001-01-02"));
    // Same precision but different values - Dates
    Assertions.assertFalse(compareDateTimes("2001", "2002"));
    Assertions.assertFalse(compareDateTimes("2001-01", "2001-02"));
    Assertions.assertFalse(compareDateTimes("2001-01-02", "2001-01-03"));
    // Different instant - Same timezone
    Assertions.assertFalse(compareDateTimes("2001-01-02T11:22:33.444Z", "2001-01-02T11:22:33.445Z"));
    Assertions.assertFalse(compareDateTimes("2001-01-02T11:22:33.445Z", "2001-01-02T11:22:33.444Z"));

    // FHIRPath tests:
    Assertions.assertNull(compareDateTimes("1974-12-25", "1974-12-25T12:34:00+10:00"));
    Assertions.assertNull(compareDateTimes("1974-12-25T12:34:00+10:00", "1974-12-25"));
    Assertions.assertFalse(compareDateTimes("1974-12-25", "1974-12-23T12:34:00+10:00")); // false because they can't be the same date irrespective of precision
    Assertions.assertFalse(compareDateTimes("1974-12-23T12:34:00+10:00", "1974-12-25"));
    Assertions.assertNull(compareDateTimes("1974-12-25", "1974-12-25T12:34:00Z"));
    Assertions.assertNull(compareDateTimes("1974-12-25T12:34:00Z", "1974-12-25"));
    Assertions.assertFalse(compareDateTimes("2012-04-15", "2012-04-16"));
    Assertions.assertFalse(compareDateTimes("2012-04-16", "2012-04-15"));
    Assertions.assertFalse(compareDateTimes("2012-04-15T15:00:00", "2012-04-15T10:00:00"));
    Assertions.assertFalse(compareDateTimes("2012-04-15T10:00:00", "2012-04-15T15:00:00"));
    Assertions.assertFalse(compareDateTimes("2017-11-05T01:30:00.0-04:00", "2017-11-05T01:15:00.0-05:00"));
    Assertions.assertFalse(compareDateTimes("2017-11-05T01:15:00.0-05:00", "2017-11-05T01:30:00.0-04:00"));
    Assertions.assertNull(compareDateTimes("1974-12-25", "1974-12-25T12:34:00"));
    Assertions.assertNull(compareDateTimes("1974-12-25T12:34:00", "1974-12-25"));
    Assertions.assertNull(compareDateTimes("2012-04-15T10:00:00", "2012-04-15"));
    Assertions.assertFalse(compareDateTimes("2012-04-15T15:00:00Z", "2012-04-15T10:00:00"));
    Assertions.assertFalse(compareDateTimes("2012-04-15T10:00:00", "2012-04-15T15:00:00Z"));
    Assertions.assertTrue(compareDateTimes("1974-12-25", "1974-12-25"));
    Assertions.assertTrue(compareDateTimes("2012-04-15", "2012-04-15"));
    Assertions.assertTrue(compareDateTimes("2012-04-15T15:00:00+02:00", "2012-04-15T16:00:00+03:00"));
    Assertions.assertTrue(compareDateTimes("2012-04-15T16:00:00+03:00", "2012-04-15T15:00:00+02:00"));
    Assertions.assertTrue(compareDateTimes("2017-11-05T01:30:00.0-04:00", "2017-11-05T00:30:00.0-05:00"));
    Assertions.assertTrue(compareDateTimes("2017-11-05T00:30:00.0-05:00", "2017-11-05T01:30:00.0-04:00"));

    Assertions.assertFalse(compareDateTimes("2016-12-02T13:00:00Z", "2016-11-02T10:00:00")); // no timezone, but cannot be the same time
    Assertions.assertFalse(compareDateTimes("2016-12-02T13:00:00Z", "2016-12-02T10:00:00")); // no timezone, might be the same time
  }

  @Test
  public void testToHumanDisplayForDateOnlyPrecisions() {
    Assertions.assertEquals("2019-01-02", new DateTimeType("2019-01-02").toHumanDisplay());
    Assertions.assertEquals("2019-01", new DateTimeType("2019-01").toHumanDisplay());
    Assertions.assertEquals("2019", new DateTimeType("2019").toHumanDisplay());
  }

  @Test
  public void testToHumanDisplayLocalTimezoneForDateOnlyPrecisions() {
    Assertions.assertEquals("2019-01-02", new DateTimeType("2019-01-02").toHumanDisplayLocalTimezone());
    Assertions.assertEquals("2019-01", new DateTimeType("2019-01").toHumanDisplayLocalTimezone());
    Assertions.assertEquals("2019", new DateTimeType("2019").toHumanDisplayLocalTimezone());
  }


  private Boolean compareDateTimes(String theLeft, String theRight) {
    System.out.println("Compare " + theLeft + " to " + theRight);
    DateTimeType leftDt = new DateTimeType(theLeft);
    DateTimeType rightDt = new DateTimeType(theRight);
    return leftDt.equalsUsingFhirPathRules(rightDt);
  }

}