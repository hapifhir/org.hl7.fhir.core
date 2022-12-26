package org.hl7.fhir.r5.profilemodel;

import java.util.List;

import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.StructureDefinition;

public class PEDefinitionSubExtension extends PEDefinition {

  public PEDefinitionSubExtension(PEBuilder builder, StructureDefinition baseStructure, ElementDefinition baseDefinition, StructureDefinition profileStructure, ElementDefinition profileDefinition) {
    super(builder, profileDefinition.getSliceName(), baseStructure, baseDefinition, profileStructure, profileDefinition);
  }

  @Override
  public void listTypes(List<PEType> types) {
    List<ElementDefinition> childDefs = builder.getChildren(profileStructure, profiledDefinition);    
    ElementDefinition eed = getElementByName(childDefs, "extension");
    ElementDefinition ved = getElementByName(childDefs, "value[x]"); 
    if (ved.isRequired() || eed.isProhibited()) {
      for (TypeRefComponent t : ved.getType()) {
        if (t.hasProfile()) {
          for (CanonicalType u : t.getProfile()) {
            types.add(builder.makeType(t, u));
          }
        } else {
          types.add(builder.makeType(t.getWorkingCode()));
        }
      }
    } else {
      types.add(builder.makeType("Extension"));
    }
  }

  private ElementDefinition getElementByName(List<ElementDefinition> children, String name) {
    for (ElementDefinition ed : children) {
      if (name.equals(ed.getName())) {
        return ed;
      }
    }
    return null;
  }

  @Override
  protected void makeChildren(String typeUrl, List<PEDefinition> children) {
    List<ElementDefinition> childDefs = builder.getChildren(profileStructure, profiledDefinition);    
    ElementDefinition eed = getElementByName(childDefs, "extension");
    ElementDefinition ved = getElementByName(childDefs, "value[x]"); 
    if (ved.isRequired() || eed.isProhibited()) {
      children.addAll(builder.listChildren(baseStructure, baseDefinition, profileStructure, ved, typeUrl));
    } else {
      children.addAll(builder.listSlices(baseStructure, baseDefinition, profileStructure, eed));
    }
  }

}
