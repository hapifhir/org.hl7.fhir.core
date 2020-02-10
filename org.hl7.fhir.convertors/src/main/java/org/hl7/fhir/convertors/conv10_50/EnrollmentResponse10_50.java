package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class EnrollmentResponse10_50 {

    public static org.hl7.fhir.dstu2.model.EnrollmentResponse convertEnrollmentResponse(org.hl7.fhir.r5.model.EnrollmentResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.EnrollmentResponse tgt = new org.hl7.fhir.dstu2.model.EnrollmentResponse();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        }
        if (src.hasDispositionElement())
            tgt.setDispositionElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_50.convertType(src.getDispositionElement()));
        if (src.hasCreatedElement())
            tgt.setCreatedElement((org.hl7.fhir.dstu2.model.DateTimeType) VersionConvertor_10_50.convertType(src.getCreatedElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.EnrollmentResponse convertEnrollmentResponse(org.hl7.fhir.dstu2.model.EnrollmentResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.EnrollmentResponse tgt = new org.hl7.fhir.r5.model.EnrollmentResponse();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        }
        if (src.hasRequest()) {
            tgt.setRequest(VersionConvertor_10_50.convertReference(src.getRequest()));
        }
        if (src.hasDispositionElement())
            tgt.setDispositionElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_10_50.convertType(src.getDispositionElement()));
        if (src.hasCreatedElement())
            tgt.setCreatedElement((org.hl7.fhir.r5.model.DateTimeType) VersionConvertor_10_50.convertType(src.getCreatedElement()));
        if (src.hasOrganization()) {
            tgt.setOrganization(VersionConvertor_10_50.convertReference(src.getOrganization()));
        }
        if (src.hasRequestProvider()) {
            tgt.setRequestProvider(VersionConvertor_10_50.convertReference(src.getRequestProvider()));
        }
        return tgt;
    }
}
