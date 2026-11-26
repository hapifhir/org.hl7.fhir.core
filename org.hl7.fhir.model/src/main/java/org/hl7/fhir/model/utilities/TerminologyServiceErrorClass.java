package org.hl7.fhir.model.utilities;



public enum TerminologyServiceErrorClass {
  UNKNOWN,
  /** there's no terminology service: none was configured, or it may not be used (401, 403) */
  NOSERVICE,
  SERVER_ERROR,
  /**
   * the request is one that isn't supported: a server said so (not-supported), or the terminology ecosystem registry
   * answered that no server has the resource (e.g. a value set to expand by url). This was VALUESET_UNSUPPORTED
   */
  RESOURCE_UNSUPPORTED,
  CODESYSTEM_UNSUPPORTED, CODESYSTEM_UNSUPPORTED_VERSION, BLOCKED_BY_OPTIONS, INTERNAL_ERROR, BUSINESS_RULE, TOO_COSTLY, PROCESSING, VALUESET_UNKNOWN;

  public boolean isInfrastructure() {
    return this == NOSERVICE || this == SERVER_ERROR || this == RESOURCE_UNSUPPORTED;
  }

  /** valueOf, that also reads the names that have been renamed (VALUESET_UNSUPPORTED), as found in existing terminology caches */
  public static TerminologyServiceErrorClass fromName(String name) {
    if ("VALUESET_UNSUPPORTED".equals(name)) {
      return RESOURCE_UNSUPPORTED;
    }
    return valueOf(name);
  }
}