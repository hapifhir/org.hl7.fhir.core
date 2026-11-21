package org.hl7.fhir.r5.utils.validation.constants;

/**
 * @deprecated the validator has never acted on this setting (displays are checked against the code
 * system regardless). It is kept, and ignored, so that existing code still compiles, and will be removed
 */
@Deprecated
public enum CheckDisplayOption {
  Ignore,
  Check,
  CheckCaseAndSpace,
  CheckCase,
  CheckSpace
}
