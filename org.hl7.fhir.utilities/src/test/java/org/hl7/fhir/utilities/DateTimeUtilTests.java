package org.hl7.fhir.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.stream.Stream;

import org.apache.commons.lang3.time.FastDateFormat;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
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

}
