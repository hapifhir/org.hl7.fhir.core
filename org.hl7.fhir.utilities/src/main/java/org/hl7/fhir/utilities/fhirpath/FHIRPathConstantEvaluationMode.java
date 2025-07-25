package org.hl7.fhir.utilities.fhirpath;

/**
 * The mode for @resolveConstant() and @resolveConstantType()
 *
 * @see #EXPLICIT
 * @see #NOVALUE
 * @see #IMPLICIT_BEFORE
 * @see #IMPLICIT_AFTER
 */
public enum FHIRPathConstantEvaluationMode {
  /**
   * the FHIRPathEngine has encountered an explicit reference to a constant e.g. %{token} that it does not recognise internally
   */
  EXPLICIT,

  /**
   * The FHIRPathEngine was invoked with no focus provided
   */
  NOVALUE,

  /**
   * The FHIRPath engine is about to evaluate a named property reference, but the Host Application is being offered
   * an opportunity to provide it's own value first
   */
  IMPLICIT_BEFORE,

  /**
   * The FHIRPath engine has evaluated a property and found nothing, and perhaps the Host Application wants to
   * offer a value (constant fall through). This only happens if checkWithHostServicesBeforeHand is true on the FHIRPath engine
   */
  IMPLICIT_AFTER
}
