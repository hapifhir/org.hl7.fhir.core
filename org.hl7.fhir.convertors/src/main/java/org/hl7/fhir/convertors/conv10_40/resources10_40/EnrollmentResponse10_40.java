package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.conv10_40.VersionConvertor_10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Identifier10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.DateTime10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.String10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class EnrollmentResponse10_40 {

    public static org.hl7.fhir.r4.model.EnrollmentResponse convertEnrollmentResponse(org.hl7.fhir.dstu2.model.EnrollmentResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.EnrollmentResponse tgt = new org.hl7.fhir.r4.model.EnrollmentResponse();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
        if (src.hasRequest())
            tgt.setRequest(Reference10_40.convertReference(src.getRequest()));
        if (src.hasDispositionElement())
            tgt.setDispositionElement(String10_40.convertString(src.getDispositionElement()));
        if (src.hasCreatedElement())
            tgt.setCreatedElement(DateTime10_40.convertDateTime(src.getCreatedElement()));
        if (src.hasOrganization())
            tgt.setOrganization(Reference10_40.convertReference(src.getOrganization()));
        if (src.hasRequestProvider())
            tgt.setRequestProvider(Reference10_40.convertReference(src.getRequestProvider()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.EnrollmentResponse convertEnrollmentResponse(org.hl7.fhir.r4.model.EnrollmentResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.EnrollmentResponse tgt = new org.hl7.fhir.dstu2.model.EnrollmentResponse();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
        if (src.hasDispositionElement())
            tgt.setDispositionElement(String10_40.convertString(src.getDispositionElement()));
        if (src.hasCreatedElement())
            tgt.setCreatedElement(DateTime10_40.convertDateTime(src.getCreatedElement()));
        return tgt;
    }
}