package org.hl7.fhir.r4b.utils.validation;

import org.hl7.fhir.r4b.elementmodel.Element;
import org.hl7.fhir.r4b.model.StructureDefinition;

public interface IValidationProfileUsageTracker {
  void recordProfileUsage(StructureDefinition profile, Object appContext, Element element);
}
