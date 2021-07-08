package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.conv10_40.VersionConvertor_10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Type10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Attachment10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.CodeableConcept10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Identifier10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Instant10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.String10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class DiagnosticReport10_40 {

    public static org.hl7.fhir.dstu2.model.DiagnosticReport convertDiagnosticReport(org.hl7.fhir.r4.model.DiagnosticReport src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.DiagnosticReport tgt = new org.hl7.fhir.dstu2.model.DiagnosticReport();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertDiagnosticReportStatus(src.getStatusElement()));
        if (src.hasCategory())
            tgt.setCategory(CodeableConcept10_40.convertCodeableConcept(src.getCategoryFirstRep()));
        if (src.hasCode())
            tgt.setCode(CodeableConcept10_40.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(Reference10_40.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(Reference10_40.convertReference(src.getEncounter()));
        if (src.hasEffective())
            tgt.setEffective(Type10_40.convertType(src.getEffective()));
        if (src.hasIssuedElement())
            tgt.setIssuedElement(Instant10_40.convertInstant(src.getIssuedElement()));
        for (org.hl7.fhir.r4.model.Reference t : src.getSpecimen()) tgt.addSpecimen(Reference10_40.convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getResult()) tgt.addResult(Reference10_40.convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getImagingStudy()) tgt.addImagingStudy(Reference10_40.convertReference(t));
        for (org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportMediaComponent t : src.getMedia()) tgt.addImage(convertDiagnosticReportImageComponent(t));
        if (src.hasConclusionElement())
            tgt.setConclusionElement(String10_40.convertString(src.getConclusionElement()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getConclusionCode()) tgt.addCodedDiagnosis(CodeableConcept10_40.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.Attachment t : src.getPresentedForm()) tgt.addPresentedForm(Attachment10_40.convertAttachment(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DiagnosticReport convertDiagnosticReport(org.hl7.fhir.dstu2.model.DiagnosticReport src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.DiagnosticReport tgt = new org.hl7.fhir.r4.model.DiagnosticReport();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertDiagnosticReportStatus(src.getStatusElement()));
        if (src.hasCategory())
            tgt.addCategory(CodeableConcept10_40.convertCodeableConcept(src.getCategory()));
        if (src.hasCode())
            tgt.setCode(CodeableConcept10_40.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(Reference10_40.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(Reference10_40.convertReference(src.getEncounter()));
        if (src.hasEffective())
            tgt.setEffective(Type10_40.convertType(src.getEffective()));
        if (src.hasIssuedElement())
            tgt.setIssuedElement(Instant10_40.convertInstant(src.getIssuedElement()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getSpecimen()) tgt.addSpecimen(Reference10_40.convertReference(t));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getResult()) tgt.addResult(Reference10_40.convertReference(t));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getImagingStudy()) tgt.addImagingStudy(Reference10_40.convertReference(t));
        for (org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportImageComponent t : src.getImage()) tgt.addMedia(convertDiagnosticReportImageComponent(t));
        if (src.hasConclusionElement())
            tgt.setConclusionElement(String10_40.convertString(src.getConclusionElement()));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getCodedDiagnosis()) tgt.addConclusionCode(CodeableConcept10_40.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu2.model.Attachment t : src.getPresentedForm()) tgt.addPresentedForm(Attachment10_40.convertAttachment(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportImageComponent convertDiagnosticReportImageComponent(org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportMediaComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportImageComponent tgt = new org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportImageComponent();
        Element10_40.copyElement(src, tgt);
        if (src.hasCommentElement())
            tgt.setCommentElement(String10_40.convertString(src.getCommentElement()));
        if (src.hasLink())
            tgt.setLink(Reference10_40.convertReference(src.getLink()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportMediaComponent convertDiagnosticReportImageComponent(org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportImageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportMediaComponent tgt = new org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportMediaComponent();
        Element10_40.copyElement(src, tgt);
        if (src.hasCommentElement())
            tgt.setCommentElement(String10_40.convertString(src.getCommentElement()));
        if (src.hasLink())
            tgt.setLink(Reference10_40.convertReference(src.getLink()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus> convertDiagnosticReportStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatusEnumFactory());
        Element10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case REGISTERED:
                tgt.setValue(org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus.REGISTERED);
                break;
            case PARTIAL:
                tgt.setValue(org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus.PARTIAL);
                break;
            case FINAL:
                tgt.setValue(org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus.FINAL);
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
            default:
                tgt.setValue(org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus> convertDiagnosticReportStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatusEnumFactory());
        Element10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case REGISTERED:
                tgt.setValue(org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus.REGISTERED);
                break;
            case PARTIAL:
                tgt.setValue(org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus.PARTIAL);
                break;
            case FINAL:
                tgt.setValue(org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus.FINAL);
                break;
            case CORRECTED:
                tgt.setValue(org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus.CORRECTED);
                break;
            case APPENDED:
                tgt.setValue(org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus.APPENDED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus.CANCELLED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus.NULL);
                break;
        }
        return tgt;
    }
}