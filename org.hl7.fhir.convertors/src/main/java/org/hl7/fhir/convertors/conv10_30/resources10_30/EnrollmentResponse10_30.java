package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.conv10_30.VersionConvertor_10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Identifier10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.DateTime10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class EnrollmentResponse10_30 {

  public static org.hl7.fhir.dstu3.model.EnrollmentResponse convertEnrollmentResponse(org.hl7.fhir.dstu2.model.EnrollmentResponse src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.EnrollmentResponse tgt = new org.hl7.fhir.dstu3.model.EnrollmentResponse();
    VersionConvertor_10_30.copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasRequest())
      tgt.setRequest(Reference10_30.convertReference(src.getRequest()));
    if (src.hasDispositionElement())
      tgt.setDispositionElement(String10_30.convertString(src.getDispositionElement()));
    if (src.hasCreatedElement())
      tgt.setCreatedElement(DateTime10_30.convertDateTime(src.getCreatedElement()));
    if (src.hasOrganization())
      tgt.setOrganization(Reference10_30.convertReference(src.getOrganization()));
    if (src.hasRequestProvider())
      tgt.setRequestProvider(Reference10_30.convertReference(src.getRequestProvider()));
    if (src.hasRequestOrganization())
      tgt.setRequestOrganization(Reference10_30.convertReference(src.getRequestOrganization()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.EnrollmentResponse convertEnrollmentResponse(org.hl7.fhir.dstu3.model.EnrollmentResponse src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.EnrollmentResponse tgt = new org.hl7.fhir.dstu2.model.EnrollmentResponse();
    VersionConvertor_10_30.copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasDispositionElement())
      tgt.setDispositionElement(String10_30.convertString(src.getDispositionElement()));
    if (src.hasCreatedElement())
      tgt.setCreatedElement(DateTime10_30.convertDateTime(src.getCreatedElement()));
    return tgt;
  }
}