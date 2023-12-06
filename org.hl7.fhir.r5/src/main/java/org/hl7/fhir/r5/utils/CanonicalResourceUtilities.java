package org.hl7.fhir.r5.utils;

import java.util.List;

import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CompartmentDefinition;
import org.hl7.fhir.r5.model.Constants;
import org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.utilities.HL7WorkGroups;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.xml.XMLUtil;

public class CanonicalResourceUtilities {

  public static void setHl7WG(CanonicalResource cr, String wgc) {
    var wg = HL7WorkGroups.find(wgc);
    if (wg == null) {
      throw new Error("Unknown WG "+wgc);
    }
    ToolingExtensions.setCodeExtension(cr, ToolingExtensions.EXT_WORKGROUP, wg.getCode());
    cr.setPublisher("HL7 International / "+wg.getName());
    cr.getContact().clear();
    cr.addContact().addTelecom().setSystem(ContactPointSystem.URL).setValue(wg.getLink());
  }

  public static void setHl7WG(CanonicalResource cr) {
    String wgc = ToolingExtensions.readStringExtension(cr, ToolingExtensions.EXT_WORKGROUP);
    if (wgc == null) {
      wgc = "fhir";      
    }
    var wg = HL7WorkGroups.find(wgc);
    if (wg == null) {
      throw new Error("Unknown WG '"+wgc+"' in "+cr.fhirType()+"/"+cr.getIdBase());
    }
    ToolingExtensions.setCodeExtension(cr, ToolingExtensions.EXT_WORKGROUP, wg.getCode());
    cr.setPublisher("HL7 International / "+wg.getName());
    cr.getContact().clear();
    cr.addContact().addTelecom().setSystem(ContactPointSystem.URL).setValue(wg.getLink());
  }

  public static void setHl7WG(Element res, String code) {
    if (VersionUtilities.getExtendedCanonicalResourceNames(res.getFHIRPublicationVersion().toCode()).contains(res.fhirType())) {
      var wg = HL7WorkGroups.find(code);
      if (wg == null) {
        throw new Error("Unknown WG "+code);
      }
      
      Element ext = res.getExtension(ToolingExtensions.EXT_WORKGROUP);
      if (ext == null) {
        ext = res.addElement("extension");
        ext.setChildValue("url", ToolingExtensions.EXT_WORKGROUP);
      }
      ext.setChildValue("valueCode", code);
      res.setChildValue("publisher", "HL7 International / "+wg.getName());
      while (res.hasChild("contact")) {
        res.removeChild("contact");
      }
      Element c = res.addElement("contact");
      Element t = c.addElement("telecom");
      t.setChildValue("system", "url");
      t.setChildValue("value", wg.getLink());
    }    
  }

  public static void setHl7WG(org.w3c.dom.Element res, String code) {
    String rt = res.getNodeName();
    if (VersionUtilities.getExtendedCanonicalResourceNames("5.0.0").contains(rt)) {
      var wg = HL7WorkGroups.find(code);
      if (wg == null) {
        throw new Error("Unknown WG "+code);
      }
      
      List<org.w3c.dom.Element> extensions = XMLUtil.getNamedChildren(res, "extension");
      org.w3c.dom.Element wgext = null;
      for (org.w3c.dom.Element ext : extensions) {
        String url = ext.getAttribute("url");
        if (ToolingExtensions.EXT_WORKGROUP.equals(url)) {
          wgext = ext;
        }
      }
      if (wgext == null) {
        wgext = res.getOwnerDocument().createElementNS(Constants.NS_FHIR_ROOT, "extension");
        wgext.setAttribute("url", ToolingExtensions.EXT_WORKGROUP);
        org.w3c.dom.Element after = XMLUtil.getFirstChild(res, "modifierExtension", "url", "identifier", "version", "status", "name", "title");
        if (after == null) {
          after = XMLUtil.getLastChild(res, "id", "meta", "text", "implicitRules", "language", "text", "contained");
          if (after != null) {
            after = XMLUtil.getNextSibling(after);
          }
        }
        res.insertBefore(wgext, after);
        res.insertBefore(res.getOwnerDocument().createTextNode("/n  "), after);
      }
      XMLUtil.clearChildren(wgext);
      org.w3c.dom.Element valueCode = res.getOwnerDocument().createElementNS(Constants.NS_FHIR_ROOT, "valueCode"); 
      wgext.appendChild(valueCode);
      valueCode.setAttribute("value", code);
      
      org.w3c.dom.Element pub = XMLUtil.getNamedChild(res, "publisher");
      if (pub == null) {
        pub = res.getOwnerDocument().createElementNS(Constants.NS_FHIR_ROOT, "publisher");
        org.w3c.dom.Element after = XMLUtil.getFirstChild(res, "contact", "relatedArtifact", "description", "useContext", "jurisdiction", "purpose", "copyright");
        res.insertBefore(pub, after);
      }
      pub.setAttribute("value", "HL7 International / "+wg.getName());
    }
  }
}
