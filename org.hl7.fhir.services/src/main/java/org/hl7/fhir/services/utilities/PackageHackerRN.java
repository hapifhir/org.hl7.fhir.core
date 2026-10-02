package org.hl7.fhir.services.utilities;

import org.hl7.fhir.model.Base;
import org.hl7.fhir.model.core.CanonicalResource;
import org.hl7.fhir.model.core.CanonicalType;
import org.hl7.fhir.model.core.CodeType;
import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.model.core.ElementDefinition.ConstraintSeverity;
import org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionConstraintComponent;
import org.hl7.fhir.model.core.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.model.core.Enumerations;
import org.hl7.fhir.model.core.Extension;
import org.hl7.fhir.model.core.MarkdownType;
import org.hl7.fhir.model.core.PackageInformation;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.model.core.UrlType;
import org.hl7.fhir.model.extensions.ExtensionDefinitions;
import org.hl7.fhir.services.context.CanonicalResourceProxy;
import org.hl7.fhir.services.context.IWorkerContext;
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
 * The R5 equivalent is org.hl7.fhir.r5.utils.PackageHackerR5
 *
 * Known limitation (a bug, not yet fixed): these fixes are only applied to resources that are
 * registered and loaded through the package path (registerResourceFromPackage / PackageResourceLoader).
 * Resources loaded through SimpleWorkerContext.loadDefinitionItem - package entries without an id in
 * the index, loose files and zips, and the definitions loaded by loadFromPackage for the core spec
 * source - bypass them, and so do not get fixed.
 */
public class PackageHackerRN {

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
     for (ElementDefinition ed : sd.getSnapshot().getElementList()) {
       if (ed.hasBinding() && "http://terminology.hl7.org/ValueSet/v3-NullFlavor|4.0.1".equals(ed.getBinding().getValueSet())) {
         ed.getBinding().setValueSet("http://terminology.hl7.org/ValueSet/v3-NullFlavor");
       }
     }
     for (ElementDefinition ed : sd.getDifferential().getElementList()) {
       if (ed.hasBinding() && "http://terminology.hl7.org/ValueSet/v3-NullFlavor|4.0.1".equals(ed.getBinding().getValueSet())) {
         ed.getBinding().setValueSet("http://terminology.hl7.org/ValueSet/v3-NullFlavor");
       }
     }
   }
   if ("http://hl7.org/fhir/StructureDefinition/DeviceUseStatement".equals(r.getUrl()) && "4.0.1".equals(r.getVersion())) {
     StructureDefinition sd = (StructureDefinition) r.getResource();
     for (ElementDefinition ed : sd.getSnapshot().getElementList()) {
       if (ed.hasRequirements()) {
         ed.setRequirements(ed.getRequirements().replace("[http://hl7.org/fhir/StructureDefinition/bodySite](null.html)", "[http://hl7.org/fhir/StructureDefinition/bodySite](http://hl7.org/fhir/extension-bodysite.html)"));
       }
     }
     for (ElementDefinition ed : sd.getDifferential().getElementList()) {
       if (ed.hasRequirements()) {
         ed.setRequirements(ed.getRequirements().replace("[http://hl7.org/fhir/StructureDefinition/bodySite](null.html)", "[http://hl7.org/fhir/StructureDefinition/bodySite](http://hl7.org/fhir/extension-bodysite.html)"));
       }
     }
   }
   if ("http://hl7.org/fhir/StructureDefinition/ServiceRequest".equals(r.getUrl()) && "4.0.1".equals(r.getVersion())) {
     StructureDefinition sd = (StructureDefinition) r.getResource();
     for (ElementDefinition ed : sd.getSnapshot().getElementList()) {
       if (ed.hasBinding()) {
         if ("Codes for tests or services that can be carried out by a designated individual, organization or healthcare service.  For laboratory, LOINC is  (preferred)[http://build.fhir.org/terminologies.html#preferred] and a valueset using LOINC Order codes is available [here](valueset-diagnostic-requests.html).".equals(ed.getBinding().getDescription())) {
           ed.getBinding().setDescription("Codes for tests or services that can be carried out by a designated individual, organization or healthcare service.  For laboratory, LOINC is  (preferred)[http://build.fhir.org/terminologies.html#preferred].");
         }
       }
     }
     for (ElementDefinition ed : sd.getDifferential().getElementList()) {
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
       for (ElementDefinition ed : sd.getSnapshot().getElementList()) {
         if (ed.getPath().equals("Observation.component.value[x]") && ed.hasBinding() && "http://hl7.org/fhir/ValueSet/ucum-vitals-common|4.0.1".equals(ed.getBinding().getValueSet())) {
           ed.getBinding().setStrength(Enumerations.BindingStrength.EXTENSIBLE);
         }
       }
       for (ElementDefinition ed : sd.getDifferential().getElementList()) {
         if (ed.getPath().equals("Observation.component.value[x]") && ed.hasBinding() && "http://hl7.org/fhir/ValueSet/ucum-vitals-common|4.0.1".equals(ed.getBinding().getValueSet())) {
           ed.getBinding().setStrength(Enumerations.BindingStrength.EXTENSIBLE);
         }
       }
     }
   }
   // work around an r2b issue
   if (packageInfo.getId().equals("hl7.fhir.r2b.core") && r.getType().equals("StructureDefinition")) {
     StructureDefinition sd = (StructureDefinition) r.getResource();
     for (ElementDefinition ed : sd.getSnapshot().getElementList()) {
       if (ed.getPath().equals(sd.getType()+".id")) {
         ed.getBase().setMax("1");
       }
     }
   }
   
   // work around a r4 version of extension pack issue
   if (packageInfo.getId().equals("hl7.fhir.uv.extensions.r4") && r.getType().equals("StructureDefinition")) {
     StructureDefinition sd = (StructureDefinition) r.getResource();
     for (ElementDefinition ed : sd.getSnapshot().getElementList()) {
       if (ed.getTypeList().removeIf(tr -> Utilities.existsInList(tr.getCode(), "integer64", "CodeableReference", "RatioRange", "Availability", "ExtendedContactDetail"))) {
         // sd.setUserData(UserDataNames.fixed_by_loader, true);
         // don't need to track this (for now)
       }
     }
     for (ElementDefinition ed : sd.getDifferential().getElementList()) {
       if (ed.getTypeList().removeIf(tr -> Utilities.existsInList(tr.getCode(), "integer64", "CodeableReference", "RatioRange", "Availability", "ExtendedContactDetail"))) {
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
   * Fixes content of a resource when it is loaded from a package (formerly R6Hacker)
   */
  public static CanonicalResource fixLoadedResource(CanonicalResource cr) {
    if (cr instanceof StructureDefinition) {
      StructureDefinition sd = (StructureDefinition) cr;
      for (ElementDefinition ed : sd.getDifferential().getElementList()) {
        fixLoadedElement(ed);
      }
      for (ElementDefinition ed : sd.getSnapshot().getElementList()) {
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
    if (ed.getTypeList().size() != 1) {
      return;
    }
    TypeRefComponent t = ed.getTypeList().get(0);
    if (!"Quantity".equals(t.getCode()) || t.getProfileList().size() != 1) {
      return;
    }
    CanonicalType ct = t.getProfileList().get(0);
    String url = ct.getValue();
    if (url == null || !(url.equals(SIMPLE_QUANTITY) || url.startsWith(SIMPLE_QUANTITY+"|")) || ct.hasExtension(ExtensionDefinitions.EXT_TYPE_PROFILE_CONSTRAINTS)) {
      return;
    }
    boolean found = false;
    for (ElementDefinitionConstraintComponent inv : ed.getConstraintList()) {
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
    fixResourceIdType(ed);
  }

  /**
   * In R6, Resource.id is an id and Element.id is a string, but the published definitions do not
   * say so consistently: in 6.0.0-ballot5, only 8 of the 124 resource StructureDefinitions (Bundle,
   * Composition, DiagnosticReport, FamilyMemberHistory, Observation, Parameters, Provenance, and
   * Resource itself) carry a fhir-type of 'id' on their id element. The other 116 - Patient, Task,
   * Device and so on - say 'string', even though their base is Resource.id, which says 'id'.
   * Element.id and the complex/primitive types are all 'string', which is correct
   * <p>
   * Anything that asks what type the id is therefore gets a different answer per resource, and, once
   * definitions from a package built against an earlier release are also in the context (where
   * Resource.id is 'id' everywhere), a different answer depending on which definition wins - which is
   * how the SQL-on-FHIR tests come to pass alone and fail in a full run
   * <p>
   * So force it here, at load, for every element based on Resource.id, regardless of what the
   * definition says. Remove this once the spec build emits it consistently
   */
  private static void fixResourceIdType(ElementDefinition ed) {
    if (ed.hasBase() && "Resource.id".equals(ed.getBase().getPath()) && ed.getTypeList().size() == 1) {
      ElementDefinition.TypeRefComponent t = ed.getTypeFirstRep();
      if (!"id".equals(t.getExtensionString(ExtensionDefinitions.EXT_FHIR_TYPE))) {
        t.removeExtension(ExtensionDefinitions.EXT_FHIR_TYPE);
        t.addExtension(ExtensionDefinitions.EXT_FHIR_TYPE, new UrlType("id"));
      }
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
      ret = md.copy(Base.COPY_NOTHING);
      ret.setValue(ret.getValue().replace("LOINC is  (preferred)[http://build.fhir.org/terminologies.html#preferred]", "LOINC is [preferred]("+Utilities.pathURL(VersionUtilities.getSpecUrl(context.getFHIRVersion()), "terminologies.html#preferred)")));
    }
    if (md.getValue().contains("[here](valueset-diagnostic-requests.html)")) {
      if (ret == null) {
        ret = md.copy(Base.COPY_NOTHING);
      }
      ret.setValue(ret.getValue().replace("[here](valueset-diagnostic-requests.html)", "here"));
    }
    return ret == null ? md : ret;
  }

}
