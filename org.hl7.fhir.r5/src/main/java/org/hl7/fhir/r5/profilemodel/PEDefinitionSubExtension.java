package org.hl7.fhir.r5.profilemodel;

import java.util.List;

import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.SlicingRules;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.profilemodel.PEDefinition.PEDefinitionElementMode;
import org.hl7.fhir.r5.model.StructureDefinition;

public class PEDefinitionSubExtension extends PEDefinition {

  private ElementDefinition eed;
  private ElementDefinition ved;
  private ElementDefinition ued;

  public PEDefinitionSubExtension(PEBuilder builder, StructureDefinition profile, ElementDefinition definition, String ppath) {
    super(builder, definition.getSliceName(), profile, definition, ppath);
    List<ElementDefinition> childDefs = builder.getChildren(profile, definition);    
    eed = getElementByName(childDefs, "extension");
    ved = getElementByName(childDefs, "value[x]"); 
    ued = getElementByName(childDefs, "url");
  }

  @Override
  public void listTypes(List<PEType> types) {
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
  protected void makeChildren(String typeUrl, List<PEDefinition> children, boolean allFixed) {
    if (ved.isRequired() || eed.isProhibited()) {
      children.addAll(builder.listChildren(allFixed, this, profile, ved, typeUrl));
    } else {
      if (eed.getSlicing().getRules() != SlicingRules.CLOSED) {
        children.addAll(builder.listChildren(allFixed, this, profile, eed, "http://hl7.org/fhir/StructureDefinition/Extension", "value[x]", "url"));
      } 
      children.addAll(builder.listSlices(profile, eed, this));
    }
  }

  @Override
  public String fhirpath() {
    if (ved.isRequired() || eed.isProhibited()) {
      return "extension('"+ued.getFixed().primitiveValue()+"').value";
    } else {
      return "extension('"+ued.getFixed().primitiveValue()+"')";
    }
  }

  public PEDefinitionElementMode mode() {
    return PEDefinitionElementMode.Extension;
  }

}
