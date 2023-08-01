package org.hl7.fhir.dstu2016may.test;

import ca.uhn.fhir.model.api.TemporalPrecisionEnum;
import org.hl7.fhir.dstu2016may.model.DateTimeType;
import org.hl7.fhir.dstu2016may.model.DateType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseDateTimeTypeTest {
  private SimpleDateFormat myDateInstantParser;

  @BeforeEach
  public void before() {
    myDateInstantParser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
  }

  /**
   * See HAPI #101 - https://github.com/jamesagnew/hapi-fhir/issues/101
   */
  @Test
  public void testPrecisionRespectedForSetValueWithPrecision() throws Exception {
    Calendar cal = Calendar.getInstance();
    cal.setTime(myDateInstantParser.parse("2012-01-02 22:31:02.333"));
    cal.setTimeZone(TimeZone.getTimeZone("EST"));

    Date time = cal.getTime();

    DateType date = new DateType();
    date.setValue(time, TemporalPrecisionEnum.DAY);
    Assertions.assertEquals("2012-01-02", date.getValueAsString());
  }

  /**
   * See HAPI #101 - https://github.com/jamesagnew/hapi-fhir/issues/101
   */
  @Test
  public void testPrecisionRespectedForSetValue() throws Exception {
    Calendar cal = Calendar.getInstance();
    cal.setTime(myDateInstantParser.parse("2012-01-02 22:31:02.333"));
    cal.setTimeZone(TimeZone.getTimeZone("EST"));

    Date time = cal.getTime();

    DateType date = new DateType();
    date.setValue(time);
    Assertions.assertEquals("2012-01-02", date.getValueAsString());
  }

  private static Stream<Arguments> getGetValueAsStringParams() {

    return Stream.of(
        Arguments.of(new DateTimeType("1933-01-02T12:34:56.789"), TemporalPrecisionEnum.MILLI,
            "1933-01-02T12:34:56.789"),
        Arguments.of(new DateTimeType("1933-01-02T12:34:56.789"), TemporalPrecisionEnum.SECOND, "1933-01-02T12:34:56"),
        Arguments.of(new DateTimeType("1933-01-02T12:34:56.789"), TemporalPrecisionEnum.MINUTE, "1933-01-02T12:34"),
        Arguments.of(new DateTimeType("1933-01-02T12:34:56.789"), TemporalPrecisionEnum.MINUTE, "1933-01-02T12:34"),
        Arguments.of(new DateTimeType("1933-01-02T12:34:56.789"), TemporalPrecisionEnum.DAY, "1933-01-02"),
        Arguments.of(new DateTimeType("1933-01-02T12:34:56.789"), TemporalPrecisionEnum.MONTH, "1933-01"),
        Arguments.of(new DateTimeType("1933-01-02T12:34:56.789"), TemporalPrecisionEnum.YEAR, "1933"));
  }

  @ParameterizedTest
  @MethodSource("getGetValueAsStringParams")
  public void testGetValueAsString(DateTimeType theType, TemporalPrecisionEnum thePrecision,
      String expectedStringValue) {
    assertEquals(expectedStringValue, theType.getValueAsString(thePrecision));
  }
}