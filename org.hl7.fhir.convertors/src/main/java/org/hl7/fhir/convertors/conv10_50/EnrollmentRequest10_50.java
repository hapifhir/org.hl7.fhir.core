package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class EnrollmentRequest10_50 {

    public static org.hl7.fhir.r5.model.EnrollmentRequest convertEnrollmentRequest(org.hl7.fhir.dstu2.model.EnrollmentRequest src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.EnrollmentRequest tgt = new org.hl7.fhir.r5.model.EnrollmentRequest();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        tgt.setCreated(src.getCreated());
        tgt.setProvider(VersionConvertor_10_50.convertReference(src.getProvider()));
        tgt.setCandidate(VersionConvertor_10_50.convertReference(src.getSubject()));
        tgt.setCoverage(VersionConvertor_10_50.convertReference(src.getCoverage()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.EnrollmentRequest convertEnrollmentRequest(org.hl7.fhir.r5.model.EnrollmentRequest src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.EnrollmentRequest tgt = new org.hl7.fhir.dstu2.model.EnrollmentRequest();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        tgt.setCreated(src.getCreated());
        tgt.setCoverage(VersionConvertor_10_50.convertReference(src.getCoverage()));
        return tgt;
    }
}
