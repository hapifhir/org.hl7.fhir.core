package org.hl7.fhir.validation.cli.services;

public enum ValidatorWatchMode {
  NONE,   // just stop when validation is done
  SINGLE, // when validation is done, watch the content that was validated, and revalidate anything that changes
  ALL     // when validation is done, watch the content that was validated, and revalidate everything if anything changes

}
