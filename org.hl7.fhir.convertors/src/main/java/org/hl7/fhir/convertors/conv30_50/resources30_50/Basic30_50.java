package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Date30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Basic30_50 {

  public static org.hl7.fhir.r5.model.Basic convertBasic(org.hl7.fhir.dstu3.model.Basic src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Basic tgt = new org.hl7.fhir.r5.model.Basic();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_50.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
    if (src.hasCreated())
      tgt.setCreatedElement(Date30_50.convertDatetoDateTime(src.getCreatedElement()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference30_50.convertReference(src.getAuthor()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Basic convertBasic(org.hl7.fhir.r5.model.Basic src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Basic tgt = new org.hl7.fhir.dstu3.model.Basic();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_50.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
    if (src.hasCreated())
      tgt.setCreatedElement(Date30_50.convertDateTimeToDate(src.getCreatedElement()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference30_50.convertReference(src.getAuthor()));
    return tgt;
  }
}