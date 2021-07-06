package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class EnrollmentResponse10_40 {

    public static org.hl7.fhir.r4.model.EnrollmentResponse convertEnrollmentResponse(org.hl7.fhir.dstu2.model.EnrollmentResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.EnrollmentResponse tgt = new org.hl7.fhir.r4.model.EnrollmentResponse();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        if (src.hasRequest())
            tgt.setRequest(VersionConvertor_10_40.convertReference(src.getRequest()));
        if (src.hasDispositionElement())
            tgt.setDispositionElement(VersionConvertor_10_40.convertString(src.getDispositionElement()));
        if (src.hasCreatedElement())
            tgt.setCreatedElement(VersionConvertor_10_40.convertDateTime(src.getCreatedElement()));
        if (src.hasOrganization())
            tgt.setOrganization(VersionConvertor_10_40.convertReference(src.getOrganization()));
        if (src.hasRequestProvider())
            tgt.setRequestProvider(VersionConvertor_10_40.convertReference(src.getRequestProvider()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.EnrollmentResponse convertEnrollmentResponse(org.hl7.fhir.r4.model.EnrollmentResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.EnrollmentResponse tgt = new org.hl7.fhir.dstu2.model.EnrollmentResponse();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        if (src.hasDispositionElement())
            tgt.setDispositionElement(VersionConvertor_10_40.convertString(src.getDispositionElement()));
        if (src.hasCreatedElement())
            tgt.setCreatedElement(VersionConvertor_10_40.convertDateTime(src.getCreatedElement()));
        return tgt;
    }
}