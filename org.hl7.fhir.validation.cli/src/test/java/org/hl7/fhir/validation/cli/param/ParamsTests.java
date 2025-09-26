package org.hl7.fhir.validation.cli.param;

import static org.assertj.core.api.Assertions.assertThat;

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
  void testFhirSettingsFile() throws Exception {
    File tempFile = ManagedFileAccess.fromPath(Files.createTempFile("fhir-settings", "json"));
    ValidationContext validationContext = Params.loadValidationContext(new String[]{"-fhir-settings", tempFile.getAbsolutePath()});
    Assertions.assertEquals(tempFile.getAbsolutePath(), validationContext.getFhirSettingsFile());
  }

  @Test
  void testFhirSettingsFileDoesntExist() {
    java.lang.Error error = Assertions.assertThrows(java.lang.Error.class, () -> {
      Params.loadValidationContext(new String[]{"-fhir-settings", "this-does-not-exist.json"});
    });
    assertThat(error.getMessage()).contains("this-does-not-exist.json");
  }
}