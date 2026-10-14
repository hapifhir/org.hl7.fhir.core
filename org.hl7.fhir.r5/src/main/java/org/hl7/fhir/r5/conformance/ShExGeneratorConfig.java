package org.hl7.fhir.r5.conformance;

import java.util.Objects;

public class ShExGeneratorConfig {

  private final boolean doDatatypes;
  private final boolean withComments;
  private final boolean completeModel;
  private final boolean debugMode;
  private final boolean processConstraints;
  private final ShExGeneratorBase.ConstraintTranslationPolicy constraintPolicy;

  public ShExGeneratorConfig(boolean doDatatypes, boolean withComments, boolean completeModel, boolean debugMode,
      boolean processConstraints, ShExGeneratorBase.ConstraintTranslationPolicy constraintPolicy) {
    this.doDatatypes = doDatatypes;
    this.withComments = withComments;
    this.completeModel = completeModel;
    this.debugMode = debugMode;
    this.processConstraints = processConstraints;
    this.constraintPolicy = Objects.requireNonNull(constraintPolicy, "constraintPolicy");
  }

  public static ShExGeneratorConfig defaultConfig() {
    return new ShExGeneratorConfig(false, true, false, false, false, ShExGeneratorBase.ConstraintTranslationPolicy.ALL);
  }

  public boolean isDoDatatypes() {
    return doDatatypes;
  }

  public boolean isWithComments() {
    return withComments;
  }

  public boolean isCompleteModel() {
    return completeModel;
  }

  public boolean isDebugMode() {
    return debugMode;
  }

  public boolean isProcessConstraints() {
    return processConstraints;
  }

  public ShExGeneratorBase.ConstraintTranslationPolicy getConstraintPolicy() {
    return constraintPolicy;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof ShExGeneratorConfig)) {
      return false;
    }
    ShExGeneratorConfig other = (ShExGeneratorConfig) obj;
    return doDatatypes == other.doDatatypes
      && withComments == other.withComments
      && completeModel == other.completeModel
      && debugMode == other.debugMode
      && processConstraints == other.processConstraints
      && constraintPolicy == other.constraintPolicy;
  }

  @Override
  public int hashCode() {
    return Objects.hash(doDatatypes, withComments, completeModel, debugMode, processConstraints, constraintPolicy);
  }
}