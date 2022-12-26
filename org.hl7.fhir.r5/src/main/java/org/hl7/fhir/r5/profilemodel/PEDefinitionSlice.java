package org.hl7.fhir.r5.profilemodel;

import java.util.List;

import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition;

public class PEDefinitionSlice extends PEDefinition {

  protected ElementDefinition sliceDefinition;

  public PEDefinitionSlice(PEBuilder builder, String name, StructureDefinition baseStructure,
      ElementDefinition baseDefinition, StructureDefinition profileStructure, ElementDefinition profileDefinition,
      ElementDefinition sliceDefinition) {
    super(builder, name, baseStructure, baseDefinition, profileStructure, profileDefinition);
    this.sliceDefinition = sliceDefinition;
  }

  @Override
  public void listTypes(List<PEType> types) {
    throw new Error("Not done yet");
  }

  @Override
  protected void makeChildren(String typeUrl, List<PEDefinition> children) {
    throw new Error("Not done yet");
  }

}
