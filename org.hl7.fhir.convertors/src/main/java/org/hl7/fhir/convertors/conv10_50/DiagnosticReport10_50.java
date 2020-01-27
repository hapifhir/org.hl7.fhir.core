package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class DiagnosticReport10_50 {

    public static org.hl7.fhir.r5.model.DiagnosticReport convertDiagnosticReport(org.hl7.fhir.dstu2.model.DiagnosticReport src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.DiagnosticReport tgt = new org.hl7.fhir.r5.model.DiagnosticReport();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        tgt.setStatus(convertDiagnosticReportStatus(src.getStatus()));
        tgt.addCategory(VersionConvertor_10_50.convertCodeableConcept(src.getCategory()));
        tgt.setCode(VersionConvertor_10_50.convertCodeableConcept(src.getCode()));
        tgt.setSubject(VersionConvertor_10_50.convertReference(src.getSubject()));
        tgt.setEncounter(VersionConvertor_10_50.convertReference(src.getEncounter()));
        tgt.setEffective(VersionConvertor_10_50.convertType(src.getEffective()));
        tgt.setIssued(src.getIssued());
        for (org.hl7.fhir.dstu2.model.Reference t : src.getSpecimen()) tgt.addSpecimen(VersionConvertor_10_50.convertReference(t));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getResult()) tgt.addResult(VersionConvertor_10_50.convertReference(t));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getImagingStudy()) tgt.addImagingStudy(VersionConvertor_10_50.convertReference(t));
        for (org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportImageComponent t : src.getImage()) tgt.addMedia(convertDiagnosticReportImageComponent(t));
        tgt.setConclusion(src.getConclusion());
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getCodedDiagnosis()) tgt.addConclusionCode(VersionConvertor_10_50.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu2.model.Attachment t : src.getPresentedForm()) tgt.addPresentedForm(VersionConvertor_10_50.convertAttachment(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DiagnosticReport convertDiagnosticReport(org.hl7.fhir.r5.model.DiagnosticReport src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.DiagnosticReport tgt = new org.hl7.fhir.dstu2.model.DiagnosticReport();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        tgt.setStatus(convertDiagnosticReportStatus(src.getStatus()));
        tgt.setCategory(VersionConvertor_10_50.convertCodeableConcept(src.getCategoryFirstRep()));
        tgt.setCode(VersionConvertor_10_50.convertCodeableConcept(src.getCode()));
        tgt.setSubject(VersionConvertor_10_50.convertReference(src.getSubject()));
        tgt.setEncounter(VersionConvertor_10_50.convertReference(src.getEncounter()));
        tgt.setEffective(VersionConvertor_10_50.convertType(src.getEffective()));
        tgt.setIssued(src.getIssued());
        for (org.hl7.fhir.r5.model.Reference t : src.getSpecimen()) tgt.addSpecimen(VersionConvertor_10_50.convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getResult()) tgt.addResult(VersionConvertor_10_50.convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getImagingStudy()) tgt.addImagingStudy(VersionConvertor_10_50.convertReference(t));
        for (org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportMediaComponent t : src.getMedia()) tgt.addImage(convertDiagnosticReportImageComponent(t));
        tgt.setConclusion(src.getConclusion());
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getConclusionCode()) tgt.addCodedDiagnosis(VersionConvertor_10_50.convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.Attachment t : src.getPresentedForm()) tgt.addPresentedForm(VersionConvertor_10_50.convertAttachment(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportMediaComponent convertDiagnosticReportImageComponent(org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportImageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportMediaComponent tgt = new org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportMediaComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setComment(src.getComment());
        tgt.setLink(VersionConvertor_10_50.convertReference(src.getLink()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportImageComponent convertDiagnosticReportImageComponent(org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportMediaComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportImageComponent tgt = new org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportImageComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setComment(src.getComment());
        tgt.setLink(VersionConvertor_10_50.convertReference(src.getLink()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus convertDiagnosticReportStatus(org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REGISTERED:
                return org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus.REGISTERED;
            case PARTIAL:
                return org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus.PARTIAL;
            case FINAL:
                return org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus.FINAL;
            case CORRECTED:
                return org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus.CORRECTED;
            case APPENDED:
                return org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus.APPENDED;
            case CANCELLED:
                return org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus.CANCELLED;
            case ENTEREDINERROR:
                return org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus convertDiagnosticReportStatus(org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus src) throws FHIRException {
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
