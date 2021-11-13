package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.context.ConversionContext10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.CodeableConcept10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Identifier10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Decimal10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class RiskAssessment10_30 {

  public static org.hl7.fhir.dstu2.model.RiskAssessment convertRiskAssessment(org.hl7.fhir.dstu3.model.RiskAssessment src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.RiskAssessment tgt = new org.hl7.fhir.dstu2.model.RiskAssessment();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    if (src.hasSubject())
      tgt.setSubject(Reference10_30.convertReference(src.getSubject()));
    if (src.hasCondition())
      tgt.setCondition(Reference10_30.convertReference(src.getCondition()));
    if (src.hasContext())
      tgt.setEncounter(Reference10_30.convertReference(src.getContext()));
    if (src.hasPerformer())
      tgt.setPerformer(Reference10_30.convertReference(src.getPerformer()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier10_30.convertIdentifier(src.getIdentifier()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept10_30.convertCodeableConcept(src.getMethod()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getBasis()) tgt.addBasis(Reference10_30.convertReference(t));
    for (org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentPredictionComponent t : src.getPrediction())
      tgt.addPrediction(convertRiskAssessmentPredictionComponent(t));
    if (src.hasMitigationElement())
      tgt.setMitigationElement(String10_30.convertString(src.getMitigationElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.RiskAssessment convertRiskAssessment(org.hl7.fhir.dstu2.model.RiskAssessment src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.RiskAssessment tgt = new org.hl7.fhir.dstu3.model.RiskAssessment();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    if (src.hasSubject())
      tgt.setSubject(Reference10_30.convertReference(src.getSubject()));
    if (src.hasCondition())
      tgt.setCondition(Reference10_30.convertReference(src.getCondition()));
    if (src.hasEncounter())
      tgt.setContext(Reference10_30.convertReference(src.getEncounter()));
    if (src.hasPerformer())
      tgt.setPerformer(Reference10_30.convertReference(src.getPerformer()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier10_30.convertIdentifier(src.getIdentifier()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept10_30.convertCodeableConcept(src.getMethod()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getBasis()) tgt.addBasis(Reference10_30.convertReference(t));
    for (org.hl7.fhir.dstu2.model.RiskAssessment.RiskAssessmentPredictionComponent t : src.getPrediction())
      tgt.addPrediction(convertRiskAssessmentPredictionComponent(t));
    if (src.hasMitigationElement())
      tgt.setMitigationElement(String10_30.convertString(src.getMitigationElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentPredictionComponent convertRiskAssessmentPredictionComponent(org.hl7.fhir.dstu2.model.RiskAssessment.RiskAssessmentPredictionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentPredictionComponent tgt = new org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentPredictionComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasOutcome())
      tgt.setOutcome(CodeableConcept10_30.convertCodeableConcept(src.getOutcome()));
    if (src.hasProbability())
      tgt.setProbability(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getProbability()));
    if (src.hasRelativeRiskElement())
      tgt.setRelativeRiskElement(Decimal10_30.convertDecimal(src.getRelativeRiskElement()));
    if (src.hasWhen())
      tgt.setWhen(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getWhen()));
    if (src.hasRationaleElement())
      tgt.setRationaleElement(String10_30.convertString(src.getRationaleElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.RiskAssessment.RiskAssessmentPredictionComponent convertRiskAssessmentPredictionComponent(org.hl7.fhir.dstu3.model.RiskAssessment.RiskAssessmentPredictionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.RiskAssessment.RiskAssessmentPredictionComponent tgt = new org.hl7.fhir.dstu2.model.RiskAssessment.RiskAssessmentPredictionComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasOutcome())
      tgt.setOutcome(CodeableConcept10_30.convertCodeableConcept(src.getOutcome()));
    if (src.hasProbability())
      tgt.setProbability(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getProbability()));
    if (src.hasRelativeRiskElement())
      tgt.setRelativeRiskElement(Decimal10_30.convertDecimal(src.getRelativeRiskElement()));
    if (src.hasWhen())
      tgt.setWhen(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getWhen()));
    if (src.hasRationaleElement())
      tgt.setRationaleElement(String10_30.convertString(src.getRationaleElement()));
    return tgt;
  }
}