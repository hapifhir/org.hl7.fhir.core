package org.hl7.fhir.r5.profilemodel;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.model.StructureDefinition;

public class PEResource extends ProfiledElement {

  public PEResource(ProfiledElementBuilder builder, StructureDefinition base, StructureDefinition profile) {
    super(builder, profile.getName(), base, base.getSnapshot().getElementFirstRep(), profile, profile.getSnapshot().getElementFirstRep());
  }

  @Override
  public List<String> types() {
    List<String> res = new ArrayList<>();
    res.add(profileStructure.getType());
    return res;
  }

  @Override
  public List<ProfiledElement> children(String type) {
    if (children == null) {
     children = builder.listChildren(baseStructure, baseDefinition, profileStructure, profiledDefinition, null);
    }
    return children; 
  }

}
