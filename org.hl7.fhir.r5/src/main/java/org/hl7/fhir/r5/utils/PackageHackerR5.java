package org.hl7.fhir.r5.utils;

import org.hl7.fhir.r5.context.CanonicalResourceManager.CanonicalResourceProxy;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.PackageInformation;
import org.hl7.fhir.r5.model.StructureDefinition;

public class PackageHackerR5 {

  public static void fixLoadedResource(CanonicalResourceProxy r, PackageInformation packageInfo) {
   if ("http://terminology.hl7.org/CodeSystem/v2-0391|2.6".equals(r.getUrl())) {
     r.hack("http://terminology.hl7.org/CodeSystem/v2-0391-2.6", "2.6");
   }
   if ("http://terminology.hl7.org/CodeSystem/v2-0391|2.4".equals(r.getUrl())) {
     r.hack("http://terminology.hl7.org/CodeSystem/v2-0391-2.4", "2.4");
   }
   if ("http://terminology.hl7.org/CodeSystem/v2-0360|2.7".equals(r.getUrl())) {
     r.hack("http://terminology.hl7.org/CodeSystem/v2-0360-2.7", "2.7");
   }

   if ("http://terminology.hl7.org/CodeSystem/v2-0006|2.1".equals(r.getUrl())) {
     r.hack("http://terminology.hl7.org/CodeSystem/v2-0006-2.1", "2.1");
   }

   if ("http://terminology.hl7.org/CodeSystem/v2-0360|2.7".equals(r.getUrl())) {
     r.hack("http://terminology.hl7.org/CodeSystem/v2-0360-2.7", "2.7");
   }

   if ("http://terminology.hl7.org/CodeSystem/v2-0006|2.4".equals(r.getUrl())) {
     r.hack("http://terminology.hl7.org/CodeSystem/v2-0006-2.4", "2.4");
   }

   if ("http://terminology.hl7.org/CodeSystem/v2-0360|2.3.1".equals(r.getUrl())) {
     r.hack("http://terminology.hl7.org/CodeSystem/v2-0360-2.3.1", "2.3.1");
   }

   if ("http://hl7.org/fhir/StructureDefinition/iso21090-nullFlavor".equals(r.getUrl()) && "4.0.1".equals(r.getVersion())) {
     StructureDefinition sd = (StructureDefinition) r.getResource();
     for (ElementDefinition ed : sd.getSnapshot().getElement()) {
       if (ed.hasBinding() && "http://terminology.hl7.org/ValueSet/v3-NullFlavor|4.0.1".equals(ed.getBinding().getValueSet())) {
         ed.getBinding().setValueSet("http://terminology.hl7.org/ValueSet/v3-NullFlavor");
       }
     }
     for (ElementDefinition ed : sd.getDifferential().getElement()) {
       if (ed.hasBinding() && "http://terminology.hl7.org/ValueSet/v3-NullFlavor|4.0.1".equals(ed.getBinding().getValueSet())) {
         ed.getBinding().setValueSet("http://terminology.hl7.org/ValueSet/v3-NullFlavor");
       }
     }
   }
   if ("http://hl7.org/fhir/StructureDefinition/DeviceUseStatement".equals(r.getUrl()) && "4.0.1".equals(r.getVersion())) {
     StructureDefinition sd = (StructureDefinition) r.getResource();
     for (ElementDefinition ed : sd.getSnapshot().getElement()) {
       if (ed.hasRequirements()) {
         ed.setRequirements(ed.getRequirements().replace("[http://hl7.org/fhir/StructureDefinition/bodySite](null.html)", "[http://hl7.org/fhir/StructureDefinition/bodySite](http://hl7.org/fhir/extension-bodysite.html)"));
       }
     }
     for (ElementDefinition ed : sd.getDifferential().getElement()) {
       if (ed.hasRequirements()) {
         ed.setRequirements(ed.getRequirements().replace("[http://hl7.org/fhir/StructureDefinition/bodySite](null.html)", "[http://hl7.org/fhir/StructureDefinition/bodySite](http://hl7.org/fhir/extension-bodysite.html)"));
       }
     }
   }
   if (r.hasUrl() && r.getUrl().contains("|")) {
     assert false;
   }
   
  }

}
