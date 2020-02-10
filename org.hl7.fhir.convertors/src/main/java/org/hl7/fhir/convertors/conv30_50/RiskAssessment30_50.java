package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class RiskAssessment30_50 {

    public static org.hl7.fhir.r5.model.RiskAssessment convertRiskAssessment(org.hl7.fhir.dstu3.model.RiskAssessment src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.RiskAssessment tgt = new org.hl7.fhir.r5.model.RiskAssessment();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(src.getIdentifier()));
        if (src.hasBasedOn())
            tgt.setBasedOn(VersionConvertor_30_50.convertReference(src.getBasedOn()));
        if (src.hasParent())
            tgt.setParent(VersionConvertor_30_50.convertReference(src.getParent()));
        if (src.hasStatus())
            tgt.setStatus(convertRiskAssessmentStatus(src.getStatus()));
        if (src.hasMethod())
            tgt.setMethod(VersionConvertor_30_50.convertCodeableConcept(src.getMethod()));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_50.convertReference(src.getSubject()));
        if (src.hasContext())
            tgt.setEncounter(VersionConvertor_30_50.convertReference(src.getContext()));
        if (src.hasOccurrence())
            tgt.setOccurrence(VersionConvertor_30_50.convertType(src.getOccurrence()));
        if (src.hasCondition())
            tgt.setCondition(VersionConvertor_30_50.convertReference(src.getCondition()));
        if (src.hasPerformer())
            tgt.setPerformer(VersionConvertor_30_50.convertReference(src.getPerformer()));
        if (src.hasReason()) {
            if (src.getReason() instanceof org.hl7.fhir.dstu3.model.CodeableConcept)
                tgt.addReason(VersionConvertor_30_50.convertCodeableConceptToCodableReference((org.hl7.fhir.dstu3.model.CodeableConcept) src.getReason()));
            else if (src.getReason() instanceof org.hl7.fhir.dstu3.model.Reference)
                tgt.addReason(VersionConvertor_30_50.convertReferenceToCodableReference((org.hl7.fhir.dstu3.model.Reference) src.getReason()));
        }
        if (src.hasBasis()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getBasis()) tgt.addBasis(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasPrediction()) {
            for (org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentPredictionComponent t : src.getPrediction()) tgt.addPrediction(convertRiskAssessmentPredictionComponent(t));
        }
        if (src.hasMitigationElement())
            tgt.setMitigationElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getMitigationElement()));
        if (src.hasComment())
            tgt.addNote().setText(src.getComment());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.RiskAssessment convertRiskAssessment(org.hl7.fhir.r5.model.RiskAssessment src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.RiskAssessment tgt = new org.hl7.fhir.dstu3.model.RiskAssessment();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_30_50.convertIdentifier(src.getIdentifierFirstRep()));
        if (src.hasBasedOn())
            tgt.setBasedOn(VersionConvertor_30_50.convertReference(src.getBasedOn()));
        if (src.hasParent())
            tgt.setParent(VersionConvertor_30_50.convertReference(src.getParent()));
        if (src.hasStatus())
            tgt.setStatus(convertRiskAssessmentStatus(src.getStatus()));
        if (src.hasMethod())
            tgt.setMethod(VersionConvertor_30_50.convertCodeableConcept(src.getMethod()));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_50.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setContext(VersionConvertor_30_50.convertReference(src.getEncounter()));
        if (src.hasOccurrence())
            tgt.setOccurrence(VersionConvertor_30_50.convertType(src.getOccurrence()));
        if (src.hasCondition())
            tgt.setCondition(VersionConvertor_30_50.convertReference(src.getCondition()));
        if (src.hasPerformer())
            tgt.setPerformer(VersionConvertor_30_50.convertReference(src.getPerformer()));
        if (src.hasReason() && src.getReasonFirstRep().hasConcept())
            tgt.setReason(VersionConvertor_30_50.convertType(src.getReasonFirstRep().getConcept()));
        if (src.hasReason() && src.getReasonFirstRep().hasReference())
            tgt.setReason(VersionConvertor_30_50.convertType(src.getReasonFirstRep().getReference()));
        if (src.hasBasis()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getBasis()) tgt.addBasis(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasPrediction()) {
            for (org.hl7.fhir.r5.model.RiskAssessment.RiskAssessmentPredictionComponent t : src.getPrediction()) tgt.addPrediction(convertRiskAssessmentPredictionComponent(t));
        }
        if (src.hasMitigationElement())
            tgt.setMitigationElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getMitigationElement()));
        if (src.hasNote())
            tgt.setComment(src.getNoteFirstRep().getText());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.RiskAssessment.RiskAssessmentPredictionComponent convertRiskAssessmentPredictionComponent(org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentPredictionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.RiskAssessment.RiskAssessmentPredictionComponent tgt = new org.hl7.fhir.r5.model.RiskAssessment.RiskAssessmentPredictionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasOutcome())
            tgt.setOutcome(VersionConvertor_30_50.convertCodeableConcept(src.getOutcome()));
        if (src.hasProbability())
            tgt.setProbability(VersionConvertor_30_50.convertType(src.getProbability()));
        if (src.hasQualitativeRisk())
            tgt.setQualitativeRisk(VersionConvertor_30_50.convertCodeableConcept(src.getQualitativeRisk()));
        if (src.hasRelativeRiskElement())
            tgt.setRelativeRiskElement((org.hl7.fhir.r5.model.DecimalType) VersionConvertor_30_50.convertType(src.getRelativeRiskElement()));
        if (src.hasWhen())
            tgt.setWhen(VersionConvertor_30_50.convertType(src.getWhen()));
        if (src.hasRationaleElement())
            tgt.setRationaleElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getRationaleElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentPredictionComponent convertRiskAssessmentPredictionComponent(org.hl7.fhir.r5.model.RiskAssessment.RiskAssessmentPredictionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentPredictionComponent tgt = new org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentPredictionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasOutcome())
            tgt.setOutcome(VersionConvertor_30_50.convertCodeableConcept(src.getOutcome()));
        if (src.hasProbability())
            tgt.setProbability(VersionConvertor_30_50.convertType(src.getProbability()));
        if (src.hasQualitativeRisk())
            tgt.setQualitativeRisk(VersionConvertor_30_50.convertCodeableConcept(src.getQualitativeRisk()));
        if (src.hasRelativeRiskElement())
            tgt.setRelativeRiskElement((org.hl7.fhir.dstu3.model.DecimalType) VersionConvertor_30_50.convertType(src.getRelativeRiskElement()));
        if (src.hasWhen())
            tgt.setWhen(VersionConvertor_30_50.convertType(src.getWhen()));
        if (src.hasRationaleElement())
            tgt.setRationaleElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getRationaleElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumerations.ObservationStatus convertRiskAssessmentStatus(org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REGISTERED:
                return org.hl7.fhir.r5.model.Enumerations.ObservationStatus.REGISTERED;
            case PRELIMINARY:
                return org.hl7.fhir.r5.model.Enumerations.ObservationStatus.PRELIMINARY;
            case FINAL:
                return org.hl7.fhir.r5.model.Enumerations.ObservationStatus.FINAL;
            case AMENDED:
                return org.hl7.fhir.r5.model.Enumerations.ObservationStatus.AMENDED;
            case CORRECTED:
                return org.hl7.fhir.r5.model.Enumerations.ObservationStatus.CORRECTED;
            case CANCELLED:
                return org.hl7.fhir.r5.model.Enumerations.ObservationStatus.CANCELLED;
            case ENTEREDINERROR:
                return org.hl7.fhir.r5.model.Enumerations.ObservationStatus.ENTEREDINERROR;
            case UNKNOWN:
                return org.hl7.fhir.r5.model.Enumerations.ObservationStatus.UNKNOWN;
            default:
                return org.hl7.fhir.r5.model.Enumerations.ObservationStatus.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentStatus convertRiskAssessmentStatus(org.hl7.fhir.r5.model.Enumerations.ObservationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REGISTERED:
                return org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentStatus.REGISTERED;
            case PRELIMINARY:
                return org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentStatus.PRELIMINARY;
            case FINAL:
                return org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentStatus.FINAL;
            case AMENDED:
                return org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentStatus.AMENDED;
            case CORRECTED:
                return org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentStatus.CORRECTED;
            case CANCELLED:
                return org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentStatus.CANCELLED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentStatus.ENTEREDINERROR;
            case UNKNOWN:
                return org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentStatus.UNKNOWN;
            default:
                return org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentStatus.NULL;
        }
    }
}
