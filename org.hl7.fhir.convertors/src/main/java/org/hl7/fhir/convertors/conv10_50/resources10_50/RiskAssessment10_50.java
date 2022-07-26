package org.hl7.fhir.convertors.conv10_50.resources10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Reference10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.CodeableConcept10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Identifier10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Decimal10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.String10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class RiskAssessment10_50 {

  public static org.hl7.fhir.r5.model.RiskAssessment convertRiskAssessment(org.hl7.fhir.dstu2.model.RiskAssessment src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.RiskAssessment tgt = new org.hl7.fhir.r5.model.RiskAssessment();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    if (src.hasSubject())
      tgt.setSubject(Reference10_50.convertReference(src.getSubject()));
    if (src.hasCondition())
      tgt.setCondition(Reference10_50.convertReference(src.getCondition()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference10_50.convertReference(src.getEncounter()));
    if (src.hasPerformer())
      tgt.setPerformer(Reference10_50.convertReference(src.getPerformer()));
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(src.getIdentifier()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept10_50.convertCodeableConcept(src.getMethod()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getBasis()) tgt.addBasis(Reference10_50.convertReference(t));
    for (org.hl7.fhir.dstu2.model.RiskAssessment.RiskAssessmentPredictionComponent t : src.getPrediction())
      tgt.addPrediction(convertRiskAssessmentPredictionComponent(t));
    if (src.hasMitigationElement())
      tgt.setMitigationElement(String10_50.convertString(src.getMitigationElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.RiskAssessment convertRiskAssessment(org.hl7.fhir.r5.model.RiskAssessment src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.RiskAssessment tgt = new org.hl7.fhir.dstu2.model.RiskAssessment();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    if (src.hasSubject())
      tgt.setSubject(Reference10_50.convertReference(src.getSubject()));
    if (src.hasCondition())
      tgt.setCondition(Reference10_50.convertReference(src.getCondition()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference10_50.convertReference(src.getEncounter()));
    if (src.hasPerformer())
      tgt.setPerformer(Reference10_50.convertReference(src.getPerformer()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier10_50.convertIdentifier(src.getIdentifierFirstRep()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept10_50.convertCodeableConcept(src.getMethod()));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasis()) tgt.addBasis(Reference10_50.convertReference(t));
    for (org.hl7.fhir.r5.model.RiskAssessment.RiskAssessmentPredictionComponent t : src.getPrediction())
      tgt.addPrediction(convertRiskAssessmentPredictionComponent(t));
    if (src.hasMitigationElement())
      tgt.setMitigationElement(String10_50.convertString(src.getMitigationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.RiskAssessment.RiskAssessmentPredictionComponent convertRiskAssessmentPredictionComponent(org.hl7.fhir.dstu2.model.RiskAssessment.RiskAssessmentPredictionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.RiskAssessment.RiskAssessmentPredictionComponent tgt = new org.hl7.fhir.r5.model.RiskAssessment.RiskAssessmentPredictionComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasOutcome())
      tgt.setOutcome(CodeableConcept10_50.convertCodeableConcept(src.getOutcome()));
    if (src.hasProbability())
      tgt.setProbability(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getProbability()));
    if (src.hasRelativeRiskElement())
      tgt.setRelativeRiskElement(Decimal10_50.convertDecimal(src.getRelativeRiskElement()));
    if (src.hasWhen())
      tgt.setWhen(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getWhen()));
    if (src.hasRationaleElement())
      tgt.setRationaleElement(String10_50.convertString(src.getRationaleElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.RiskAssessment.RiskAssessmentPredictionComponent convertRiskAssessmentPredictionComponent(org.hl7.fhir.r5.model.RiskAssessment.RiskAssessmentPredictionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.RiskAssessment.RiskAssessmentPredictionComponent tgt = new org.hl7.fhir.dstu2.model.RiskAssessment.RiskAssessmentPredictionComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasOutcome())
      tgt.setOutcome(CodeableConcept10_50.convertCodeableConcept(src.getOutcome()));
    if (src.hasProbability())
      tgt.setProbability(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getProbability()));
    if (src.hasRelativeRiskElement())
      tgt.setRelativeRiskElement(Decimal10_50.convertDecimal(src.getRelativeRiskElement()));
    if (src.hasWhen())
      tgt.setWhen(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getWhen()));
    if (src.hasRationaleElement())
      tgt.setRationaleElement(String10_50.convertString(src.getRationaleElement()));
    return tgt;
  }
}