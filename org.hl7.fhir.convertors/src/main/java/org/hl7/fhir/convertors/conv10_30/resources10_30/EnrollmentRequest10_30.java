package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.conv10_30.VersionConvertor_10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Identifier10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.DateTime10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class EnrollmentRequest10_30 {

  public static org.hl7.fhir.dstu3.model.EnrollmentRequest convertEnrollmentRequest(org.hl7.fhir.dstu2.model.EnrollmentRequest src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.EnrollmentRequest tgt = new org.hl7.fhir.dstu3.model.EnrollmentRequest();
    VersionConvertor_10_30.copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasCreatedElement())
      tgt.setCreatedElement(DateTime10_30.convertDateTime(src.getCreatedElement()));
    if (src.hasProvider())
      tgt.setProvider(Reference10_30.convertReference(src.getProvider()));
    if (src.hasOrganization())
      tgt.setOrganization(Reference10_30.convertReference(src.getOrganization()));
    if (src.hasSubject())
      tgt.setSubject(Reference10_30.convertReference(src.getSubject()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference10_30.convertReference(src.getCoverage()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.EnrollmentRequest convertEnrollmentRequest(org.hl7.fhir.dstu3.model.EnrollmentRequest src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.EnrollmentRequest tgt = new org.hl7.fhir.dstu2.model.EnrollmentRequest();
    VersionConvertor_10_30.copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasCreatedElement())
      tgt.setCreatedElement(DateTime10_30.convertDateTime(src.getCreatedElement()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference10_30.convertReference(src.getCoverage()));
    return tgt;
  }
}