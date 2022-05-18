package org.hl7.fhir.utilities;

import org.hl7.fhir.utilities.tests.ModuleTestExecutor;

import java.util.Arrays;
import java.util.List;

public class UtilitiesTestExecutor extends ModuleTestExecutor {
  @Override
  public String getModuleName() {
    return "org.hl7.fhir.utilities";
  }
  @Override
  protected List<String> getPackages() {
    return Arrays.asList("org.hl7.fhir.utilities");
  }
}
