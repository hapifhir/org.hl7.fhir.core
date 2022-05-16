package org.hl7.fhir.utilities;

import org.hl7.fhir.utilities.tests.PackageTestExecutor;

import java.util.Arrays;
import java.util.List;

public class UtilitiesTestExecutor extends PackageTestExecutor {
  @Override
  protected List<String> getPackages() {
    return Arrays.asList("org.hl7.fhir.utilities");
  }

  public static void main(String[] args) {
    new UtilitiesTestExecutor().executeTests();
  }
}
