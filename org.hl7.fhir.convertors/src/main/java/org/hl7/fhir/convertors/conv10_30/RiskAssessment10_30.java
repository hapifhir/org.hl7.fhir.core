package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class RiskAssessment10_30 {

    public static org.hl7.fhir.dstu2.model.RiskAssessment convertRiskAssessment(org.hl7.fhir.dstu3.model.RiskAssessment src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.RiskAssessment tgt = new org.hl7.fhir.dstu2.model.RiskAssessment();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        if (src.hasCondition())
            tgt.setCondition(VersionConvertor_10_30.convertReference(src.getCondition()));
        if (src.hasContext())
            tgt.setEncounter(VersionConvertor_10_30.convertReference(src.getContext()));
        if (src.hasPerformer())
            tgt.setPerformer(VersionConvertor_10_30.convertReference(src.getPerformer()));
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        if (src.hasMethod())
            tgt.setMethod(VersionConvertor_10_30.convertCodeableConcept(src.getMethod()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getBasis()) tgt.addBasis(VersionConvertor_10_30.convertReference(t));
        for (org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentPredictionComponent t : src.getPrediction()) tgt.addPrediction(convertRiskAssessmentPredictionComponent(t));
        if (src.hasMitigationElement())
            tgt.setMitigationElement(VersionConvertor_10_30.convertString(src.getMitigationElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.RiskAssessment convertRiskAssessment(org.hl7.fhir.dstu2.model.RiskAssessment src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.RiskAssessment tgt = new org.hl7.fhir.dstu3.model.RiskAssessment();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        if (src.hasCondition())
            tgt.setCondition(VersionConvertor_10_30.convertReference(src.getCondition()));
        if (src.hasEncounter())
            tgt.setContext(VersionConvertor_10_30.convertReference(src.getEncounter()));
        if (src.hasPerformer())
            tgt.setPerformer(VersionConvertor_10_30.convertReference(src.getPerformer()));
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        if (src.hasMethod())
            tgt.setMethod(VersionConvertor_10_30.convertCodeableConcept(src.getMethod()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getBasis()) tgt.addBasis(VersionConvertor_10_30.convertReference(t));
        for (org.hl7.fhir.dstu2.model.RiskAssessment.RiskAssessmentPredictionComponent t : src.getPrediction()) tgt.addPrediction(convertRiskAssessmentPredictionComponent(t));
        if (src.hasMitigationElement())
            tgt.setMitigationElement(VersionConvertor_10_30.convertString(src.getMitigationElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentPredictionComponent convertRiskAssessmentPredictionComponent(org.hl7.fhir.dstu2.model.RiskAssessment.RiskAssessmentPredictionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentPredictionComponent tgt = new org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentPredictionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasOutcome())
            tgt.setOutcome(VersionConvertor_10_30.convertCodeableConcept(src.getOutcome()));
        if (src.hasProbability())
            tgt.setProbability(VersionConvertor_10_30.convertType(src.getProbability()));
        if (src.hasRelativeRiskElement())
            tgt.setRelativeRiskElement(VersionConvertor_10_30.convertDecimal(src.getRelativeRiskElement()));
        if (src.hasWhen())
            tgt.setWhen(VersionConvertor_10_30.convertType(src.getWhen()));
        if (src.hasRationaleElement())
            tgt.setRationaleElement(VersionConvertor_10_30.convertString(src.getRationaleElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.RiskAssessment.RiskAssessmentPredictionComponent convertRiskAssessmentPredictionComponent(org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentPredictionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.RiskAssessment.RiskAssessmentPredictionComponent tgt = new org.hl7.fhir.dstu2.model.RiskAssessment.RiskAssessmentPredictionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasOutcome())
            tgt.setOutcome(VersionConvertor_10_30.convertCodeableConcept(src.getOutcome()));
        if (src.hasProbability())
            tgt.setProbability(VersionConvertor_10_30.convertType(src.getProbability()));
        if (src.hasRelativeRiskElement())
            tgt.setRelativeRiskElement(VersionConvertor_10_30.convertDecimal(src.getRelativeRiskElement()));
        if (src.hasWhen())
            tgt.setWhen(VersionConvertor_10_30.convertType(src.getWhen()));
        if (src.hasRationaleElement())
            tgt.setRationaleElement(VersionConvertor_10_30.convertString(src.getRationaleElement()));
        return tgt;
    }
}