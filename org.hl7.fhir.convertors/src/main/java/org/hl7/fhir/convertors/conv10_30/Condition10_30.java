package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Condition10_30 {

    public static org.hl7.fhir.dstu3.model.Condition convertCondition(org.hl7.fhir.dstu2.model.Condition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Condition tgt = new org.hl7.fhir.dstu3.model.Condition();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasPatient()) {
            tgt.setSubject(VersionConvertor_10_30.convertReference(src.getPatient()));
        }
        if (src.hasEncounter()) {
            tgt.setContext(VersionConvertor_10_30.convertReference(src.getEncounter()));
        }
        if (src.hasAsserter()) {
            tgt.setAsserter(VersionConvertor_10_30.convertReference(src.getAsserter()));
        }
        if (src.hasDateRecorded())
            tgt.setAssertedDate(src.getDateRecorded());
        if (src.hasCode()) {
            tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        }
        if (src.hasCategory()) {
            tgt.addCategory(VersionConvertor_10_30.convertCodeableConcept(src.getCategory()));
        }
        try {
            if (src.hasClinicalStatus()) {
                tgt.setClinicalStatus(org.hl7.fhir.dstu3.model.Condition.ConditionClinicalStatus.fromCode(src.getClinicalStatus()));
            }
        } catch (org.hl7.fhir.exceptions.FHIRException e) {
            throw new FHIRException(e);
        }
        if (src.hasVerificationStatus()) {
            tgt.setVerificationStatus(convertConditionVerificationStatus(src.getVerificationStatus()));
        }
        if (src.hasSeverity()) {
            tgt.setSeverity(VersionConvertor_10_30.convertCodeableConcept(src.getSeverity()));
        }
        if (src.hasOnset()) {
            tgt.setOnset(VersionConvertor_10_30.convertType(src.getOnset()));
        }
        if (src.hasAbatement()) {
            tgt.setAbatement(VersionConvertor_10_30.convertType(src.getAbatement()));
        }
        if (src.hasStage()) {
            tgt.setStage(convertConditionStageComponent(src.getStage()));
        }
        if (src.hasEvidence()) {
            for (org.hl7.fhir.dstu2.model.Condition.ConditionEvidenceComponent t : src.getEvidence()) tgt.addEvidence(convertConditionEvidenceComponent(t));
        }
        if (src.hasBodySite()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getBodySite()) tgt.addBodySite(VersionConvertor_10_30.convertCodeableConcept(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Condition convertCondition(org.hl7.fhir.dstu3.model.Condition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Condition tgt = new org.hl7.fhir.dstu2.model.Condition();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasSubject()) {
            tgt.setPatient(VersionConvertor_10_30.convertReference(src.getSubject()));
        }
        if (src.hasContext()) {
            tgt.setEncounter(VersionConvertor_10_30.convertReference(src.getContext()));
        }
        if (src.hasAsserter()) {
            tgt.setAsserter(VersionConvertor_10_30.convertReference(src.getAsserter()));
        }
        if (src.hasAssertedDate())
            tgt.setDateRecorded(src.getAssertedDate());
        if (src.hasCode()) {
            tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        }
        if (src.hasCategory()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCategory()) tgt.setCategory(VersionConvertor_10_30.convertCodeableConcept(t));
        }
        if (src.hasClinicalStatus()) {
            tgt.setClinicalStatus(src.getClinicalStatus().toCode());
        }
        if (src.hasVerificationStatus()) {
            tgt.setVerificationStatus(convertConditionVerificationStatus(src.getVerificationStatus()));
        }
        if (src.hasSeverity()) {
            tgt.setSeverity(VersionConvertor_10_30.convertCodeableConcept(src.getSeverity()));
        }
        if (src.hasOnset()) {
            tgt.setOnset(VersionConvertor_10_30.convertType(src.getOnset()));
        }
        if (src.hasAbatement()) {
            tgt.setAbatement(VersionConvertor_10_30.convertType(src.getAbatement()));
        }
        if (src.hasStage()) {
            tgt.setStage(convertConditionStageComponent(src.getStage()));
        }
        if (src.hasEvidence()) {
            for (org.hl7.fhir.dstu3.model.Condition.ConditionEvidenceComponent t : src.getEvidence()) tgt.addEvidence(convertConditionEvidenceComponent(t));
        }
        if (src.hasBodySite()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getBodySite()) tgt.addBodySite(VersionConvertor_10_30.convertCodeableConcept(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Condition.ConditionEvidenceComponent convertConditionEvidenceComponent(org.hl7.fhir.dstu3.model.Condition.ConditionEvidenceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Condition.ConditionEvidenceComponent tgt = new org.hl7.fhir.dstu2.model.Condition.ConditionEvidenceComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasCode()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept cc : src.getCode()) tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(cc));
        }
        if (src.hasDetail()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getDetail()) tgt.addDetail(VersionConvertor_10_30.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Condition.ConditionEvidenceComponent convertConditionEvidenceComponent(org.hl7.fhir.dstu2.model.Condition.ConditionEvidenceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Condition.ConditionEvidenceComponent tgt = new org.hl7.fhir.dstu3.model.Condition.ConditionEvidenceComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasCode()) {
            tgt.addCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        }
        if (src.hasDetail()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getDetail()) tgt.addDetail(VersionConvertor_10_30.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Condition.ConditionStageComponent convertConditionStageComponent(org.hl7.fhir.dstu2.model.Condition.ConditionStageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Condition.ConditionStageComponent tgt = new org.hl7.fhir.dstu3.model.Condition.ConditionStageComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasSummary()) {
            tgt.setSummary(VersionConvertor_10_30.convertCodeableConcept(src.getSummary()));
        }
        if (src.hasAssessment()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getAssessment()) tgt.addAssessment(VersionConvertor_10_30.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Condition.ConditionStageComponent convertConditionStageComponent(org.hl7.fhir.dstu3.model.Condition.ConditionStageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Condition.ConditionStageComponent tgt = new org.hl7.fhir.dstu2.model.Condition.ConditionStageComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasSummary()) {
            tgt.setSummary(VersionConvertor_10_30.convertCodeableConcept(src.getSummary()));
        }
        if (src.hasAssessment()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getAssessment()) tgt.addAssessment(VersionConvertor_10_30.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Condition.ConditionVerificationStatus convertConditionVerificationStatus(org.hl7.fhir.dstu3.model.Condition.ConditionVerificationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PROVISIONAL:
                return org.hl7.fhir.dstu2.model.Condition.ConditionVerificationStatus.PROVISIONAL;
            case DIFFERENTIAL:
                return org.hl7.fhir.dstu2.model.Condition.ConditionVerificationStatus.DIFFERENTIAL;
            case CONFIRMED:
                return org.hl7.fhir.dstu2.model.Condition.ConditionVerificationStatus.CONFIRMED;
            case REFUTED:
                return org.hl7.fhir.dstu2.model.Condition.ConditionVerificationStatus.REFUTED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu2.model.Condition.ConditionVerificationStatus.ENTEREDINERROR;
            case UNKNOWN:
                return org.hl7.fhir.dstu2.model.Condition.ConditionVerificationStatus.UNKNOWN;
            default:
                return org.hl7.fhir.dstu2.model.Condition.ConditionVerificationStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.Condition.ConditionVerificationStatus convertConditionVerificationStatus(org.hl7.fhir.dstu2.model.Condition.ConditionVerificationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PROVISIONAL:
                return org.hl7.fhir.dstu3.model.Condition.ConditionVerificationStatus.PROVISIONAL;
            case DIFFERENTIAL:
                return org.hl7.fhir.dstu3.model.Condition.ConditionVerificationStatus.DIFFERENTIAL;
            case CONFIRMED:
                return org.hl7.fhir.dstu3.model.Condition.ConditionVerificationStatus.CONFIRMED;
            case REFUTED:
                return org.hl7.fhir.dstu3.model.Condition.ConditionVerificationStatus.REFUTED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.Condition.ConditionVerificationStatus.ENTEREDINERROR;
            case UNKNOWN:
                return org.hl7.fhir.dstu3.model.Condition.ConditionVerificationStatus.UNKNOWN;
            default:
                return org.hl7.fhir.dstu3.model.Condition.ConditionVerificationStatus.NULL;
        }
    }
}
