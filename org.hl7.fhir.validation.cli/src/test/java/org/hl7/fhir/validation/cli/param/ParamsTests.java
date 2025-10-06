package org.hl7.fhir.validation.cli.param;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.nio.file.Files;
import java.util.Locale;

import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParamsTests {
  @Test
  void testLocale() throws Exception {
    ValidationContext validationContext = Params.loadValidationContext(new String[]{"-locale", "de"});
    Assertions.assertEquals(Locale.GERMAN, validationContext.getLocale());
  }

  @Test
  void testHasParamAndValue() {
    assertTrue(Params.hasParamAndValue(new String[]{"-param", "value"}, "-param"));
    Error expectedError = assertThrows(Error.class, () -> Params.hasParamAndValue(new String[]{"-param"}, "-param"));
    assertThat(expectedError.getMessage()).contains("-param");
    assertThat(expectedError.getMessage()).contains("without providing a value");
  }
}