package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class DiagnosticReport30_40 {

    public static org.hl7.fhir.r4.model.DiagnosticReport convertDiagnosticReport(org.hl7.fhir.dstu3.model.DiagnosticReport src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.DiagnosticReport tgt = new org.hl7.fhir.r4.model.DiagnosticReport();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) tgt.addBasedOn(VersionConvertor_30_40.convertReference(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertDiagnosticReportStatus(src.getStatusElement()));
        if (src.hasCategory())
            tgt.addCategory(VersionConvertor_30_40.convertCodeableConcept(src.getCategory()));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_40.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        if (src.hasContext())
            tgt.setEncounter(VersionConvertor_30_40.convertReference(src.getContext()));
        if (src.hasEffective())
            tgt.setEffective(VersionConvertor_30_40.convertType(src.getEffective()));
        if (src.hasIssued())
            tgt.setIssuedElement(VersionConvertor_30_40.convertInstant(src.getIssuedElement()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getSpecimen()) tgt.addSpecimen(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getResult()) tgt.addResult(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getImagingStudy()) tgt.addImagingStudy(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportImageComponent t : src.getImage()) tgt.addMedia(convertDiagnosticReportImageComponent(t));
        if (src.hasConclusion())
            tgt.setConclusionElement(VersionConvertor_30_40.convertString(src.getConclusionElement()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCodedDiagnosis()) tgt.addConclusionCode(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.Attachment t : src.getPresentedForm()) tgt.addPresentedForm(VersionConvertor_30_40.convertAttachment(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DiagnosticReport convertDiagnosticReport(org.hl7.fhir.r4.model.DiagnosticReport src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.DiagnosticReport tgt = new org.hl7.fhir.dstu3.model.DiagnosticReport();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(VersionConvertor_30_40.convertReference(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertDiagnosticReportStatus(src.getStatusElement()));
        if (src.hasCategory())
            tgt.setCategory(VersionConvertor_30_40.convertCodeableConcept(src.getCategoryFirstRep()));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_40.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setContext(VersionConvertor_30_40.convertReference(src.getEncounter()));
        if (src.hasEffective())
            tgt.setEffective(VersionConvertor_30_40.convertType(src.getEffective()));
        if (src.hasIssued())
            tgt.setIssuedElement(VersionConvertor_30_40.convertInstant(src.getIssuedElement()));
        for (org.hl7.fhir.r4.model.Reference t : src.getSpecimen()) tgt.addSpecimen(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getResult()) tgt.addResult(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getImagingStudy()) tgt.addImagingStudy(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportMediaComponent t : src.getMedia()) tgt.addImage(convertDiagnosticReportImageComponent(t));
        if (src.hasConclusion())
            tgt.setConclusionElement(VersionConvertor_30_40.convertString(src.getConclusionElement()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getConclusionCode()) tgt.addCodedDiagnosis(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.Attachment t : src.getPresentedForm()) tgt.addPresentedForm(VersionConvertor_30_40.convertAttachment(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportMediaComponent convertDiagnosticReportImageComponent(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportImageComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportMediaComponent tgt = new org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportMediaComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasComment())
            tgt.setCommentElement(VersionConvertor_30_40.convertString(src.getCommentElement()));
        if (src.hasLink())
            tgt.setLink(VersionConvertor_30_40.convertReference(src.getLink()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportImageComponent convertDiagnosticReportImageComponent(org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportMediaComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportImageComponent tgt = new org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportImageComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasComment())
            tgt.setCommentElement(VersionConvertor_30_40.convertString(src.getCommentElement()));
        if (src.hasLink())
            tgt.setLink(VersionConvertor_30_40.convertReference(src.getLink()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus> convertDiagnosticReportStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatusEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case REGISTERED:
                tgt.setValue(org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus.REGISTERED);
                break;
            case PARTIAL:
                tgt.setValue(org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus.PARTIAL);
                break;
            case PRELIMINARY:
                tgt.setValue(org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus.PRELIMINARY);
                break;
            case FINAL:
                tgt.setValue(org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus.FINAL);
                break;
            case AMENDED:
                tgt.setValue(org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus.AMENDED);
                break;
            case CORRECTED:
                tgt.setValue(org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus.CORRECTED);
                break;
            case APPENDED:
                tgt.setValue(org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus.APPENDED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus.CANCELLED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus.ENTEREDINERROR);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus> convertDiagnosticReportStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatusEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case REGISTERED:
                tgt.setValue(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.REGISTERED);
                break;
            case PARTIAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.PARTIAL);
                break;
            case PRELIMINARY:
                tgt.setValue(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.PRELIMINARY);
                break;
            case FINAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.FINAL);
                break;
            case AMENDED:
                tgt.setValue(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.AMENDED);
                break;
            case CORRECTED:
                tgt.setValue(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.CORRECTED);
                break;
            case APPENDED:
                tgt.setValue(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.APPENDED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.CANCELLED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.ENTEREDINERROR);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.NULL);
                break;
        }
        return tgt;
    }
}