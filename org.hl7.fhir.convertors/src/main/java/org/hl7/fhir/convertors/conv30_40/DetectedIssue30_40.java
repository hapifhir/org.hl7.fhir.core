package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class DetectedIssue30_40 {

    public static org.hl7.fhir.dstu3.model.DetectedIssue convertDetectedIssue(org.hl7.fhir.r4.model.DetectedIssue src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.DetectedIssue tgt = new org.hl7.fhir.dstu3.model.DetectedIssue();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_30_40.convertIdentifier(src.getIdentifierFirstRep()));
        if (src.hasStatus())
            tgt.setStatus(convertDetectedIssueStatus(src.getStatus()));
        if (src.hasCode())
            tgt.setCategory(VersionConvertor_30_40.convertCodeableConcept(src.getCode()));
        if (src.hasSeverity())
            tgt.setSeverity(convertDetectedIssueSeverity(src.getSeverity()));
        if (src.hasPatient())
            tgt.setPatient(VersionConvertor_30_40.convertReference(src.getPatient()));
        if (src.hasIdentifiedDateTimeType())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getIdentifiedDateTimeType()));
        if (src.hasAuthor())
            tgt.setAuthor(VersionConvertor_30_40.convertReference(src.getAuthor()));
        if (src.hasImplicated()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getImplicated()) tgt.addImplicated(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasDetailElement())
            tgt.setDetailElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getDetailElement()));
        if (src.hasReferenceElement())
            tgt.setReferenceElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_30_40.convertType(src.getReferenceElement()));
        if (src.hasMitigation()) {
            for (org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueMitigationComponent t : src.getMitigation()) tgt.addMitigation(convertDetectedIssueMitigationComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DetectedIssue convertDetectedIssue(org.hl7.fhir.dstu3.model.DetectedIssue src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.DetectedIssue tgt = new org.hl7.fhir.r4.model.DetectedIssue();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(src.getIdentifier()));
        if (src.hasStatus())
            tgt.setStatus(convertDetectedIssueStatus(src.getStatus()));
        if (src.hasCategory())
            tgt.setCode(VersionConvertor_30_40.convertCodeableConcept(src.getCategory()));
        if (src.hasSeverity())
            tgt.setSeverity(convertDetectedIssueSeverity(src.getSeverity()));
        if (src.hasPatient())
            tgt.setPatient(VersionConvertor_30_40.convertReference(src.getPatient()));
        if (src.hasDateElement())
            tgt.setIdentified(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasAuthor())
            tgt.setAuthor(VersionConvertor_30_40.convertReference(src.getAuthor()));
        if (src.hasImplicated()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getImplicated()) tgt.addImplicated(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasDetailElement())
            tgt.setDetailElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getDetailElement()));
        if (src.hasReferenceElement())
            tgt.setReferenceElement((org.hl7.fhir.r4.model.UriType) VersionConvertor_30_40.convertType(src.getReferenceElement()));
        if (src.hasMitigation()) {
            for (org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueMitigationComponent t : src.getMitigation()) tgt.addMitigation(convertDetectedIssueMitigationComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueMitigationComponent convertDetectedIssueMitigationComponent(org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueMitigationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueMitigationComponent tgt = new org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueMitigationComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasAction())
            tgt.setAction(VersionConvertor_30_40.convertCodeableConcept(src.getAction()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasAuthor())
            tgt.setAuthor(VersionConvertor_30_40.convertReference(src.getAuthor()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueMitigationComponent convertDetectedIssueMitigationComponent(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueMitigationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueMitigationComponent tgt = new org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueMitigationComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasAction())
            tgt.setAction(VersionConvertor_30_40.convertCodeableConcept(src.getAction()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasAuthor())
            tgt.setAuthor(VersionConvertor_30_40.convertReference(src.getAuthor()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity convertDetectedIssueSeverity(org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueSeverity src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case HIGH:
                return org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity.HIGH;
            case MODERATE:
                return org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity.MODERATE;
            case LOW:
                return org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity.LOW;
            default:
                return org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueSeverity convertDetectedIssueSeverity(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case HIGH:
                return org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueSeverity.HIGH;
            case MODERATE:
                return org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueSeverity.MODERATE;
            case LOW:
                return org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueSeverity.LOW;
            default:
                return org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueSeverity.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus convertDetectedIssueStatus(org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REGISTERED:
                return org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.REGISTERED;
            case PRELIMINARY:
                return org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.PRELIMINARY;
            case FINAL:
                return org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.FINAL;
            case AMENDED:
                return org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.AMENDED;
            case CORRECTED:
                return org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.CORRECTED;
            case CANCELLED:
                return org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.CANCELLED;
            case ENTEREDINERROR:
                return org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.ENTEREDINERROR;
            case UNKNOWN:
                return org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.UNKNOWN;
            default:
                return org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueStatus convertDetectedIssueStatus(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REGISTERED:
                return org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueStatus.REGISTERED;
            case PRELIMINARY:
                return org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueStatus.PRELIMINARY;
            case FINAL:
                return org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueStatus.FINAL;
            case AMENDED:
                return org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueStatus.AMENDED;
            case CORRECTED:
                return org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueStatus.CORRECTED;
            case CANCELLED:
                return org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueStatus.CANCELLED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueStatus.ENTEREDINERROR;
            case UNKNOWN:
                return org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueStatus.UNKNOWN;
            default:
                return org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueStatus.NULL;
        }
    }
}
