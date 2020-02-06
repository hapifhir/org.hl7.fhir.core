package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class DiagnosticReport10_30 {

    public static org.hl7.fhir.dstu2.model.DiagnosticReport convertDiagnosticReport(org.hl7.fhir.dstu3.model.DiagnosticReport src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.DiagnosticReport tgt = new org.hl7.fhir.dstu2.model.DiagnosticReport();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasStatus()) {
            tgt.setStatus(convertDiagnosticReportStatus(src.getStatus()));
        }
        if (src.hasCategory()) {
            tgt.setCategory(VersionConvertor_10_30.convertCodeableConcept(src.getCategory()));
        }
        if (src.hasCode()) {
            tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        }
        if (src.hasSubject()) {
            tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        }
        if (src.hasContext()) {
            tgt.setEncounter(VersionConvertor_10_30.convertReference(src.getContext()));
        }
        if (src.hasEffective()) {
            tgt.setEffective(VersionConvertor_10_30.convertType(src.getEffective()));
        }
        if (src.hasIssued()) {
            tgt.setIssued(src.getIssued());
        }
        if (src.hasBasedOn()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) tgt.addRequest(VersionConvertor_10_30.convertReference(t));
        }
        if (src.hasSpecimen()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getSpecimen()) tgt.addSpecimen(VersionConvertor_10_30.convertReference(t));
        }
        if (src.hasResult()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getResult()) tgt.addResult(VersionConvertor_10_30.convertReference(t));
        }
        if (src.hasImagingStudy()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getImagingStudy()) tgt.addImagingStudy(VersionConvertor_10_30.convertReference(t));
        }
        if (src.hasImage()) {
            for (org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportImageComponent t : src.getImage()) tgt.addImage(convertDiagnosticReportImageComponent(t));
        }
        if (src.hasConclusion()) {
            tgt.setConclusion(src.getConclusion());
        }
        if (src.hasCodedDiagnosis()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCodedDiagnosis()) tgt.addCodedDiagnosis(VersionConvertor_10_30.convertCodeableConcept(t));
        }
        if (src.hasPresentedForm()) {
            for (org.hl7.fhir.dstu3.model.Attachment t : src.getPresentedForm()) tgt.addPresentedForm(VersionConvertor_10_30.convertAttachment(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DiagnosticReport convertDiagnosticReport(org.hl7.fhir.dstu2.model.DiagnosticReport src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.DiagnosticReport tgt = new org.hl7.fhir.dstu3.model.DiagnosticReport();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasStatus()) {
            tgt.setStatus(convertDiagnosticReportStatus(src.getStatus()));
        }
        if (src.hasCategory()) {
            tgt.setCategory(VersionConvertor_10_30.convertCodeableConcept(src.getCategory()));
        }
        if (src.hasCode()) {
            tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        }
        if (src.hasSubject()) {
            tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        }
        if (src.hasEncounter()) {
            tgt.setContext(VersionConvertor_10_30.convertReference(src.getEncounter()));
        }
        if (src.hasEffective()) {
            tgt.setEffective(VersionConvertor_10_30.convertType(src.getEffective()));
        }
        if (src.hasIssued()) {
            tgt.setIssued(src.getIssued());
        }
        if (src.hasRequest()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getRequest()) tgt.addBasedOn(VersionConvertor_10_30.convertReference(t));
        }
        if (src.hasSpecimen()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getSpecimen()) tgt.addSpecimen(VersionConvertor_10_30.convertReference(t));
        }
        if (src.hasResult()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getResult()) tgt.addResult(VersionConvertor_10_30.convertReference(t));
        }
        if (src.hasImagingStudy()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getImagingStudy()) tgt.addImagingStudy(VersionConvertor_10_30.convertReference(t));
        }
        if (src.hasImage()) {
            for (org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportImageComponent t : src.getImage()) tgt.addImage(convertDiagnosticReportImageComponent(t));
        }
        if (src.hasConclusion()) {
            tgt.setConclusion(src.getConclusion());
        }
        if (src.hasCodedDiagnosis()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getCodedDiagnosis()) tgt.addCodedDiagnosis(VersionConvertor_10_30.convertCodeableConcept(t));
        }
        if (src.hasPresentedForm()) {
            for (org.hl7.fhir.dstu2.model.Attachment t : src.getPresentedForm()) tgt.addPresentedForm(VersionConvertor_10_30.convertAttachment(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportImageComponent convertDiagnosticReportImageComponent(org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportImageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportImageComponent tgt = new org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportImageComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasComment()) {
            tgt.setComment(src.getComment());
        }
        if (src.hasLink()) {
            tgt.setLink(VersionConvertor_10_30.convertReference(src.getLink()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportImageComponent convertDiagnosticReportImageComponent(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportImageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportImageComponent tgt = new org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportImageComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasComment()) {
            tgt.setComment(src.getComment());
        }
        if (src.hasLink()) {
            tgt.setLink(VersionConvertor_10_30.convertReference(src.getLink()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus convertDiagnosticReportStatus(org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REGISTERED:
                return org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.REGISTERED;
            case PARTIAL:
                return org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.PARTIAL;
            case FINAL:
                return org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.FINAL;
            case CORRECTED:
                return org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.CORRECTED;
            case APPENDED:
                return org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.APPENDED;
            case CANCELLED:
                return org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.CANCELLED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus convertDiagnosticReportStatus(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REGISTERED:
                return org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus.REGISTERED;
            case PARTIAL:
                return org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus.PARTIAL;
            case FINAL:
                return org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus.FINAL;
            case CORRECTED:
                return org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus.CORRECTED;
            case APPENDED:
                return org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus.APPENDED;
            case CANCELLED:
                return org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus.CANCELLED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus.NULL;
        }
    }
}
