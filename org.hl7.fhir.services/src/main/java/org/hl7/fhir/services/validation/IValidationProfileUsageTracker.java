package org.hl7.fhir.services.validation;

import org.hl7.fhir.services.elementmodel.Element;
import org.hl7.fhir.model.core.StructureDefinition;

public interface IValidationProfileUsageTracker {
  void recordProfileUsage(StructureDefinition profile, Object appContext, Element element);
}
