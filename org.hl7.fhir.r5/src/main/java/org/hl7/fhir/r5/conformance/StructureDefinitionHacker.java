package org.hl7.fhir.r5.conformance;

import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.VersionUtilities;

/**
 * This doesn't do anythign at this time
 * 
 * @author graha
 *
 */
public class StructureDefinitionHacker {

  private String version;

  public StructureDefinitionHacker(String version) {
    super();
    this.version = version;
  }

  public Resource fixSD(StructureDefinition sd) {
    if (VersionUtilities.isR4Ver(version) && "http://hl7.org/fhir/StructureDefinition/example-composition".equals(sd.getUrl())) {
      for (ElementDefinition ed : sd.getSnapshot().getElement()) {
        fixDocSecURL(ed);
      } 
      for (ElementDefinition ed : sd.getDifferential().getElement()) {
        fixDocSecURL(ed);
        if ("ClinicalImpression.problem".equals(ed.getPath())) {
          // work around a bidi problem
          ed.setComment("e.g. The patient is a pregnant, has congestive heart failure, has an Adenocarcinoma, and is allergic to penicillin.");
        }
      }
    }
    if (VersionUtilities.isR4Ver(version) && "http://hl7.org/fhir/StructureDefinition/ClinicalImpression".equals(sd.getUrl())) {
      for (ElementDefinition ed : sd.getSnapshot().getElement()) {
        if ("ClinicalImpression.problem".equals(ed.getPath())) {
          // work around a bidi problem
          ed.setComment("e.g. The patient is a pregnant, has congestive heart failure, has an Adenocarcinoma, and is allergic to penicillin.");
        }
      } 
      for (ElementDefinition ed : sd.getDifferential().getElement()) {
        if ("ClinicalImpression.problem".equals(ed.getPath())) {
          // work around a bidi problem
          ed.setComment("e.g. The patient is a pregnant, has congestive heart failure, has an Adenocarcinoma, and is allergic to penicillin.");
        }
      }
    }
    return sd;
  }

  private void fixDocSecURL(ElementDefinition ed) {
    for (TypeRefComponent tr : ed.getType()) {
      for (CanonicalType c : tr.getProfile()) {
        if ("http://hl7.org/fhir/StructureDefinition/document-section-library".equals(c.getValue())) {
          c.setValue("http://hl7.org/fhir/StructureDefinition/example-section-library");
        }
      }
    }
  }


}
