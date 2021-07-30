package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.conv10_30.VersionConvertor_10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.CodeableConcept10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Identifier10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Date10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Basic10_30 {

  public static org.hl7.fhir.dstu2.model.Basic convertBasic(org.hl7.fhir.dstu3.model.Basic src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Basic tgt = new org.hl7.fhir.dstu2.model.Basic();
    VersionConvertor_10_30.copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_30.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference10_30.convertReference(src.getSubject()));
    if (src.hasCreatedElement())
      tgt.setCreatedElement(Date10_30.convertDate(src.getCreatedElement()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference10_30.convertReference(src.getAuthor()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Basic convertBasic(org.hl7.fhir.dstu2.model.Basic src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Basic tgt = new org.hl7.fhir.dstu3.model.Basic();
    VersionConvertor_10_30.copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_30.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference10_30.convertReference(src.getSubject()));
    if (src.hasCreatedElement())
      tgt.setCreatedElement(Date10_30.convertDate(src.getCreatedElement()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference10_30.convertReference(src.getAuthor()));
    return tgt;
  }
}