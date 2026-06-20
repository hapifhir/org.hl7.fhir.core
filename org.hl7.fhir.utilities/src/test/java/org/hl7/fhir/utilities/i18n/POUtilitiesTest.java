package org.hl7.fhir.utilities.i18n;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class POUtilitiesTest {
  public static Stream<Arguments> provideArgsForTestWrapQuotes() {
    return Stream.of(
      Arguments.of(
          """
          This material contains content from <a href="http://loinc.org">LOINC</a>. LOINC is copyright &copy; 1995-2020, Regenstrief Institute, Inc. and the Logical Observation Identifiers Names and Codes (LOINC) Committee and is available at no cost under the <a href="http://loinc.org/license">license</a>. LOINC&reg; is a registered United States trademark of Regenstrief Institute, Inc.
          """,
        """
        This material contains content from <a href=\\"http://loinc.org\\">LOINC</a>. LOINC is copyright &copy; 1995-2020, Regenstrief Institute, Inc. and the Logical Observation Identifiers Names and Codes (LOINC) Committee and is available at no cost under the <a href=\\"http://loinc.org/license\\">license</a>. LOINC&reg; is a registered United States trademark of Regenstrief Institute, Inc.
        """
      ),
      Arguments.of("""
          This material contains content from <a href=\\"http://loinc.org\\">LOINC</a>. LOINC is copyright &copy; 1995-2020, Regenstrief Institute, Inc. and the Logical Observation Identifiers Names and Codes (LOINC) Committee and is available at no cost under the <a href=\\"http://loinc.org/license\\">license</a>. LOINC&reg; is a registered United States trademark of Regenstrief Institute, Inc.
          """,
          """
          This material contains content from <a href=\\"http://loinc.org\\">LOINC</a>. LOINC is copyright &copy; 1995-2020, Regenstrief Institute, Inc. and the Logical Observation Identifiers Names and Codes (LOINC) Committee and is available at no cost under the <a href=\\"http://loinc.org/license\\">license</a>. LOINC&reg; is a registered United States trademark of Regenstrief Institute, Inc.
          """
      ),
      Arguments.of(
        """
        This material contains content from <a href=\\"http://loinc.org\\">LOINC</a>. LOINC is copyright &copy; 1995-2020, Regenstrief Institute, Inc. and the Logical Observation Identifiers Names and Codes (LOINC) Committee and is available at no cost under the <a href="http://loinc.org/license">license</a>. LOINC&reg; is a registered United States trademark of Regenstrief Institute, Inc.
        """,
        """
        This material contains content from <a href=\\"http://loinc.org\\">LOINC</a>. LOINC is copyright &copy; 1995-2020, Regenstrief Institute, Inc. and the Logical Observation Identifiers Names and Codes (LOINC) Committee and is available at no cost under the <a href=\\"http://loinc.org/license\\">license</a>. LOINC&reg; is a registered United States trademark of Regenstrief Institute, Inc.
        """
      )
    );
  }

  @ParameterizedTest
  @MethodSource("provideArgsForTestWrapQuotes")
  void testWrapQuotes(String input, String expected) {
    String actual = POUtilities.escapeNonEscapedQuotes(input);
    assertThat(actual).isEqualTo(expected);
  }
}
