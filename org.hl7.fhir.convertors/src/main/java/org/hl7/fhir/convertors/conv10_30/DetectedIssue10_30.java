package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class DetectedIssue10_30 {

    public static org.hl7.fhir.dstu2.model.DetectedIssue convertDetectedIssue(org.hl7.fhir.dstu3.model.DetectedIssue src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.DetectedIssue tgt = new org.hl7.fhir.dstu2.model.DetectedIssue();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasPatient()) {
            tgt.setPatient(VersionConvertor_10_30.convertReference(src.getPatient()));
        }
        if (src.hasCategory()) {
            tgt.setCategory(VersionConvertor_10_30.convertCodeableConcept(src.getCategory()));
        }
        if (src.hasSeverity()) {
            tgt.setSeverity(convertDetectedIssueSeverity(src.getSeverity()));
        }
        if (src.hasImplicated()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getImplicated()) tgt.addImplicated(VersionConvertor_10_30.convertReference(t));
        }
        if (src.hasDetail()) {
            tgt.setDetail(src.getDetail());
        }
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasAuthor()) {
            tgt.setAuthor(VersionConvertor_10_30.convertReference(src.getAuthor()));
        }
        if (src.hasIdentifier()) {
            tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        }
        if (src.hasReference()) {
            tgt.setReference(src.getReference());
        }
        if (src.hasMitigation()) {
            for (org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueMitigationComponent t : src.getMitigation()) tgt.addMitigation(convertDetectedIssueMitigationComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DetectedIssue convertDetectedIssue(org.hl7.fhir.dstu2.model.DetectedIssue src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.DetectedIssue tgt = new org.hl7.fhir.dstu3.model.DetectedIssue();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasPatient()) {
            tgt.setPatient(VersionConvertor_10_30.convertReference(src.getPatient()));
        }
        if (src.hasCategory()) {
            tgt.setCategory(VersionConvertor_10_30.convertCodeableConcept(src.getCategory()));
        }
        if (src.hasSeverity()) {
            tgt.setSeverity(convertDetectedIssueSeverity(src.getSeverity()));
        }
        if (src.hasImplicated()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getImplicated()) tgt.addImplicated(VersionConvertor_10_30.convertReference(t));
        }
        if (src.hasDetail()) {
            tgt.setDetail(src.getDetail());
        }
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasAuthor()) {
            tgt.setAuthor(VersionConvertor_10_30.convertReference(src.getAuthor()));
        }
        if (src.hasIdentifier()) {
            tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        }
        if (src.hasReference()) {
            tgt.setReference(src.getReference());
        }
        if (src.hasMitigation()) {
            for (org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueMitigationComponent t : src.getMitigation()) tgt.addMitigation(convertDetectedIssueMitigationComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueMitigationComponent convertDetectedIssueMitigationComponent(org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueMitigationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueMitigationComponent tgt = new org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueMitigationComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasAction()) {
            tgt.setAction(VersionConvertor_10_30.convertCodeableConcept(src.getAction()));
        }
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasAuthor()) {
            tgt.setAuthor(VersionConvertor_10_30.convertReference(src.getAuthor()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueMitigationComponent convertDetectedIssueMitigationComponent(org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueMitigationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueMitigationComponent tgt = new org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueMitigationComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasAction()) {
            tgt.setAction(VersionConvertor_10_30.convertCodeableConcept(src.getAction()));
        }
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasAuthor()) {
            tgt.setAuthor(VersionConvertor_10_30.convertReference(src.getAuthor()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueSeverity convertDetectedIssueSeverity(org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueSeverity src) throws FHIRException {
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

    public static org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueSeverity convertDetectedIssueSeverity(org.hl7.fhir.dstu3.model.DetectedIssue.DetectedIssueSeverity src) throws FHIRException {
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
