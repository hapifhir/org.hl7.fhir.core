package org.hl7.fhir.r5.profilemodel;

import java.util.List;

import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.SlicingRules;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.profilemodel.PEDefinition.PEDefinitionElementMode;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r5.model.StructureDefinition;

public class PEDefinitionExtension extends PEDefinition {

  private StructureDefinition extension;
  private ElementDefinition sliceDefinition;
  private ElementDefinition eed;
  private ElementDefinition ved;

  public PEDefinitionExtension(PEBuilder builder, String name, StructureDefinition profile, ElementDefinition definition, ElementDefinition sliceDefinition, StructureDefinition extension, String ppath) {
    super(builder, name, profile, definition, ppath);
    this.sliceDefinition = sliceDefinition;
    this.extension= extension;
    eed = extension.getSnapshot().getElementByPath("Extension.extension");
    ved = extension.getSnapshot().getElementByPath("Extension.value[x]"); 
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

  @Override
  protected void makeChildren(String typeUrl, List<PEDefinition> children, boolean allFixed) {
    if (ved.isRequired() || eed.isProhibited()) {
      children.addAll(builder.listChildren(allFixed, this, extension, ved, typeUrl));
    } else {
      if (eed.getSlicing().getRules() != SlicingRules.CLOSED) {
        children.addAll(builder.listChildren(allFixed, this, extension, eed, "http://hl7.org/fhir/StructureDefinition/Extension", "value[x]", "url"));
      }      
      children.addAll(builder.listSlices(extension, eed, this));
    }
  }

  @Override
  public String fhirpath() {
    if (ved.isRequired() || eed.isProhibited()) {
      return "extension('"+extension.getUrl()+"').value";
    } else {
      return "extension('"+extension.getUrl()+"')";      
    }
  }

  public PEDefinitionElementMode mode() {
    return PEDefinitionElementMode.Extension;
  }
}
