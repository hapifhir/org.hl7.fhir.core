package org.hl7.fhir.r4b.utils.validation.constants;

import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;

@MarkedToMoveToAdjunctPackage
public enum BindingKind {
  /**
   * The primary binding e.g. ElementDefinition.binding.valueSet
   */
  PRIMARY,

  /**
   * The max value set
   */
  MAX_VS;

}
