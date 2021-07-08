package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.conv30_40.VersionConvertor_30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.DateTime30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Uri30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class DetectedIssue30_40 {

    public static org.hl7.fhir.dstu3.model.DetectedIssue convertDetectedIssue(org.hl7.fhir.r4.model.DetectedIssue src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.DetectedIssue tgt = new org.hl7.fhir.dstu3.model.DetectedIssue();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(Identifier30_40.convertIdentifier(src.getIdentifierFirstRep()));
        if (src.hasStatus())
            tgt.setStatusElement(convertDetectedIssueStatus(src.getStatusElement()));
        if (src.hasCode())
            tgt.setCategory(CodeableConcept30_40.convertCodeableConcept(src.getCode()));
        if (src.hasSeverity())
            tgt.setSeverityElement(convertDetectedIssueSeverity(src.getSeverityElement()));
        if (src.hasPatient())
            tgt.setPatient(Reference30_40.convertReference(src.getPatient()));
        if (src.hasIdentifiedDateTimeType())
            tgt.setDateElement(DateTime30_40.convertDateTime(src.getIdentifiedDateTimeType()));
        if (src.hasAuthor())
            tgt.setAuthor(Reference30_40.convertReference(src.getAuthor()));
        for (org.hl7.fhir.r4.model.Reference t : src.getImplicated()) tgt.addImplicated(Reference30_40.convertReference(t));
        if (src.hasDetail())
            tgt.setDetailElement(String30_40.convertString(src.getDetailElement()));
        if (src.hasReference())
            tgt.setReferenceElement(Uri30_40.convertUri(src.getReferenceElement()));
        for (org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueMitigationComponent t : src.getMitigation()) tgt.addMitigation(convertDetectedIssueMitigationComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DetectedIssue convertDetectedIssue(org.hl7.fhir.dstu3.model.DetectedIssue src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.DetectedIssue tgt = new org.hl7.fhir.r4.model.DetectedIssue();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.addIdentifier(Identifier30_40.convertIdentifier(src.getIdentifier()));
        if (src.hasStatus())
            tgt.setStatusElement(convertDetectedIssueStatus(src.getStatusElement()));
        if (src.hasCategory())
            tgt.setCode(CodeableConcept30_40.convertCodeableConcept(src.getCategory()));
        if (src.hasSeverity())
            tgt.setSeverityElement(convertDetectedIssueSeverity(src.getSeverityElement()));
        if (src.hasPatient())
            tgt.setPatient(Reference30_40.convertReference(src.getPatient()));
        if (src.hasDateElement())
            tgt.setIdentified(DateTime30_40.convertDateTime(src.getDateElement()));
        if (src.hasAuthor())
            tgt.setAuthor(Reference30_40.convertReference(src.getAuthor()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getImplicated()) tgt.addImplicated(Reference30_40.convertReference(t));
        if (src.hasDetail())
            tgt.setDetailElement(String30_40.convertString(src.getDetailElement()));
        if (src.hasReference())
            tgt.setReferenceElement(Uri30_40.convertUri(src.getReferenceElement()));
        for (org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueMitigationComponent t : src.getMitigation()) tgt.addMitigation(convertDetectedIssueMitigationComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueMitigationComponent convertDetectedIssueMitigationComponent(org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueMitigationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueMitigationComponent tgt = new org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueMitigationComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasAction())
            tgt.setAction(CodeableConcept30_40.convertCodeableConcept(src.getAction()));
        if (src.hasDateElement())
            tgt.setDateElement(DateTime30_40.convertDateTime(src.getDateElement()));
        if (src.hasAuthor())
            tgt.setAuthor(Reference30_40.convertReference(src.getAuthor()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueMitigationComponent convertDetectedIssueMitigationComponent(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueMitigationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueMitigationComponent tgt = new org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueMitigationComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasAction())
            tgt.setAction(CodeableConcept30_40.convertCodeableConcept(src.getAction()));
        if (src.hasDateElement())
            tgt.setDateElement(DateTime30_40.convertDateTime(src.getDateElement()));
        if (src.hasAuthor())
            tgt.setAuthor(Reference30_40.convertReference(src.getAuthor()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity> convertDetectedIssueSeverity(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueSeverity> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverityEnumFactory());
        Element30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case HIGH:
                tgt.setValue(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity.HIGH);
                break;
            case MODERATE:
                tgt.setValue(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity.MODERATE);
                break;
            case LOW:
                tgt.setValue(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity.LOW);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueSeverity> convertDetectedIssueSeverity(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueSeverity> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueSeverityEnumFactory());
        Element30_40.copyElement(src, tgt);
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus> convertDetectedIssueStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatusEnumFactory());
        Element30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case REGISTERED:
                tgt.setValue(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.REGISTERED);
                break;
            case PRELIMINARY:
                tgt.setValue(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.PRELIMINARY);
                break;
            case FINAL:
                tgt.setValue(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.FINAL);
                break;
            case AMENDED:
                tgt.setValue(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.AMENDED);
                break;
            case CORRECTED:
                tgt.setValue(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.CORRECTED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.CANCELLED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.ENTEREDINERROR);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueStatus> convertDetectedIssueStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueStatusEnumFactory());
        Element30_40.copyElement(src, tgt);
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