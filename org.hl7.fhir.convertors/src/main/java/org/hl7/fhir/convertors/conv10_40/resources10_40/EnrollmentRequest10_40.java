package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.conv10_40.VersionConvertor_10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Identifier10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.DateTime10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class EnrollmentRequest10_40 {

  public static org.hl7.fhir.r4.model.EnrollmentRequest convertEnrollmentRequest(org.hl7.fhir.dstu2.model.EnrollmentRequest src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.EnrollmentRequest tgt = new org.hl7.fhir.r4.model.EnrollmentRequest();
    VersionConvertor_10_40.copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    if (src.hasCreatedElement())
      tgt.setCreatedElement(DateTime10_40.convertDateTime(src.getCreatedElement()));
    if (src.hasProvider())
      tgt.setProvider(Reference10_40.convertReference(src.getProvider()));
    if (src.hasSubject())
      tgt.setCandidate(Reference10_40.convertReference(src.getSubject()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference10_40.convertReference(src.getCoverage()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.EnrollmentRequest convertEnrollmentRequest(org.hl7.fhir.r4.model.EnrollmentRequest src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.EnrollmentRequest tgt = new org.hl7.fhir.dstu2.model.EnrollmentRequest();
    VersionConvertor_10_40.copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    if (src.hasCreatedElement())
      tgt.setCreatedElement(DateTime10_40.convertDateTime(src.getCreatedElement()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference10_40.convertReference(src.getCoverage()));
    return tgt;
  }
}