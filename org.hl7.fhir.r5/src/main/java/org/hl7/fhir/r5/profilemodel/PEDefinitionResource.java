package org.hl7.fhir.r5.profilemodel;

import java.util.List;

import org.hl7.fhir.r5.model.StructureDefinition;

public class PEDefinitionResource extends PEDefinition {

  public PEDefinitionResource(PEBuilder builder, StructureDefinition profile, String ppath) {
    super(builder, profile.getName(), profile, profile.getSnapshot().getElementFirstRep(), ppath);
  }

  @Override
  public void listTypes(List<PEType> types) {
    types.add(new PEType(profile.getName(), profile.getType(), profile.getUrl()));
  }

  @Override
  protected void makeChildren(String typeUrl, List<PEDefinition> children, boolean allFixed) {
    children.addAll(builder.listChildren(allFixed, this, profile, definition, null));
  }

  @Override
  public String fhirpath() {
    return profile.getType();
  }

  
}
