package org.hl7.fhir.validation.cli.model;

import org.hl7.fhir.r5.elementmodel.ValidatedFragment;

import java.util.List;

public class ValidatedFragments {

  public List<ValidatedFragment> getValidatedFragments() {
    return validatedFragments;
  }

  public ValidationTime getValidationTime() {
    return validationTime;
  }

  private List<ValidatedFragment> validatedFragments;

  private ValidationTime validationTime;

  public ValidatedFragments(List<ValidatedFragment> validatedFragments, ValidationTime validationTime) {
    this.validatedFragments = validatedFragments;
    this.validationTime = validationTime;
  }

}
