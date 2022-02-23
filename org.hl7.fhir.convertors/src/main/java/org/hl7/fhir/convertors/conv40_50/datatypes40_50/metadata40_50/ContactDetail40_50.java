package org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.ContactPoint40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class ContactDetail40_50 {
  public static org.hl7.fhir.r5.model.ContactDetail convertContactDetail(org.hl7.fhir.r4.model.ContactDetail src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.ContactDetail tgt = new org.hl7.fhir.r5.model.ContactDetail();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasName()) tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint40_50.convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ContactDetail convertContactDetail(org.hl7.fhir.r5.model.ContactDetail src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasName()) tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint40_50.convertContactPoint(t));
    return tgt;
  }
}
