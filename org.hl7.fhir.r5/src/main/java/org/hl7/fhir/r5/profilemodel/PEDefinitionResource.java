package org.hl7.fhir.r5.profilemodel;

import java.util.List;

import org.hl7.fhir.r5.model.StructureDefinition;

public class PEDefinitionResource extends PEDefinition {

  public PEDefinitionResource(PEBuilder builder, StructureDefinition base, StructureDefinition profile) {
    super(builder, profile.getName(), base, base.getSnapshot().getElementFirstRep(), profile, profile.getSnapshot().getElementFirstRep());
  }

  @Override
  public void listTypes(List<PEType> types) {
    types.add(new PEType(profileStructure.getName(), profileStructure.getType(), profileStructure.getUrl()));
  }

  @Override
  protected void makeChildren(String typeUrl, List<PEDefinition> children) {
    children.addAll(builder.listChildren(baseStructure, baseDefinition, profileStructure, profiledDefinition, null));
  }

}
