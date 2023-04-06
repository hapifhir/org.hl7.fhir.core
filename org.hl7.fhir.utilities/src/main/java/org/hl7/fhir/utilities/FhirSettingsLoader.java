package org.hl7.fhir.utilities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FhirSettingsLoader<T extends FhirSettings> {


  public T getFhirSettings() throws IOException {
    return getFhirSettings(getDefaultSettingsPath());
  }
  public T getFhirSettings(String filePath) throws IOException {
    final File file = new File(filePath);

    final ObjectMapper objectMapper = new ObjectMapper();
    final InputStream inputStream = new FileInputStream(file);
    final T output = objectMapper.readValue(inputStream, new TypeReference<T>() {
    });

    return output;
  }

  private static String getDefaultSettingsPath() throws IOException {
    return Utilities.path(System.getProperty("user.home"), "fhir-settings.json");
  }
}
