package org.hl7.fhir.r5.profilemodel;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.StructureDefinition;

public class PEElement extends ProfiledElement {

  public PEElement(ProfiledElementBuilder builder, 
      StructureDefinition baseStructure, ElementDefinition baseDefinition, 
      StructureDefinition profileStructure, ElementDefinition profileDefinition) {
    super(builder, baseDefinition.getName(), baseStructure, baseDefinition, profileStructure, profileDefinition);
  }

  @Override
  public List<String> types() {
    List<String> res = new ArrayList<>();
    for (TypeRefComponent t : profiledDefinition.getType()) {
      if (t.hasProfile()) {
        for (CanonicalType u : t.getProfile()) {
          res.add(t.getWorkingCode()+"["+u.getValue()+"]");
        }
      } else if (!t.getCode().startsWith("http://hl7.org/fhirpath/")) {
        res.add(t.getWorkingCode());
      }
    }
    return res;
  }

  @Override
  public List<ProfiledElement> children(String type) {
    if (children == null) {
      for (TypeRefComponent t : profiledDefinition.getType()) {
        if (t.hasProfile()) {
          for (CanonicalType u : t.getProfile()) {
            if ((t.getWorkingCode()+"["+u.getValue()+"]").equals(type)) {
              children = builder.listChildren(baseStructure, baseDefinition, profileStructure, profiledDefinition, t, u);            
            }
          }
        } else {
          if (t.getWorkingCode().equals(type)) {
            children = builder.listChildren(baseStructure, baseDefinition, profileStructure, profiledDefinition, t);
          }
        }
      }
    }
    if (children != null) {
      return children;
    }
    throw new DefinitionException("Unable to understand type '"+type+"'");
  }

}
