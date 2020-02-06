package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class ClinicalImpression30_50 {

    public static org.hl7.fhir.dstu3.model.ClinicalImpression convertClinicalImpression(org.hl7.fhir.r5.model.ClinicalImpression src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ClinicalImpression tgt = new org.hl7.fhir.dstu3.model.ClinicalImpression();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertClinicalImpressionStatus(src.getStatus()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_50.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setContext(VersionConvertor_30_50.convertReference(src.getEncounter()));
        if (src.hasEffective())
            tgt.setEffective(VersionConvertor_30_50.convertType(src.getEffective()));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasPerformer())
            tgt.setAssessor(VersionConvertor_30_50.convertReference(src.getPerformer()));
        if (src.hasPrevious())
            tgt.setPrevious(VersionConvertor_30_50.convertReference(src.getPrevious()));
        if (src.hasProblem()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getProblem()) tgt.addProblem(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasProtocol()) {
            for (org.hl7.fhir.r5.model.UriType t : src.getProtocol()) tgt.addProtocol(t.getValue());
        }
        if (src.hasSummary())
            tgt.setSummary(src.getSummary());
        if (src.hasFinding()) {
            for (org.hl7.fhir.r5.model.ClinicalImpression.ClinicalImpressionFindingComponent t : src.getFinding()) tgt.addFinding(convertClinicalImpressionFindingComponent(t));
        }
        if (src.hasPrognosisCodeableConcept()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getPrognosisCodeableConcept()) tgt.addPrognosisCodeableConcept(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasPrognosisReference()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getPrognosisReference()) tgt.addPrognosisReference(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasNote()) {
            for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_50.convertAnnotation(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ClinicalImpression convertClinicalImpression(org.hl7.fhir.dstu3.model.ClinicalImpression src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ClinicalImpression tgt = new org.hl7.fhir.r5.model.ClinicalImpression();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertClinicalImpressionStatus(src.getStatus()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_50.convertReference(src.getSubject()));
        if (src.hasContext())
            tgt.setEncounter(VersionConvertor_30_50.convertReference(src.getContext()));
        if (src.hasEffective())
            tgt.setEffective(VersionConvertor_30_50.convertType(src.getEffective()));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasAssessor())
            tgt.setPerformer(VersionConvertor_30_50.convertReference(src.getAssessor()));
        if (src.hasPrevious())
            tgt.setPrevious(VersionConvertor_30_50.convertReference(src.getPrevious()));
        if (src.hasProblem()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getProblem()) tgt.addProblem(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasProtocol()) {
            for (org.hl7.fhir.dstu3.model.UriType t : src.getProtocol()) tgt.addProtocol(t.getValue());
        }
        if (src.hasSummary())
            tgt.setSummary(src.getSummary());
        if (src.hasFinding()) {
            for (org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionFindingComponent t : src.getFinding()) tgt.addFinding(convertClinicalImpressionFindingComponent(t));
        }
        if (src.hasPrognosisCodeableConcept()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getPrognosisCodeableConcept()) tgt.addPrognosisCodeableConcept(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasPrognosisReference()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getPrognosisReference()) tgt.addPrognosisReference(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasNote()) {
            for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_50.convertAnnotation(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionFindingComponent convertClinicalImpressionFindingComponent(org.hl7.fhir.r5.model.ClinicalImpression.ClinicalImpressionFindingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionFindingComponent tgt = new org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionFindingComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasItem() && src.getItem().hasConcept())
            tgt.setItem(VersionConvertor_30_50.convertType(src.getItem().getConcept()));
        else if (src.hasItem() && src.getItem().hasReference())
            tgt.setItem(VersionConvertor_30_50.convertType(src.getItem().getReference()));
        if (src.hasBasis())
            tgt.setBasis(src.getBasis());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ClinicalImpression.ClinicalImpressionFindingComponent convertClinicalImpressionFindingComponent(org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionFindingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ClinicalImpression.ClinicalImpressionFindingComponent tgt = new org.hl7.fhir.r5.model.ClinicalImpression.ClinicalImpressionFindingComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasItemCodeableConcept())
            tgt.setItem(VersionConvertor_30_50.convertCodeableConceptToCodableReference(src.getItemCodeableConcept()));
        if (src.hasItemReference())
            tgt.setItem(VersionConvertor_30_50.convertReferenceToCodableReference(src.getItemReference()));
        if (src.hasBasis())
            tgt.setBasis(src.getBasis());
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionStatus convertClinicalImpressionStatus(org.hl7.fhir.r5.model.Enumerations.EventStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INPROGRESS:
                return org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionStatus.DRAFT;
            case COMPLETED:
                return org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionStatus.COMPLETED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionStatus.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.Enumerations.EventStatus convertClinicalImpressionStatus(org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DRAFT:
                return org.hl7.fhir.r5.model.Enumerations.EventStatus.INPROGRESS;
            case COMPLETED:
                return org.hl7.fhir.r5.model.Enumerations.EventStatus.COMPLETED;
            case ENTEREDINERROR:
                return org.hl7.fhir.r5.model.Enumerations.EventStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.r5.model.Enumerations.EventStatus.NULL;
        }
    }
}
