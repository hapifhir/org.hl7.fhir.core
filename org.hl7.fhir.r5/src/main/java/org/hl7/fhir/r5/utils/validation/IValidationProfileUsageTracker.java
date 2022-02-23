package org.hl7.fhir.r5.utils.validation;

import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.StructureDefinition;

public interface IValidationProfileUsageTracker {
  void recordProfileUsage(StructureDefinition profile, Object appContext, Element element);
}
