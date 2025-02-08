package org.hl7.fhir.r5.utils.sql;

import java.util.List;

import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;

@MarkedToMoveToAdjunctPackage
public interface Provider {
  List<Base> fetch(String resourceType);

  Base resolveReference(Base rootResource, String ref, String specifiedResourceType);
}
