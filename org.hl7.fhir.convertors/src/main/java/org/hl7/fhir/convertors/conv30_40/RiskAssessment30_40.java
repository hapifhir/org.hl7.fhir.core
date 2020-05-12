package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class RiskAssessment30_40 {

    public static org.hl7.fhir.dstu3.model.RiskAssessment convertRiskAssessment(org.hl7.fhir.r4.model.RiskAssessment src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.RiskAssessment tgt = new org.hl7.fhir.dstu3.model.RiskAssessment();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_30_40.convertIdentifier(src.getIdentifierFirstRep()));
        if (src.hasBasedOn())
            tgt.setBasedOn(VersionConvertor_30_40.convertReference(src.getBasedOn()));
        if (src.hasParent())
            tgt.setParent(VersionConvertor_30_40.convertReference(src.getParent()));
        if (src.hasStatus())
            tgt.setStatusElement(convertRiskAssessmentStatus(src.getStatusElement()));
        if (src.hasMethod())
            tgt.setMethod(VersionConvertor_30_40.convertCodeableConcept(src.getMethod()));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_40.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setContext(VersionConvertor_30_40.convertReference(src.getEncounter()));
        if (src.hasOccurrence())
            tgt.setOccurrence(VersionConvertor_30_40.convertType(src.getOccurrence()));
        if (src.hasCondition())
            tgt.setCondition(VersionConvertor_30_40.convertReference(src.getCondition()));
        if (src.hasPerformer())
            tgt.setPerformer(VersionConvertor_30_40.convertReference(src.getPerformer()));
        if (src.hasReasonCode())
            tgt.setReason(VersionConvertor_30_40.convertType(src.getReasonCodeFirstRep()));
        if (src.hasReasonReference())
            tgt.setReason(VersionConvertor_30_40.convertType(src.getReasonReferenceFirstRep()));
        for (org.hl7.fhir.r4.model.Reference t : src.getBasis()) tgt.addBasis(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentPredictionComponent t : src.getPrediction()) tgt.addPrediction(convertRiskAssessmentPredictionComponent(t));
        if (src.hasMitigation())
            tgt.setMitigationElement(VersionConvertor_30_40.convertString(src.getMitigationElement()));
        if (src.hasNote())
            tgt.setComment(src.getNoteFirstRep().getText());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.RiskAssessment convertRiskAssessment(org.hl7.fhir.dstu3.model.RiskAssessment src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.RiskAssessment tgt = new org.hl7.fhir.r4.model.RiskAssessment();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(src.getIdentifier()));
        if (src.hasBasedOn())
            tgt.setBasedOn(VersionConvertor_30_40.convertReference(src.getBasedOn()));
        if (src.hasParent())
            tgt.setParent(VersionConvertor_30_40.convertReference(src.getParent()));
        if (src.hasStatus())
            tgt.setStatusElement(convertRiskAssessmentStatus(src.getStatusElement()));
        if (src.hasMethod())
            tgt.setMethod(VersionConvertor_30_40.convertCodeableConcept(src.getMethod()));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_40.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        if (src.hasContext())
            tgt.setEncounter(VersionConvertor_30_40.convertReference(src.getContext()));
        if (src.hasOccurrence())
            tgt.setOccurrence(VersionConvertor_30_40.convertType(src.getOccurrence()));
        if (src.hasCondition())
            tgt.setCondition(VersionConvertor_30_40.convertReference(src.getCondition()));
        if (src.hasPerformer())
            tgt.setPerformer(VersionConvertor_30_40.convertReference(src.getPerformer()));
        if (src.hasReason()) {
            org.hl7.fhir.r4.model.Type t = VersionConvertor_30_40.convertType(src.getReason());
            if (t instanceof org.hl7.fhir.r4.model.CodeableConcept)
                tgt.addReasonCode((org.hl7.fhir.r4.model.CodeableConcept) t);
            else
                tgt.addReasonReference((org.hl7.fhir.r4.model.Reference) t);
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getBasis()) tgt.addBasis(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentPredictionComponent t : src.getPrediction()) tgt.addPrediction(convertRiskAssessmentPredictionComponent(t));
        if (src.hasMitigation())
            tgt.setMitigationElement(VersionConvertor_30_40.convertString(src.getMitigationElement()));
        if (src.hasComment())
            tgt.addNote().setText(src.getComment());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentPredictionComponent convertRiskAssessmentPredictionComponent(org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentPredictionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentPredictionComponent tgt = new org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentPredictionComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasOutcome())
            tgt.setOutcome(VersionConvertor_30_40.convertCodeableConcept(src.getOutcome()));
        if (src.hasProbability())
            tgt.setProbability(VersionConvertor_30_40.convertType(src.getProbability()));
        if (src.hasQualitativeRisk())
            tgt.setQualitativeRisk(VersionConvertor_30_40.convertCodeableConcept(src.getQualitativeRisk()));
        if (src.hasRelativeRisk())
            tgt.setRelativeRiskElement(VersionConvertor_30_40.convertDecimal(src.getRelativeRiskElement()));
        if (src.hasWhen())
            tgt.setWhen(VersionConvertor_30_40.convertType(src.getWhen()));
        if (src.hasRationale())
            tgt.setRationaleElement(VersionConvertor_30_40.convertString(src.getRationaleElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentPredictionComponent convertRiskAssessmentPredictionComponent(org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentPredictionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentPredictionComponent tgt = new org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentPredictionComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasOutcome())
            tgt.setOutcome(VersionConvertor_30_40.convertCodeableConcept(src.getOutcome()));
        if (src.hasProbability())
            tgt.setProbability(VersionConvertor_30_40.convertType(src.getProbability()));
        if (src.hasQualitativeRisk())
            tgt.setQualitativeRisk(VersionConvertor_30_40.convertCodeableConcept(src.getQualitativeRisk()));
        if (src.hasRelativeRisk())
            tgt.setRelativeRiskElement(VersionConvertor_30_40.convertDecimal(src.getRelativeRiskElement()));
        if (src.hasWhen())
            tgt.setWhen(VersionConvertor_30_40.convertType(src.getWhen()));
        if (src.hasRationale())
            tgt.setRationaleElement(VersionConvertor_30_40.convertString(src.getRationaleElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentStatus> convertRiskAssessmentStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentStatusEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case REGISTERED:
                tgt.setValue(org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentStatus.REGISTERED);
                break;
            case PRELIMINARY:
                tgt.setValue(org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentStatus.PRELIMINARY);
                break;
            case FINAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentStatus.FINAL);
                break;
            case AMENDED:
                tgt.setValue(org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentStatus.AMENDED);
                break;
            case CORRECTED:
                tgt.setValue(org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentStatus.CORRECTED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentStatus.CANCELLED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentStatus.ENTEREDINERROR);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentStatus.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentStatus> convertRiskAssessmentStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentStatusEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case REGISTERED:
                tgt.setValue(org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentStatus.REGISTERED);
                break;
            case PRELIMINARY:
                tgt.setValue(org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentStatus.PRELIMINARY);
                break;
            case FINAL:
                tgt.setValue(org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentStatus.FINAL);
                break;
            case AMENDED:
                tgt.setValue(org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentStatus.AMENDED);
                break;
            case CORRECTED:
                tgt.setValue(org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentStatus.CORRECTED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentStatus.CANCELLED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentStatus.ENTEREDINERROR);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentStatus.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentStatus.NULL);
                break;
        }
        return tgt;
    }
}