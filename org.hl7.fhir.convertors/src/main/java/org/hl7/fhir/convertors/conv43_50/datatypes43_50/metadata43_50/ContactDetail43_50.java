package org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.ContactPoint43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class ContactDetail43_50 {
  public static org.hl7.fhir.r5.model.ContactDetail convertContactDetail(org.hl7.fhir.r4b.model.ContactDetail src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.ContactDetail tgt = new org.hl7.fhir.r5.model.ContactDetail();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasName()) tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    for (org.hl7.fhir.r4b.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint43_50.convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ContactDetail convertContactDetail(org.hl7.fhir.r5.model.ContactDetail src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.ContactDetail tgt = new org.hl7.fhir.r4b.model.ContactDetail();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasName()) tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint43_50.convertContactPoint(t));
    return tgt;
  }
}
