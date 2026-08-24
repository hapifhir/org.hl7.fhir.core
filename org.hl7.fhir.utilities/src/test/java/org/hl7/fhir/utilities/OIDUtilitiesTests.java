package org.hl7.fhir.utilities;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OIDUtilitiesTests {

  static Stream<Arguments> isValidOIDCases() {
    return Stream.of(
      Arguments.of("2.16.840.1.113883", true),   // valid OID
      Arguments.of("0.1.2.3", true),              // valid, first arc 0
      Arguments.of("1.2.3", true),                // valid, first arc 1
      Arguments.of("3.1.2", false),               // invalid: first arc > 2
      Arguments.of("2.16", true),                 // valid: minimum two arcs
      Arguments.of("2", false),                   // invalid: only one arc
      Arguments.of("2.016.840", false),           // invalid: leading zero in arc
      Arguments.of("abc.def", false)              // invalid: non-numeric
    );
  }

  @ParameterizedTest
  @MethodSource("isValidOIDCases")
  void testIsValidOID(String oid, boolean expected) {
    assertEquals(expected, OIDUtilities.isValidOID(oid));
  }
}
