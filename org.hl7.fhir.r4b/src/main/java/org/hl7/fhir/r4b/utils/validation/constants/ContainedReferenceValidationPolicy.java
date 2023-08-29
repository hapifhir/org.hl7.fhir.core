package org.hl7.fhir.r4b.utils.validation.constants;

public enum ContainedReferenceValidationPolicy {
  IGNORE, CHECK_TYPE, CHECK_VALID;

  public boolean ignore() {
    return this == IGNORE;
  }

  public boolean checkType() {
    return this == CHECK_TYPE || this == CHECK_VALID;
  }

  public boolean checkValid() {
    return this == CHECK_VALID;
  }
}
