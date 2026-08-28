package org.hl7.fhir.model.utilities;

import org.hl7.fhir.model.extensions.ExtensionDefinitions;
import org.hl7.fhir.model.extensions.ExtensionUtilities;
import org.hl7.fhir.model.core.CanonicalResource;
import org.hl7.fhir.model.core.CodeType;
import org.hl7.fhir.model.core.ContactDetail;
import org.hl7.fhir.model.core.ContactPoint;
import org.hl7.fhir.model.core.ContactPoint.ContactPointSystem;
import org.hl7.fhir.utilities.HL7WorkGroups;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;

public class CanonicalResourceUtilities {

  public static void setHl7WG(CanonicalResource cr, String wgc) {
    var wg = HL7WorkGroups.find(wgc);
    if (wg == null) {
      throw new Error("Unknown WG "+wgc);
    }
    ExtensionUtilities.setCodeExtension(cr, ExtensionDefinitions.EXT_WORKGROUP, wg.getCode());
    cr.setPublisher("HL7 International / "+wg.getName());
    boolean found = false;
    for (ContactDetail c : cr.getContactList()) {
      for (ContactPoint t : c.getTelecomList()) {
        if ((t.getSystem() == ContactPointSystem.URL) && wg.getLink().equals(t.getValue())) {
          found = true;
        }
      }
    }
    if (!found) {
      cr.addContact().addTelecom().setSystem(ContactPointSystem.URL).setValue(wg.getLink());
    }
  }

  public static void setHl7WG(CanonicalResource cr) {
    String wgc = ExtensionUtilities.readStringExtension(cr, ExtensionDefinitions.EXT_WORKGROUP);
    if (wgc == null) {
      wgc = "fhir";      
    }
    var wg = HL7WorkGroups.find(wgc);
    if (wg == null) {
      throw new Error("Unknown WG '"+wgc+"' in "+cr.fhirType()+"/"+cr.getIdBase());
    }
    ExtensionUtilities.setCodeExtension(cr, ExtensionDefinitions.EXT_WORKGROUP, wg.getCode());
    cr.setPublisher("HL7 International / "+wg.getName());
    boolean found = false;
    for (ContactDetail c : cr.getContactList()) {
      for (ContactPoint t : c.getTelecomList()) {
        if ((t.getSystem() == ContactPointSystem.URL) && wg.getLink().equals(t.getValue())) {
          found = true;
        }
      }
    }
    if (!found) {
      cr.addContact().addTelecom().setSystem(ContactPointSystem.URL).setValue(wg.getLink());
    }
  }
}
