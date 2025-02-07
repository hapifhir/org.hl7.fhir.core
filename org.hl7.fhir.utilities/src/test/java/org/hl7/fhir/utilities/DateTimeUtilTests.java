package org.hl7.fhir.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.stream.Stream;

import org.apache.commons.lang3.time.FastDateFormat;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ca.uhn.fhir.model.api.TemporalPrecisionEnum;

public class DateTimeUtilTests {

  private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(DateTimeUtilTests.class.getName());

  private static Stream<Arguments> getToHumanDisplayParams() {
    return Stream.of(
      Arguments.of(TimeZone.getTimeZone("EST"), TemporalPrecisionEnum.YEAR, new Date("2002/02/04"), "dummyValueAsString"),
      Arguments.of(TimeZone.getTimeZone("EST"), TemporalPrecisionEnum.MONTH, new Date("2002/02/04"), "dummyValueAsString"),
      Arguments.of(TimeZone.getTimeZone("EST"), TemporalPrecisionEnum.DAY, new Date("2002/02/04"), "dummyValueAsString"),
      Arguments.of(TimeZone.getTimeZone("EST"), TemporalPrecisionEnum.MILLI, new Date("2002/02/04"), "4-Feb-2002 12:00:00 AM"),
      Arguments.of(TimeZone.getTimeZone("EST"), TemporalPrecisionEnum.SECOND, new Date("2002/02/04"), "4-Feb-2002 12:00:00 AM"),
      Arguments.of(TimeZone.getTimeZone("EST"), TemporalPrecisionEnum.MINUTE, new Date("2002/02/04"), "4-Feb-2002 12:00:00 AM"),

      Arguments.of(TimeZone.getTimeZone("UTC"), TemporalPrecisionEnum.YEAR, new Date("2002/02/04"), "dummyValueAsString"),
      Arguments.of(TimeZone.getTimeZone("UTC"), TemporalPrecisionEnum.MONTH, new Date("2002/02/04"), "dummyValueAsString"),
      Arguments.of(TimeZone.getTimeZone("UTC"), TemporalPrecisionEnum.DAY, new Date("2002/02/04"), "dummyValueAsString"),
      Arguments.of(TimeZone.getTimeZone("UTC"), TemporalPrecisionEnum.MILLI, new Date("2002/02/04"), "4-Feb-2002 12:00:00 AM"),
      Arguments.of(TimeZone.getTimeZone("UTC"), TemporalPrecisionEnum.SECOND, new Date("2002/02/04"), "4-Feb-2002 12:00:00 AM"),
      Arguments.of(TimeZone.getTimeZone("UTC"), TemporalPrecisionEnum.MINUTE, new Date("2002/02/04"), "4-Feb-2002 12:00:00 AM")

    );
  }

  @Disabled
  @ParameterizedTest
  @MethodSource("getToHumanDisplayParams")
  public void testToHumanDisplay(TimeZone theTimeZone, TemporalPrecisionEnum thePrecision, Date theValue, String expected) {
    final String humanDisplay = DateTimeUtil.toHumanDisplay(theTimeZone, thePrecision, theValue, "dummyValueAsString");
    assertEquals(expected, humanDisplay);
  }

  private static Stream<Arguments> getToHumanDisplayLocalTimezoneParams() {
    return Stream.of(
      Arguments.of(TemporalPrecisionEnum.YEAR, new Date("2002/02/04"), "dummyValueAsString"),
      Arguments.of(TemporalPrecisionEnum.MONTH, new Date("2002/02/04"), "dummyValueAsString"),
      Arguments.of(TemporalPrecisionEnum.DAY, new Date("2002/02/04"), "dummyValueAsString"),
      Arguments.of(TemporalPrecisionEnum.MILLI, new Date("2002/02/04"), "04-Feb-2002 00:00:00"),
      Arguments.of(TemporalPrecisionEnum.SECOND, new Date("2002/02/04"), "04-Feb-2002 00:00:00"),
      Arguments.of(TemporalPrecisionEnum.MINUTE, new Date("2002/02/04"), "04-Feb-2002 00:00:00")

    );
  }

  private static Locale defaultLocale;

  @BeforeAll
  public static void beforeAll() {
    defaultLocale = Locale.getDefault();
    ourLog.info("Test setup: getting current default locale");
    ourLog.info("Locale.getDefault(): " + defaultLocale);
    ourLog.info("Test setup: setting default locale to UK for tests");
    Locale.setDefault(Locale.UK);
    ourLog.info("Locale.getDefault(): " + Locale.getDefault());
    ourLog.info("DateTime format: " + FastDateFormat.getDateTimeInstance(FastDateFormat.MEDIUM, FastDateFormat.MEDIUM));
  }

  @AfterAll
  public static void afterAll() {
    ourLog.info("Test teardown: setting default locale back to default");
    Locale.setDefault(defaultLocale);
    ourLog.info("Locale.getDefault(): " + Locale.getDefault());
    ourLog.info("DateTime format: " + FastDateFormat.getDateTimeInstance(FastDateFormat.MEDIUM, FastDateFormat.MEDIUM));
  }

  @ParameterizedTest
  @MethodSource("getToHumanDisplayLocalTimezoneParams")
  public void testToHumanDisplayLocalTimezone(TemporalPrecisionEnum thePrecision, Date theValue, String expected){
    final String humanDisplay = DateTimeUtil.toHumanDisplayLocalTimezone(thePrecision, theValue, "dummyValueAsString");
    assertEquals(expected, humanDisplay);
  }

  @Test
  @DisplayName("Date Reasoning Tests")
  void testDateRoutines() {
//    Assertions.assertEquals("2021-01-01T00:00:00.000", Utilities.lowBoundaryForDate("2021"));
//    Assertions.assertEquals("2021-04-01T00:00:00.000", Utilities.lowBoundaryForDate("2021-04"));
//    Assertions.assertEquals("2020-02-01T00:00:00.000", Utilities.lowBoundaryForDate("2020-02"));
//    Assertions.assertEquals("2021-04-04T00:00:00.000", Utilities.lowBoundaryForDate("2021-04-04"));
//    Assertions.assertEquals("2021-04-04T21:22:23.000", Utilities.lowBoundaryForDate("2021-04-04T21:22:23"));
//    Assertions.assertEquals("2021-04-04T21:22:23.245", Utilities.lowBoundaryForDate("2021-04-04T21:22:23.245"));
//    Assertions.assertEquals("2021-04-04T21:22:23.000Z", Utilities.lowBoundaryForDate("2021-04-04T21:22:23Z"));
//    Assertions.assertEquals("2021-04-04T21:22:23.245+10:00", Utilities.lowBoundaryForDate("2021-04-04T21:22:23.245+10:00"));
//
//    Assertions.assertEquals("2021-12-31T23:23:59.999", Utilities.highBoundaryForDate("2021"));
//    Assertions.assertEquals("2021-04-30T23:23:59.999", Utilities.highBoundaryForDate("2021-04"));
//    Assertions.assertEquals("2020-02-29T23:23:59.999", Utilities.highBoundaryForDate("2020-02"));
//    Assertions.assertEquals("2021-04-04T23:23:59.999", Utilities.highBoundaryForDate("2021-04-04"));
//    Assertions.assertEquals("2021-04-04T21:22:23.999", Utilities.highBoundaryForDate("2021-04-04T21:22:23"));
//    Assertions.assertEquals("2021-04-04T21:22:23.245", Utilities.highBoundaryForDate("2021-04-04T21:22:23.245"));
//    Assertions.assertEquals("2021-04-04T21:22:23.999Z", Utilities.highBoundaryForDate("2021-04-04T21:22:23Z"));
//    Assertions.assertEquals("2021-04-04T21:22:23.245+10:00", Utilities.highBoundaryForDate("2021-04-04T21:22:23.245+10:00"));

    assertEquals(8, DateTimeUtil.getDatePrecision("1900-01-01"));
    assertEquals(4, DateTimeUtil.getDatePrecision("1900"));
    assertEquals(6, DateTimeUtil.getDatePrecision("1900-06"));
    assertEquals(14, DateTimeUtil.getDatePrecision("1900-06-06T14:00:00"));
    assertEquals(17, DateTimeUtil.getDatePrecision("1900-06-06T14:00:00.000"));
    assertEquals(8, DateTimeUtil.getDatePrecision("1900-01-01Z"));
    assertEquals(4, DateTimeUtil.getDatePrecision("1900Z"));
    assertEquals(6, DateTimeUtil.getDatePrecision("1900-06Z"));
    assertEquals(14, DateTimeUtil.getDatePrecision("1900-06-06T14:00:00Z"));
    assertEquals(17, DateTimeUtil.getDatePrecision("1900-06-06T14:00:00.000Z"));
    assertEquals(8, DateTimeUtil.getDatePrecision("1900-01-01+10:00"));
    assertEquals(4, DateTimeUtil.getDatePrecision("1900+10:00"));
    assertEquals(6, DateTimeUtil.getDatePrecision("1900-06+10:00"));
    assertEquals(14, DateTimeUtil.getDatePrecision("1900-06-06T14:00:00+10:00"));
    assertEquals(17, DateTimeUtil.getDatePrecision("1900-06-06T14:00:00.000-10:00"));
  }

}
