package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class DiagnosticReport30_50 {

    public static org.hl7.fhir.r5.model.DiagnosticReport convertDiagnosticReport(org.hl7.fhir.dstu3.model.DiagnosticReport src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.DiagnosticReport tgt = new org.hl7.fhir.r5.model.DiagnosticReport();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
        if (src.hasBasedOn()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) tgt.addBasedOn(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertDiagnosticReportStatus(src.getStatus()));
        if (src.hasCategory())
            tgt.addCategory(VersionConvertor_30_50.convertCodeableConcept(src.getCategory()));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_50.convertReference(src.getSubject()));
        if (src.hasContext())
            tgt.setEncounter(VersionConvertor_30_50.convertReference(src.getContext()));
        if (src.hasEffective())
            tgt.setEffective(VersionConvertor_30_50.convertType(src.getEffective()));
        if (src.hasIssued())
            tgt.setIssued(src.getIssued());
        if (src.hasSpecimen()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getSpecimen()) tgt.addSpecimen(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasResult()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getResult()) tgt.addResult(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasImagingStudy()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getImagingStudy()) tgt.addImagingStudy(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasImage()) {
            for (org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportImageComponent t : src.getImage()) tgt.addMedia(convertDiagnosticReportImageComponent(t));
        }
        if (src.hasConclusion())
            tgt.setConclusion(src.getConclusion());
        if (src.hasCodedDiagnosis()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCodedDiagnosis()) tgt.addConclusionCode(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasPresentedForm()) {
            for (org.hl7.fhir.dstu3.model.Attachment t : src.getPresentedForm()) tgt.addPresentedForm(VersionConvertor_30_50.convertAttachment(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DiagnosticReport convertDiagnosticReport(org.hl7.fhir.r5.model.DiagnosticReport src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.DiagnosticReport tgt = new org.hl7.fhir.dstu3.model.DiagnosticReport();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
        if (src.hasBasedOn()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertDiagnosticReportStatus(src.getStatus()));
        if (src.hasCategory())
            tgt.setCategory(VersionConvertor_30_50.convertCodeableConcept(src.getCategoryFirstRep()));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_50.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setContext(VersionConvertor_30_50.convertReference(src.getEncounter()));
        if (src.hasEffective())
            tgt.setEffective(VersionConvertor_30_50.convertType(src.getEffective()));
        if (src.hasIssued())
            tgt.setIssued(src.getIssued());
        if (src.hasSpecimen()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getSpecimen()) tgt.addSpecimen(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasResult()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getResult()) tgt.addResult(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasImagingStudy()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getImagingStudy()) tgt.addImagingStudy(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasMedia()) {
            for (org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportMediaComponent t : src.getMedia()) tgt.addImage(convertDiagnosticReportImageComponent(t));
        }
        if (src.hasConclusion())
            tgt.setConclusion(src.getConclusion());
        if (src.hasConclusionCode()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getConclusionCode()) tgt.addCodedDiagnosis(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasPresentedForm()) {
            for (org.hl7.fhir.r5.model.Attachment t : src.getPresentedForm()) tgt.addPresentedForm(VersionConvertor_30_50.convertAttachment(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportImageComponent convertDiagnosticReportImageComponent(org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportMediaComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportImageComponent tgt = new org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportImageComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasComment())
            tgt.setComment(src.getComment());
        if (src.hasLink())
            tgt.setLink(VersionConvertor_30_50.convertReference(src.getLink()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportMediaComponent convertDiagnosticReportImageComponent(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportImageComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportMediaComponent tgt = new org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportMediaComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasComment())
            tgt.setComment(src.getComment());
        if (src.hasLink())
            tgt.setLink(VersionConvertor_30_50.convertReference(src.getLink()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus convertDiagnosticReportStatus(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REGISTERED:
                return org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus.REGISTERED;
            case PARTIAL:
                return org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus.PARTIAL;
            case PRELIMINARY:
                return org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus.PRELIMINARY;
            case FINAL:
                return org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus.FINAL;
            case AMENDED:
                return org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus.AMENDED;
            case CORRECTED:
                return org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus.CORRECTED;
            case APPENDED:
                return org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus.APPENDED;
            case CANCELLED:
                return org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus.CANCELLED;
            case ENTEREDINERROR:
                return org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus.ENTEREDINERROR;
            case UNKNOWN:
                return org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus.UNKNOWN;
            default:
                return org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus convertDiagnosticReportStatus(org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REGISTERED:
                return org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.REGISTERED;
            case PARTIAL:
                return org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.PARTIAL;
            case PRELIMINARY:
                return org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.PRELIMINARY;
            case FINAL:
                return org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.FINAL;
            case AMENDED:
                return org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.AMENDED;
            case CORRECTED:
                return org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.CORRECTED;
            case APPENDED:
                return org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.APPENDED;
            case CANCELLED:
                return org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.CANCELLED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.ENTEREDINERROR;
            case UNKNOWN:
                return org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.UNKNOWN;
            default:
                return org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.NULL;
        }
    }
}
