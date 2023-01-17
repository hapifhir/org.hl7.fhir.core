package org.hl7.fhir.r5.profilemodel;

import java.util.List;

import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;

public class PEDefinitionElement extends PEDefinition {

  public PEDefinitionElement(PEBuilder builder, StructureDefinition profile, ElementDefinition definition, String ppath) {
    super(builder, definition.getName(), profile, definition, ppath);
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
    if (definition.hasSlicing()) {
      // get all the slices 
      CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder(" or ");
      List<PEDefinition> slices = builder.listSlices(profile, definition, this);
      // list all the fhirpaths
      for (PEDefinition slice : slices) {
        b.append("("+builder.makeSliceExpression(profile, definition.getSlicing(), slice.definition())+")");
      }
      if (b.count() == 0)
        return base;
      else
        return base+".where(("+b.toString()+").not())";
    } else {
      return base;
    }
  }


}
