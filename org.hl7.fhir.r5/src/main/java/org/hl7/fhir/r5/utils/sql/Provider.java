package org.hl7.fhir.r5.utils.sql;

import java.util.List;

import org.hl7.fhir.r5.model.Base;

public interface Provider {
  List<Base> fetch(String resourceType);

  Base resolveReference(Base rootResource, String ref, String specifiedResourceType);
}
