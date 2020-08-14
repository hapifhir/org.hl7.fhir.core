package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class DetectedIssue30_50 {

    public static org.hl7.fhir.dstu3.model.DetectedIssue convertDetectedIssue(org.hl7.fhir.r5.model.DetectedIssue src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.DetectedIssue tgt = new org.hl7.fhir.dstu3.model.DetectedIssue();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_30_50.convertIdentifier(src.getIdentifierFirstRep()));
        if (src.hasStatus())
            tgt.setStatusElement(convertDetectedIssueStatus(src.getStatusElement()));
        if (src.hasCode())
            tgt.setCategory(VersionConvertor_30_50.convertCodeableConcept(src.getCode()));
        if (src.hasSeverity())
            tgt.setSeverityElement(convertDetectedIssueSeverity(src.getSeverityElement()));
        if (src.hasPatient())
            tgt.setPatient(VersionConvertor_30_50.convertReference(src.getPatient()));
        if (src.hasIdentifiedDateTimeType())
            tgt.setDateElement(VersionConvertor_30_50.convertDateTime(src.getIdentifiedDateTimeType()));
        if (src.hasAuthor())
            tgt.setAuthor(VersionConvertor_30_50.convertReference(src.getAuthor()));
        for (org.hl7.fhir.r5.model.Reference t : src.getImplicated()) tgt.addImplicated(VersionConvertor_30_50.convertReference(t));
        if (src.hasDetail())
            tgt.setDetailElement(VersionConvertor_30_50.convertString(src.getDetailElement()));
        if (src.hasReference())
            tgt.setReferenceElement(VersionConvertor_30_50.convertUri(src.getReferenceElement()));
        for (org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueMitigationComponent t : src.getMitigation()) tgt.addMitigation(convertDetectedIssueMitigationComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DetectedIssue convertDetectedIssue(org.hl7.fhir.dstu3.model.DetectedIssue src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.DetectedIssue tgt = new org.hl7.fhir.r5.model.DetectedIssue();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(src.getIdentifier()));
        if (src.hasStatus())
            tgt.setStatusElement(convertDetectedIssueStatus(src.getStatusElement()));
        if (src.hasCategory())
            tgt.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getCategory()));
        if (src.hasSeverity())
            tgt.setSeverityElement(convertDetectedIssueSeverity(src.getSeverityElement()));
        if (src.hasPatient())
            tgt.setPatient(VersionConvertor_30_50.convertReference(src.getPatient()));
        if (src.hasDate())
            tgt.setIdentified(VersionConvertor_30_50.convertDateTime(src.getDateElement()));
        if (src.hasAuthor())
            tgt.setAuthor(VersionConvertor_30_50.convertReference(src.getAuthor()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getImplicated()) tgt.addImplicated(VersionConvertor_30_50.convertReference(t));
        if (src.hasDetail())
            tgt.setDetailElement(VersionConvertor_30_50.convertString(src.getDetailElement()));
        if (src.hasReference())
            tgt.setReferenceElement(VersionConvertor_30_50.convertUri(src.getReferenceElement()));
        for (org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueMitigationComponent t : src.getMitigation()) tgt.addMitigation(convertDetectedIssueMitigationComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueMitigationComponent convertDetectedIssueMitigationComponent(org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueMitigationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueMitigationComponent tgt = new org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueMitigationComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasAction())
            tgt.setAction(VersionConvertor_30_50.convertCodeableConcept(src.getAction()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_30_50.convertDateTime(src.getDateElement()));
        if (src.hasAuthor())
            tgt.setAuthor(VersionConvertor_30_50.convertReference(src.getAuthor()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueMitigationComponent convertDetectedIssueMitigationComponent(org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueMitigationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueMitigationComponent tgt = new org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueMitigationComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasAction())
            tgt.setAction(VersionConvertor_30_50.convertCodeableConcept(src.getAction()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_30_50.convertDateTime(src.getDateElement()));
        if (src.hasAuthor())
            tgt.setAuthor(VersionConvertor_30_50.convertReference(src.getAuthor()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueSeverity> convertDetectedIssueSeverity(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverity> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueSeverity> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueSeverityEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case HIGH:
                tgt.setValue(org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueSeverity.HIGH);
                break;
            case MODERATE:
                tgt.setValue(org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueSeverity.MODERATE);
                break;
            case LOW:
                tgt.setValue(org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueSeverity.LOW);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueSeverity.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverity> convertDetectedIssueSeverity(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueSeverity> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverity> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverityEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case HIGH:
                tgt.setValue(org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverity.HIGH);
                break;
            case MODERATE:
                tgt.setValue(org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverity.MODERATE);
                break;
            case LOW:
                tgt.setValue(org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverity.LOW);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverity.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ObservationStatus> convertDetectedIssueStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ObservationStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ObservationStatusEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case REGISTERED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.REGISTERED);
                break;
            case PRELIMINARY:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.PRELIMINARY);
                break;
            case FINAL:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.FINAL);
                break;
            case AMENDED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.AMENDED);
                break;
            case CORRECTED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.CORRECTED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.CANCELLED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.ENTEREDINERROR);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueStatus> convertDetectedIssueStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ObservationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueStatusEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case REGISTERED:
                tgt.setValue(org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueStatus.REGISTERED);
                break;
            case PRELIMINARY:
                tgt.setValue(org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueStatus.PRELIMINARY);
                break;
            case FINAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueStatus.FINAL);
                break;
            case AMENDED:
                tgt.setValue(org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueStatus.AMENDED);
                break;
            case CORRECTED:
                tgt.setValue(org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueStatus.CORRECTED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueStatus.CANCELLED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueStatus.ENTEREDINERROR);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueStatus.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueStatus.NULL);
                break;
        }
        return tgt;
    }
}