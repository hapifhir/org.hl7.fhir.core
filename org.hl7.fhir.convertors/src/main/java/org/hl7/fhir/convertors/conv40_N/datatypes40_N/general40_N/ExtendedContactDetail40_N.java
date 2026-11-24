package org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N;

import java.util.List;
import java.util.function.Supplier;

import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionDatatype40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.ExtendedContactDetail;

/**
 * R5 replaced telecom with contact (ExtendedContactDetail) in resources whose R4 versions only have telecom
 * (PractitionerRole, OrganizationAffiliation, HealthcareService, Location...). If the first contact has nothing but
 * telecom, it goes to R4 telecom; every other contact goes whole into the cross-version extension for [Resource].contact
 * (ExtendedContactDetail isn't an R4 type, so as a complex extension), and comes back from there
 */
public class ExtendedContactDetail40_N {

  public static boolean isTelecomOnly(ExtendedContactDetail c) {
    return c.hasTelecom() && !c.hasPurpose() && !c.hasName() && !c.hasAddress() && !c.hasOrganization() && !c.hasPeriod()
      && !c.hasId() && !c.hasExtension();
  }

  /**
   * R6 to R4
   */
  public static void convertContacts(List<ExtendedContactDetail> src, List<org.hl7.fhir.r4.model.ContactPoint> telecom,
                                     List<org.hl7.fhir.r4.model.Extension> extensions, String url) throws FHIRException {
    for (ExtendedContactDetail c : src) {
      // only the first: R4 telecom comes back as a single contact, so this keeps the contacts and their order
      if (c == src.get(0) && isTelecomOnly(c)) {
        for (org.hl7.fhir.model.core.ContactPoint cp : c.getTelecomList())
          telecom.add(ContactPoint40_N.convertContactPoint(cp));
      } else {
        extensions.add(CrossVersionDatatype40_N.convertToExtension(url, c));
      }
    }
  }

  /**
   * R4 to R6: the telecoms become a contact of their own, followed by the contacts from the extension
   */
  public static void convertContacts(List<org.hl7.fhir.r4.model.ContactPoint> telecom, List<org.hl7.fhir.r4.model.Extension> extensions,
                                     String url, Supplier<ExtendedContactDetail> addContact) throws FHIRException {
    if (!telecom.isEmpty()) {
      ExtendedContactDetail c = addContact.get();
      for (org.hl7.fhir.r4.model.ContactPoint t : telecom)
        c.addTelecom(ContactPoint40_N.convertContactPoint(t));
    }
    for (org.hl7.fhir.r4.model.Extension ext : extensions) {
      if (url.equals(ext.getUrl())) {
        CrossVersionDatatype40_N.populateDatatype(ext, addContact.get());
      }
    }
  }
}
