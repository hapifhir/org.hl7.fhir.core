package org.hl7.fhir.r5.utils;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.Enumerations.BindingStrength;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.model.StructureDefinition;

public class R5Hacker {

  public static void fixR5BrokenResources(IWorkerContext context) {
    for (StructureDefinition sd : context.fetchResourcesByType(StructureDefinition.class)) {
      fixSD(sd);
    }
  }


  private static void fixSD(StructureDefinition sd) {
    if (sd.getDerivation() == TypeDerivationRule.CONSTRAINT) {
      for (ElementDefinition ed : sd.getDifferential().getElement()) {
        fix(ed);
      }
      for (ElementDefinition ed : sd.getSnapshot().getElement()) {
        fix(ed);
      }
    }
  }


  private static void fix(ElementDefinition ed) {
    if (ed.hasDefinition()) {
      ed.setDefinition(ed.getDefinition().replace("http://hl7.org/fhir/5.0.0-snapshot3/", "http://hl7.org/fhir/R5/"));
    }
    
  }


  public static CanonicalResource fixR5BrokenResource(CanonicalResource cr) {
    if (cr instanceof StructureDefinition) {
      StructureDefinition sd = (StructureDefinition) cr;
      fixSD(sd);
    }
    return cr;
  }
  
}
