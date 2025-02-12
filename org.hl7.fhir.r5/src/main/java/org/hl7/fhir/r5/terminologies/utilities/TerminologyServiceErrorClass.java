package org.hl7.fhir.r5.terminologies.utilities;

import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;

public enum TerminologyServiceErrorClass {
  UNKNOWN, NOSERVICE, SERVER_ERROR, VALUESET_UNSUPPORTED, CODESYSTEM_UNSUPPORTED, CODESYSTEM_UNSUPPORTED_VERSION, BLOCKED_BY_OPTIONS, INTERNAL_ERROR, BUSINESS_RULE, TOO_COSTLY, PROCESSING, VALUESET_UNKNOWN;

  public boolean isInfrastructure() {
    return this == NOSERVICE || this == SERVER_ERROR || this == VALUESET_UNSUPPORTED;
  }
}