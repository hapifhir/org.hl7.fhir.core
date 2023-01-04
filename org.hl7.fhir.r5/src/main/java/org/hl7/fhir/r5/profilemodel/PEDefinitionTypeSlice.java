package org.hl7.fhir.r5.profilemodel;

import java.util.List;

import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;

public class PEDefinitionTypeSlice extends PEDefinition {

  protected ElementDefinition sliceDefinition;

  public PEDefinitionTypeSlice(PEBuilder builder, String name, StructureDefinition profile, ElementDefinition definition, ElementDefinition sliceDefinition, String ppath) {
    super(builder, name, profile, definition, ppath);
    this.sliceDefinition = sliceDefinition;
  }

  @Override
  public void listTypes(List<PEType> types) {
    for (TypeRefComponent t : definition.getType()) {
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
  protected void makeChildren(String typeUrl, List<PEDefinition> children, boolean allFixed) {
    children.addAll(builder.listChildren(allFixed, this, profile, definition, typeUrl));            
  }

  @Override
  public String fhirpath() {
    String base = definition.getName().replace("[x]", "");
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder(" | ");
    for (TypeRefComponent t : definition.getType()) {
      b.append(base+".ofType("+t.getWorkingCode()+")");
    }
    return b.toString();
  }

}
