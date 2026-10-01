package org.hl7.fhir.model;

import org.hl7.fhir.model.core.DateTimeType;
import org.junit.jupiter.api.Test;

import java.time.temporal.ChronoUnit;

import static org.junit.Assert.assertEquals;

public class DateTimeTypeFieldTests {
  @Test
  public void testFieldSet() {
    final int YEAR = 1979;
    final int MONTH = 0; // January
    final int DAY = 23;
    final DateTimeType dateTimeYearFirst = new DateTimeType();
    dateTimeYearFirst.setPrecision(ChronoUnit.DAYS);
    dateTimeYearFirst.setYear(YEAR);
    dateTimeYearFirst.setDay(DAY);
    dateTimeYearFirst.setMonth(MONTH);

    final DateTimeType dateTimeDayFirst = new DateTimeType();
    dateTimeDayFirst.setPrecision(ChronoUnit.DAYS);
    dateTimeDayFirst.setDay(DAY);
    dateTimeDayFirst.setYear(YEAR);
    dateTimeDayFirst.setMonth(MONTH);

    assertEquals("1979-01-23",dateTimeDayFirst.asStringValue());
    assertEquals("1979-01-23",dateTimeYearFirst.asStringValue());
  }
}
