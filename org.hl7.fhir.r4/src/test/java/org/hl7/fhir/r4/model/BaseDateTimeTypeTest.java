package org.hl7.fhir.r4.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ca.uhn.fhir.model.api.TemporalPrecisionEnum;

public class BaseDateTimeTypeTest {

  /**
   * <ul>
   * <li>true if the given datetimes represent the exact same instant with the
   * same precision (irrespective of the timezone)</li>
   * <li>true if the given datetimes represent the exact same instant but one
   * includes milliseconds of <code>.[0]+</code> while the other includes only
   * SECONDS precision (irrespecitve of the timezone)</li>
   * <li>true if the given datetimes represent the exact same
   * year/year-month/year-month-date (if both operands have the same
   * precision)</li>
   * <li>false if the given datetimes have the same precision but do not represent
   * the same instant (irrespective of timezone)</li>
   * <li>null otherwise (since these datetimes are not comparable)</li>
   * </ul>
   */
  @Test
  @Disabled
  public void equalsUsingFhirPathRules() {

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
    Assertions.assertFalse(compareDateTimes("1974-12-25", "1974-12-25T12:34:00+10:00"));
    Assertions.assertFalse(compareDateTimes("1974-12-25T12:34:00+10:00", "1974-12-25"));
    Assertions.assertFalse(compareDateTimes("1974-12-25", "1974-12-25T12:34:00-10:00"));
    Assertions.assertFalse(compareDateTimes("1974-12-25T12:34:00-10:00", "1974-12-25"));
    Assertions.assertFalse(compareDateTimes("1974-12-25", "1974-12-25T12:34:00Z"));
    Assertions.assertFalse(compareDateTimes("1974-12-25T12:34:00Z", "1974-12-25"));
    Assertions.assertFalse(compareDateTimes("2012-04-15", "2012-04-16"));
    Assertions.assertFalse(compareDateTimes("2012-04-16", "2012-04-15"));
    Assertions.assertFalse(compareDateTimes("2012-04-15T15:00:00", "2012-04-15T10:00:00"));
    Assertions.assertFalse(compareDateTimes("2012-04-15T10:00:00", "2012-04-15T15:00:00"));
    Assertions.assertFalse(compareDateTimes("2017-11-05T01:30:00.0-04:00", "2017-11-05T01:15:00.0-05:00"));
    Assertions.assertFalse(compareDateTimes("2017-11-05T01:15:00.0-05:00", "2017-11-05T01:30:00.0-04:00"));
    Assertions.assertNull(compareDateTimes("1974-12-25", "1974-12-25T12:34:00"));
    Assertions.assertNull(compareDateTimes("1974-12-25T12:34:00", "1974-12-25"));
    Assertions.assertNull(compareDateTimes("2012-04-15T10:00:00", "2012-04-15"));
    Assertions.assertNull(compareDateTimes("2012-04-15T15:00:00Z", "2012-04-15T10:00:00"));
    Assertions.assertNull(compareDateTimes("2012-04-15T10:00:00", "2012-04-15T15:00:00Z"));
    Assertions.assertTrue(compareDateTimes("1974-12-25", "1974-12-25"));
    Assertions.assertTrue(compareDateTimes("2012-04-15", "2012-04-15"));
    Assertions.assertTrue(compareDateTimes("2012-04-15T15:00:00+02:00", "2012-04-15T16:00:00+03:00"));
    Assertions.assertTrue(compareDateTimes("2012-04-15T16:00:00+03:00", "2012-04-15T15:00:00+02:00"));
    Assertions.assertTrue(compareDateTimes("2017-11-05T01:30:00.0-04:00", "2017-11-05T00:30:00.0-05:00"));
    Assertions.assertTrue(compareDateTimes("2017-11-05T00:30:00.0-05:00", "2017-11-05T01:30:00.0-04:00"));

    Assertions.assertFalse(compareDateTimes("2016-12-02T13:00:00Z", "2016-11-02T10:00:00")); // no timezone, but cannot
                                                                                             // be the same time
    Assertions.assertNull(compareDateTimes("2016-12-02T13:00:00Z", "2016-12-02T10:00:00")); // no timezone, might be the
                                                                                            // same time
  }

  private Boolean compareDateTimes(String theLeft, String theRight) {
    DateTimeType leftDt = new DateTimeType(theLeft);
    DateTimeType rightDt = new DateTimeType(theRight);
    return leftDt.equalsUsingFhirPathRules(rightDt);
  }

  private static Stream<Arguments> getInvalidStringParams() {
    return Stream.of(Arguments.of(DateType.class, "1933-01-02T12:34:56"),
        Arguments.of(DateType.class, "1933-01-02T12:34:56.7"), Arguments.of(DateType.class, "1933-01-02T12:34:56.78"),
        Arguments.of(DateType.class, "1933-01-02T12:34:56.789"), Arguments.of(InstantType.class, "1933"),
        Arguments.of(InstantType.class, "1933-01"), Arguments.of(InstantType.class, "1933-01-02"));
  }

  @ParameterizedTest
  @MethodSource("getInvalidStringParams")
  public <K extends BaseDateTimeType> void testInvalidString(Class<K> clazz, String param)
      throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    InvocationTargetException exceptionWrapper = Assertions.assertThrows(InvocationTargetException.class,
        () -> clazz.getConstructor(String.class).newInstance(param));
    assertEquals(IllegalArgumentException.class, exceptionWrapper.getTargetException().getClass());
  }

  private static Stream<Arguments> getValidStringParams() {
    return Stream.of(Arguments.of(DateType.class, "1933"), Arguments.of(DateType.class, "1933-01"),
        Arguments.of(DateType.class, "1933-01-02"), Arguments.of(DateTimeType.class, "1933"),
        Arguments.of(DateTimeType.class, "1933-01"), Arguments.of(DateTimeType.class, "1933-01-02"),
        Arguments.of(DateTimeType.class, "1933-01-02T12:34:56"),
        Arguments.of(DateTimeType.class, "1933-01-02T12:34:56.7"),
        Arguments.of(DateTimeType.class, "1933-01-02T12:34:56.78"),
        Arguments.of(DateTimeType.class, "1933-01-02T12:34:56.789"),
        Arguments.of(InstantType.class, "1933-01-02T12:34:56"),
        Arguments.of(InstantType.class, "1933-01-02T12:34:56.7"),
        Arguments.of(InstantType.class, "1933-01-02T12:34:56.78"),
        Arguments.of(InstantType.class, "1933-01-02T12:34:56.789"));
  }

  @ParameterizedTest
  @MethodSource("getValidStringParams")
  public <K extends BaseDateTimeType> void testValidString(Class<K> clazz, String param)
      throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    clazz.getConstructor(String.class).newInstance(param);
    K srcInstance = clazz.getDeclaredConstructor().newInstance();
    srcInstance.setValueAsString(param);
    assertEquals(param, srcInstance.getValueAsString());
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