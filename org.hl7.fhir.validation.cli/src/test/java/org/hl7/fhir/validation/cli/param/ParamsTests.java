package org.hl7.fhir.validation.cli.param;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.nio.file.Files;
import java.util.Locale;

import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.hl7.fhir.validation.service.model.ValidationEngineSettings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParamsTests {
  @Test
  void testLocale() throws Exception {
    ValidationContext validationContext = Params.loadValidationContext(new ValidationEngineSettings(), new String[]{"-locale", "de"});
    assertEquals(Locale.GERMAN, validationContext.getLocale());
  }

  @Test
  void testFhirSettingsFile() throws Exception {
    File tempFile = ManagedFileAccess.fromPath(Files.createTempFile("fhir-settings", "json"));
    ValidationContext validationContext = Params.loadValidationContext(new ValidationEngineSettings(), new String[]{"-fhir-settings", tempFile.getAbsolutePath()});
    assertEquals(tempFile.getAbsolutePath(), validationContext.getFhirSettingsFile());
  }

  @Test
  void testFhirSettingsFileDoesntExist() {

    java.lang.Error error = Assertions.assertThrows(java.lang.Error.class, () -> {
      ValidationContext validationContext = Params.loadValidationContext(new ValidationEngineSettings(), new String[]{"-fhir-settings", "this-does-not-exist.json"});
    });
    assertThat(error.getMessage()).contains("this-does-not-exist.json");
  }
}