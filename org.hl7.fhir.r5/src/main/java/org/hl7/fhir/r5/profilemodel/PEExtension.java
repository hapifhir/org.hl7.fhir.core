package org.hl7.fhir.r5.profilemodel;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;

public class PEExtension extends ProfiledElement {

  private StructureDefinition extension;

  public PEExtension(ProfiledElementBuilder builder, String name, 
      StructureDefinition baseStructure, ElementDefinition baseDefinition, 
      StructureDefinition profileStructure, ElementDefinition profileDefinition,
      ElementDefinition sliceDefinition, StructureDefinition extension) {
    super(builder, name, baseStructure, baseDefinition, profileStructure, profileDefinition, sliceDefinition);
    this.extension= extension;
  }

  @Override
  public List<String> types() {
    List<String> res = new ArrayList<>();
    ElementDefinition eed = extension.getSnapshot().getElementByPath("Extension.extension");
    ElementDefinition ved = extension.getSnapshot().getElementByPath("Extension.value[x]"); 
    if (ved.isRequired() || eed.isProhibited()) {
      for (TypeRefComponent t : ved.getType()) {
        if (t.hasProfile()) {
          for (CanonicalType u : t.getProfile()) {
            res.add(t.getWorkingCode()+"["+u.getValue()+"]");
          }
        } else {
          res.add(t.getWorkingCode());
        }
      }
    } else {
      res.add("Extension");
    }
    return res;
  }

  @Override
  public List<ProfiledElement> children(String type) {
    throw new Error("Not done yet");

  }

}
