package org.hl7.fhir.r5.conformance;

import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.VersionUtilities;

public class StructureDefinitionHacker {

  private String version;

  public StructureDefinitionHacker(String version) {
    super();
    this.version = version;
  }

  public Resource fixSD(StructureDefinition sd) {
    if (VersionUtilities.isR4BVer(version) && sd.getUrl().equals("http://hl7.org/fhir/StructureDefinition/structuredefinition-fhir-type")) {
      // the definition of this one is wrong in R4B
      return fixR4BFhirType(sd);
    }
    return sd;
  }

  private Resource fixR4BFhirType(StructureDefinition sd) {
    for (ElementDefinition ed : sd.getDifferential().getElement()) {
      if (ed.getPath().equals("Extension.value[x]")) {
        fixEDType(ed, "url", "uri");
      }
    }
    for (ElementDefinition ed : sd.getSnapshot().getElement()) {
      if (ed.getPath().equals("Extension.value[x]")) {
        fixEDType(ed, "url", "uri");
      }
    }
    return sd;
  }

  private void fixEDType(ElementDefinition ed, String orig, String repl) {
    for (TypeRefComponent t : ed.getType()) {
      if (orig.equals(t.getCode())) {
        t.setCode(repl);
      }
    }    
  }

}
