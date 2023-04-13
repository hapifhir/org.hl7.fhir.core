package org.hl7.fhir.utilities.settings;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.Map;

@Data
@Builder
@Jacksonized
@AllArgsConstructor
public class FhirSettingsPOJO {

  private String fhirDirectory;
  private Map<String, String> apiKeys;

  private String npmPath;

  private String rubyPath;

  private String fhirTestCasesPath;

  private String diffToolPath;

  private String tempPath;

  private String testIgsPath;

  protected FhirSettingsPOJO() {
    apiKeys = null;
    npmPath = null;
    rubyPath = null;
    fhirTestCasesPath = null;
    diffToolPath = null;
    tempPath = null;
    testIgsPath = null;
  }
}
