package org.hl7.fhir.r5.formats;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FormatUtilitiesTest {

  private static Stream<Arguments> provideIdsWithOutcomes() {
    return Stream.of(
      Arguments.of("1234", true),
      Arguments.of("12-34", true),
      Arguments.of("12_34", false),
      Arguments.of("12.34", true),
      Arguments.of("12/34", false),
      Arguments.of("1234#", false),
      Arguments.of("31415926535897932384626433832795028841971693993751058209749445923", false) // 65 digits
    );
  }

  @ParameterizedTest
  @MethodSource("provideIdsWithOutcomes")
  void isValidIdTest(String id, boolean expected) {
    Assertions.assertEquals(FormatUtilities.isValidId(id), expected);
  }
}