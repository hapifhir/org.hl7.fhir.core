package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.dstu3.model.UriType;
import org.hl7.fhir.exceptions.FHIRException;

public class ClinicalImpression10_30 {

    public static org.hl7.fhir.dstu3.model.ClinicalImpression convertClinicalImpression(org.hl7.fhir.dstu2.model.ClinicalImpression src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ClinicalImpression tgt = new org.hl7.fhir.dstu3.model.ClinicalImpression();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        tgt.setSubject(VersionConvertor_10_30.convertReference(src.getPatient()));
        tgt.setAssessor(VersionConvertor_10_30.convertReference(src.getAssessor()));
        tgt.setStatus(convertClinicalImpressionStatus(src.getStatus()));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setDescription(src.getDescription());
        tgt.setPrevious(VersionConvertor_10_30.convertReference(src.getPrevious()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getProblem()) tgt.addProblem(VersionConvertor_10_30.convertReference(t));
        tgt.addProtocol(src.getProtocol());
        tgt.setSummary(src.getSummary());
        for (org.hl7.fhir.dstu2.model.ClinicalImpression.ClinicalImpressionFindingComponent t : src.getFinding()) tgt.addFinding(convertClinicalImpressionFindingComponent(t));
        if (src.hasPrognosis())
            tgt.addPrognosisCodeableConcept().setText(src.getPrognosis());
        for (org.hl7.fhir.dstu2.model.Reference t : src.getAction()) tgt.addAction(VersionConvertor_10_30.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ClinicalImpression convertClinicalImpression(org.hl7.fhir.dstu3.model.ClinicalImpression src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ClinicalImpression tgt = new org.hl7.fhir.dstu2.model.ClinicalImpression();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        tgt.setPatient(VersionConvertor_10_30.convertReference(src.getSubject()));
        tgt.setAssessor(VersionConvertor_10_30.convertReference(src.getAssessor()));
        tgt.setStatus(convertClinicalImpressionStatus(src.getStatus()));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setDescription(src.getDescription());
        tgt.setPrevious(VersionConvertor_10_30.convertReference(src.getPrevious()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getProblem()) tgt.addProblem(VersionConvertor_10_30.convertReference(t));
        for (UriType t : src.getProtocol()) tgt.setProtocol(t.asStringValue());
        tgt.setSummary(src.getSummary());
        for (org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionFindingComponent t : src.getFinding()) tgt.addFinding(convertClinicalImpressionFindingComponent(t));
        tgt.setPrognosis(src.getPrognosisCodeableConceptFirstRep().getText());
        for (org.hl7.fhir.dstu3.model.Reference t : src.getAction()) tgt.addAction(VersionConvertor_10_30.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionFindingComponent convertClinicalImpressionFindingComponent(org.hl7.fhir.dstu2.model.ClinicalImpression.ClinicalImpressionFindingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionFindingComponent tgt = new org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionFindingComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setItem(VersionConvertor_10_30.convertCodeableConcept(src.getItem()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ClinicalImpression.ClinicalImpressionFindingComponent convertClinicalImpressionFindingComponent(org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionFindingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ClinicalImpression.ClinicalImpressionFindingComponent tgt = new org.hl7.fhir.dstu2.model.ClinicalImpression.ClinicalImpressionFindingComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasItemCodeableConcept())
            try {
                tgt.setItem(VersionConvertor_10_30.convertCodeableConcept(src.getItemCodeableConcept()));
            } catch (org.hl7.fhir.exceptions.FHIRException e) {
            }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionStatus convertClinicalImpressionStatus(org.hl7.fhir.dstu2.model.ClinicalImpression.ClinicalImpressionStatus src) throws FHIRException {
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

    public static org.hl7.fhir.dstu2.model.ClinicalImpression.ClinicalImpressionStatus convertClinicalImpressionStatus(org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DRAFT:
                return org.hl7.fhir.dstu2.model.ClinicalImpression.ClinicalImpressionStatus.INPROGRESS;
            case COMPLETED:
                return org.hl7.fhir.dstu2.model.ClinicalImpression.ClinicalImpressionStatus.COMPLETED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu2.model.ClinicalImpression.ClinicalImpressionStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu2.model.ClinicalImpression.ClinicalImpressionStatus.NULL;
        }
    }
}
