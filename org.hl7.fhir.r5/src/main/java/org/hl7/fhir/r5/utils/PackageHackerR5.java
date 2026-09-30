package org.hl7.fhir.r5.utils;

import org.hl7.fhir.r5.context.CanonicalResourceProxy;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Enumerations.BindingStrength;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.MarkdownType;
import org.hl7.fhir.r5.model.PackageInformation;
import org.hl7.fhir.r5.model.StructureDefinition;

import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;

/**
 * Work arounds for problems in published packages that can't (practically) be fixed in the packages themselves.
 * All the hacks live here, so that there's one place to look:
 *
 * - fixRegisteredResource(proxy, packageInfo): when a resource is registered from a package (before it is loaded)
 * - fixLoadedResource(resource): when a resource is actually loaded from a package
 * - fixBindingDescriptions(context, md): when a binding description is rendered
 *
 * The R6 equivalent is org.hl7.fhir.services.utilities.PackageHackerRN
 *
 * Known limitation (a bug, not yet fixed): these fixes are only applied to resources that are
 * registered and loaded through the package path (registerResourceFromPackage / PackageResourceLoader).
 * Resources loaded through SimpleWorkerContext.loadDefinitionItem - package entries without an id in
 * the index, loose files and zips, and the definitions loaded by loadFromPackage for the core spec
 * source - bypass them, and so do not get fixed.
 */
public class PackageHackerR5 {

  private static final String SIMPLE_QUANTITY = "http://hl7.org/fhir/StructureDefinition/SimpleQuantity";

  public static void fixRegisteredResource(CanonicalResourceProxy r, PackageInformation packageInfo) {
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

   if ("http://hl7.org/fhir/ValueSet/languages".equals(r.getUrl())) {
     r.getResource().setExperimental(false);
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
   if ("http://hl7.org/fhir/StructureDefinition/ServiceRequest".equals(r.getUrl()) && "4.0.1".equals(r.getVersion())) {
     StructureDefinition sd = (StructureDefinition) r.getResource();
     for (ElementDefinition ed : sd.getSnapshot().getElement()) {
       if (ed.hasBinding()) {
         if ("Codes for tests or services that can be carried out by a designated individual, organization or healthcare service.  For laboratory, LOINC is  (preferred)[http://build.fhir.org/terminologies.html#preferred] and a valueset using LOINC Order codes is available [here](valueset-diagnostic-requests.html).".equals(ed.getBinding().getDescription())) {
           ed.getBinding().setDescription("Codes for tests or services that can be carried out by a designated individual, organization or healthcare service.  For laboratory, LOINC is  (preferred)[http://build.fhir.org/terminologies.html#preferred].");
         }
       }
     }
     for (ElementDefinition ed : sd.getDifferential().getElement()) {
       if (ed.hasBinding()) {
         if ("Codes for tests or services that can be carried out by a designated individual, organization or healthcare service.  For laboratory, LOINC is  (preferred)[http://build.fhir.org/terminologies.html#preferred] and a valueset using LOINC Order codes is available [here](valueset-diagnostic-requests.html).".equals(ed.getBinding().getDescription())) {
           ed.getBinding().setDescription("Codes for tests or services that can be carried out by a designated individual, organization or healthcare service.  For laboratory, LOINC is  (preferred)[http://build.fhir.org/terminologies.html#preferred].");
         }
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
         // sd.setUserData(UserDataNames.fixed_by_loader, true);
         // don't need to track this (for now)
       }
     }
     for (ElementDefinition ed : sd.getDifferential().getElement()) {
       if (ed.getType().removeIf(tr -> Utilities.existsInList(tr.getCode(), "integer64", "CodeableReference", "RatioRange", "Availability", "ExtendedContactDetail"))) {
         // sd.setUserData(UserDataNames.fixed_by_loader, true);
         // don't need to track this (for now)
       }
     }
   }
   if (r.hasUrl() && r.getUrl().contains("|")) {
     assert false;
   }
   
  }

  /**
   * Fixes content of a resource when it is loaded from a package (formerly R5Hacker)
   */
  public static CanonicalResource fixLoadedResource(CanonicalResource cr) {
    if (cr instanceof StructureDefinition) {
      StructureDefinition sd = (StructureDefinition) cr;
      for (ElementDefinition ed : sd.getDifferential().getElement()) {
        fixLoadedElement(ed);
      }
      for (ElementDefinition ed : sd.getSnapshot().getElement()) {
        fixLoadedElement(ed);
        fixSimpleQuantity(ed);
      }
    }
    return cr;
  }

  /**
   * Snapshots generated before the constraints on the root of a datatype profile were merged into the
   * element that references it (see TypeProfileRootMerger and the type-profile-constraints extension)
   * are missing those constraints. We can't regenerate old snapshots at load - that's far too expensive -
   * but the only datatype profile used in the core specifications is SimpleQuantity, and the only thing
   * its root adds over Quantity is sqty-1. So we fix that case here, cheaply, for every package (IG
   * snapshots built from the core definitions inherited the same gap), and mark the profile as fully
   * merged. Anything else stays unmarked, which means the constraints are assumed to be not merged.
   *
   * Only elements with a single type, Quantity, with a single profile, SimpleQuantity, are fixed - that
   * matches what the snapshot generator merges. Choice elements are left alone
   */
  private static void fixSimpleQuantity(ElementDefinition ed) {
    if (ed.getType().size() != 1) {
      return;
    }
    TypeRefComponent t = ed.getType().get(0);
    if (!"Quantity".equals(t.getCode()) || t.getProfile().size() != 1) {
      return;
    }
    CanonicalType ct = t.getProfile().get(0);
    String url = ct.getValue();
    if (url == null || !(url.equals(SIMPLE_QUANTITY) || url.startsWith(SIMPLE_QUANTITY+"|")) || ct.hasExtension(ExtensionDefinitions.EXT_TYPE_PROFILE_CONSTRAINTS)) {
      return;
    }
    boolean found = false;
    for (ElementDefinitionConstraintComponent inv : ed.getConstraint()) {
      found = found || "sqty-1".equals(inv.getKey());
    }
    if (!found) {
      ElementDefinitionConstraintComponent inv = ed.addConstraint();
      inv.setKey("sqty-1");
      inv.setSeverity(ConstraintSeverity.ERROR);
      inv.setHuman("The comparator is not used on a SimpleQuantity");
      inv.setExpression("comparator.empty()");
      inv.setSource(SIMPLE_QUANTITY);
    }
    ct.addExtension(ExtensionDefinitions.EXT_TYPE_PROFILE_CONSTRAINTS, new CodeType("full"));
  }

  private static void fixLoadedElement(ElementDefinition ed) {
    if (ed.hasDefinition() && ed.getDefinition() != null) {
      ed.setDefinition(ed.getDefinition().replace("http://hl7.org/fhir/5.0.0-snapshot3/", "http://hl7.org/fhir/R5/"));
    }
    if (ed.hasBinding() && ed.getBinding().hasExtension(ExtensionDefinitions.EXT_BINDING_DEFINITION)) {
      Extension ext = ed.getBinding().getExtensionByUrl(ExtensionDefinitions.EXT_BINDING_DEFINITION);
      ext.setValue(new MarkdownType(ext.getValue().primitiveValue()));
    }
  }

  /**
   * Fixes up broken binding descriptions from past FHIR publications when they are rendered (formerly PublicationHacker).
   * All of them will be or are fixed in a later version, but fixing old versions is procedurally very difficult.
   */
  public static MarkdownType fixBindingDescriptions(IWorkerContext context, MarkdownType md) {
    MarkdownType ret = null;

    // ServiceRequest.code
    if (md.getValue().contains("LOINC is  (preferred)[http://build.fhir.org/terminologies.html#preferred]")) {
      ret = md.copy();
      ret.setValue(ret.getValue().replace("LOINC is  (preferred)[http://build.fhir.org/terminologies.html#preferred]", "LOINC is [preferred]("+Utilities.pathURL(VersionUtilities.getSpecUrl(context.getVersion()), "terminologies.html#preferred)")));
    }
    if (md.getValue().contains("[here](valueset-diagnostic-requests.html)")) {
      if (ret == null) {
        ret = md.copy();
      }
      ret.setValue(ret.getValue().replace("[here](valueset-diagnostic-requests.html)", "here"));
    }
    return ret == null ? md : ret;
  }

}
