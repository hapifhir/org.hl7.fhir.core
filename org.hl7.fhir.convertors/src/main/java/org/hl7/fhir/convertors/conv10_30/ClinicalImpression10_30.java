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
        if (src.hasPatient()) {
            tgt.setSubject(VersionConvertor_10_30.convertReference(src.getPatient()));
        }
        if (src.hasAssessor()) {
            tgt.setAssessor(VersionConvertor_10_30.convertReference(src.getAssessor()));
        }
        if (src.hasStatus()) {
            tgt.setStatus(convertClinicalImpressionStatus(src.getStatus()));
        }
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasDescription()) {
            tgt.setDescription(src.getDescription());
        }
        if (src.hasPrevious()) {
            tgt.setPrevious(VersionConvertor_10_30.convertReference(src.getPrevious()));
        }
        if (src.hasProblem()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getProblem()) tgt.addProblem(VersionConvertor_10_30.convertReference(t));
        }
        if (src.hasProtocol()) {
            tgt.addProtocol(src.getProtocol());
        }
        if (src.hasSummary()) {
            tgt.setSummary(src.getSummary());
        }
        if (src.hasFinding()) {
            for (org.hl7.fhir.dstu2.model.ClinicalImpression.ClinicalImpressionFindingComponent t : src.getFinding()) tgt.addFinding(convertClinicalImpressionFindingComponent(t));
        }
        if (src.hasPrognosis())
            tgt.addPrognosisCodeableConcept().setText(src.getPrognosis());
        if (src.hasAction()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getAction()) tgt.addAction(VersionConvertor_10_30.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ClinicalImpression convertClinicalImpression(org.hl7.fhir.dstu3.model.ClinicalImpression src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ClinicalImpression tgt = new org.hl7.fhir.dstu2.model.ClinicalImpression();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasSubject()) {
            tgt.setPatient(VersionConvertor_10_30.convertReference(src.getSubject()));
        }
        if (src.hasAssessor()) {
            tgt.setAssessor(VersionConvertor_10_30.convertReference(src.getAssessor()));
        }
        if (src.hasStatus()) {
            tgt.setStatus(convertClinicalImpressionStatus(src.getStatus()));
        }
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasDescription()) {
            tgt.setDescription(src.getDescription());
        }
        if (src.hasPrevious()) {
            tgt.setPrevious(VersionConvertor_10_30.convertReference(src.getPrevious()));
        }
        if (src.hasProblem()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getProblem()) tgt.addProblem(VersionConvertor_10_30.convertReference(t));
        }
        if (src.hasProtocol()) {
            for (UriType t : src.getProtocol()) tgt.setProtocol(t.asStringValue());
        }
        if (src.hasSummary()) {
            tgt.setSummary(src.getSummary());
        }
        if (src.hasFinding()) {
            for (org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionFindingComponent t : src.getFinding()) tgt.addFinding(convertClinicalImpressionFindingComponent(t));
        }
        if (src.hasPrognosisCodeableConcept()) {
            tgt.setPrognosis(src.getPrognosisCodeableConceptFirstRep().getText());
        }
        if (src.hasAction()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getAction()) tgt.addAction(VersionConvertor_10_30.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionFindingComponent convertClinicalImpressionFindingComponent(org.hl7.fhir.dstu2.model.ClinicalImpression.ClinicalImpressionFindingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionFindingComponent tgt = new org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionFindingComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasItem()) {
            tgt.setItem(VersionConvertor_10_30.convertCodeableConcept(src.getItem()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ClinicalImpression.ClinicalImpressionFindingComponent convertClinicalImpressionFindingComponent(org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionFindingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ClinicalImpression.ClinicalImpressionFindingComponent tgt = new org.hl7.fhir.dstu2.model.ClinicalImpression.ClinicalImpressionFindingComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasItemCodeableConcept())
            try {
                if (src.hasItemCodeableConcept()) {
                    tgt.setItem(VersionConvertor_10_30.convertCodeableConcept(src.getItemCodeableConcept()));
                }
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
