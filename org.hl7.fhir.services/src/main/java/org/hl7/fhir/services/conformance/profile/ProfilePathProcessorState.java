package org.hl7.fhir.services.conformance.profile;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.hl7.fhir.model.core.StructureDefinition;

@AllArgsConstructor(access = AccessLevel.PROTECTED)

public class ProfilePathProcessorState {
  protected StructureDefinition baseSource; 
  protected StructureDefinition.StructureDefinitionSnapshotComponent base;

  protected int baseCursor;
  protected int diffCursor;

  protected String contextName;
  protected String resultPathBase;

}
