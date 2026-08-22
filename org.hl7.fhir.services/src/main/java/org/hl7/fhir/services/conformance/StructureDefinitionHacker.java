package org.hl7.fhir.services.conformance;

import org.hl7.fhir.model.core.CanonicalType;
import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionConstraintComponent;
import org.hl7.fhir.model.core.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.model.core.Resource;
import org.hl7.fhir.model.core.StructureDefinition;

import org.hl7.fhir.utilities.VersionUtilities;

/**
 * This works around known issues in structure definitions
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
      for (ElementDefinition ed : sd.getSnapshot().getElementList()) {
        fixDocSecURL(ed);
      } 
      for (ElementDefinition ed : sd.getDifferential().getElementList()) {
        fixDocSecURL(ed);
        if ("ClinicalImpression.problem".equals(ed.getPath())) {
          // work around a bidi problem
          ed.setComment("e.g. The patient is a pregnant, has congestive heart failure, has an Adenocarcinoma, and is allergic to penicillin.");
        }
      }
    }
    if (VersionUtilities.isR4Ver(version) && "http://hl7.org/fhir/StructureDefinition/ClinicalImpression".equals(sd.getUrl())) {
      for (ElementDefinition ed : sd.getSnapshot().getElementList()) {
        if ("ClinicalImpression.problem".equals(ed.getPath())) {
          // work around a bidi problem
          ed.setComment("e.g. The patient is a pregnant, has congestive heart failure, has an Adenocarcinoma, and is allergic to penicillin.");
        }
      } 
      for (ElementDefinition ed : sd.getDifferential().getElementList()) {
        if ("ClinicalImpression.problem".equals(ed.getPath())) {
          // work around a bidi problem
          ed.setComment("e.g. The patient is a pregnant, has congestive heart failure, has an Adenocarcinoma, and is allergic to penicillin.");
        }
      }
    }    
    if (VersionUtilities.isR4Ver(version) && "http://hl7.org/fhir/StructureDefinition/Consent".equals(sd.getUrl())) {
      for (ElementDefinition ed : sd.getSnapshot().getElementList()) {
        if ("Consent.identifier".equals(ed.getPath())) {
          ed.getExampleFirstRep().getValueIdentifier().setSystem("http://acme.org/identifier/local/eCMS");
        }        
      }
      for (ElementDefinition ed : sd.getDifferential().getElementList()) {
        if ("Consent.identifier".equals(ed.getPath())) {
          ed.getExampleFirstRep().getValueIdentifier().setSystem("http://acme.org/identifier/local/eCMS");
        }        
      }
    }
    if (VersionUtilities.isR4Ver(version) && "http://hl7.org/fhir/StructureDefinition/ExplanationOfBenefit".equals(sd.getUrl())) {
      for (ElementDefinition ed : sd.getSnapshot().getElementList()) {
        if (ed.hasBinding() && "http://terminology.hl7.org/CodeSystem/processpriority".equals(ed.getBinding().getValueSet())) {
          ed.getBinding().setValueSet("http://hl7.org/fhir/ValueSet/process-priority");
        }
      }
      for (ElementDefinition ed : sd.getDifferential().getElementList()) {
        if (ed.hasBinding() && "http://terminology.hl7.org/CodeSystem/processpriority".equals(ed.getBinding().getValueSet())) {
          ed.getBinding().setValueSet("http://hl7.org/fhir/ValueSet/process-priority");
        }
      }
    }
    if (sd.getUrl().startsWith("http://hl7.org/fhir/uv/subscriptions-backport")) {
      for (ElementDefinition ed : sd.getDifferential().getElementList()) {
        fixMarkdownR4BURLs(ed);
      }
      for (ElementDefinition ed : sd.getSnapshot().getElementList()) {
        fixMarkdownR4BURLs(ed);
      }
    }
    if ("http://hl7.org/fhir/StructureDefinition/vitalsigns".equals(sd.getUrl()) || "http://hl7.org/fhir/StructureDefinition/vitalsigns".equals(sd.getBaseDefinitionNoVersion())) {
      for (ElementDefinition ed : sd.getDifferential().getElementList()) {
        checkVSConstraint(ed);
      }
      for (ElementDefinition ed : sd.getSnapshot().getElementList()) {
        checkVSConstraint(ed);
      }
    }
    return sd;
  }

  private void checkVSConstraint(ElementDefinition ed) {
    for (ElementDefinitionConstraintComponent constraint : ed.getConstraintList()) {
      if ("vs-1".equals(constraint.getKey())) {
        constraint.setExpression("$this is dateTime implies $this.toString().length() >= 10");
      }
    }
  }

  private void fixMarkdownR4BURLs(ElementDefinition ed) {
    if (ed.hasDefinition()) {
      ed.setDefinition(ed.getDefinition().replace("http://hl7.org/fhir/R4B/", "http://hl7.org/fhir/R4/"));
    } 
    if (ed.hasComment()) {
      ed.setComment(ed.getComment().replace("http://hl7.org/fhir/R4B/", "http://hl7.org/fhir/R4/"));
    }
    if (ed.hasRequirements()) {
      ed.setRequirements(ed.getRequirements().replace("http://hl7.org/fhir/R4B/", "http://hl7.org/fhir/R4/"));
    }
  }

  private void fixDocSecURL(ElementDefinition ed) {
    for (TypeRefComponent tr : ed.getTypeList()) {
      for (CanonicalType c : tr.getProfileList()) {
        if ("http://hl7.org/fhir/StructureDefinition/document-section-library".equals(c.getValue())) {
          c.setValue("http://hl7.org/fhir/StructureDefinition/example-section-library");
        }
      }
    }
  }


}
