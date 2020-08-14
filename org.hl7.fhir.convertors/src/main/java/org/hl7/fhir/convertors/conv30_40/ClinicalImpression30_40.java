package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class ClinicalImpression30_40 {

    public static org.hl7.fhir.dstu3.model.ClinicalImpression convertClinicalImpression(org.hl7.fhir.r4.model.ClinicalImpression src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ClinicalImpression tgt = new org.hl7.fhir.dstu3.model.ClinicalImpression();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertClinicalImpressionStatus(src.getStatusElement()));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_40.convertCodeableConcept(src.getCode()));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_40.convertString(src.getDescriptionElement()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setContext(VersionConvertor_30_40.convertReference(src.getEncounter()));
        if (src.hasEffective())
            tgt.setEffective(VersionConvertor_30_40.convertType(src.getEffective()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasAssessor())
            tgt.setAssessor(VersionConvertor_30_40.convertReference(src.getAssessor()));
        if (src.hasPrevious())
            tgt.setPrevious(VersionConvertor_30_40.convertReference(src.getPrevious()));
        for (org.hl7.fhir.r4.model.Reference t : src.getProblem()) tgt.addProblem(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.r4.model.ClinicalImpression.ClinicalImpressionInvestigationComponent t : src.getInvestigation()) tgt.addInvestigation(convertClinicalImpressionInvestigationComponent(t));
        for (org.hl7.fhir.r4.model.UriType t : src.getProtocol()) tgt.addProtocol(t.getValue());
        if (src.hasSummary())
            tgt.setSummaryElement(VersionConvertor_30_40.convertString(src.getSummaryElement()));
        for (org.hl7.fhir.r4.model.ClinicalImpression.ClinicalImpressionFindingComponent t : src.getFinding()) tgt.addFinding(convertClinicalImpressionFindingComponent(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getPrognosisCodeableConcept()) tgt.addPrognosisCodeableConcept(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getPrognosisReference()) tgt.addPrognosisReference(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ClinicalImpression convertClinicalImpression(org.hl7.fhir.dstu3.model.ClinicalImpression src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ClinicalImpression tgt = new org.hl7.fhir.r4.model.ClinicalImpression();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertClinicalImpressionStatus(src.getStatusElement()));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_40.convertCodeableConcept(src.getCode()));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_40.convertString(src.getDescriptionElement()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        if (src.hasContext())
            tgt.setEncounter(VersionConvertor_30_40.convertReference(src.getContext()));
        if (src.hasEffective())
            tgt.setEffective(VersionConvertor_30_40.convertType(src.getEffective()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasAssessor())
            tgt.setAssessor(VersionConvertor_30_40.convertReference(src.getAssessor()));
        if (src.hasPrevious())
            tgt.setPrevious(VersionConvertor_30_40.convertReference(src.getPrevious()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getProblem()) tgt.addProblem(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionInvestigationComponent t : src.getInvestigation()) tgt.addInvestigation(convertClinicalImpressionInvestigationComponent(t));
        for (org.hl7.fhir.dstu3.model.UriType t : src.getProtocol()) tgt.addProtocol(t.getValue());
        if (src.hasSummary())
            tgt.setSummaryElement(VersionConvertor_30_40.convertString(src.getSummaryElement()));
        for (org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionFindingComponent t : src.getFinding()) tgt.addFinding(convertClinicalImpressionFindingComponent(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getPrognosisCodeableConcept()) tgt.addPrognosisCodeableConcept(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getPrognosisReference()) tgt.addPrognosisReference(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ClinicalImpression.ClinicalImpressionFindingComponent convertClinicalImpressionFindingComponent(org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionFindingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ClinicalImpression.ClinicalImpressionFindingComponent tgt = new org.hl7.fhir.r4.model.ClinicalImpression.ClinicalImpressionFindingComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasItemCodeableConcept())
            tgt.setItemCodeableConcept(VersionConvertor_30_40.convertCodeableConcept(src.getItemCodeableConcept()));
        if (src.hasItemReference())
            tgt.setItemReference(VersionConvertor_30_40.convertReference(src.getItemReference()));
        if (src.hasBasis())
            tgt.setBasisElement(VersionConvertor_30_40.convertString(src.getBasisElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionFindingComponent convertClinicalImpressionFindingComponent(org.hl7.fhir.r4.model.ClinicalImpression.ClinicalImpressionFindingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionFindingComponent tgt = new org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionFindingComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasItemCodeableConcept())
            tgt.setItem(VersionConvertor_30_40.convertType(src.getItemCodeableConcept()));
        else if (src.hasItemReference())
            tgt.setItem(VersionConvertor_30_40.convertType(src.getItemReference()));
        if (src.hasBasis())
            tgt.setBasisElement(VersionConvertor_30_40.convertString(src.getBasisElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ClinicalImpression.ClinicalImpressionInvestigationComponent convertClinicalImpressionInvestigationComponent(org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionInvestigationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ClinicalImpression.ClinicalImpressionInvestigationComponent tgt = new org.hl7.fhir.r4.model.ClinicalImpression.ClinicalImpressionInvestigationComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_40.convertCodeableConcept(src.getCode()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getItem()) tgt.addItem(VersionConvertor_30_40.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionInvestigationComponent convertClinicalImpressionInvestigationComponent(org.hl7.fhir.r4.model.ClinicalImpression.ClinicalImpressionInvestigationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionInvestigationComponent tgt = new org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionInvestigationComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_40.convertCodeableConcept(src.getCode()));
        for (org.hl7.fhir.r4.model.Reference t : src.getItem()) tgt.addItem(VersionConvertor_30_40.convertReference(t));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ClinicalImpression.ClinicalImpressionStatus> convertClinicalImpressionStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ClinicalImpression.ClinicalImpressionStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ClinicalImpression.ClinicalImpressionStatusEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case DRAFT:
                tgt.setValue(org.hl7.fhir.r4.model.ClinicalImpression.ClinicalImpressionStatus.INPROGRESS);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r4.model.ClinicalImpression.ClinicalImpressionStatus.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.ClinicalImpression.ClinicalImpressionStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ClinicalImpression.ClinicalImpressionStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionStatus> convertClinicalImpressionStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ClinicalImpression.ClinicalImpressionStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionStatusEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionStatus.DRAFT);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionStatus.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionStatus.NULL);
                break;
        }
        return tgt;
    }
}