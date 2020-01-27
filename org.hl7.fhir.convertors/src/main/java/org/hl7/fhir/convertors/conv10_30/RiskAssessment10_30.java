package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class RiskAssessment10_30 {

    public static org.hl7.fhir.dstu2.model.RiskAssessment convertRiskAssessment(org.hl7.fhir.dstu3.model.RiskAssessment src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.RiskAssessment tgt = new org.hl7.fhir.dstu2.model.RiskAssessment();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        tgt.setCondition(VersionConvertor_10_30.convertReference(src.getCondition()));
        tgt.setEncounter(VersionConvertor_10_30.convertReference(src.getContext()));
        tgt.setPerformer(VersionConvertor_10_30.convertReference(src.getPerformer()));
        tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        tgt.setMethod(VersionConvertor_10_30.convertCodeableConcept(src.getMethod()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getBasis()) tgt.addBasis(VersionConvertor_10_30.convertReference(t));
        for (org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentPredictionComponent t : src.getPrediction()) tgt.addPrediction(convertRiskAssessmentPredictionComponent(t));
        tgt.setMitigation(src.getMitigation());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.RiskAssessment convertRiskAssessment(org.hl7.fhir.dstu2.model.RiskAssessment src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.RiskAssessment tgt = new org.hl7.fhir.dstu3.model.RiskAssessment();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        tgt.setCondition(VersionConvertor_10_30.convertReference(src.getCondition()));
        tgt.setContext(VersionConvertor_10_30.convertReference(src.getEncounter()));
        tgt.setPerformer(VersionConvertor_10_30.convertReference(src.getPerformer()));
        tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        tgt.setMethod(VersionConvertor_10_30.convertCodeableConcept(src.getMethod()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getBasis()) tgt.addBasis(VersionConvertor_10_30.convertReference(t));
        for (org.hl7.fhir.dstu2.model.RiskAssessment.RiskAssessmentPredictionComponent t : src.getPrediction()) tgt.addPrediction(convertRiskAssessmentPredictionComponent(t));
        tgt.setMitigation(src.getMitigation());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentPredictionComponent convertRiskAssessmentPredictionComponent(org.hl7.fhir.dstu2.model.RiskAssessment.RiskAssessmentPredictionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentPredictionComponent tgt = new org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentPredictionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setOutcome(VersionConvertor_10_30.convertCodeableConcept(src.getOutcome()));
        tgt.setProbability(VersionConvertor_10_30.convertType(src.getProbability()));
        tgt.setRelativeRisk(src.getRelativeRisk());
        tgt.setWhen(VersionConvertor_10_30.convertType(src.getWhen()));
        tgt.setRationale(src.getRationale());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.RiskAssessment.RiskAssessmentPredictionComponent convertRiskAssessmentPredictionComponent(org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentPredictionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.RiskAssessment.RiskAssessmentPredictionComponent tgt = new org.hl7.fhir.dstu2.model.RiskAssessment.RiskAssessmentPredictionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setOutcome(VersionConvertor_10_30.convertCodeableConcept(src.getOutcome()));
        tgt.setProbability(VersionConvertor_10_30.convertType(src.getProbability()));
        tgt.setRelativeRisk(src.getRelativeRisk());
        tgt.setWhen(VersionConvertor_10_30.convertType(src.getWhen()));
        tgt.setRationale(src.getRationale());
        return tgt;
    }
}
