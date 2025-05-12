package org.hl7.fhir.r5.utils.validation.constants;

import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;

/**
 * whether to validate a reference, if the reference is resolvable (for external links, that there is some way to try resolving it)
 */
@MarkedToMoveToAdjunctPackage
public enum ReferenceValidationPolicy {
  IGNORE,  // don't validate anything about the reference 
  CHECK_TYPE_IF_EXISTS, // if the reference can be resolved, check that the type of the target is correct
  CHECK_EXISTS, // check that the reference can be resolved, but don't check anything else
  CHECK_EXISTS_AND_TYPE, // check that the reference be resolved, and check that the type of the target is correct
  CHECK_VALID; // check the the reference can be resolved, and then check that it conforms to applicable profiles etc

  public boolean ignore() {
    return this == IGNORE;
  }

  public boolean checkExists() {
    return this == CHECK_EXISTS_AND_TYPE || this == CHECK_EXISTS || this == CHECK_VALID || this == CHECK_TYPE_IF_EXISTS;
  }

  public boolean checkType() {
    return this == CHECK_TYPE_IF_EXISTS || this == CHECK_EXISTS_AND_TYPE || this == CHECK_VALID;
  }

  public boolean checkValid() {
    return this == CHECK_VALID;
  }
}
