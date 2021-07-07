package org.hl7.fhir.convertors.conv10_50.resources10_50;

import org.hl7.fhir.convertors.conv10_50.VersionConvertor_10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complexTypes10_50.Identifier10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.DateTime10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.String10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Reference10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class EnrollmentResponse10_50 {

    public static org.hl7.fhir.dstu2.model.EnrollmentResponse convertEnrollmentResponse(org.hl7.fhir.r5.model.EnrollmentResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.EnrollmentResponse tgt = new org.hl7.fhir.dstu2.model.EnrollmentResponse();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
        if (src.hasDispositionElement())
            tgt.setDispositionElement(String10_50.convertString(src.getDispositionElement()));
        if (src.hasCreatedElement())
            tgt.setCreatedElement(DateTime10_50.convertDateTime(src.getCreatedElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.EnrollmentResponse convertEnrollmentResponse(org.hl7.fhir.dstu2.model.EnrollmentResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.EnrollmentResponse tgt = new org.hl7.fhir.r5.model.EnrollmentResponse();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
        if (src.hasRequest())
            tgt.setRequest(Reference10_50.convertReference(src.getRequest()));
        if (src.hasDispositionElement())
            tgt.setDispositionElement(String10_50.convertString(src.getDispositionElement()));
        if (src.hasCreatedElement())
            tgt.setCreatedElement(DateTime10_50.convertDateTime(src.getCreatedElement()));
        if (src.hasOrganization())
            tgt.setOrganization(Reference10_50.convertReference(src.getOrganization()));
        if (src.hasRequestProvider())
            tgt.setRequestProvider(Reference10_50.convertReference(src.getRequestProvider()));
        return tgt;
    }
}