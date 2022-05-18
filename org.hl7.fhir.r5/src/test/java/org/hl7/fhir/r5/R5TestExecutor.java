package org.hl7.fhir.r5;

import org.hl7.fhir.utilities.tests.ModuleTestExecutor;

import java.util.Arrays;
import java.util.List;

public class R5TestExecutor extends ModuleTestExecutor {
  @Override
  public String getModuleName() {
    return "org.hl7.fhir.r5";
  }

  @Override
  protected List<String> getPackages() {
    return Arrays.asList("org.hl7.fhir.r5");
  }
}