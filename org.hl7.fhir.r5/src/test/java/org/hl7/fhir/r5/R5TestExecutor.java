package org.hl7.fhir.r5;

import org.hl7.fhir.utilities.tests.PackageTestExecutor;

import java.util.Arrays;
import java.util.List;

public class R5TestExecutor extends PackageTestExecutor {
  @Override
  protected List<String> getPackages() {
    return Arrays.asList("org.hl7.fhir.r5");
  }

  public static void main(String[] args) {
    new R5TestExecutor().executeTests();
  }
}