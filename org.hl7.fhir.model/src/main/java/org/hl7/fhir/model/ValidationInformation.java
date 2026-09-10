package org.hl7.fhir.model;

import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.model.core.StructureDefinition;

/**
 * Post Validation Information
 * Added by the validator during validation, retained for interest
 *
 */
public class ValidationInformation {

  public enum ValidationReason {
    Validation, MatchingSlice, Expression
  }

  public enum ProfileSource {
    BaseDefinition, ConfigProfile, MetaProfile, ProfileDependency, FromExpression,  GlobalProfile
  }

  public static class ValidationMode {
    private ValidationReason reason;
    private ProfileSource source;
    public ValidationMode(ValidationReason reason, ProfileSource source) {
      super();
      this.reason = reason;
      this.source = source;
    }
    public ValidationReason getReason() {
      return reason;
    }
    public ProfileSource getSource() {
      return source;
    }
    public ValidationMode withSource(ProfileSource source) {
      ValidationMode res = new ValidationMode(reason, source);
      return res;
    }
    public ValidationMode withReason(ValidationReason reason) {
      ValidationMode res = new ValidationMode(reason, source);
      return res;
    }
  }

  private StructureDefinition structure;
  private ElementDefinition definition;
  private ValidationReason reason;
  private ProfileSource source;
  private boolean valid;

  public ValidationInformation(StructureDefinition structure, ElementDefinition definition, ValidationMode mode) {
    super();
    this.structure = structure;
    this.definition = definition;
    this.reason = mode.reason;
    this.source = mode.source;
  }

  public StructureDefinition getStructure() {
    return structure;
  }

  public ElementDefinition getDefinition() {
    return definition;
  }

  public ValidationReason getReason() {
    return reason;
  }

  public ProfileSource getSource() {
    return source;
  }

  public boolean isValid() {
    return valid;
  }

  public void setValid(boolean valid) {
    this.valid = valid;
  }

}
