package org.hl7.fhir.dstu2.model;

import ca.uhn.fhir.model.api.TemporalPrecisionEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseDateTimeTypeTests {
  
  private static Stream<Arguments> getInvalidStringParams() {
      return Stream.of(
              Arguments.of(DateType.class, "1933-01-02T12:34:56"),
              Arguments.of(DateType.class, "1933-01-02T12:34:56.7"),
              Arguments.of(DateType.class, "1933-01-02T12:34:56.78"),
              Arguments.of(DateType.class, "1933-01-02T12:34:56.789"),
              Arguments.of(InstantType.class, "1933"),
              Arguments.of(InstantType.class, "1933-01"),
              Arguments.of(InstantType.class, "1933-01-02")
      );
  }

  @ParameterizedTest
  @MethodSource("getInvalidStringParams")
  public <K extends BaseDateTimeType> void testInvalidString(Class<K> clazz, String param) {
    InvocationTargetException exceptionWrapper =  Assertions.assertThrows(InvocationTargetException.class, () ->  clazz.getConstructor(String.class).newInstance(param));
    assertEquals(IllegalArgumentException.class, exceptionWrapper.getTargetException().getClass());
  }

  private static Stream<Arguments> getValidStringParams() {
      return Stream.of(
        Arguments.of(DateType.class, "1933"),
        Arguments.of(DateType.class, "1933-01"),
        Arguments.of(DateType.class, "1933-01-02"),
        Arguments.of(DateTimeType.class, "1933"),
        Arguments.of(DateTimeType.class, "1933-01"),
        Arguments.of(DateTimeType.class, "1933-01-02"),
        Arguments.of(DateTimeType.class, "1933-01-02T12:34:56"),
        Arguments.of(DateTimeType.class, "1933-01-02T12:34:56.7"),
        Arguments.of(DateTimeType.class, "1933-01-02T12:34:56.78"),
        Arguments.of(DateTimeType.class, "1933-01-02T12:34:56.789"),
        Arguments.of(InstantType.class, "1933-01-02T12:34:56"),
        Arguments.of(InstantType.class, "1933-01-02T12:34:56.7"),
        Arguments.of(InstantType.class, "1933-01-02T12:34:56.78"),
        Arguments.of(InstantType.class, "1933-01-02T12:34:56.789")
      );
  }

  @ParameterizedTest
  @MethodSource("getValidStringParams")
  public <K extends BaseDateTimeType> void testValidString(Class<K> clazz, String param) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    clazz.getConstructor(String.class).newInstance(param);
    K srcInstance = clazz.getDeclaredConstructor().newInstance();
    srcInstance.setValueAsString(param);
    assertEquals(param, srcInstance.getValueAsString());
  }

  private static Stream<Arguments> getGetValueAsStringParams() {

    return Stream.of(
      Arguments.of(new DateTimeType("1933-01-02T12:34:56.789"), TemporalPrecisionEnum.MILLI, "1933-01-02T12:34:56.789"),
      Arguments.of(new DateTimeType("1933-01-02T12:34:56.789"), TemporalPrecisionEnum.SECOND, "1933-01-02T12:34:56"),
      Arguments.of(new DateTimeType("1933-01-02T12:34:56.789"), TemporalPrecisionEnum.MINUTE, "1933-01-02T12:34"),
      Arguments.of(new DateTimeType("1933-01-02T12:34:56.789"), TemporalPrecisionEnum.MINUTE, "1933-01-02T12:34"),
      Arguments.of(new DateTimeType("1933-01-02T12:34:56.789"), TemporalPrecisionEnum.DAY, "1933-01-02"),
      Arguments.of(new DateTimeType("1933-01-02T12:34:56.789"), TemporalPrecisionEnum.MONTH, "1933-01"),
      Arguments.of(new DateTimeType("1933-01-02T12:34:56.789"), TemporalPrecisionEnum.YEAR, "1933")
    );
  }

  @ParameterizedTest
  @MethodSource("getGetValueAsStringParams")
  public void testGetValueAsString(DateTimeType theType, TemporalPrecisionEnum thePrecision, String expectedStringValue) {
    assertEquals(expectedStringValue, theType.getValueAsString(thePrecision));
  }
}
