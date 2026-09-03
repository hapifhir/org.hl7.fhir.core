package org.hl7.fhir.r5.elementmodel;

import java.util.List;

public class ElementUtilities {

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
