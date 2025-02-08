package org.hl7.fhir.r5.utils.validation.constants;

import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;

@MarkedToMoveToAdjunctPackage
public enum ContainedReferenceValidationPolicy {
  IGNORE,
  CHECK_TYPE,
  CHECK_VALID;

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
