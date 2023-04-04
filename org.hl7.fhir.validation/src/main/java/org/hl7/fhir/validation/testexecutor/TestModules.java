package org.hl7.fhir.validation.testexecutor;

import java.util.Arrays;
import java.util.List;

public class TestModules {
  public static final String VALIDATION_MODULE = "org.hl7.fhir.validation";
  public static final String[] JUNIT5_MODULE_NAMES = {
    "org.hl7.fhir.utilities",
    "org.hl7.fhir.convertors",
    "org.hl7.fhir.dstu2",
    "org.hl7.fhir.dstu2016may",
    "org.hl7.fhir.dstu3",
    "org.hl7.fhir.r4",
    "org.hl7.fhir.r4b",
    "org.hl7.fhir.r5",
    VALIDATION_MODULE
  };

  public static final List<String> JUNIT4_CLASSNAMES = Arrays.asList("org.hl7.fhir.validation.tests.ValidationTests", "org.hl7.fhir.terminologies.tests.TerminologyServiceTests");
}
