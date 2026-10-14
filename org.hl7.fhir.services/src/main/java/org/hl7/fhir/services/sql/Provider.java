package org.hl7.fhir.services.sql;

import org.hl7.fhir.model.Base;

import java.util.List;


public interface Provider {
  List<Base> fetch(String resourceType);

  Base resolveReference(Base rootResource, String ref, String specifiedResourceType);
}
