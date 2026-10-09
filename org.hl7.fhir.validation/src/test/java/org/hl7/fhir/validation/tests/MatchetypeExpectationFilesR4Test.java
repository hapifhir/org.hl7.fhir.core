package org.hl7.fhir.validation.tests;

/** The expectation files on a FHIR 4.0.1 validator, which does not define all of their R5-shaped content. */
class MatchetypeExpectationFilesR4Test extends MatchetypeExpectationFilesTestBase {

  @Override
  protected String corePackage() {
    return "hl7.fhir.r4.core#4.0.1";
  }

  @Override
  protected String fhirVersion() {
    return "4.0.1";
  }

  @Override
  protected int port() {
    return 18093;
  }

  @Override
  protected boolean definesR5Content() {
    return false;
  }
}
