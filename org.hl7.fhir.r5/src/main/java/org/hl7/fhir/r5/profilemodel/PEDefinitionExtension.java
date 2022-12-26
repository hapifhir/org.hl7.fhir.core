package org.hl7.fhir.r5.profilemodel;

import java.util.List;

import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.StructureDefinition;

public class PEDefinitionExtension extends PEDefinition {

  private StructureDefinition extension;
  private ElementDefinition sliceDefinition;

  public PEDefinitionExtension(PEBuilder builder, String name, 
      StructureDefinition baseStructure, ElementDefinition baseDefinition, 
      StructureDefinition profileStructure, ElementDefinition profileDefinition,
      ElementDefinition sliceDefinition, StructureDefinition extension) {
    super(builder, name, baseStructure, baseDefinition, profileStructure, profileDefinition);
    this.sliceDefinition = sliceDefinition;
    this.extension= extension;
  }

  @Override
  public void listTypes(List<PEType> types) {
    ElementDefinition eed = extension.getSnapshot().getElementByPath("Extension.extension");
    ElementDefinition ved = extension.getSnapshot().getElementByPath("Extension.value[x]"); 
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

  @Override
  protected void makeChildren(String typeUrl, List<PEDefinition> children) {
    ElementDefinition eed = extension.getSnapshot().getElementByPath("Extension.extension");
    ElementDefinition ved = extension.getSnapshot().getElementByPath("Extension.value[x]"); 
    if (ved.isRequired() || eed.isProhibited()) {
      children.addAll(builder.listChildren(extension, ved, extension, ved, typeUrl));
    } else {
      children.addAll(builder.listSlices(extension, eed, extension, eed));
    }
  }

}
