package org.hl7.fhir.r5.utils;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.Enumerations.BindingStrength;
import org.hl7.fhir.r5.model.StructureDefinition;

public class R5Hacker {

  public static void fixR5BrokenResources(IWorkerContext context) {
    for (StructureDefinition sd : context.fetchResourcesByType(StructureDefinition.class)) {
      fixSD(sd);
    }
  }


  private static void fixSD(StructureDefinition sd) {
    if ("5.0.0-ballot".equals(sd.getVersion()) && "ElementDefinition".equals(sd.getType())) {
      for (ElementDefinition ed : sd.getDifferential().getElement()) {
        hackEDR5BallotError(ed);
      }
      for (ElementDefinition ed : sd.getSnapshot().getElement()) {
        hackEDR5BallotError(ed);
      }
    }
    if ("5.0.0-ballot".equals(sd.getVersion()) && "Base".equals(sd.getType())) {
      for (ElementDefinition ed : sd.getDifferential().getElement()) {
        hackBaseR5BallotError(ed);
      }
      for (ElementDefinition ed : sd.getSnapshot().getElement()) {
        hackBaseR5BallotError(ed);
      }
    }
    if ("5.0.0-ballot".equals(sd.getVersion()) && "Bundle".equals(sd.getType())) {
      for (ElementDefinition ed : sd.getDifferential().getElement()) {
        hackBundleR5BallotError(ed);
      }
      for (ElementDefinition ed : sd.getSnapshot().getElement()) {
        hackBundleR5BallotError(ed);
      }
    }
    if ("5.0.0-ballot".equals(sd.getVersion()) && "http://hl7.org/fhir/StructureDefinition/elementdefinition-defaulttype".equals(sd.getUrl())) {
      sd.getContextFirstRep().setExpression("ElementDefinition");
    }
  }


  private static void hackBaseR5BallotError(ElementDefinition ed) {
    ed.getConstraint().clear(); 
  }

  private static void hackBundleR5BallotError(ElementDefinition ed) {
    if (ed.getPath().equals("Bundle.link.relation")) {
      ToolingExtensions.removeExtension(ed.getBinding(), ToolingExtensions.EXT_BINDING_NAME);
    }    
  }

  private static void hackEDR5BallotError(ElementDefinition ed) {
    if (ed.getPath().equals("ElementDefinition.type.code")) {
      ed.getBinding().setStrength(BindingStrength.EXTENSIBLE);
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
