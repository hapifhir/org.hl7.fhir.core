package org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.ContactPoint40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class ContactDetail40_N {
  public static org.hl7.fhir.model.core.ContactDetail convertContactDetail(org.hl7.fhir.r4.model.ContactDetail src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.ContactDetail tgt = new org.hl7.fhir.model.core.ContactDetail();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasName()) tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint40_N.convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ContactDetail convertContactDetail(org.hl7.fhir.model.core.ContactDetail src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasName()) tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    for (org.hl7.fhir.model.core.ContactPoint t : src.getTelecomList())
      tgt.addTelecom(ContactPoint40_N.convertContactPoint(t));
    return tgt;
  }
}
