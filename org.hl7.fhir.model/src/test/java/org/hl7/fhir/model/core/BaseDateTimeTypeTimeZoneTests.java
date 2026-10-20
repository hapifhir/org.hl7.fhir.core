package org.hl7.fhir.model.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.TimeZone;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Date/time arithmetic must happen in the value's own time zone, whatever time zone the code runs
 * in. The JVM default is set to New Zealand, where daylight saving started on 2023-09-24, so
 * arithmetic done in the default time zone across that date moves the time of day by an hour.
 */
class BaseDateTimeTypeTimeZoneTests {

  private TimeZone originalTimeZone;

  @BeforeEach
  void setUp() {
    originalTimeZone = TimeZone.getDefault();
    TimeZone.setDefault(TimeZone.getTimeZone("Pacific/Auckland"));
  }

  @AfterEach
  void tearDown() {
    TimeZone.setDefault(originalTimeZone);
  }

  @ParameterizedTest(name = "{0} + {2} {1} = {3}")
  @CsvSource({
    "2023-09-25T13:19:13.502Z, DATE, -5, 2023-09-20T13:19:13.502Z",
    "2023-09-20T13:19:13.502Z, DATE, 5, 2023-09-25T13:19:13.502Z",
    "2023-09-15T12:00:00Z, MONTH, 1, 2023-10-15T12:00:00Z",
    "2024-03-15T12:00:00Z, MONTH, 1, 2024-04-15T12:00:00Z",
    "2023-09-25T13:19:13+13:00, DATE, -5, 2023-09-20T13:19:13+13:00",
    "2023-09-25T13:19:13Z, YEAR, -1, 2022-09-25T13:19:13Z",
    "2023-09-24T01:00:00Z, HOUR, 3, 2023-09-24T04:00:00Z"
  })
  void testAddUsesValueTimeZone(String value, String field, int amount, String expected) {
    DateTimeType dt = new DateTimeType(value);
    dt.add(field(field), amount);
    assertEquals(expected, dt.getValueAsString());
  }

  private static int field(String name) {
    switch (name) {
      case "YEAR": return Calendar.YEAR;
      case "MONTH": return Calendar.MONTH;
      case "DATE": return Calendar.DATE;
      case "HOUR": return Calendar.HOUR;
      default: throw new IllegalArgumentException(name);
    }
  }
}
