package org.hl7.fhir.dstu2016may.model;

import ca.uhn.fhir.model.api.TemporalPrecisionEnum;
import org.junit.jupiter.api.Test;

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

    assertEquals("1979-01-23", dateTimeDayFirst.asStringValue());
    assertEquals("1979-01-23", dateTimeYearFirst.asStringValue());
  }
}
