package org.hl7.fhir.services.elementmodel;

import org.hl7.fhir.model.core.VersionResolutionRules;
import org.hl7.fhir.model.extensions.ExtensionDefinitions;

import java.util.List;

public class ElementUtilities {

  public static VersionResolutionRules getVersionResolutionRules(org.hl7.fhir.services.elementmodel.Element element) {
    if (element == null) {
      return VersionResolutionRules.defaultRule();
    }
    String rule = element.getExtensionString(ExtensionDefinitions.CANONICAL_RESOLUTION_METHOD);
    return rule == null ? VersionResolutionRules.defaultRule() : VersionResolutionRules.fromCode(rule);
  }


  public static void findSignatures(Element bundle, List<Element> signatureProvenances) {
    for (Element entry : bundle.getChildrenByName("entry")) {
      Element resource = entry.getNamedChild("resource", false);
      if (resource != null && "Provenance".equals(resource.fhirType())) {
        boolean hasTarget = false;
        for (Element target : resource.getChildrenByName("target")) {
          hasTarget = hasTarget || "#/".equals(target.getNamedChildValue("reference"));
        }
        if (hasTarget) {
          signatureProvenances.add(resource);
        }
      }
    }
  }

}
