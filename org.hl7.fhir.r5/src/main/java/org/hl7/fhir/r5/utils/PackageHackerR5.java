package org.hl7.fhir.r5.utils;

import org.hl7.fhir.r5.context.CanonicalResourceManager.CanonicalResourceProxy;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.Enumerations.BindingStrength;
import org.hl7.fhir.utilities.Utilities;
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
   if (r.getUrl() != null && r.getUrl().startsWith("http://hl7.org/fhir/StructureDefinition/") && "StructureDefinition".equals(r.getType()) && "4.0.1".equals(r.getVersion())) {
     // the R4 profile wrongly applies this value set to all types. Fixing it properly is too big a thing to do here, but we can at least back off the binding strength
     StructureDefinition sd = (StructureDefinition) r.getResource();
     if (sd.getType().equals("Observation") && ("http://hl7.org/fhir/StructureDefinition/vitalsigns".equals(sd.getUrl()) || "http://hl7.org/fhir/StructureDefinition/vitalsigns".equals(sd.getBaseDefinition()))) {
       for (ElementDefinition ed : sd.getSnapshot().getElement()) {
         if (ed.getPath().equals("Observation.component.value[x]") && ed.hasBinding() && "http://hl7.org/fhir/ValueSet/ucum-vitals-common|4.0.1".equals(ed.getBinding().getValueSet())) {
           ed.getBinding().setStrength(BindingStrength.EXTENSIBLE);
         }
       }
       for (ElementDefinition ed : sd.getDifferential().getElement()) {
         if (ed.getPath().equals("Observation.component.value[x]") && ed.hasBinding() && "http://hl7.org/fhir/ValueSet/ucum-vitals-common|4.0.1".equals(ed.getBinding().getValueSet())) {
           ed.getBinding().setStrength(BindingStrength.EXTENSIBLE);
         }
       }
     }
   }
   // work around an r2b issue
   if (packageInfo.getId().equals("hl7.fhir.r2b.core") && r.getType().equals("StructureDefinition")) {
     StructureDefinition sd = (StructureDefinition) r.getResource();
     for (ElementDefinition ed : sd.getSnapshot().getElement()) {
       if (ed.getPath().equals(sd.getType()+".id")) {
         ed.getBase().setMax("1");
       }
     }
   }
   
   // work around a r4 version of extension pack issue
   if (packageInfo.getId().equals("hl7.fhir.uv.extensions.r4") && r.getType().equals("StructureDefinition")) {
     StructureDefinition sd = (StructureDefinition) r.getResource();
     for (ElementDefinition ed : sd.getSnapshot().getElement()) {
       if (ed.getType().removeIf(tr -> Utilities.existsInList(tr.getCode(), "integer64", "CodeableReference", "RatioRange", "Availability", "ExtendedContactDetail"))) {
         sd.setUserData("fixed-by-loader", true);
       }
     }
     for (ElementDefinition ed : sd.getDifferential().getElement()) {
       if (ed.getType().removeIf(tr -> Utilities.existsInList(tr.getCode(), "integer64", "CodeableReference", "RatioRange", "Availability", "ExtendedContactDetail"))) {
         sd.setUserData("fixed-by-loader", true);
       }
     }
   }
   if (r.hasUrl() && r.getUrl().contains("|")) {
     assert false;
   }
   
  }

}
