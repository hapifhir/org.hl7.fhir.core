package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class DetectedIssue10_50 {

    public static org.hl7.fhir.dstu2.model.DetectedIssue convertDetectedIssue(org.hl7.fhir.r5.model.DetectedIssue src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.DetectedIssue tgt = new org.hl7.fhir.dstu2.model.DetectedIssue();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        tgt.setPatient(VersionConvertor_10_50.convertReference(src.getPatient()));
        tgt.setCategory(VersionConvertor_10_50.convertCodeableConcept(src.getCode()));
        tgt.setSeverity(convertDetectedIssueSeverity(src.getSeverity()));
        for (org.hl7.fhir.r5.model.Reference t : src.getImplicated()) tgt.addImplicated(VersionConvertor_10_50.convertReference(t));
        tgt.setDetail(src.getDetail());
        if (src.hasIdentifiedDateTimeType())
            tgt.setDateElement(VersionConvertor_10_50.convertDateTime(src.getIdentifiedDateTimeType()));
        tgt.setAuthor(VersionConvertor_10_50.convertReference(src.getAuthor()));
        tgt.setIdentifier(VersionConvertor_10_50.convertIdentifier(src.getIdentifierFirstRep()));
        tgt.setReference(src.getReference());
        for (org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueMitigationComponent t : src.getMitigation()) tgt.addMitigation(convertDetectedIssueMitigationComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DetectedIssue convertDetectedIssue(org.hl7.fhir.dstu2.model.DetectedIssue src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.DetectedIssue tgt = new org.hl7.fhir.r5.model.DetectedIssue();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        tgt.setPatient(VersionConvertor_10_50.convertReference(src.getPatient()));
        tgt.setCode(VersionConvertor_10_50.convertCodeableConcept(src.getCategory()));
        tgt.setSeverity(convertDetectedIssueSeverity(src.getSeverity()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getImplicated()) tgt.addImplicated(VersionConvertor_10_50.convertReference(t));
        tgt.setDetail(src.getDetail());
        if (src.hasDate())
            tgt.setIdentified(VersionConvertor_10_50.convertDateTime(src.getDateElement()));
        tgt.setAuthor(VersionConvertor_10_50.convertReference(src.getAuthor()));
        tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(src.getIdentifier()));
        tgt.setReference(src.getReference());
        for (org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueMitigationComponent t : src.getMitigation()) tgt.addMitigation(convertDetectedIssueMitigationComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueMitigationComponent convertDetectedIssueMitigationComponent(org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueMitigationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueMitigationComponent tgt = new org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueMitigationComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setAction(VersionConvertor_10_50.convertCodeableConcept(src.getAction()));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setAuthor(VersionConvertor_10_50.convertReference(src.getAuthor()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueMitigationComponent convertDetectedIssueMitigationComponent(org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueMitigationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueMitigationComponent tgt = new org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueMitigationComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setAction(VersionConvertor_10_50.convertCodeableConcept(src.getAction()));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setAuthor(VersionConvertor_10_50.convertReference(src.getAuthor()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverity convertDetectedIssueSeverity(org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueSeverity src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case HIGH:
                return org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverity.HIGH;
            case MODERATE:
                return org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverity.MODERATE;
            case LOW:
                return org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverity.LOW;
            default:
                return org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverity.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueSeverity convertDetectedIssueSeverity(org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverity src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case HIGH:
                return org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueSeverity.HIGH;
            case MODERATE:
                return org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueSeverity.MODERATE;
            case LOW:
                return org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueSeverity.LOW;
            default:
                return org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueSeverity.NULL;
        }
    }
}
