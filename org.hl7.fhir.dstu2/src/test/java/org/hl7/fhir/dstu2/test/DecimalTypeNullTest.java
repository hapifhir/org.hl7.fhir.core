package org.hl7.fhir.dstu2.test;

import org.hl7.fhir.dstu2.model.DecimalType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class DecimalTypeNullTest {

  @Test
  @DisplayName("Test null value toString()")
  void testToString() {
    assertDoesNotThrow(() -> {
      DecimalType nullDecimal = new DecimalType();
      System.out.println("Value -> " + nullDecimal);
    });
  }

  @Test
  @DisplayName("Test null value equalsDeep()")
  void equalsDeep() {
    DecimalType nullDecimal = new DecimalType();
    DecimalType validDecimal = new DecimalType("3.14");
    Assertions.assertFalse(nullDecimal.equalsDeep(validDecimal));
  }

  @Test
  @DisplayName("Test null value equalsShallow()")
  void equalsShallow() {
    DecimalType nullDecimal = new DecimalType();
    DecimalType validDecimal = new DecimalType("3.14");
    Assertions.assertFalse(nullDecimal.equalsShallow(validDecimal));
  }

  @Test
  @DisplayName("Test null value copy()")
  void copy() {
    DecimalType nullDecimal = new DecimalType();
    DecimalType copyDecimal = nullDecimal.copy();
    Assertions.assertNull(copyDecimal.getValue());
  }

  @Test
  @DisplayName("Test null value typedCopy()")
  void typedCopy() {
    DecimalType nullDecimal = new DecimalType();
    DecimalType copyDecimal = (DecimalType) nullDecimal.typedCopy();
    Assertions.assertNull(copyDecimal.getValue());
  }

  public static Stream<Arguments> provideEmptyOrNullStringsConstructor() {
    return Stream.of(
      Arguments.of((String)null),
      Arguments.of(""),
      Arguments.of("  ")
    );
  }

  @ParameterizedTest
  @MethodSource("provideEmptyOrNullStringsConstructor")
  void testNullValue(String theStringValue) {
    DecimalType nullDecimal = new DecimalType();
    Assertions.assertNull(nullDecimal.getValue());
    Assertions.assertNull(nullDecimal.asStringValue());

    DecimalType anotherNullDecimal = new DecimalType(theStringValue);
    Assertions.assertNull(anotherNullDecimal.getValue());
    Assertions.assertNull(anotherNullDecimal.asStringValue());

    Assertions.assertTrue(nullDecimal.equalsDeep(anotherNullDecimal));
    Assertions.assertTrue(nullDecimal.equalsShallow(anotherNullDecimal));
  }
}