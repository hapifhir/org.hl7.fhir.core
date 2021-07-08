package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.conv30_50.VersionConvertor_30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Element30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Type30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Decimal30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class RiskAssessment30_50 {

    public static org.hl7.fhir.r5.model.RiskAssessment convertRiskAssessment(org.hl7.fhir.dstu3.model.RiskAssessment src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.RiskAssessment tgt = new org.hl7.fhir.r5.model.RiskAssessment();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.addIdentifier(Identifier30_50.convertIdentifier(src.getIdentifier()));
        if (src.hasBasedOn())
            tgt.setBasedOn(Reference30_50.convertReference(src.getBasedOn()));
        if (src.hasParent())
            tgt.setParent(Reference30_50.convertReference(src.getParent()));
        if (src.hasStatus())
            tgt.setStatusElement(convertRiskAssessmentStatus(src.getStatusElement()));
        if (src.hasMethod())
            tgt.setMethod(CodeableConcept30_50.convertCodeableConcept(src.getMethod()));
        if (src.hasCode())
            tgt.setCode(CodeableConcept30_50.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
        if (src.hasContext())
            tgt.setEncounter(Reference30_50.convertReference(src.getContext()));
        if (src.hasOccurrence())
            tgt.setOccurrence(Type30_50.convertType(src.getOccurrence()));
        if (src.hasCondition())
            tgt.setCondition(Reference30_50.convertReference(src.getCondition()));
        if (src.hasPerformer())
            tgt.setPerformer(Reference30_50.convertReference(src.getPerformer()));
        if (src.hasReason()) {
            if (src.getReason() instanceof org.hl7.fhir.dstu3.model.CodeableConcept)
                tgt.addReason(Reference30_50.convertCodeableConceptToCodableReference((org.hl7.fhir.dstu3.model.CodeableConcept) src.getReason()));
            else if (src.getReason() instanceof org.hl7.fhir.dstu3.model.Reference)
                tgt.addReason(Reference30_50.convertReferenceToCodableReference((org.hl7.fhir.dstu3.model.Reference) src.getReason()));
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getBasis()) tgt.addBasis(Reference30_50.convertReference(t));
        for (org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentPredictionComponent t : src.getPrediction()) tgt.addPrediction(convertRiskAssessmentPredictionComponent(t));
        if (src.hasMitigation())
            tgt.setMitigationElement(String30_50.convertString(src.getMitigationElement()));
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
            tgt.setIdentifier(Identifier30_50.convertIdentifier(src.getIdentifierFirstRep()));
        if (src.hasBasedOn())
            tgt.setBasedOn(Reference30_50.convertReference(src.getBasedOn()));
        if (src.hasParent())
            tgt.setParent(Reference30_50.convertReference(src.getParent()));
        if (src.hasStatus())
            tgt.setStatusElement(convertRiskAssessmentStatus(src.getStatusElement()));
        if (src.hasMethod())
            tgt.setMethod(CodeableConcept30_50.convertCodeableConcept(src.getMethod()));
        if (src.hasCode())
            tgt.setCode(CodeableConcept30_50.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setContext(Reference30_50.convertReference(src.getEncounter()));
        if (src.hasOccurrence())
            tgt.setOccurrence(Type30_50.convertType(src.getOccurrence()));
        if (src.hasCondition())
            tgt.setCondition(Reference30_50.convertReference(src.getCondition()));
        if (src.hasPerformer())
            tgt.setPerformer(Reference30_50.convertReference(src.getPerformer()));
        if (src.hasReason() && src.getReasonFirstRep().hasConcept())
            tgt.setReason(Type30_50.convertType(src.getReasonFirstRep().getConcept()));
        if (src.hasReason() && src.getReasonFirstRep().hasReference())
            tgt.setReason(Type30_50.convertType(src.getReasonFirstRep().getReference()));
        for (org.hl7.fhir.r5.model.Reference t : src.getBasis()) tgt.addBasis(Reference30_50.convertReference(t));
        for (org.hl7.fhir.r5.model.RiskAssessment.RiskAssessmentPredictionComponent t : src.getPrediction()) tgt.addPrediction(convertRiskAssessmentPredictionComponent(t));
        if (src.hasMitigation())
            tgt.setMitigationElement(String30_50.convertString(src.getMitigationElement()));
        if (src.hasNote())
            tgt.setComment(src.getNoteFirstRep().getText());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.RiskAssessment.RiskAssessmentPredictionComponent convertRiskAssessmentPredictionComponent(org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentPredictionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.RiskAssessment.RiskAssessmentPredictionComponent tgt = new org.hl7.fhir.r5.model.RiskAssessment.RiskAssessmentPredictionComponent();
        Element30_50.copyElement(src, tgt);
        if (src.hasOutcome())
            tgt.setOutcome(CodeableConcept30_50.convertCodeableConcept(src.getOutcome()));
        if (src.hasProbability())
            tgt.setProbability(Type30_50.convertType(src.getProbability()));
        if (src.hasQualitativeRisk())
            tgt.setQualitativeRisk(CodeableConcept30_50.convertCodeableConcept(src.getQualitativeRisk()));
        if (src.hasRelativeRisk())
            tgt.setRelativeRiskElement(Decimal30_50.convertDecimal(src.getRelativeRiskElement()));
        if (src.hasWhen())
            tgt.setWhen(Type30_50.convertType(src.getWhen()));
        if (src.hasRationale())
            tgt.setRationaleElement(String30_50.convertString(src.getRationaleElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentPredictionComponent convertRiskAssessmentPredictionComponent(org.hl7.fhir.r5.model.RiskAssessment.RiskAssessmentPredictionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentPredictionComponent tgt = new org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentPredictionComponent();
        Element30_50.copyElement(src, tgt);
        if (src.hasOutcome())
            tgt.setOutcome(CodeableConcept30_50.convertCodeableConcept(src.getOutcome()));
        if (src.hasProbability())
            tgt.setProbability(Type30_50.convertType(src.getProbability()));
        if (src.hasQualitativeRisk())
            tgt.setQualitativeRisk(CodeableConcept30_50.convertCodeableConcept(src.getQualitativeRisk()));
        if (src.hasRelativeRisk())
            tgt.setRelativeRiskElement(Decimal30_50.convertDecimal(src.getRelativeRiskElement()));
        if (src.hasWhen())
            tgt.setWhen(Type30_50.convertType(src.getWhen()));
        if (src.hasRationale())
            tgt.setRationaleElement(String30_50.convertString(src.getRationaleElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ObservationStatus> convertRiskAssessmentStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ObservationStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ObservationStatusEnumFactory());
        Element30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case REGISTERED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.REGISTERED);
                break;
            case PRELIMINARY:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.PRELIMINARY);
                break;
            case FINAL:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.FINAL);
                break;
            case AMENDED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.AMENDED);
                break;
            case CORRECTED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.CORRECTED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.CANCELLED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.ENTEREDINERROR);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentStatus> convertRiskAssessmentStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ObservationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentStatusEnumFactory());
        Element30_50.copyElement(src, tgt);
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
}