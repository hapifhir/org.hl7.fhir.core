package org.hl7.fhir.r5.utils.validation;

import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;

@MarkedToMoveToAdjunctPackage
public interface IValidationProfileUsageTracker {
  void recordProfileUsage(StructureDefinition profile, Object appContext, Element element);
}
