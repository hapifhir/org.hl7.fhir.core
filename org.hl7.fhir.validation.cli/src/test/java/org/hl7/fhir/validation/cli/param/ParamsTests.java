package org.hl7.fhir.validation.cli.param;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;

import org.junit.jupiter.api.Test;

class ParamsTests {

  @Test
  void testHasParamAndValue() {
    assertTrue(Params.hasParamAndValue(new String[]{"-param", "value"}, "-param"));
    Error expectedError = assertThrows(Error.class, () -> Params.hasParamAndValue(new String[]{"-param"}, "-param"));
    assertThat(expectedError.getMessage()).contains("-param");
    assertThat(expectedError.getMessage()).contains("without providing a value");
  }

  @Test
  void testMultipleParamAndValue() {
    String[] args = new String[]{"-input", "first", "-input", "second", "meh"};
    Collection<String> values = Params.getMultiValueParam(args, "-input");
    assertThat(values).containsExactly("first", "second");
  }
}