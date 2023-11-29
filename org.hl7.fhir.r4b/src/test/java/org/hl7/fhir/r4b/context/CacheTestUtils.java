package org.hl7.fhir.r4b.context;

import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.validation.ValidationOptions;

public class CacheTestUtils {
  public static final ValidationOptions validationOptions = new ValidationOptions(FhirPublication.R4B).withGuessSystem()
      .withVersionFlexible(false);

}
