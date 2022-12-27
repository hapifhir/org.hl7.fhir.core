package org.hl7.fhir.r5.profilemodel;

import java.util.List;

import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;

public class PEDefinitionTypeSlice extends PEDefinition {

  protected ElementDefinition sliceDefinition;

  public PEDefinitionTypeSlice(PEBuilder builder, String name, StructureDefinition baseStructure,
      ElementDefinition baseDefinition, StructureDefinition profileStructure, ElementDefinition profileDefinition,
      ElementDefinition sliceDefinition) {
    super(builder, name, baseStructure, baseDefinition, profileStructure, profileDefinition);
    this.sliceDefinition = sliceDefinition;
  }

  @Override
  public void listTypes(List<PEType> types) {
    for (TypeRefComponent t : profiledDefinition.getType()) {
      if (t.hasProfile()) {
        for (CanonicalType u : t.getProfile()) {
          types.add(builder.makeType(t, u));
        }
      } else if (!t.getCode().startsWith("http://hl7.org/fhirpath/")) {
        types.add(new PEType(t.getWorkingCode(), t.getWorkingCode(), "http://hl7.org/fhir/StructureDefinition/"+t.getWorkingCode()));
      }
    }
  }

  @Override
  protected void makeChildren(String typeUrl, List<PEDefinition> children) {
    children.addAll(builder.listChildren(baseStructure, baseDefinition, profileStructure, profiledDefinition, typeUrl));            
  }

  @Override
  public String fhirpath() {
    throw new Error("Not done yet");
  }

}
