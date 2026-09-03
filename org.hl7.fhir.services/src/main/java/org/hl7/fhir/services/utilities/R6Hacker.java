package org.hl7.fhir.services.utilities;

import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.model.extensions.ExtensionDefinitions;
import org.hl7.fhir.model.core.*;


public class R6Hacker {

  public static void fixR5BrokenResources(IWorkerContext context) {
    for (StructureDefinition sd : context.fetchResourcesByType(StructureDefinition.class)) {
      fixSD(sd);
    }
  }

  private static void fixSD(StructureDefinition sd) {
    for (ElementDefinition ed : sd.getDifferential().getElementList()) {
      fix(ed);
    }
    for (ElementDefinition ed : sd.getSnapshot().getElementList()) {
      fix(ed);
    }
  }

  private static void fix(ElementDefinition ed) {
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


  public static CanonicalResource fixR5BrokenResource(CanonicalResource cr) {
    if (cr instanceof StructureDefinition) {
      StructureDefinition sd = (StructureDefinition) cr;
      fixSD(sd);
    }
    return cr;
  }
  
}
