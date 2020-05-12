package org.hl7.fhir.r5.utils;

import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.utilities.Utilities;

public class KeyGenerator {

  private String canonical; 
  int i = 0;
  
  public KeyGenerator(String canonical) {
    super();
    this.canonical = canonical;
  }

  public void genId(DomainResource dr) {
    i++;
    dr.setId(getAcronym(dr.fhirType())+Integer.toString(i));
    if (dr instanceof CanonicalResource) {
      CanonicalResource mr = (CanonicalResource) dr;
      mr.setUrl(Utilities.pathURL(canonical, mr.fhirType(), mr.getId()));
    }
  }

  private String getAcronym(String rt) {
    if ("CapabilityStatement".equals(rt)) {
      return "cs";
    }
    if ("ValueSet".equals(rt)) {
      return "vs";
    }
    if ("CodeSystem".equals(rt)) {
      return "cs";
    }
    if ("StructureDefinition".equals(rt)) {
      return "sd";
    }
    if ("StructureMap".equals(rt)) {
      return "sm";
    }
    if ("ConceptMap".equals(rt)) {
      return "cm";
    }
    if ("ImplementationGuide".equals(rt)) {
      return "";
    }
    if ("SearchParameter".equals(rt)) {
      return "sp";
    }
    if ("MessageDefinition".equals(rt)) {
      return "md";
    }
    if ("OperationDefinition".equals(rt)) {
      return "od";
    }
    if ("CompartmentDefinition".equals(rt)) {
      return "cd";
    }
    if ("GraphDefinition".equals(rt)) {
      return "gd";
    }
    if ("ExampleScenario".equals(rt)) {
      return "es";
    }
    if ("NamingSystem".equals(rt)) {
      return "ns";
    }
    if ("TerminologyCapabilities".equals(rt)) {
      return "tc";
    }
    return "r";
  }

}