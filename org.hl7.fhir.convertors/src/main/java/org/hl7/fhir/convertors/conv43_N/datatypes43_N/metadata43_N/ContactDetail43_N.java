package org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.ContactPoint43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class ContactDetail43_N {
  public static org.hl7.fhir.model.core.ContactDetail convertContactDetail(org.hl7.fhir.r4b.model.ContactDetail src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.ContactDetail tgt = new org.hl7.fhir.model.core.ContactDetail();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasName()) tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    for (org.hl7.fhir.r4b.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint43_N.convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ContactDetail convertContactDetail(org.hl7.fhir.model.core.ContactDetail src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.ContactDetail tgt = new org.hl7.fhir.r4b.model.ContactDetail();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasName()) tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    for (org.hl7.fhir.model.core.ContactPoint t : src.getTelecomList())
      tgt.addTelecom(ContactPoint43_N.convertContactPoint(t));
    return tgt;
  }
}
