package org.hl7.fhir.convertors.conv30_40.datatypes30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.ContactPoint30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class ContactDetail30_40 {
  public static org.hl7.fhir.r4.model.ContactDetail convertContactDetail(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasName()) tgt.setNameElement(String30_40.convertString(src.getNameElement()));
    for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint30_40.convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ContactDetail convertContactDetail(org.hl7.fhir.r4.model.ContactDetail src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.ContactDetail tgt = new org.hl7.fhir.dstu3.model.ContactDetail();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasName()) tgt.setNameElement(String30_40.convertString(src.getNameElement()));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint30_40.convertContactPoint(t));
    return tgt;
  }

}
