package org.hl7.fhir.r5.conformance.profile;

import org.hl7.fhir.r5.model.StructureDefinition;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ProfilePathProcessorState {
  protected StructureDefinition.StructureDefinitionSnapshotComponent base;

  protected int baseCursor;
  protected int diffCursor;

  protected String contextName;
  protected String resultPathBase;

}
