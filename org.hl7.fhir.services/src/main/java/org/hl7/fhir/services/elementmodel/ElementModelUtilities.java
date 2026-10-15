package org.hl7.fhir.services.elementmodel;

import org.hl7.fhir.model.core.CodeType;
import org.hl7.fhir.model.core.VersionResolutionRules;
import org.hl7.fhir.model.extensions.ExtensionDefinitions;
import org.hl7.fhir.utilities.HL7WorkGroups;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;

import java.util.List;

public class ElementModelUtilities {

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

  public static void setHl7WG(Element res, String code) {
    if (VersionUtilities.getExtendedCanonicalResourceNames(res.getFHIRPublicationVersion().toCode()).contains(res.fhirType())) {
      var wg = HL7WorkGroups.find(code);
      if (wg == null) {
        throw new Error("Unknown WG "+code);
      }

      Element ext = res.getExtension(ExtensionDefinitions.EXT_WORKGROUP);
      if (ext == null) {
        ext = res.addElement("extension");
        ext.setChildValue("url", ExtensionDefinitions.EXT_WORKGROUP);
      }
      ext.setChildValue("value[x]",  new CodeType(code));
      if (!Utilities.existsInList(res.fhirType(), "ClinicalUseDefinition")) {
        res.setChildValue("publisher", "HL7 International / "+wg.getName());
        while (res.hasChildren("contact")) {
          res.removeChild("contact");
        }
        Element c = res.addElement("contact");
        Element t = c.addElement("telecom");
        t.setChildValue("system", "url");
        t.setChildValue("value", wg.getLink());
      }
    }
  }

}
