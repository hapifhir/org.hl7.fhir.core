package org.hl7.fhir.validation.cli.utils;

import org.hl7.fhir.validation.cli.model.CliContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;

public class ParamsTests {
  @Test
  void testLocale() throws Exception {
    CliContext cliContext = Params.loadCliContext(new String[]{"-locale", "de"});
    assertEquals(Locale.GERMAN, cliContext.getLocale());
  }

  @Test
  void testFhirSettingsFile() throws Exception {
    File tempFile = Files.createTempFile("fhir-settings", "json").toFile();
    CliContext cliContext = Params.loadCliContext(new String[]{"-fhir-settings", tempFile.getAbsolutePath()});
    assertEquals(tempFile.getAbsolutePath(), cliContext.getFhirSettingsFile());
  }

  @Test
  void testApiKeyFileDoesntExist() {

    java.lang.Error error = Assertions.assertThrows(java.lang.Error.class, () -> {
      CliContext cliContext = Params.loadCliContext(new String[]{"-api-key-file", "this-does-not-exist.ini"});
    });
    assertThat(error.getMessage(), containsString("this-does-not-exist.ini"));
  }
}