package org.hl7.fhir.r5.model;

import ca.uhn.fhir.model.api.TemporalPrecisionEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateTimeTypeFieldTests {
  @Test
  public void testFieldSet() {
    final int YEAR = 1979;
    final int MONTH = 0; // January
    final int DAY = 23;
    final DateTimeType dateTimeYearFirst = new DateTimeType();
    dateTimeYearFirst.setPrecision(TemporalPrecisionEnum.DAY);
    dateTimeYearFirst.setYear(YEAR);
    dateTimeYearFirst.setDay(DAY);
    dateTimeYearFirst.setMonth(MONTH);

    final DateTimeType dateTimeDayFirst = new DateTimeType();
    dateTimeDayFirst.setPrecision(TemporalPrecisionEnum.DAY);
    dateTimeDayFirst.setDay(DAY);
    dateTimeDayFirst.setYear(YEAR);
    dateTimeDayFirst.setMonth(MONTH);

    assertEquals("1979-01-23",dateTimeDayFirst.asStringValue());
    assertEquals("1979-01-23",dateTimeYearFirst.asStringValue());
  }

  // a FHIRPath literal such as @2015-02-04T10:00 is built like this, and its string has no seconds
  @ParameterizedTest
  @ValueSource(strings = {"2015-02-04T10:00:00", "2015-02-04T10:00:00Z", "2015-02-04T10:00:00-05:00"})
  void copyKeepsMinutePrecision(String value) {
    DateTimeType dateTime = new DateTimeType(value);
    dateTime.setPrecision(TemporalPrecisionEnum.MINUTE);
    DateTimeType copy = dateTime.copy();
    assertEquals(dateTime.getValueAsString(), copy.getValueAsString());
    assertEquals(TemporalPrecisionEnum.MINUTE, copy.getPrecision());
    assertEquals(dateTime.getValue(), copy.getValue());
  }
}
