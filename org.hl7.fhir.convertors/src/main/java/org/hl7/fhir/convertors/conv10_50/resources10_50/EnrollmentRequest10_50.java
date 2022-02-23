package org.hl7.fhir.convertors.conv10_50.resources10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Reference10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Identifier10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.DateTime10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class EnrollmentRequest10_50 {

  public static org.hl7.fhir.r5.model.EnrollmentRequest convertEnrollmentRequest(org.hl7.fhir.dstu2.model.EnrollmentRequest src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.EnrollmentRequest tgt = new org.hl7.fhir.r5.model.EnrollmentRequest();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
    if (src.hasCreatedElement())
      tgt.setCreatedElement(DateTime10_50.convertDateTime(src.getCreatedElement()));
    if (src.hasProvider())
      tgt.setProvider(Reference10_50.convertReference(src.getProvider()));
    if (src.hasSubject())
      tgt.setCandidate(Reference10_50.convertReference(src.getSubject()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference10_50.convertReference(src.getCoverage()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.EnrollmentRequest convertEnrollmentRequest(org.hl7.fhir.r5.model.EnrollmentRequest src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.EnrollmentRequest tgt = new org.hl7.fhir.dstu2.model.EnrollmentRequest();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
    if (src.hasCreatedElement())
      tgt.setCreatedElement(DateTime10_50.convertDateTime(src.getCreatedElement()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference10_50.convertReference(src.getCoverage()));
    return tgt;
  }
}