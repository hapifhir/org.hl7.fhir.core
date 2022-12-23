package org.hl7.fhir.r5.profilemodel;

import java.util.List;

import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition;

public class PESlice extends ProfiledElement {

  public PESlice(ProfiledElementBuilder builder, String name, 
      StructureDefinition baseStructure, ElementDefinition baseDefinition, 
      StructureDefinition profileStructure, ElementDefinition profileDefinition,
      ElementDefinition sliceDefinition) {
    super(builder, name, baseStructure, baseDefinition, profileStructure, profileDefinition, sliceDefinition);
  }

  @Override
  public List<String> types() {
    throw new Error("Not done yet");
  }

  @Override
  public List<ProfiledElement> children(String type) {
    throw new Error("Not done yet");
  }

}
